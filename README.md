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
  - Soft-delete single user specified by ID (limited access)

### Requirements for running the application:
  - Development software (such as IntelliJ)
  - Local hosting tools for accessing the database
  - A web browser for accessing the swagger documentation or an application like Postman

### Steps to run the application:
  - Run local host tool
  - Run database creation script in order to create the database and tables (the database runs on MySQL 5.7):
      - It is located in the project structure under resources/db/db-create.sql.
      - The script adds a database-specific user. If issues in its creation are present, it can be added manually with username 'superuser' and password '1234' or the database access properties can be adjusted 
  - Run database insert script in order to populate the database tables with test data:
      - It is located in the project structure under resources/db/db-insert-data.sql
      - All provided users have an encoded password of '12345678'. You can use any of their email addresses and that password to log in
  - Build and launch the application
  - You should now be able to access the Swagger documentation available at http://localhost:8080/swagger-ui/index.html#/
    - If prompted to log in, you can use username 'swagger' with password '12345678' or any other user in the database
  - For full functionality and testing, you can use Postman or similar
  - Simple web pages with only GET functions through the API should also be available at http://localhost:8080
