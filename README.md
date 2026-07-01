# Login Testing Simulator

A Java console application that simulates a user login system while demonstrating software engineering principles and quality assurance practices. This project was built as a beginner-friendly portfolio project to showcase Java programming, object-oriented design, validation, exception handling, and automated testing with JUnit 5.

---

## Features

* User login with username and password
* Input validation
* Password length validation
* Unknown user detection
* Incorrect password handling
* Account locking after three failed login attempts
* User logout
* Display registered users
* Custom exception handling
* Automated unit tests with JUnit 5

---

## Technologies Used

* Java 21
* Maven
* JUnit 5
* IntelliJ IDEA
* Git

---

## Project Structure

```text
Login-testing/
├── README.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── loginsimulator
│   │   │           ├── Main.java
│   │   │           ├── LoginService.java
│   │   │           ├── LoginException.java
│   │   │           ├── User.java
│   │   │           ├── UserRepository.java
│   │   │           └── Validator.java
│   │   └── resources
│   └── test
│       └── java
│           └── com
│               └── loginsimulator
│                   └── LoginServiceTest.java
```

---

## Software Engineering Principles Demonstrated

### Encapsulation

The `User` class keeps its fields private and provides controlled access through getters and setters.

### Single Responsibility Principle (SRP)

Each class has one clearly defined responsibility:

* `User` – stores user information
* `UserRepository` – manages user data
* `LoginService` – handles login logic
* `Validator` – validates user input
* `LoginException` – represents login-related exceptions
* `Main` – provides the user interface

### Separation of Concerns

The application separates:

* User interface
* Business logic
* Validation
* Data management

making the code easier to maintain and test.

### Exception Handling

Custom exceptions are used to provide meaningful error messages for login failures.

### Unit Testing

Core login functionality is tested using JUnit 5 to ensure reliability and correctness.

---

## Running the Application

Clone the repository:

```bash
git clone <repository-url>
```

Navigate into the project:

```bash
cd Login-testing
```

Compile the project:

```bash
mvn compile
```

Run the tests:

```bash
mvn test
```

You can also run the application directly from IntelliJ IDEA by opening `Main.java` and selecting **Run**.

---

## Sample Login

### Successful Login

```text
Username: admin
Password: admin123

Login Successful
```

### Incorrect Password

```text
Username: admin
Password: wrongpassword

Login Failed
Reason: Incorrect password
```

### Unknown User

```text
Username: john
Password: hello123

User not found
```

### Empty Username

```text
Username:
Password: admin123

Username cannot be empty
```

### Empty Password

```text
Username: admin
Password:

Password cannot be empty
```

### Password Too Short

```text
Password must contain at least 8 characters.
```

### Locked Account

```text
Account Locked

Please contact administrator.
```

---

## Test Cases

| Test ID | Scenario                    | Expected Result    |
| ------- | --------------------------- | ------------------ |
| TC001   | Valid username and password | Login successful   |
| TC002   | Incorrect password          | Login failed       |
| TC003   | Unknown username            | User not found     |
| TC004   | Empty username              | Validation message |
| TC005   | Empty password              | Validation message |
| TC006   | Password too short          | Validation message |
| TC007   | Locked account              | Login denied       |
| TC008   | Three failed attempts       | Account locked     |
| TC009   | Password case sensitivity   | Login fails        |
| TC010   | Username with spaces        | Validation message |

---

## Automated Testing

This project includes automated unit tests using JUnit 5 that verify:

* Successful login
* Invalid password handling
* Unknown users
* Empty username validation
* Empty password validation
* Password length validation
* Account locking after multiple failed attempts
* Locked account rejection

Run all tests using:

```bash
mvn test
```

---

## Future Improvements

Possible enhancements include:

* Password hashing
* User registration
* Password reset functionality
* User roles (Admin/User)
* Login history
* Audit logging
* Persistent storage using JSON or a database
* JavaFX graphical user interface
* REST API using Spring Boot
* Selenium UI automation tests
* Test coverage reporting with JaCoCo
* Continuous Integration using GitHub Actions

---

## Learning Outcomes

This project demonstrates practical experience with:

* Java programming
* Object-Oriented Programming (OOP)
* Software engineering principles
* Maven project management
* Exception handling
* Input validation
* Unit testing with JUnit 5
* Git version control
* Clean code practices

---

## Author

**Nobuntu Batyi**

This project was developed as part of my software engineering and quality assurance learning journey and serves as a portfolio project demonstrating Java development and automated testing skills.
