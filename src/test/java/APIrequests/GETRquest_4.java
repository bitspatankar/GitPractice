package APIrequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GETRquest_4 {
	@Test
	public void validateJSONResponseBody() {
		
		// 1st -- Specify the base URI
		RestAssured.baseURI="https://reqres.in/";
		
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		// send GET request // This respo contains whole response which include Code,Time,response body etc.
		Response respo = httpRequest.request(Method.GET,"api/users?page=2");
	
		// Get response and convert JSON to string
		String respoBody = respo.getBody().asString(); // This method will give only response Body from whole response
		System.out.println(respoBody);
		
		// Now To validate contains in response body
		Assert.assertEquals(respoBody.contains("michael.lawson@reqres.in"), true);
		
		// Validate Status code
		int statusCode = respo.getStatusCode();
		System.out.println("Status code is : "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
	}

}
