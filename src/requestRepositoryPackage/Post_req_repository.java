package requestRepositoryPackage;
import java.io.IOException;
import java.util.ArrayList;
import commonFunctionPackage.Utility_commonFunctions;

public class Post_req_repository {
	
	public static String baseURI() {
		String baseURI="https://reqres.in/"; 
		return baseURI;
	}
	
	public static String post_resource() {
		String resource="/api/users";
		return resource;
	}
  
	public static String post_request() throws IOException 
	
	
{
		ArrayList<String> data=Utility_commonFunctions.readdataexcel("testdata","Post_TC_1");
		String req_name = data.get(1);
		String req_job = data.get(2);
		
		
		
		 String requestBody = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		
		return requestBody;
		
}}


     