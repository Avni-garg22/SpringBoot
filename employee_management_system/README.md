# Employee Management REST API

A Spring Boot REST API for managing employees with full CRUD, filtering, sorting, pagination, and salary analytics.

## Features

- Employee CRUD operations
- Filter by department
- Filter by salary threshold
- Sort by salary
- Pagination support
- Above-average salary query
- Employee count
- Global exception handling
- Custom `EmployeeNotFoundException`

## Tech Stack

- **Spring Boot**: 3.5.11
- **Spring Data JPA**: Database operations
- **Spring Web**: REST API
- **PostgreSQL**: Database
- **Java**: 17

## Project Structure

```
employee/
├── controller/
│   └── EmployeeController.java     # REST endpoints
├── entity/
│   └── Employee.java               # Employee entity
├── exception/
│   ├── EmployeeNotFoundException.java
│   └── GlobalExceptionHandler.java
├── repository/
│   └── EmployeeRepository.java     # JPA repository + custom queries
└── service/
    ├── EmployeeService.java        # Service interface
    └── EmployeeServiceImpl.java    # Service implementation
```

## Configuration

Update `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/springdb
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /employees | Create employee |
| GET | /employees | Get all employees |
| GET | /employees/{id} | Get employee by ID |
| PUT | /employees/{id} | Update employee |
| DELETE | /employees/{id} | Delete employee |
| GET | /employees/department/{name} | Get by department |
| GET | /employees/highsalary?salary=50000 | Get employees above salary |
| GET | /employees/count | Count all employees |
| GET | /employees/sort | Sort by salary (ascending) |
| GET | /employees/page?page=0&size=5 | Paginated results |
| GET | /employees/above-average | Employees above average salary |
