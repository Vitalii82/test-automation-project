import io.qameta.allure.*;
package com.example.tests.imperative;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
@Epic("General")
@Feature("E2E")
@Story("Baseline Flow")
@Severity(SeverityLevel.NORMAL)
public class HttpBinImperativeTest {
  @Parameters({"baseUrl"})
  @BeforeClass
  public void setup(@Optional String baseUrl){
    String prop=System.getProperty("base_url");
    RestAssured.baseURI = (baseUrl!=null && !baseUrl.isBlank())? baseUrl : (prop!=null && !prop.isBlank()? prop : "http://localhost");
  }
  @Test(groups="imperative")
  public void uuid_should_exist(){ given().when().get("/uuid").then().statusCode(200).body("uuid",notNullValue()); }
  @Test(groups="imperative")
  public void headers_should_echo_custom_header(){ given().header("X-Demo-Header","carina").when().get("/headers").then().statusCode(200).body("headers.'X-Demo-Header'",equalTo("carina")); }
  @Test(groups="imperative")
  public void anything_post_should_echo_body(){ given().contentType(ContentType.JSON).body("{\"hello\":\"world\"}").when().post("/anything").then().statusCode(200).body("json.hello",equalTo("world")); }
  @Test(groups="imperative")
  public void status_200_should_return_200(){ given().when().get("/status/200").then().statusCode(200); }
  @Test(groups="imperative", timeOut=6000)
  public void delay_1sec_should_be_fast(){ given().when().get("/delay/1").then().statusCode(200); }
}