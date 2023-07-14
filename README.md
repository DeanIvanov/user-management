# CRUD User Management Application

This is a REST API for CRUD operations on users. It uses Spring boot with Maven and the MySQL database is handled with JPA.

### Functionalities:
  - Create a new user
  - Get a single user by ID
  - Get all users sorted by ID
  - Get all users sorted by Date of Birth
  - Get all users sorted by Last name
  - Update single user specified by ID
  - Delete single user specified by ID
  - Soft delete single user specified by ID (disabled access)

### Requirements for running the application:
  - Development software (such as IntelliJ)
  - Local hosting tools for accessing the database
  - A web browser for accessing the swagger documentation or application like Postman

### Steps to run the application:
  - Run database creation script in order to create the database and tables:
      - It is located in the project structure under resources/db/db-create.sql 
  - Run database insert script in order to populate the database tables with test data:
      - It is located in the project structure under resources/db/db-insert-data.sql
  - Build and launch the application
  - You should now be able to access the Swagger documentation available at http://localhost:8080/swagger-ui/index.html#/
