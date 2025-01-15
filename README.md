# CodeArena

CodeArena is a Spring Boot-based online coding platform that allows users to solve programming problems and manage coding submissions.

## 🚀 Features

- User authentication and authorization system
- Problem management with pagination support
- Code submission and evaluation system
- Job/submission tracking and management
- Question bank management with categorization (LMC system)

## 🛠️ Tech Stack

- **Backend Framework**: Spring Boot 3.3.5
- **Java Version**: JDK 17
- **Database**: MySQL
- **Authentication**:
  - Spring Security
  - JWT (JSON Web Tokens)
- **Data Management**:
  - Lombok for reducing boilerplate code
  - Jackson for JSON processing
  - MyBatis for database operations
- **Build Tool**: Maven

## 📁 Project Structure

```
com.xyz.codearena/
├── controller/
│   ├── EditController.java       # Problem editing endpoints
│   ├── ManagerController.java    # Management operations
│   ├── SecurityController.java   # Authentication endpoints
│   └── ThinkController.java      # Problem solving operations
├── dao/
│   ├── Job.java                 # Job/submission entity
│   ├── JobPageParam.java        # Job pagination parameters
│   ├── Option.java             # Options configuration
│   ├── Question.java           # Problem entity
│   ├── QuestionParam.java      # Question query parameters
│   └── User.java               # User entity
├── service/
│   ├── EditService.java        # Problem editing interface
│   ├── ManagerService.java     # Management interface
│   ├── SecurityService.java    # Authentication interface
│   └── ThinkService.java       # Problem solving interface
└── mapper/                     # MyBatis mappers (not shown)
```

## 🔑 Key Components

### Controllers

- **EditController**: Handles problem creation and updates
- **ManagerController**: Manages system configuration and options
- **SecurityController**: Handles user authentication
- **ThinkController**: Manages problem queries and job submissions

### Data Models

- **Question**: Represents programming problems with PDF support
- **Job**: Tracks code submissions and their states
- **User**: Manages user information and roles
- **Option**: Handles system configuration options

## 🚦 API Endpoints

### Authentication

- `POST /login` - User login

### Problem Management

- `POST /edit/update/question` - Update existing problem
- `POST /edit/add/question` - Add new problem
- `GET /think/query/questions` - Query problems by ID or LMC
- `POST /think/query/page/questions` - Paginated problem query

### Job Management

- `POST /think/jobs/query` - Query submissions with pagination
- `POST /think/delete/questions` - Delete problems
- `POST /thinkhome/jobs/delete` - Delete submissions

### System Management

- `GET /think/options` - Get system options
- `GET /test` - Test endpoint

## 🛠️ Setup and Installation

### Prerequisites

1. JDK 17 or higher
2. Maven 3.6 or higher
3. MySQL 8.0 or higher

### Dependencies

The project uses the following major dependencies:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>3.0.3</version>
</dependency>
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>
```

### Installation Steps

1. Clone the repository:

```bash
git clone [your-repository-url]
cd CodeArena
```

2. Configure MySQL database:
  - Create a new MySQL database
  - Update `src/main/resources/application.properties` with your database configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Build the project:

```bash
mvn clean install
```

4. Run the application:

```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

### Resource Configuration

The project includes special resource handling for MyBatis mapper files:

```xml
<resources>
    <resource>
        <directory>src/main/java</directory>
        <includes>
            <include>**/*.xml</include>
        </includes>
    </resource>
    <resource>
        <directory>src/main/resources</directory>
    </resource>
</resources>
```

### Development Notes

- The project uses Lombok for code generation. Ensure your IDE has Lombok plugin installed.
- JWT is used for authentication. Configure your JWT secret in the application properties.
- MyBatis mapper XML files should be placed alongside their Java interfaces.

## 🤝 Contributing

Welcome to contribute to CodeArena! There are steps below:

1. Fork the repository.

2. Create a new branch:

   ```bash
   git checkout -b feature/your_new_feature
   ```

3. Commit the code:

   ```bash
   git commit -m "describe your feature"
   ```

4. Push to your repository

   ```bash
   git push origin feature/your_new_feature
   ```

5. Commit Pull Request。

## 📝 License

This project uses the MIT License. See license file for details
