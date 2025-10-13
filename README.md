# Carina API Automation (Standalone)

This project mirrors the style of the repos you shared and contains **10 API tests**:
- 5 **imperative** tests (RestAssured)
- 5 **declarative** tests (Carina AbstractApiMethodV2 with templates)

## Quick start
1) Run a local httpbin:
   docker run -d --name httpbin -p 80:80 kennethreitz/httpbin

2) Run tests :
   mvn test
   # if httpbin on 8080:
   mvn -Dbase_url=http://localhost:8080 test
