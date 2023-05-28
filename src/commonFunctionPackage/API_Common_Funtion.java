package commonFunctionPackage;

import static io.restassured.RestAssured.given;


import io.restassured.RestAssured;


public class API_Common_Funtion {
	
	   public static int response_statusCode(String baseURI,String resource,String requestBody) {
		
		
		// Step 1: Declare base Uri and RequestBody
		RestAssured.baseURI = baseURI;
		
		//Step 2 : Configure request body
		
		int statusCode = given().header("Content-Type","application/json").body(requestBody).when().post(resource).then().extract().statusCode();
		
		
		System.out.println(statusCode);
	
		return statusCode;
		}

        public static String res_responseBody(String baseURI,String resource,String requestBody) 
        {
		
		
		// Step 1: Declare base Uri and RequestBody
		RestAssured.baseURI = baseURI;
		
		
		//Step 2 : Configure request body
		String responseBody = given().header("Content-Type","application/json").body(requestBody).when().post(resource).then().extract().response().asString();
		
		return responseBody;
	

	
	
		}
      
}
