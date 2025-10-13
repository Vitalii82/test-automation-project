# Dockerfile for Carina API tests
FROM maven:3.9.6-eclipse-temurin-17 AS deps
WORKDIR /project
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn -q -e -DskipTests dependency:go-offline

FROM maven:3.9.6-eclipse-temurin-17 AS test
WORKDIR /project
COPY --from=deps /root/.m2 /root/.m2
COPY . .
ARG BASE_URL=http://localhost
ENV base_url=${BASE_URL}
CMD ["bash","-lc","mvn -q -Dbase_url=${base_url} test && ls -la target/surefire-reports"]
