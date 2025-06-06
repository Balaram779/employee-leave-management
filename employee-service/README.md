# Employee Service

This microservice manages employee information.

## Features

- Add new employees
- Stores data in H2 database
- Exposes REST APIs

## Tech Stack

- Spring Boot
- Spring Data JPA (H2)
- Maven

## API Endpoints

- `POST /employees` — Add an employee  
  Request body:
  ```json
  {
    "employeeId": "EMP001",
    "name": "Balaram",
    "department": "IT",
    "designation": "Engineer"
  }
  ```

## Run

```
mvn spring-boot:run
```

## Test

```
mvn test
```
