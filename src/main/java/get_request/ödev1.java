package get_request;

import base_url.AutomationexercisseBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ödev1 extends AutomationexercisseBaseUrl {
    /*
Given
    https://automationexercise.com/api/productsList
When
    User sends a GET Request to the url
Then
    HTTP Status Code should be 200
And
    Content Type should be "text/html; charset=utf-8"
And
    Status Line should be HTTP/1.1 200 OK
And
     There must be 12 Women, 9 Men, 13 Kids usertype in products
  */

    @Test
    public void odev1(){

        spec.pathParam("1","productsList");

        Response response=given().spec(spec).
                when().get("/{1}");
        response.prettyPrint();


    }
}
