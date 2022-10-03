package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Location;
import pojo.addPlace;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils{
	RequestSpecification res;
	ResponseSpecification responsespec;
	Response response;
	TestDataBuild data=new TestDataBuild();

	@Given("Add place payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
 
	 res=	given().spec(requestSpecification())
.body(data.addPlacePayload(name,language,address));
	}
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		APIResources resourseAPI=APIResources.valueOf(resource);
		System.out.println(resourseAPI.getResource());
		
		responsespec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
	     response=res.when().post(resourseAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			response=res.when().get(resourseAPI.getResource());
				
		
	}
	    			
	@Then("the API call got  success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body os {string}")
	public void in_response_body_os(String key, String ExpectedValue) {
	    String resp=response.asString();
	    JsonPath js=new JsonPath(resp);
	   assertEquals( js.get(key).toString(),ExpectedValue);
	}
	




}
