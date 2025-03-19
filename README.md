# Report Generator

A Spring Boot microservice for generating PDF reports using **JasperReports**, with optional integration with **PostgreSQL**.

## 📌 Prerequisites

- Java 17
- Maven
- Docker (optional, for PostgreSQL)

## 🚀 Project Configuration

### 📥 Clone the repository

```sh
git clone https://github.com/your-username/report-generator.git
cd report-generator
```

## ⚙️ Configuration Options

### 🏷️ Option A: Run **without database**

1. Open the `src/main/resources/application.properties` file
2. Comment out the PostgreSQL configuration lines:

```properties
# spring.datasource.url=jdbc:postgresql://db:5432/your_database
# spring.datasource.username=your_user
# spring.datasource.password=your_password
# spring.jpa.hibernate.ddl-auto=update
```

3. Add this line to disable database auto-configuration:

```properties
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
```

### 🏷️ Option B: Use **PostgreSQL**

1. Create the `.env` file from the example:

```sh
cp .env.example .env
```

2. Edit the `.env` file with your database credentials:

```env
DATABASE_HOST=localhost
DATABASE_PORT=5432
DATABASE_NAME=your_database
DATABASE_USER=your_user
DATABASE_PASSWORD=your_password
```

3. Start **PostgreSQL** via **Docker**:

```sh
docker-compose up -d db
```

## ▶️ Running the Application

### 🔹 Local execution (without Docker)

```sh
mvn spring-boot:run
```

### 🔹 Running with Docker

```sh
docker-compose up --build
```

## ✅ Tests

### 🔹 Run tests (uses an in-memory H2 database)

```sh
mvn test
```

### 🔹 Create build without running tests

```sh
mvn clean package -DskipTests
```

## 📡 API Endpoints

### 📝 Generate a report

```http
GET /api/reports/generate?reportPath=classpath:reports/example.jasper
```

### 🔍 Health Check

```http
GET /actuator/health
```

## ℹ️ Notes

- Database integration **is optional**.
- For **production**, replace `localhost` with the actual database host.
- `.jasper` files should be stored in the directory:
```plaintext
src/main/resources/reports/
```
- If **UnknownHostException: db`** occurs, check if Docker and the PostgreSQL service are running.

## 🛑 Cleanup (Stop Docker services)

```sh
docker-compose down -v
```

---