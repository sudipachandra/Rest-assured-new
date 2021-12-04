package RestAPI;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {

	@Test
	public void deleteCall() {
		
		Logger logger = Logger.getLogger("EmployeeLogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.ERROR);
		logger.info("-------------Start of delete call----------------");
		
		RestAssured.baseURI="http://3.95.178.131:8088";
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("/employees/5");
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
		
	}
	
}
