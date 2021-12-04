package RestAPI;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	public void getCall() {
		
		Logger logger = Logger.getLogger("EmployeeLogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.ERROR);
		logger.info("-------------Start of get call----------------");
		RestAssured.baseURI="http://3.95.178.131:8088";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/employees");
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		int resCode = response.getStatusCode();
		AssertJUnit.assertEquals(resCode,200);
		JsonPath jpath = response.jsonPath();
		List<String> names = jpath.get("firstName");
		System.out.println(names);
		for(int i = 0;i<names.size();i++) {
			System.out.println(names.get(i));
		}
		
		
		AssertJUnit.assertEquals(names.get(1),"only");
		
	}
}
