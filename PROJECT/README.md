### Employee Management System
The Employee Management System is a microservices-based application built with Java (Spring Boot) and Angular. The system provides functionalities for user registration, authentication, and authorization, as well as CRUD operations for employees.

**Backend (Java Spring Boot)**
- User Service: Handles user registration, authentication, and authorization.
- Employee Service: Handles CRUD operations for employees.

**Frontend (Angular)**
- User Interface: Implements components for user registration, login, and employee management (list, add, edit, delete).
- Services: Provides Angular services for interacting with the backend APIs.
- Routing: Implements routing for navigating between different views.

**Database**
The system uses MySQL database, and the database settings are configured in the application.properties file.

**JWTAuthentication**
The system uses JWT-based authentication, and the JWT settings are configured in the application.properties file.


### User Service
The User Service is a microservice responsible for handling user registration, authentication, and authorization. It is built using Java and Spring Boot.

#### Endpoints
**Register a new user**
- POST /users/register: Register a new user.
Request Body: User object with username, password, and email fields.
Response: 201 Created with a User object containing the newly created user's details.
Authenticate a user
- POST /users/login: Authenticate a user and return a JWT token.
Request Body: User object with username and password fields.
Response: 200 OK with a JWT token in the response body.
- Retrieve logged-in user's profile
GET /users/profile: Retrieve the logged-in user's profile.
Request Header: Authorization with a valid JWT token.
Response: 200 OK with a User object containing the logged-in user's details.

**Entities**
- User
- Security
- Configuration
