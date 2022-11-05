package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get03 extends JsonplaceholderBaseUrl {
     /*
      Given
          https://jsonplaceholder.typicode.com/todos/23
        When
              User send GET Request to the URL
        Then
               HTTP Status Code should be 200
        And
               Response format should be "application/json"
        And
               "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
        And
               "completed" is false
        And
                "userId" is 2
   */
    @Test
    public void get01() {
        //set the url
        spec.pathParams("first", "todos", "second", 23);
        //expected data
        //send the request and get response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //do assertion
        //1.yol
        response.then().assertThat().
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", equalTo(false)).
                body("userId", equalTo(2));
        //2.yol


        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(true),
                        "userId",equalTo(2));

    }
}
