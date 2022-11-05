package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get14ObjectMapper_Pojo extends JsonplaceholderBaseUrl {
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
    //objectMapper +pojo en iyi yontem
    @Test
    public void get14Pojo(){
        //Set the url
        spec.pathParams("1","todos","2",198);
        //Set the expected data
        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(10,"quis eius est sint explicabo",true);
        //send the request and get the response
        Response response=given().spec(spec).when().get("/{1}/{2}");
        response.prettyPrint();

        //do assertion
      JsonPlaceHolderPojo actualData=  ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());
    }

}
