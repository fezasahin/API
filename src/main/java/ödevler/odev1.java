package ödevler;

import base_url.AutomationexercisseBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class odev1  {
    /*
        Given
            https://automationexercise.com/api/brandsList
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "text/html; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
        And
             Number of H&M brands must be equal to Polo(H&M marka sayısı Polo marka sayısına eşit olmalı)
*/

    @Test
    public void odev1() {
        // set the url
        String url="https://automationexercise.com/api/brandsList";

        //spec.pathParam("1", "brandsList");

        //send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

        //do assertion

        JsonPath jsonPath=response.jsonPath();
        assertEquals(200, response.statusCode());
        assertEquals("text/html; charset=utf-8", response.contentType());
        assertEquals("HTTP/1.1 200 OK", response.statusLine());

//        List<String> hm = jsonPath.getList("brands");
//
//        System.out.println(hm);

        Map<String, Object> brands = response.jsonPath().getMap("findAll{it.brand}.brands");
        System.out.println("brands = " + brands);


    }
}
