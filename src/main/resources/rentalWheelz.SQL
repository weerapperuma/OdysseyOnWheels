DROP DATABASE IF EXISTS rentalWheelz;
CREATE DATABASE rentalWheelz;

USE rentalWheelz;
CREATE TABLE user(
    userId VARCHAR(20) PRIMARY KEY NOT NULL ,
    userName VARCHAR(50) NOT NULL ,
    userNIC VARCHAR(15) NOT NULL ,
    userMobile INT(20) NOT NULL,
    userEmail VARCHAR(200) NOT NULL,
    userPassword VARCHAR(200) NOT NULL
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
    customerNIC VARCHAR(30) PRIMARY KEY NOT NULL ,
    customerName VARCHAR(100) DEFAULT NULL,
    customerCountry VARCHAR(30) ,
    customerEmail VARCHAR(200)
);
CREATE TABLE customer_contact (
    contactId VARCHAR(10) PRIMARY KEY ,
    customerNIC VARCHAR(20),
    customerContact VARCHAR(20),
    FOREIGN KEY (customerNIC) REFERENCES customer(customerNIC)
);

CREATE TABLE rent(
    rentId VARCHAR(20) PRIMARY KEY NOT NULL ,
    customerNIC VARCHAR(20),
    rent_first_amount DECIMAL(10,2),
    rent_second_amount DECIMAL(10,2),
    total_amount DECIMAL(10,2) GENERATED ALWAYS AS (rent_first_amount + rent_second_amount) STORED,
    rent_starting DATE,
    rent_ending DATE,
    CONSTRAINT FOREIGN KEY (customerNIC) REFERENCES customer(customerNIC) ON DELETE CASCADE ON UPDATE  CASCADE
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

INSERT INTO user (userId, userName, userNIC, userMobile, userEmail,userPassword) VALUES
    ('U001','PENGUIN','960036789v','0764532478','penguingotham@gmail.com','123'),
    ('U002','RIDDLER','960089769v','0767834971','RIDDLER34gotham@gmail.com','456');

INSERT INTO employee (employeeId, employeeName, empEmail, empNIC, empPosition, empAddress, empContact)
VALUES
    ('E004', 'John Doe', 'johndoe@gmail.com', '923456789v', 'Technician', 'colombo', '0712345678'),
    ('E005', 'Jane Smith', 'janesmith@gmail.com', '823456789v', 'Engineer', 'kandy', '0723456789'),
    ('E006', 'Alice Johnson', 'alicejohnson@gmail.com', '713456789v', 'Supervisor', 'negombo', '0734567890'),
    ('E007', 'Bob Williams', 'bobwilliams@gmail.com', '603456789v', 'Driver', 'jaffna', '0745678901'),
    ('E008', 'Eva Davis', 'evadavis@gmail.com', '503456789v', 'Security', 'anuradhapura', '0756789012'),
    ('E009', 'Charlie Brown', 'charliebrown@gmail.com', '403456789v', 'Clerk', 'batticaloa', '0767890123'),
    ('E010', 'Lucy Johnson', 'lucyjohnson@gmail.com', '303456789v', 'Accountant', 'trincomalee', '0778901234'),
    ('E011', 'Michael Smith', 'michaelsmith@gmail.com', '203456789v', 'Cleaner', 'ratnapura', '0789012345'),
    ('E012', 'Sophia Davis', 'sophiadavis@gmail.com', '103456789v', 'Assistant', 'kurunegala', '0790123456'),
    ('E013', 'David Wilson', 'davidwilson@gmail.com', '903456789v', 'Coordinator', 'gampaha', '0711223344'),
    ('E014', 'Olivia Anderson', 'oliviaanderson@gmail.com', '803456789v', 'Manager', 'nuwaraeliya', '0712345678'),
    ('E015', 'Henry Taylor', 'henrytaylor@gmail.com', '703456789v', 'Technician', 'colombo', '0723456789'),
    ('E016', 'Grace Miller', 'gracemiller@gmail.com', '603456789v', 'Engineer', 'kandy', '0734567890'),
    ('E017', 'Samuel Brown', 'samuelbrown@gmail.com', '503456789v', 'Supervisor', 'negombo', '0745678901'),
    ('E018', 'Isabella Wilson', 'isabellawilson@gmail.com', '403456789v', 'Driver', 'jaffna', '0756789012');
