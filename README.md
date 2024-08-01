# Warehouse Management Application

This project is a Spring Boot-based REST API for managing a warehouse. The application allows you to manage users, inventory, and borrowing/returning tools or materials.

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Project Structure](#project-structure)

## Features

- Add new users with roles.
- Add inventory products with details including name, quantity, and product type.
- Increase the number of existing products.
- Borrow tools or use materials with inventory validation.
- Return borrowed tools or materials.
- Retrieve user, inventory, and borrowing record details.
- Comprehensive unit tests for service logic.
- API documentation with Swagger.

## Requirements

- Java 17+
- Maven
- PostgreSQL database

## Setup

1. **Clone the repository**:
    ```sh
    git clone https://github.com/Rugphy/Pt-BTI-java-test.git
    cd Pt-BTI-java-test
    ```

2. **Configure the PostgreSQL database**:
    - Create a PostgreSQL database named `porgres`.
    - Update the `src/main/resources/application.properties` file with your database credentials:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. **Build the project**:
    ```sh
    mvn clean install
    ```

## Running the Application

To run the application, use the following command:
```sh
mvn spring-boot:run
The application will be available at http://localhost:8191
```

## API Documentation
```sh
API documentation is available at http://localhost:8191/swagger-ui.html
```


## Project Structure
```sh
src
└── main
    ├── java
    │   └── com
    │       └── example
    │           └── warehouse
    │               ├── controller
    │               │   ├── UserController.java
    │               │   ├── InventoryController.java
    │               │   └── BorrowController.java
    │               ├── entity
    │               │   ├── User.java
    │               │   ├── Inventory.java
    │               │   └── BorrowRecord.java
    │               ├── repository
    │               │   ├── UserRepository.java
    │               │   ├── InventoryRepository.java
    │               │   └── BorrowRecordRepository.java
    │               └── service
    │                   ├── UserService.java
    │                   ├── InventoryService.java
    │                   └── BorrowService.java
    └── resources
        └── application.properties
```
