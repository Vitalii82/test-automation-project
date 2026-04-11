# Project Context

This is a QA Automation project built with:
- Java
- Maven
- Selenium (UI)
- TestNG
- RestAssured (API)

Project structure:
- Page Object Model for UI tests
- API tests using RestAssured
- Maven for build and execution

---

# Rules for Claude

## Scope control
- Modify ONLY the file mentioned in the task
- Do NOT refactor unrelated code
- Do NOT touch multiple files unless explicitly asked

## Execution control
- Do NOT run full test suite unless explicitly requested
- Prefer running single test or class

## Change strategy
- Prefer minimal safe changes
- One change at a time
- Do NOT introduce large refactors

## Debugging rules
- Prefer adding temporary debug output instead of rewriting logic
- Remove debug code after diagnosis

---

# UI Testing Rules

- Use Page Object Model
- Avoid direct driver usage inside tests
- Prefer element-based assertions (NOT page source)
- Avoid Thread.sleep()
- Use targeted waits only when necessary

---

# API Testing Rules

- Keep tests readable and explicit
- Use clear assertions
- Avoid unnecessary complexity

---

# Workflow

- One task at a time
- One change at a time
- One verification at a time
- Always keep the test suite green