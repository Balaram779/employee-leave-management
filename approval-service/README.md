# Approval Service

This microservice consumes leave events from Kafka and makes approval decisions.

## Features

- Listens to Kafka topic `leave-events`
- Sends decisions to topic `approval-events`
- Stores decisions in H2
- Exposes REST APIs

## Tech Stack

- Spring Boot
- Kafka
- Spring Data JPA (H2)
- Maven

## API Endpoints

- `GET /approvals/{leaveId}` — Get approval for a leave ID

## Run

```
mvn spring-boot:run
```

## Test

```
mvn test
```
