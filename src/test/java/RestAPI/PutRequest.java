package RestAPI;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {

	@Test
	public void putCall() {
		
		Logger logger = Logger.getLogger("EmployeeLogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.ERROR);
		logger.info("-------------Start of put call----------------");
		
		RestAssured.baseURI="http://3.95.178.131:8088";
		RequestSpecification request = RestAssured.given();
		Map<String,Object> jsonMap = new HashMap<String,Object>();
        jsonMap.put("firstName","rahul");
		
		jsonMap.put("lastName","paul");
		jsonMap.put("salary","90000");
		jsonMap.put("email","j@gamil.com");
		
		Response response = request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(jsonMap)
				.put("/employees/5");
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		int ResCode = response.getStatusCode();
		AssertJUnit.assertEquals(ResCode,200);
		}
		
}
