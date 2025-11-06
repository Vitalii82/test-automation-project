# QA Automation project

Modern, full-stack test automation project combining **Carina**, **Selenium**, **Appium**, and **Allure** — fully containerized with **Docker** and CI-ready for **Jenkins**.


## Features
- Java + Maven + TestNG
- Selenium (Web UI)
- Appium (Android)
- REST API testing (RestAssured)
- Allure reporting (integrated with Jenkins)
- Carina framework (driver & config management)
- Dockerized infra: Selenium Grid + Appium + Jenkins
- Sample mobile app (`app.apk`) in resources

---

## Project Structure
src/
├── main/
│ ├── java/com/solvd/
│ │ ├── ui/pages/ → Page Object Models
│ │ └── ui/components/ → Reusable UI components
│ └── resources/
│ ├── android/apps/ → demo app.apk
│ └── carina-docker.properties
└── test/
├── java/com/solvd/
│ ├── ui/tests/
│ ├── api/tests/
│ └── mobile/tests/
└── resources/
├── _config.properties
└── testng.xml