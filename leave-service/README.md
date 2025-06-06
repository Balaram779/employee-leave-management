# Leave Service

This microservice lets employees apply for leave and publishes events to Kafka.

## Features

- Apply for leave
- Sends leave requests to Kafka topic `leave-events`
- Stores requests in H2
- Exposes REST APIs

## Tech Stack

- Spring Boot
- Kafka
- Spring Data JPA (H2)
- Maven

## API Endpoints

- `POST /leaves` — Apply leave  
- `GET /leaves/{leaveId}` — Get leave by ID

## Run

```
mvn spring-boot:run
```

## Test

```
mvn test
```
