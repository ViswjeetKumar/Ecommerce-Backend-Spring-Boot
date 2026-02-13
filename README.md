# 🛒 E-Commerce Backend — Spring Boot

A robust backend system for an e-commerce platform built using **Java and Spring Boot**.  
This project provides RESTful APIs for managing products, categories, users, and core e-commerce operations.

Designed to demonstrate real-world backend development skills including API design, database integration, layered architecture, and exception handling.

---

##  Features

- 🔐 RESTful APIs for e-commerce operations
- 📦 Product management (Create, Read, Update, Delete)
- 🗂️ Category management
- 👤 User management
- 🧾 Order processing logic
- 🗄️ Database integration using JPA/Hibernate
- 🧩 Layered architecture (Controller → Service → Repository)
- ⚡ Global exception handling
- ✅ Input validation

---

##  Tech Stack

### Backend
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- JPQL
- Pageable
### Database
- MySQL / H2 Database(Testing)

### Tools & Build
- Maven
- Postman (API Testing)
- Git & GitHub

---

## 📂 Project Structure

src/main/java 

⟫ controller ✓ REST Controllers (API endpoints)

⟫ service ✓ Business logic layer

⟫ repository ✓ Data access layer (JPA Repositories)

⟫ model/entity ✓ Database entities

⟫ exception ✓ Custom exception handling


---

## ⚙️ Getting Started

### Prerequisites

- Java 17 or later
- Maven
- MySQL (optional if using H2)

---

### 🔧 Run Locally

#### 1. Clone the repository

git clone https://github.com/ViswjeetKumar/Ecommerce-Backend-Spring-Boot.git


#### 2️. Navigate into the project

cd Ecommerce-Backend-Spring-Boot


#### 3️.  Configure Database

Update `application.properties`:

For MySQL:

spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update


OR use H2 database (default for testing).

---

#### 4️.  Run the application

mvn spring-boot:run


Server will start at:

http://localhost:8080


---

## 📡 API Testing

Use **Postman** or any REST client to test endpoints.

Example endpoints:

- GET /products
- POST /products
- PUT /products/{id}
- DELETE /products/{id}

---

## 🎯 Learning Outcomes

This project demonstrates:

- Building scalable REST APIs using Spring Boot
- Implementing layered architecture
- Database operations using JPA/Hibernate
- Exception handling and validation
- Backend system design for real-world applications

---

## 👨‍💻 Author

**Viswjeet Kumar**

- LinkedIn: https://linkedin.com/in/viswjeet-kumar-engineer
- GitHub: https://github.com/ViswjeetKumar

---

⭐ If you found this project useful, consider giving it a star.