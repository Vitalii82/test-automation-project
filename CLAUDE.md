# Project Context
This is a QA Automation project built with Java, Maven, Selenium, TestNG, and RestAssured.

## Main Areas
- UI automation tests
- API automation tests
- Page Object Model
- Maven-based execution
- TestNG suites

## Rules for Claude
- Do not modify multiple files unless explicitly requested
- Prefer minimal safe changes
- Do not run the full test suite unless explicitly requested
- Focus only on the file/class/method mentioned in the task
- Do not refactor unrelated code
- Do not investigate Maven, API, network, or other layers unless the task is explicitly about them
- When debugging, prefer adding temporary debug output instead of broad refactors
- Remove temporary debug code after diagnosis

## UI Testing Rules
- Prefer element-based assertions
- Use Page Object Model
- Avoid page source assertions
- Avoid brittle waits and unnecessary sleeps
- Prefer targeted waits only when needed

## API Testing Rules
- Keep tests explicit and readable
- Prefer stable assertions
- Avoid unnecessary global state

## Workflow
- One task at a time
- One change at a time
- One verification at a time
- Keep the working baseline green