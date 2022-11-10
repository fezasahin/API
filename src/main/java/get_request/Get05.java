package get_request;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get05 {
     /*
        Given    https://reqres.in/api/unknown/3
        When     User send a GET request to the URL
        Then     HTTP Status Code should be 200
        And      Response content type is “application/json; charset=utf-8”
        And      Response body should be like;(Soft Assertion)

        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */


    @Test
    public void get05(){
        //set the url
        String url="https://reqres.in/api/unknown/3";
        //set the expected data

        //send the request ang get the response
        Response response=given().when().get(url);
        response.prettyPrint();

        //do the assertion

        JsonPath jsonPath=response.jsonPath();
        assertEquals(200,response.statusCode());
        jsonPath.getList("data.pantone_value");

    }
}
