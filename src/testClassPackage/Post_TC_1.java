package testClassPackage;



import java.io.IOException;


import org.testng.Assert;
import commonFunctionPackage.API_Common_Funtion;
import commonFunctionPackage.Utility_commonFunctions;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.Post_req_repository;

public class Post_TC_1 {

public static void execute() throws IOException {
			
			for(int i=0; i<5; i++)
			{
				 String baseURI=Post_req_repository.baseURI();
				 String resource=Post_req_repository.post_resource();
				  String requestBody=Post_req_repository.post_request();
				 
				  
				  int statusCode=API_Common_Funtion.response_statusCode(baseURI,resource,requestBody);
				  if(statusCode==201)
				  {
					  String responseBody=API_Common_Funtion.res_responseBody(baseURI,resource ,requestBody);
					  System.out.println(responseBody);
					  Post_TC_1.validator(responseBody, statusCode, requestBody);
					  Utility_commonFunctions.evidencecreator("Post_TC_1", requestBody, responseBody);
					  
					  break;
				  }
				  else 
				  {
					  System.out.println("correct status code not found hence retrying");
				  }
			}
		
		}
		
		public static void validator(String responseBody,int statusCode,String requestBody) {
		  
		//Parse response body and its parameters
			JsonPath jspres=new JsonPath(responseBody);
			String res_name=jspres.getString("name");
			String res_job=jspres.getString("job");
			String res_id=jspres.getString("id");
			String res_createdAt=jspres.getString("createdAt");
			
			  //Validate the response
		   
		   Assert.assertEquals(statusCode,201);
		   Assert.assertEquals(res_name, "morpheus");
		   Assert.assertEquals(res_job, "leader");
		   Assert.assertNotNull(res_id);
		   Assert.assertNotNull(res_createdAt);
		   
		}
}
		   
		 
		   
		
		

	
