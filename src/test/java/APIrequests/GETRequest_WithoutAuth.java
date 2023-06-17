package APIrequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GETRequest_WithoutAuth {
	
	@Test
	public void withOutAuthentication() {
		
	        RequestSpecification httpRequest = RestAssured.given();
	        Response respo = httpRequest.get("https://postman-echo.com/basic-auth");
	       String respoBody = respo.getBody().asString();
	        
	        System.out.println("Data from the GET API- "+respoBody);
	        
	        // To validate status code
	        int statusCode = respo.getStatusCode();
	        System.out.println(statusCode);
	        Assert.assertEquals(statusCode, 401);
	    }
	}


