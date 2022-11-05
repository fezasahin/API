package post_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Post01 extends JsonplaceholderBaseUrl {
    /*
    Given
      1)  https://jsonplaceholder.typicode.com/todos
      2)  {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
           }
   When
    I send POST Request to the Url
   Then
       Status code is 201
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
*/


@Test
    public void post01(){
    //set the url
        spec.pathParams("1","todos");
        // set the expected data
    JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
    Map<String,Object> expectedData=obj.expectedData(55,"Tidy your room",false);

    //Sent the request and gert the response
    Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{1}");
    response.prettyPrint();

    //Do assertion
    Map<String,Object> actualData=response.as(HashMap.class);
    assertEquals(expectedData.get("completed"),actualData.get("completed"));
    assertEquals(expectedData.get("title"),actualData.get("title"));
    assertEquals(expectedData.get("userId"),actualData.get("userId"));





}












}
