package APIrequests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class POSTRequest_1 {

		@Test
		public void testPOSTRequest() {
			
			// 1st -- Specify the base URI
			RestAssured.baseURI="https://reqres.in/";
			
			// Now we want to send POST request
			RequestSpecification httpRequest = RestAssured.given();
			
			// Now for POST request we need to send request body(Request parameters) 
			// But the request body is in JSON format so we need to create object of class JSONObject
			
			JSONObject reqPara = new JSONObject();
			// Now we need to send (request Body) parameter by using method from class JSONObject
			// Request PayLoad or Body along with POST request
			reqPara.put("name","Jhonathan Wali");
			reqPara.put("job", "Tester");
			//Above in () 1st is key and 2nd is its value
			
			//Now if we want to send header along with POST request 
			httpRequest.header("Content-Type","application/json");
			
			// Now above parameters are in String format but we need to send them in json format
			//Now To attach above parameters to request body in json format
			
			httpRequest.body(reqPara.toJSONString());
			// above method will convert parameters into JSON format and will attach it to request body
			
			// Now send POST request 
			Response respo = httpRequest.request(Method.POST,"api/users");
			
			// Now validation 
			// get response body
			String respoBody = respo.getBody().asString();
			System.out.println("Response Body is :"+ respoBody);
			
			// Validate status cod
			int statusCode = respo.getStatusCode();
			System.out.println("Status code is : "+statusCode);
			Assert.assertEquals(statusCode, 201);
			
			// Now to validate response body
			// we check values 1 by 1 like for validating name 1st
			String name = respo.jsonPath().get("name");
			System.out.println("Register name is : " + name);
			Assert.assertEquals("Jhonathan Wali", name);
			
			// Validate job in response body
			String job = respo.jsonPath().get("job");
			System.out.println("Register for Job is : " + job);
			Assert.assertEquals("Tester", job);
			
		}
}
