# 🏦 Banking Application - Backend

A robust RESTful API for a banking application built with Spring Boot, providing secure account management and transaction processing capabilities.

## 🌟 Live Demo

**Backend API:** [https://bankingapp-backend-bankingspringsql.up.railway.app](https://bankingapp-backend-bankingspringsql.up.railway.app/api/accounts)

**Frontend Application:** [https://banking-sarthkg-1122.netlify.app](https://banking-sarthkg-1122.netlify.app)

## 📋 Overview

This is the backend API for a comprehensive banking application that enables users to manage bank accounts and perform financial transactions. The application provides a complete set of RESTful endpoints for account creation, balance management, deposits, withdrawals, and account queries with built-in transaction validation.

## ✨ Features

- ✅ **Account Management**
  - Create new bank accounts with auto-generated account numbers
  - View all accounts or specific account details
  - Delete accounts
  
- 💰 **Transaction Processing**
  - Secure deposit operations
  - Withdrawal with balance validation
  - Real-time balance updates
  
- 🔒 **Data Validation**
  - Transaction amount validation (positive values only)
  - Insufficient balance checking for withdrawals
  - Input validation for account creation

- 🗄️ **Database Integration**
  - MySQL database with Hibernate ORM
  - Automatic schema generation
  - Efficient query optimization

## 🛠️ Tech Stack

### **Backend Framework**
- **Spring Boot 3.x** - Main application framework
- **Spring Web** - RESTful API development
- **Spring Data JPA** - Database abstraction layer
- **Hibernate** - ORM (Object-Relational Mapping)

### **Database**
- **MySQL 8.0** - Primary database
- **HikariCP** - Connection pooling

### **Build Tool**
- **Maven** - Dependency management and build automation

### **Language**
- **Java 17** - Core programming language

### **Additional Libraries**
- **Lombok** - Reduces boilerplate code
- **MySQL Connector/J** - JDBC driver for MySQL



## 🚀 API Endpoints

### Base URL: `/api/accounts`

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/` | Create a new account |
| `GET` | `/` | Get all accounts |
| `GET` | `/{id}` | Get account by ID |
| `PUT` | `/deposit` | Deposit money |
| `PUT` | `/withdraw` | Withdraw money |
| `DELETE` | `/{id}` | Delete account |

### Example Requests

#### Create Account
```bash
POST /api/accounts
Content-Type: application/json

{
  "accountHolderName": "John Doe",
  "balance": 1000.00
}
```

#### Deposit Money
```bash
PUT /api/accounts/deposit
Content-Type: application/json

{
  "accountId": 1,
  "amount": 500.00
}
```

#### Withdraw Money
```bash
PUT /api/accounts/withdraw
Content-Type: application/json

{
  "accountId": 1,
  "amount": 200.00
}
```

#### Get All Accounts
```bash
GET /api/accounts
```

## 💻 Local Development Setup

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

### Installation Steps

1. **Clone the repository**
```bash
git clone https://github.com/yourusername/banking-backend.git
cd banking-backend
```

2. **Create MySQL Database**
```sql
CREATE DATABASE banking_db;
```

3. **Configure Database**

Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. **Build the project**
```bash
./mvnw clean install
```

5. **Run the application**
```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`



## 🌐 Deployment

This application is deployed on **Railway** with the following configuration:

- **Platform:** Railway.app
- **Database:** MySQL (Railway managed)
- **Environment:** Production
- **Auto-deploy:** Enabled on git push

### Environment Variables (Production)
```
MYSQLHOST=<railway-mysql-host>
MYSQLPORT=3306
MYSQLDATABASE=railway
MYSQLUSER=root
MYSQLPASSWORD=<railway-mysql-password>
ALLOWED_ORIGINS=https://banking-sarthkg-1122.netlify.app
PORT=8080
```

## 🧪 Testing

### Using cURL
```bash
# Test API health
curl http://localhost:8080/api/accounts

# Create account
curl -X POST http://localhost:8080/api/accounts \
  -H "Content-Type: application/json" \
  -d '{"accountHolderName":"Test User","balance":1000}'
```

### Using Postman
Import the API collection and test all endpoints with the Postman interface.

## 🔧 Configuration

### Application Properties
```properties
# Server Configuration
server.port=${PORT:8080}

# Database Configuration
spring.datasource.url=jdbc:mysql://${MYSQLHOST:localhost}:${MYSQLPORT:3306}/${MYSQLDATABASE:banking_db}
spring.datasource.username=${MYSQLUSER:root}
spring.datasource.password=${MYSQLPASSWORD:password}

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# CORS
allowed.origins=${ALLOWED_ORIGINS:http://localhost:3000}
```

## 🏗️ Architecture

The application follows a **layered architecture** pattern:

```
┌─────────────────────────────────────┐
│         Controller Layer            │  ← REST API Endpoints
├─────────────────────────────────────┤
│          Service Layer              │  ← Business Logic
├─────────────────────────────────────┤
│        Repository Layer             │  ← Data Access
├─────────────────────────────────────┤
│          Database (MySQL)           │  ← Data Storage
└─────────────────────────────────────┘
```


## 🔐 Security Features

- Input validation on all endpoints
- Transaction amount validation
- Balance verification before withdrawals
- CORS configuration for secure cross-origin requests
- Environment-based configuration for sensitive data

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 Future Enhancements

- [ ] User authentication and authorization (JWT)
- [ ] Transaction history tracking
- [ ] Account statements generation
- [ ] Transfer money between accounts
- [ ] Interest calculation
- [ ] Email notifications
- [ ] Rate limiting
- [ ] API documentation with Swagger/OpenAPI
- [ ] Unit and integration tests
- [ ] Logging and monitoring

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


## 🙏 Acknowledgments

- Spring Boot Documentation
- Railway Deployment Platform
- MySQL Community

