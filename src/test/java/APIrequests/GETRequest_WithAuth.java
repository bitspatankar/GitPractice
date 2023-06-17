package APIrequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GETRequest_WithAuth {
	@Test
	public void withAuthentication() {
		
		// In order to send Authentication with request 
	        RequestSpecification httpRequest = RestAssured.given().auth().basic("postman","password");
	        Response respo = httpRequest.get("https://postman-echo.com/basic-auth");
	       String respoBody = respo.getBody().asString();
	        
	        System.out.println("Data from the GET API- "+respoBody);
	        
	        // To validate status code
	        int statusCode = respo.getStatusCode();
	        System.out.println(statusCode);
	        Assert.assertEquals(statusCode, 200);
	    }

}
