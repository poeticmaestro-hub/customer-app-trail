# Customer App Trail

A Java-based REST API built with Spring Boot for managing customer records. This project demonstrates RESTful API development, database integration, input validation, and exception handling.

## Features

* Create customer records
* Retrieve all customers
* Retrieve a customer by ID
* Update existing customer records
* Delete customer records
* Validate customer input, including email addresses
* Handle invalid requests and missing customer records
* Persist records using an H2 in-memory database

## Technology Stack

* **Java:** 21
* **Framework:** Spring Boot
* **Build Tool:** Maven
* **Database:** H2
* **Persistence:** Spring Data JPA
* **Testing:** Postman
* **IDE:** Eclipse

## Getting Started

### Prerequisites

* JDK 21 or a compatible configured Java development environment
* Maven, or the project's Maven Wrapper if included
* Eclipse IDE or another Java IDE
* Postman (for API testing)

### Run the Application

1. Clone or download this repository.
2. Import the project into your IDE as an existing Maven project.
3. Allow Maven to resolve the project dependencies.
4. Run the Spring Boot application from your IDE.

Alternatively, from the project directory, run:

```bash
mvn spring-boot:run
```

If the Maven Wrapper is included, you can use `mvnw.cmd spring-boot:run` on Windows.

The application is configured to use port `8081`.

### Base URL

```text
http://localhost:8081/api/customers
```

## API Endpoints

| Method | Endpoint              | Description               |
| ------ | --------------------- | ------------------------- |
| POST   | `/api/customers`      | Create a customer         |
| GET    | `/api/customers`      | Retrieve all customers    |
| GET    | `/api/customers/{id}` | Retrieve a customer by ID |
| PUT    | `/api/customers/{id}` | Update a customer         |
| DELETE | `/api/customers/{id}` | Delete a customer         |

## Example Request

### Create a Customer

**POST** `/api/customers`

Request body:

```json
{
  "firstName": "Jordan",
  "lastName": "Rivera",
  "email": "jordan.rivera@example.com",
  "phone": "555-0102"
}
```

A successful creation returns `201 Created` with the created customer record.

### Update a Customer

**PUT** `/api/customers/1`

Request body:

```json
{
  "firstName": "Jordan",
  "lastName": "Rivera",
  "email": "jordan.updated@example.com",
  "phone": "555-0199"
}
```

Replace `1` with the ID of the customer you want to update.

## Validation and Error Handling

The API has been tested for successful CRUD operations and common error cases, including:

* Invalid email input, returning `400 Bad Request`
* Requests for nonexistent customers, returning `404 Not Found`

## Database Notes

The application uses an H2 in-memory database. Customer records are intended for development and testing, and data may be lost when the application shuts down or restarts.

## Testing

The API was tested using Postman. Verification included:

* Creating and retrieving customer records
* Updating existing records
* Deleting records
* Submitting invalid email data
* Retrieving nonexistent customer IDs

## Project Structure

The application follows a layered architecture:

* **Model:** Represents customer data
* **Repository:** Handles database access
* **Service:** Contains business logic
* **Controller:** Exposes REST API endpoints

## Purpose

Customer App Trail serves as a practical project for demonstrating Java, Spring Boot, REST API development, database persistence, validation, and Git-based version control.

## Author

Developed as a Java and Spring Boot learning project.
