package com.example.tests.imperative;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("API")
@Feature("HttpBin")
@Severity(SeverityLevel.NORMAL)
public class HttpBinImperativeTest {

    private static final String BASE = "https://httpbin.org";

    @Test(groups = "imperative")
    @Description("GET /uuid returns 200 with a non-null UUID value")
    public void getUuid_shouldReturnNonNullValue() {
        given()
            .when().get(BASE + "/uuid")
            .then()
                .statusCode(200)
                .body("uuid", notNullValue());
    }

    @Test(groups = "imperative")
    @Description("GET /headers echoes back the custom request header")
    public void customHeader_shouldBeEchoedInResponse() {
        given()
            .header("X-Demo-Header", "carina")
            .when().get(BASE + "/headers")
            .then()
                .statusCode(200)
                .body("headers.'X-Demo-Header'", equalTo("carina"));
    }

    @Test(groups = "imperative")
    @Description("POST /anything echoes back the JSON request body")
    public void postBody_shouldBeEchoedInResponse() {
        given()
            .contentType(ContentType.JSON)
            .body("{\"hello\":\"world\"}")
            .when().post(BASE + "/anything")
            .then()
                .statusCode(200)
                .body("json.hello", equalTo("world"));
    }

    @Test(groups = "imperative")
    @Description("GET /status/200 returns the requested status code")
    public void statusEndpoint_shouldReturnRequestedStatusCode() {
        given()
            .when().get(BASE + "/status/200")
            .then()
                .statusCode(200);
    }

    @Test(groups = "imperative", timeOut = 6000)
    @Description("GET /delay/1 completes within the allowed timeout")
    public void delayedResponse_shouldCompleteWithinTimeout() {
        given()
            .when().get(BASE + "/delay/1")
            .then()
                .statusCode(200);
    }
}
