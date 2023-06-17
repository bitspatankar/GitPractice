package APIrequests;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETRequest_5 {
	@Test
	public void validate1by1ResponseBody() {
		
		// 1st -- Specify the base URI
		RestAssured.baseURI="https://reqres.in";
		
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		// send GET request // This respo contains whole response which include Code,Time,response body etc.
		Response respo = httpRequest.request(Method.GET,"/api/users/2");
	
		// Get response and convert JSON to string
		String respoBody = respo.getBody().asString(); // This method will give only response Body from whole response
		System.out.println(respoBody);
		
		// Now to validate Response body contains 1 by 1 all
		// For that we need to use JsonPath class methods
		
		JsonPath jsonPath = respo.jsonPath();
		System.out.println(jsonPath.get("first_name")); 
		// In above method we need to provide key whose value we need to validate
		// Like this we can print all values for specific related keys present in response Body
		
		// Now to validate we are getting correct response body for above key
		Assert.assertEquals(null, jsonPath.get("first_name"));
	}

}
