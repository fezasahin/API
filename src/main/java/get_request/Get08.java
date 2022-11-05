package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get08 extends JsonplaceholderBaseUrl {
    /*
    Given
       https://jsonplaceholder.typicode.com/todos/2
   When
       I send GET Request to the URL
   Then
       Status code is 200
       And "completed" is false
       And "userId" is 1
       And "title" is "quis ut nam facilis et officia qui"
       And header "Via" is "1.1 vegur"
       And header "Server" is "cloudflare"
       {
           "userId": 1,
           "id": 2,
           "title": "quis ut nam facilis et officia qui",
           "completed": false
       }
*/
    @Test
    public void get08(){
        // set the url
        spec.pathParams("first",   "todos","second",2);
        //set the expected data
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);
        System.out.println("expecteddata"+expectedData);
        //send the request get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //do assertion
       Map<String,Object> actualdata= response.as(HashMap.class);
        System.out.println("actualdata"+actualdata);
        assertEquals(expectedData.get("userId"),actualdata.get("userId"));
        assertEquals(expectedData.get("id"),actualdata.get("id"));
        assertEquals(expectedData.get("title"),actualdata.get("title"));
        assertEquals(expectedData.get("completed"),actualdata.get("completed"));
        assertEquals("1.1 vegur",response.header("via"));
        assertEquals("cloudflare",response.header("server"));
        assertEquals(200,response.statusCode());
    }
}