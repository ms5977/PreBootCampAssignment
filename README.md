# Pre-Bootcamp Assignment Project

This project is a Spring Boot-based web application designed for managing `Credentials` and their associated `Roles`. It utilizes Spring Data JPA for database interactions and supports CRUD operations for managing entities.

## Features

- **Credential Management**: CRUD operations for managing user credentials.
- **Role Management**: CRUD operations for managing roles associated with credentials.
- **Relational Mapping**: Many-to-Many relationship between `Credentials` and `Roles`.
- **REST API**: Exposes endpoints for interacting with credentials and roles.
- **Database Integration**: Uses MySQL for data persistence.

## Technologies Used

- **Backend**:
  - Java
  - Spring Boot
  - Spring Data JPA
- **Database**:
  - In memory Database (H2)
- **Tools**:
  - Maven (for dependency management)
  - Lombok (for reducing boilerplate code)

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6+
- MySQL 8.0+

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/your-repo.git
   ```

2. Navigate to the project directory:
   ```bash
   cd your-repo
   ```

3. Configure the database in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. Build the project:
   ```bash
   ./mvnw clean install
   ```

5. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

6. Access the application:
   - API Base URL: `http://localhost:8080`

## API Endpoints

### Credential Endpoints

| Method | Endpoint                 | Description                     |
|--------|--------------------------|---------------------------------|
| GET    | `/api/credentials`       | Retrieve all credentials       |
| GET    | `/api/credentials/{id}`  | Retrieve a credential by ID    |
| POST   | `/api/credentials`       | Create a new credential        |
| PUT    | `/api/credentials/{id}`  | Update an existing credential  |
| DELETE | `/api/credentials/{id}`  | Delete a credential by ID      |

### Role Endpoints

| Method | Endpoint         | Description              |
|--------|------------------|--------------------------|
| GET    | `/api/roles`     | Retrieve all roles       |
| POST   | `/api/roles`     | Create a new role        |
| DELETE | `/api/roles/{id}`| Delete a role by ID      |

## Project Structure

```
src/main/java/com/main
├── controller          # REST controllers
├── entity              # JPA entities
├── repository          # Spring Data JPA repositories
├── service             # Business logic layer
└── PreBootCampAssigmentApplication.java # Main application class
```

## Database Schema

### Credential Table
| Column        | Type          | Description              |
|---------------|---------------|--------------------------|
| `id`          | BIGINT (PK)   | Primary key              |
| `username`    | VARCHAR(255)  | Username of the user     |
| `password`    | VARCHAR(255)  | Encrypted password       |

### Role Table
| Column        | Type          | Description              |
|---------------|---------------|--------------------------|
| `id`          | BIGINT (PK)   | Primary key              |
| `name`        | VARCHAR(255)  | Name of the role         |

### Credential_Roles Table (Join Table)
| Column          | Type        | Description                       |
|------------------|-------------|-----------------------------------|
| `credential_id`  | BIGINT (FK) | Foreign key referencing `id` in `Credential` |
| `role_id`        | BIGINT (FK) | Foreign key referencing `id` in `Role`       |

## Future Enhancements

- Implement authentication and authorization.
- Add Swagger/OpenAPI documentation for better API exploration.
- Write comprehensive unit and integration tests.



## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
