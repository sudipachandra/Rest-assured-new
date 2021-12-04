package oAuth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class oAuthExample {
	@Test
	public void test1() {

	Response TokenResponse = RestAssured.given()
			.baseUri("http://18.208.199.188:8088")
			.auth().preemptive().basic("rest-assured", "password")
			.contentType("application/x-www-form-urlencoded")
			.formParam("grant_type", "password")
            .formParam("username", "onlyfullstack")
            .formParam("password", "secret")
            .when()
            .post("/oauth/token");


System.out.println(TokenResponse.body().asString());

JsonPath jpath = TokenResponse.jsonPath();
String TokenValue  = jpath.get("access_token");
System.out.println(TokenValue);

Response GetResponse = RestAssured.given()
.auth()
.oauth2(TokenValue)
.baseUri("http://18.208.199.188:8088")
.when()
.get("/students");

System.out.println(GetResponse.body().asString());


}
}
