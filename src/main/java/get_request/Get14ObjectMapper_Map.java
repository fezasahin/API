package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.JsonPlaceHolderTestData;
import utils.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get14ObjectMapper_Map extends JsonplaceholderBaseUrl {
    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test

    public void get14(){

        //set the url
        spec.pathParams("1","todos","2",198);
        // set the expected data
        String expectedDataInString=new JsonPlaceHolderTestData().expectedDataInString(10,"quis eius est sint explicabo",true);

        Map expectedData=ObjectMapperUtils.convertJsonToJava(expectedDataInString, Map.class);
        System.out.println("expected DATA"+ expectedData);
        //send the request get the response
        Response response=given().spec(spec).when().get("{1}/{2}");
        response.prettyPrint();
        //do the assertion
        Map actualdata=ObjectMapperUtils.convertJsonToJava(response.asString(),Map.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.get("userId"),actualdata.get("userId"));
        assertEquals(expectedData.get("title"),actualdata.get("title"));
        assertEquals(expectedData.get("completed"),actualdata.get("completed"));


    }














}
