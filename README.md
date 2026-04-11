# QA Automation Project

This is a personal QA automation project where I practice UI, API, and mobile testing in one place.

I started it as a learning project, but over time I kept improving it by adding new tests, fixing unstable scenarios, and making the test suite cleaner and more reliable.

The main idea is to keep a working test automation setup that reflects how I would approach a real project.

---

## What is covered

In this project, I work with:

- UI tests using Selenium and Page Object Model  
- API tests using RestAssured  
- Test execution with TestNG  
- Basic mobile test setup (Appium-ready)  

I try to keep things simple, readable, and practical rather than over-engineered.

---

## Project highlights

- Page Object Model used for UI tests  
- Stable default test suite (`mvn test`)  
- API tests for public endpoints (HttpBin, JsonPlaceholder)  
- Flaky UI scenarios isolated from the stable suite  
- Maven + TestNG based execution  
- Incremental improvements instead of large refactoring  

---

## How to run

### Run the default stable test suite

```bash
mvn test
###Run a specific test class
mvn -Dtest=ClassName test
###Run a specific test method
mvn -Dtest=ClassName#methodName test
###Run a specific TestNG suite
mvn test -DsuiteXmlFile=src/test/resources/testng.xml