package get_request;

import base_url.RegresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Get06b extends RegresBaseUrl {

     /*
   Given
          https://reqres.in/api/unknown/
   When
        I send GET Request to the URL
   Then

        1)Status code is 200
        2)Print all pantone_values
        3)Print all ids greater than 3 on the console
          Assert that there are 3 ids greater than 3
        4)Print all names whose ids are less than 3 on the console
          Assert that the number of names whose ids are less than 3 is 2
*/
    @Test

    public void get06b(){
        // set the url
        spec.pathParam("first","unknown");
        //set the expected data
        //send the request and get the response
        Response response=given().spec(spec).when().get("//{first}");
        response.prettyPrint();
        //do assertion
        //assertEquals(200,response.statusCode());
        JsonPath jsonPath=response.jsonPath();
        System.out.println(jsonPath.getList("pantone_value").get(0));
        //3)Print all ids greater than 3 on the console
        System.out.println(jsonPath.getList("data.id"));
      List<Integer> ids= jsonPath.getList("data.findAll{it.id>3}.id");
        //Assert that there are 3 ids greater than 3
        assertEquals(3,ids.size());
       // Print all names whose ids are less than 3 on the console
        List<String> nms= jsonPath.getList("data.findAll{it.id<3}.name");
        //Assert that the number of names whose ids are less than 3 is 2
        assertEquals(2,nms.size());
    }








}
