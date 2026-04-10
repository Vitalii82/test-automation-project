package com.example.tests.imperative;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("API")
@Feature("JSONPlaceholder")
@Severity(SeverityLevel.NORMAL)
public class JsonPlaceholderApiTest {

    private static final String BASE = "https://jsonplaceholder.typicode.com";

    @Test(groups = "imperative")
    @Description("GET /posts/1 returns 200 with correct id, userId and non-empty title")
    public void getPost_shouldReturn200WithCorrectFields() {
        given()
            .when().get(BASE + "/posts/1")
            .then()
                .statusCode(200)
                .body("id",     equalTo(1))
                .body("userId", equalTo(1))
                .body("title",  not(emptyOrNullString()));
    }

    @Test(groups = "imperative")
    @Description("GET /posts returns 200 and a list of exactly 100 posts")
    public void getAllPosts_shouldReturn100Posts() {
        given()
            .when().get(BASE + "/posts")
            .then()
                .statusCode(200)
                .body("size()", equalTo(100));
    }

    @Test(groups = "imperative")
    @Description("POST /posts returns 201 and echoes the submitted title")
    public void createPost_shouldReturn201WithEchoedBody() {
        given()
            .contentType("application/json")
            .body("{\"title\":\"test\",\"body\":\"content\",\"userId\":1}")
            .when().post(BASE + "/posts")
            .then()
                .statusCode(201)
                .body("title", equalTo("test"))
                .body("id",    notNullValue());
    }
}
