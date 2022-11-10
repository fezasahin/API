package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get2b extends ReqresBaseUrl {
    /**
     * given   https://reqres.in/api/users/23
     * when    user send aget requset and the url
     * then    http status code should be 404
     * And     status line should be HTTP/1.1 404 Not Found
     * And     Server is "cloudflare"
     * And     response body should be empty
     */

    @Test
    public void get02b(){
        //set the url
        spec.pathParams("1","users","2",23);
        //set the expected data
        Response response=given().spec(spec).when().get("/{1}/{2}");
        response.prettyPrint();

        //assertEquals(404,response.statusCode());
        //assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertEquals(2,response.asString().replaceAll("\\s","").length());


    }


}
