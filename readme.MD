
# SIBS Order Management System

A Spring Boot application for managing orders, stock movements, items, and users.  
Uses PostgreSQL as the database.

---

## Table of Contents


- [Configuration](#configuration)
- [API Endpoints](#api-endpoints)

---

## Configuration

Configure your PostgreSQL database connection and mail properties in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.mail.host=smtp.example.com
spring.mail.port=587
spring.mail.username=your_email@example.com
spring.mail.password=your_email_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

Make sure your PostgreSQL server is running and the database is created.

---

## API Endpoints

### Items
| Method | Endpoint           | Description                  | Request Body                 |
|--------|--------------------|------------------------------|-----------------------------|
| GET    | `/items`           | List all items                |                             |
| GET    | `/items/{id}`      | Get item by ID               |                             |
| POST   | `/items`           | Create a new item             | Item JSON                   |
| PUT    | `/items/{id}`      | Update existing item          | Item JSON                   |
| DELETE | `/items/{id}`      | Delete item by ID             |                             |

---

### Orders
| Method | Endpoint           | Description                  | Request Body                 |
|--------|--------------------|------------------------------|-----------------------------|
| GET    | `/orders`          | List all orders               |                             |
| GET    | `/orders/{id}`     | Get order by ID               |                             |
| POST   | `/orders`          | Create a new order            | Order JSON                  |

---

### Stock Movements
| Method | Endpoint               | Description                  | Request Body                 |
|--------|------------------------|------------------------------|-----------------------------|
| GET    | `/stock-movements`     | List all stock movements      |                             |
| GET    | `/stock-movements/{id}`| Get stock movement by ID      |                             |
| POST   | `/stock-movements`     | Create a new stock movement   | StockMovement JSON          |
---

### Users
| Method | Endpoint           | Description                  | Request Body                 |
|--------|--------------------|------------------------------|-----------------------------|
| GET    | `/users`           | List all users                |                             |
| GET    | `/users/{id}`      | Get user by ID               |                             |
| POST   | `/users`           | Create a new user             | User JSON                   |
