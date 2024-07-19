CREATE DATABASE COGNIZANT;
SHOW DATABASES;
USE COGNIZANT;
CREATE TABLE Medication (
    medication_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(10, 2),
    quantity_in_stock INT
);
CREATE TABLE Supplier (
    supplier_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone_number VARCHAR(15),
    address VARCHAR(255)
);
CREATE TABLE Inventory (
    inventory_id INT AUTO_INCREMENT PRIMARY KEY,
    medication_id INT,
    supplier_id INT,
    quantity_received INT,
    date_received DATE,
    FOREIGN KEY (medication_id) REFERENCES Medication(medication_id),
    FOREIGN KEY (supplier_id) REFERENCES Supplier(supplier_id)
);