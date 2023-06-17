package APIrequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GETRequest_1 {
	
	//1st create TESTNG method
	@Test
	public void testGETRequest() {
		
		// 1st -- Specify the base URI
		RestAssured.baseURI="https://reqres.in/";
		
		// Now we want to send GET request
		// We need to create request object 1st  of RequestSpecification class
		
		RequestSpecification httpRequest = RestAssured.given();
		
		// After sending request we need to store response so we need to create response object
		// Response object of class "Response"
		// Here with Request we need to send Path parameter(End points)
		// this path parameter(End points) will be added to above baseURI
		Response respo = httpRequest.request(Method.GET,"api/users?page=2");
		
		// above method will send a GET request and it will store response in "respo" variable
		
		// Now the response we get is in JSON format which we can not print in console
		// So we convert that response into String by using
		
		String respoBody = respo.getBody().asString();
		//Above method will convert JSON response into String
		
		System.out.println("Response Body is :"+ respoBody);
		
		// Now to validate status code
		// As we know "respo" variable contains whole response from which we need status code
		
		int statusCode = respo.getStatusCode();
		System.out.println("Status code is : "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		// Now validate status line
		
		String statusLine = respo.getStatusLine();
		System.out.println("Status Line is : "+ statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}

}
