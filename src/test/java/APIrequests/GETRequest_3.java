package APIrequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GETRequest_3 {
	
	@Test
	public void printAllHeaders() {
		
		// 1st -- Specify the base URI
		RestAssured.baseURI="https://www.google.com/";
		
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		// send GET request
		Response respo = httpRequest.request(Method.GET,"maps/search/market+near+me/@20.9730554,77.7795364,15z/data=!3m1!4b1");
	
		// Get response and convert JSON to string
		String respoBody = respo.getBody().asString();
		
		// Validate Status code
		int statusCode = respo.getStatusCode();
		System.out.println("Status code is : "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		// Now get all headers from response 
		Headers allHeaders = respo.headers(); // this method will capture all headers from response
		for(Header header : allHeaders) 
		{
			System.out.println(header.getName()+"  :  "+header.getValue());
		}
		
	}

}
