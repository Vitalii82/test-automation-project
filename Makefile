.PHONY: up test down clean allure
up:
	docker compose up -d httpbin
test:
	docker compose up --build --abort-on-container-exit tests
down:
	docker compose down
clean:
	rm -rf target
allure:
	mvn -q test && mvn -q allure:report && echo "Open target/site/allure-maven-plugin/index.html"
