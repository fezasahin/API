package deleteRequest;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Delete01 extends JsonplaceholderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete01(){
        //SET THE URL
        spec.pathParams("1","todos","2",198);
        //set the expected data
        Map<String,String> expectedData=new HashMap<>();
        //send the request and get the response
        Response response=given().spec(spec).when().delete("/{1}/{2}");
        // do assertion
       Map actualData= ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(expectedData,actualData);

        assertTrue(actualData.isEmpty());

        assertEquals(0,actualData.size());


    }
}
