DROP DATABASE IF EXISTS odysseyonwheelz;
CREATE DATABASE odysseyonwheelz;

USE odysseyonwheelz;
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
    customerEmail VARCHAR(200) DEFAULT NULL
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
CREATE TABLE language(
    wordSetNb int AUTO_INCREMENT PRIMARY KEY ,
    russian VARCHAR(500),
    sinhala VARCHAR(500),
    german VARCHAR(500),
    hindi VARCHAR(500),
    french VARCHAR(500),
    english VARCHAR(500)
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

INSERT INTO customer (customerNIC, customerName, customerCountry, customerEmail)
VALUES
    ('AB123456', 'John Doe', 'USA', 'john.doe@example.com'),
    ('CD789012', 'Jane Smith', 'Canada', 'jane.smith@example.com'),
    ('EF345678', 'Bob Johnson', 'Australia', 'bob.johnson@example.com'),
    ('GH901234', 'Emily Davis', 'Germany', 'emily.davis@example.com'),
    ('IJ567890', 'Michael Wilson', 'France', 'michael.wilson@example.com'),
    ('KL123456', 'Amanda Brown', 'Spain', 'amanda.brown@example.com'),
    ('MN789012', 'David Lee', 'Italy', 'david.lee@example.com'),
    ('OP345678', 'Sophia Garcia', 'Brazil', 'sophia.garcia@example.com'),
    ('QR901234', 'James Kim', 'South Korea', 'james.kim@example.com'),
    ('ST567890', 'Linda Wang', 'China', 'linda.wang@example.com'),
    ('UV123456', 'Daniel Martinez', 'Mexico', 'daniel.martinez@example.com'),
    ('WX789012', 'Elena Rodriguez', 'Argentina', 'elena.rodriguez@example.com'),
    ('YZ345678', 'Mohammed Ali', 'Egypt', 'mohammed.ali@example.com'),
    ('AA901234', 'Mia Johnson', 'Sweden', 'mia.johnson@example.com'),
    ('BB567890', 'Oliver Nielsen', 'Denmark', 'oliver.nielsen@example.com'),
    ('CC123456', 'Isabella Smith', 'Norway', 'isabella.smith@example.com'),
    ('DD789012', 'Benjamin Jensen', 'Finland', 'benjamin.jensen@example.com'),
    ('EE345678', 'Emma Davis', 'Ireland', 'emma.davis@example.com'),
    ('FF901234', 'William Wong', 'Singapore', 'william.wong@example.com'),
    ('GG567890', 'Grace Kim', 'Japan', 'grace.kim@example.com'),
    ('HH123456', 'Ryan Chen', 'Taiwan', 'ryan.chen@example.com'),
    ('II789012', 'Zoe Tan', 'Malaysia', 'zoe.tan@example.com'),
    ('JJ345678', 'Lucas Lim', 'Philippines', 'lucas.lim@example.com'),
    ('KK901234', 'Ava Nguyen', 'Vietnam', 'ava.nguyen@example.com'),
    ('LL567890', 'Ethan Park', 'Thailand', 'ethan.park@example.com'),
    ('MM123456', 'Nina Kumar', 'India', 'nina.kumar@example.com'),
    ('NN789012', 'Oscar Patel', 'South Africa', 'oscar.patel@example.com'),
    ('OO345678', 'Victoria Mbeki', 'Nigeria', 'victoria.mbkei@example.com'),
    ('PP901234', 'Samuel Kofi', 'Ghana', 'samuel.kofi@example.com'),
    ('QQ567890', 'Sophie Abimbola', 'Kenya', 'sophie.abimbola@example.com');

INSERT INTO vehicle(vehicle_id, vehicle_type, status) VALUES
    ('QA-5678', 'double-cab', 'available'),
    ('AAI-5678', 'three-wheeler', 'available'),
    ('BAY-3489', 'Scooter bike', 'available'),
    ('ABC-1234', 'sedan', 'available'),
    ('XYZ-5678', 'Scooter bike', 'available'),
    ('DEF-9876', 'pickup truck', 'available'),
    ('GHI-5432', 'mini van', 'available'),
    ('JKL-9876', 'compact car', 'available'),
    ('MNO-1234', 'electric scooter', 'available'),
    ('PQR-5678', 'van', 'available'),
    ('STU-9876', 'motorbike', 'available'),
    ('VWX-1234', 'luxury car', 'available'),
    ('YZA-5678', 'moped', 'available'),
    ('BCD-9876', 'ATV', 'available'),
    ('EFG-1234', 'minivan', 'available'),
    ('HIJ-5678', 'hybrid car', 'available'),
    ('KLM-9876', 'touring motorcycle', 'available'),
    ('NOP-1234', 'sports car', 'available'),
    ('QRS-5678', 'cargo van', 'available'),
    ('TUV-9876', 'scooter', 'available'),
    ('WXY-1234', 'crossover SUV', 'available'),
    ('ZAB-5678', 'delivery truck', 'available'),
    ('CDE-9876', 'golf cart', 'available'),
    ('FGH-1234', 'limousine', 'available'),
    ('IJK-5678', 'monster truck', 'available');

INSERT INTO language(russian,sinhala,german,hindi,french,english) VALUES
    ('номер паспорта','ජාතික හැඳුනුම්පත් අංකය','Nummer des Reisepasses','पासपोर्ट नंबर','numéro de passeport','ID / Passport'),
    ('Оформить аренду','කුලියට ගන්න','Miete machen','किराया लगाओ','Faire un loyer','Make a Rent',
     );