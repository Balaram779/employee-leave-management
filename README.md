# 🏢 Employee Leave Management System (Microservices + Kafka + Docker)

A microservices-based application that allows employees to apply for leave, process approval via Kafka events, and manage leave status via APIs.

---

## ✅ Technologies Used

- Java 17, Spring Boot (REST APIs)
- Apache Kafka (Inter-service messaging)
- Docker + Docker Compose (Kafka + Zookeeper)
- H2 Database (In-memory, per service)
- Postman (API testing)
- JUnit + Mockito (Unit tests)
- Maven (Build tool)

---

## 🧱 Microservices Overview

### 1. **Employee Service**
- Registers employees via `POST /employees`
- Stores in H2 DB
- REST API + JUnit tested

### 2. **Leave Service**
- Applies leave via `POST /leaves`
- Publishes leave requests to Kafka (`leave-events`)
- Consumes Kafka approval via `approval-events`
- Updates DB with approved/rejected status

### 3. **Approval Service**
- Consumes `leave-events` from Kafka
- Makes decision: Approve if leave ≤ 3 days, else Reject
- Publishes decision to `approval-events-v2`
- Stores approval status in DB
- Provides API: `GET /approvals/{leaveId}`

---

## 🔁 Kafka Event Flow

1. **User** → `POST /leaves`
2. **Leave Service** → Kafka topic `leave-events`
3. **Approval Service** → listens to `leave-events`, processes, then publishes to `approval-events-v2`
4. **Leave Service** → listens to `approval-events-v2`, updates DB

---

## 🚀 How to Run Locally

### Step 1: Start Kafka via Docker
```bash
docker-compose up

### Step 2: Start Microservices (in separate terminals)
# Employee Service
cd employee-service
mvn spring-boot:run

# Leave Service
cd leave-service
mvn spring-boot:run

# Approval Service
cd approval-service
mvn spring-boot:run

📬 Postman Collection
Create Employee
Apply Leave
Get Leave Status
Get Approval Decision
Import this Postman Collection to test the APIs:
👉 [employee-leave-system.postman_collection.json](./employee-leave-system.postman_collection.json)

## 📸 Screenshots
📄 See all screenshots in this document: [Screenshots.docx](./Balaram_Usecase_result_screenshots.docx)

🧪 Unit Tests
LeaveControllerTest: REST endpoint + Kafka mock
ApprovalEventConsumerTest: Kafka event → save approval decision
Coverage: REST + Kafka + DB

🖥️ H2 Database Consoles
Leave Service: http://localhost:8082/h2-console
Approval Service: http://localhost:8083/h2-console
Employee Service: http://localhost:8081/h2-console

🧾 Author
Marrapu Balarama Murthy
Java Developer | Spring Boot | Microservices | Kafka
8+ years experience in enterprise backend systems
Email: b9048635@gmail.com
GitHub: Balaram779
