# Docker Add-ons
Run httpbin + tests via Docker Compose.

## Quick start
docker compose up --build --abort-on-container-exit
# Reports: ./target/surefire-reports

## Only API server then run tests locally
make up
mvn -Dbase_url=http://localhost:8080 test
make down
