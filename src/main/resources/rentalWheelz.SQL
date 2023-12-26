DROP DATABASE IF EXISTS rentalWheelz;
CREATE DATABASE rentalWheelz;

USE rentalWheelz;
CREATE TABLE user(
    userId VARCHAR(20) PRIMARY KEY NOT NULL ,
    userName VARCHAR(50) NOT NULL ,
    userNIC VARCHAR(15) NOT NULL ,
    userMobile INT(20) NOT NULL,
    userEmail VARCHAR(200) NOT NULL
);

CREATE TABLE employee(
    employeeId VARCHAR(20) PRIMARY KEY KEY NOT NULL ,
    employeeName VARCHAR(50) NOT NULL ,
    empEmail VARCHAR(200) NOT NULL,
    empNIC VARCHAR(20),
    empPosition VARCHAR(20) NOT NULL,
    empAddress VARCHAR(200) NOT NULL,
    empContact VARCHAR(15) NOT NULL
);
CREATE TABLE employee_Attendance(
    attendanceId VARCHAR(20) PRIMARY KEY NOT NULL ,
    attendanceDate DATE,
    employeeId VARCHAR(10),
    CONSTRAINT FOREIGN KEY (employeeId) REFERENCES employee(employeeId) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE employee_salary(
    salaryId VARCHAR(20) PRIMARY KEY NOT NULL ,
    salaryAmount DECIMAL(10,2) DEFAULT NULL,
    employeeId VARCHAR(10),
    CONSTRAINT FOREIGN KEY (employeeId) references employee(employeeId) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE customer(
    customerId VARCHAR(20) PRIMARY KEY NOT NULL ,
    customerNIC VARCHAR(30) NOT NULL ,
    customerCountry VARCHAR(30) ,
    customerEmail VARCHAR(200)
);
CREATE TABLE customer_contact (
    contactId INT PRIMARY KEY AUTO_INCREMENT,
    customerId VARCHAR(20),
    customerContact VARCHAR(20),
    FOREIGN KEY (customerId) REFERENCES customer(customerId)
);

CREATE TABLE rent(
    rentId VARCHAR(20) PRIMARY KEY NOT NULL ,
    customerId VARCHAR(20),
    rent_first_amount DECIMAL(10,2),
    rent_second_amount DECIMAL(10,2),
    total_amount DECIMAL(10,2) GENERATED ALWAYS AS (rent_first_amount + rent_second_amount) STORED,
    rent_starting DATE,
    rent_ending DATE,
    CONSTRAINT FOREIGN KEY (customerId) REFERENCES customer(customerId) ON DELETE CASCADE ON UPDATE  CASCADE
);

CREATE TABLE vehicle (
    vehicle_id VARCHAR(10) PRIMARY KEY,
    vehicle_type VARCHAR(50),
    status VARCHAR(10)
);
CREATE TABLE rent_detail (
    rent_id VARCHAR(10) NOT NULL ,
    vehicle_id VARCHAR(10) NOT NULL ,
    rent_fee DECIMAL   NOT NULL,
    CONSTRAINT FOREIGN KEY (rent_id) REFERENCES rent(rentId) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE sup_order (
    order_id VARCHAR(10) PRIMARY KEY,
    date DATE,
    amount_1 DECIMAL(10,2),
    amount_2 DECIMAL(10,2),
    total_amount DECIMAL(10,2) GENERATED ALWAYS AS (amount_1 + amount_2) STORED
);

CREATE TABLE supplier (
    sup_id VARCHAR(10) PRIMARY KEY,
    sup_name VARCHAR(50) NOT NULL,
    available_car VARCHAR(20) NOT NULL,
    order_id VARCHAR(10),
    CONSTRAINT FOREIGN KEY (order_id) REFERENCES sup_order(order_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE sup_order_detail (
    order_id VARCHAR(10),
    sup_id VARCHAR(10),
    amount DECIMAL(10,2),
    CONSTRAINT FOREIGN KEY (order_id) REFERENCES sup_order(order_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (sup_id) REFERENCES supplier(sup_id) ON DELETE CASCADE ON UPDATE CASCADE
);