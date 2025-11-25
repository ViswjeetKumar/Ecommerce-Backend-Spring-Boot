
# 🛒 Spring Boot E-Commerce Product API

A simple and clean **REST API for managing products** in an e-commerce system, built using **Spring Boot**, **Spring Data JPA**, and **H2 database**.  
Supports full CRUD (Create, Read, Update, Delete) operations.

---

## 🚀 Tech Stack

| Technology | Use |
|------------|-----|
| Java 17+ | Core language |
| Spring Boot | REST API development |
| Spring Data JPA | Database ORM |
| H2 Database | In-memory / file DB |
| Lombok | Reduce boilerplate code |
| Maven | Build and dependency management |

---

## ✨ Features

- Add new products
- Get all products
- Get a product by ID
- Update product (full or partial update)
- Delete product
- Persistent H2 database (file mode)
- Constructor-based dependency injection
- Clean layered architecture (Controller → Service → Repository)

---

## 📦 API Endpoints

### 🔍 Get all products
```http
GET /api/products
````

### 🔍 Get product by ID

```http
GET /api/products/{id}
```

### ➕ Create a new product

```http
POST /api/products
```

#### Example JSON body

```json
{
  "name": "MacBook Pro 14",
  "description": "Apple laptop with M3 chip",
  "brand": "Apple",
  "price": 1999.99,
  "catagory": "Computers",
  "released_date": "2024-03-10",
  "available": true,
  "quantity": 15
}
```

### ✏ Update product (partial update)

```http
PATCH /api/products/{id}
```

### 🗑 Delete product

```http
DELETE /api/products/{id}
```

---

## 🗄 Database Configuration (H2 - File Mode)

`application.properties` example

```properties
spring.application.name=ecom_1
spring.jpa.show-sql=true
spring.datasource.url=jdbc:h2:file:./data/my_db1
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.datasource.username=sa
spring.datasource.password=
```

H2 Console:

```
http://localhost:8080/h2-console
```

---

## ▶ How to Run the Project

### Using IntelliJ IDEA

1. Clone the repo

   ```bash
   git clone <your-repo-url>
   ```
2. Open project in IntelliJ
3. Wait until Maven dependencies download
4. Run `Ecom1Application.java`
5. Test APIs using Postman or browser

### Running via Maven command

```bash
mvn spring-boot:run
```

---

## 📁 Project Structure

```
src
 └── main
     ├── java
     │   └── com.ecom.ecom_1
     │        ├── Controller
     │        ├── Service
     │        └── Repository
     └── resources
         ├── application.properties
         └── data.sql (optional)
```

---

## 🤝 Contributions

Pull requests are welcome.
For major changes, please open an issue first to discuss the change.

---

## 📄 License

This project is open-source and free to use.

---

# ⭐ Show Support

If you found this useful, give the repository a **star ⭐ on GitHub**!

````

---

## Next steps
- Create a file named `README.md` in your project root
- Paste the content above
- Commit & push it to GitHub:

### CLI
```bash
git add README.md
git commit -m "Add README documentation"
git push

