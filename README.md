# Playwright Automation Framework

A scalable UI automation framework built using **Playwright**, **Java**, **TestNG**, and **Maven** following the **Page Object Model (POM)** design pattern.

This project is being developed as an enterprise-ready automation framework with a focus on maintainability, reusability, and scalability.

---

## Tech Stack

- Java 17
- Playwright for Java
- TestNG
- Maven
- Git & GitHub
- Eclipse IDE

---

## Project Structure

```
playwright-automation
│
├── src
│   └── test
│       ├── java
│       │   └── com.yashraj.playwright
│       │       ├── base
│       │       ├── pages
│       │       ├── tests
│       │       ├── listeners
│       │       └── utils
│       │
│       └── resources
│           ├── config
│           │   └── config.properties
│           ├── testdata
│           └── testng.xml
│
├── pom.xml
└── README.md
```

---

## Framework Design

### Base Package
Contains browser setup and teardown.

Responsibilities:
- Playwright initialization
- Browser launch
- BrowserContext creation
- Page creation
- Cleanup after test execution

---

### Pages Package

Implements the Page Object Model (POM).

Each page contains:
- Locators
- Page actions
- Page validations

Example:
- LoginPage
- InventoryPage

---

### Tests Package

Contains TestNG test classes.

Responsibilities:
- Execute test scenarios
- Call page methods
- Perform assertions

---

### Utils Package

Contains reusable utility classes.

Examples:
- Configuration reader
- JSON reader
- Excel reader
- Common helper methods

---

### Listeners Package

Contains TestNG listeners.

Future enhancements:
- Screenshot on failure
- Logging
- Report generation
- Retry mechanism

---

## Features

✔ Maven Project

✔ Playwright Java

✔ TestNG Integration

✔ Page Object Model

✔ Git Version Control

✔ Browser Launch

✔ Assertions

✔ CSS Selectors

✔ Playwright Locators

✔ Cross-browser support (planned)

✔ Data Driven Framework (planned)

✔ Reporting (planned)

---

## Running Tests

Run a single test:

```
Right Click → LoginTest.java
Run As → TestNG Test
```

Run complete suite:

```
Right Click → testng.xml
Run As → TestNG Suite
```

---

## Browser Configuration

Current browser:

- Chromium (Chrome)

Headless Mode:

```java
.setHeadless(false)
```

---

## Sample Test Flow

```
Launch Browser

↓

Navigate to Application

↓

Enter Username

↓

Enter Password

↓

Click Login

↓

Validate Inventory Page

↓

Close Browser
```

---

## Current Learning Scope

- Playwright Java API
- Browser & Context Management
- Playwright Locators
- Assertions
- TestNG
- Page Object Model
- Git & GitHub

---

## Planned Enhancements

- Browser Factory
- Config Reader
- Excel Data Provider
- JSON Test Data
- Extent Reports
- Log4j2 Logging
- Screenshot on Failure
- Retry Analyzer
- Parallel Execution
- Cross Browser Execution
- CI/CD using GitHub Actions
- Docker Support
- Jenkins Integration

---

## Author

**Yashraj Suman**

QA Automation Engineer

GitHub: [https://github.com/Itsyashraj]

---

## License

This project is intended for learning, practice, and demonstration purposes.
