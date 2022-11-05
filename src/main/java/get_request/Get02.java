package get_request;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;

public class Get02 {
    /* Given
    https://restful-booker.herokuapp.com/booking/1
    When
    User send a GET Request to the url
    Then
    HTTP Status code should be 404
    And
    Status Line should be HTTP/1.1 404 Not Found
    And
    Response body contains "Not Found"
    And
    Response body does not contain "TechProEd"
    And
    Server is "Cowboy"
            */

    @Test
    public void get01(){
        // 1 set the url
        String url="https://restful-booker.herokuapp.com/booking/1";
        //set the expected data
        //type code to send request
        Response response=given().when().get(url);
        response.prettyPrint();

        //do assertion
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        //BODY NOT FOUND İÇERİYORMU TESTİ YAPILIYOR
        assertTrue(response.asString().contains("Not Found"));
        //BODY NİN TECHPRO İÇERMEDİĞİ TEST EDİLİYOR
        assertFalse(response.asString().contains("TechProEd"));
        //SERVER COWBOY OLUP OLMADIĞI TEST EDİLİYOR
        assertEquals("Cowboy",response.getHeader("Server"));
    }

}
