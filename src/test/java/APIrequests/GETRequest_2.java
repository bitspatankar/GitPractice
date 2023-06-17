package APIrequests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GETRequest_2 {
	@Test
	public  void validateHeaders()
	 {
		// 1st -- Specify the base URI
				RestAssured.baseURI="https://www.google.com/";
				
				// Request Object
				RequestSpecification httpRequest = RestAssured.given();
				
				// send GET request
				Response respo = httpRequest.request(Method.GET,"maps/search/market+near+me/@20.9730554,77.7795364,15z/data=!3m1!4b1");
				
				// Get response and convert JSON to string
				String respoBody = respo.getBody().asString();
				//System.out.println("Response Body is :"+ respoBody);
				
				// Validate Status code
				int statusCode = respo.getStatusCode();
				System.out.println("Status code is : "+statusCode);
				Assert.assertEquals(statusCode, 200);
				
				// Validate Header Part
				// To know which headers we will get we can check then by sending this request in POSTMAN TOOL
				
				// 1st We capture details of headers from response 
				// We provide Key which values we need to validate
				String contectType = respo.header("Content-Type");
				
				// Value of Content-Type header which we will get from above method will be stored in variable
				System.out.println("Content Type is: "+contectType);
				Assert.assertEquals(contectType, "text/html; charset=UTF-8");
				
				
				// Now to capture value of server header from response 
				String server = respo.header("Server");
				
				// Value of server header which we will get from above method will be stored in variable
				System.out.println("Server is : "+server);
				Assert.assertEquals(server, "gws");
				
				// Like this we can validate all headers from response

	}
}


