# Inventory Management System

## Setup

1. Install MySQL and create a database using the provided SQL script.
2. Update the `JdbcConnection` class with your MySQL credentials.
3. Compile and run the `InventoryManagementSystem` class.

## Features

- **Medication Management**:
  - Add a new medication
  - View medication details
  - Update medication information
  - Delete a medication

- **Supplier Management**:
  - Add a new supplier
  - View supplier details
  - Update supplier information
  - Delete a supplier

- **Inventory Management**:
  - Update inventory levels
  - View inventory levels
  - Generate low-stock alerts

## Dependencies

- Java SE Development Kit (JDK)
- MySQL Database
- JDBC Driver for MySQL

## Author

- Sayan Khanra

## Project Structure

```plaintext
├── src
│ └── MainCode
│ ├── DAO
│ │ ├── InventoryDAO.java
│ │ ├── MedicationDAO.java
│ │ └── SupplierDAO.java
│ ├── MOD
│ │ ├── Inventory.java
│ │ ├── Medication.java
│ │ └── Supplier.java
│ ├── DB
│ │ └── JDBCUtil.java
│ ├── Menu.java
│ └── InventoryManagementSystem.java
└── lib
└── mysql-connector-j-8.0.25.jar
