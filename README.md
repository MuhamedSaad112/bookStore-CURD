# Bookstore Demo Project

## 📖 Project Overview

A comprehensive Spring Boot-based bookstore management system providing robust RESTful APIs for managing books, authors, categories, orders, and more. This demo project demonstrates best practices in building a full-featured backend application.

## 🚀 Features

- Full CRUD operations for:
  - Authors
  - Books
  - Categories
  - Orders
  - Users
  - Roles
  - Shipping Addresses
  - Shopping Cart
- Comprehensive API endpoints
- Data validation
- Database interaction using JPA

## 🛠 Technologies Used

- **Backend Framework:** Spring Boot
- **ORM:** Spring Data JPA
- **Database:** H2/MySQL/PostgreSQL
- **Validation:** Jakarta Validation
- **Build Tool:** Maven

## 📋 Prerequisites

- Java 17 or higher
- Maven
- Git
- Preferred Database (H2/MySQL/PostgreSQL)

## 🔧 Installation

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/bookstore-demo.git
cd bookstore-demo
```

### 2. Configure Database
Edit `application.properties` to configure your database connection:

```properties
# H2 Database
spring.datasource.url=jdbc:mysql://localhost:3306/bookstore?createDatabaseIfNotExist=true
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=mohamed
spring.datasource.password=mohamed
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

### 3. Build the Project
```bash
mvn clean install
```

### 4. Run the Application
```bash
mvn spring-boot:run
```

## 🌐 API Endpoints

### Core Endpoint Categories
- Authors: `/api/author`
- Books: `/api/book`
- Categories: `/api/categories`
- Orders: `/api/order`
- Users: `/api/user`
- Roles: `/api/role`
- Cart: `/api/cart`
- Shipping Address: `/api/shippingaddress`

### Common Endpoint Patterns
For most entities, standard endpoints include:
- `GET /{entityName}`: List all
- `GET /{entityName}/{id}`: Find by ID
- `POST /{entityName}`: Create new
- `PUT /{entityName}`: Update existing
- `DELETE /{entityName}/{id}`: Delete by ID



## 📊 Database Configuration

Supports multiple databases:
- H2 (Development/Testing)
- MySQL (Production)
- PostgreSQL (Alternative)

## 🧪 Testing

Run test suite:
```bash
mvn test
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
   ```bash
   git checkout -b feature/AmazingFeature
   ```
3. Commit your changes
   ```bash
   git commit -m 'Add some AmazingFeature'
   ```
4. Push to the branch
   ```bash
   git push origin feature/AmazingFeature
   ```
5. Open a Pull Request


## 🚦 Development Roadmap

- [ ] Add more comprehensive unit tests
- [ ] Implement caching mechanisms
- [ ] Add logging and monitoring
- [ ] Enhance security features



## 📞 Contact

## 👨‍💻 Developer
Mohamed Saad
GitHub: [https://github.com/MuhamedSaad112](https://github.com/MuhamedSaad112)

Project Link: [https://github.com/yourusername/bookstore-demo](https://github.com/yourusername/bookstore-demo)
```

## 💡 Additional Resources
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Maven Documentation](https://maven.apache.org/guides/index.html)
