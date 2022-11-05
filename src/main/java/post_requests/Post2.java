package post_requests;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.RestfullTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post2 extends RestfulBaseUrl {
     /*
   Given
       1) https://restful-booker.herokuapp.com/booking
       2) {
            "firstname": "John",
            "lastname": "Doe",
            "totalprice": 11111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2021-09-09",
                "checkout": "2021-09-21"
             }
          }
   When
       I send POST Request to the Url
   Then
       Status code is 200
       And response body should be like {
                                           "bookingid": 5315,
                                           "booking": {
                                               "firstname": "John",
                                               "lastname": "Doe",
                                               "totalprice": 11111,
                                               "depositpaid": true,
                                               "bookingdates": {
                                                   "checkin": "2021-09-09",
                                                   "checkout": "2021-09-21"
                                               }
                                           }
                                        }
*/
 @Test
    public void post02(){
     //set the url
     spec.pathParam("1","booking");
     //set the expected data
     RestfullTestData obj=new RestfullTestData();
     Map<String,String> bookingdatesMap=obj.bookingdatesMethod("2021-09-09","2021-09-21");
     Map<String,Object>expectedData=obj.expectedData("John","Doe",11111,true,bookingdatesMap);
     //sent the request and get the response

     Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{1}");
          response.prettyPrint();
          // Do the assertion
     Map<String,Object> actualdata=response.as(HashMap.class);
     System.out.println("actualdata"+actualdata);
     assertEquals(expectedData.get("fistname"),((Map)actualdata.get("booking")).get("fistname"));
     assertEquals(expectedData.get("lastname"),((Map)actualdata.get("booking")).get("lastname"));
     assertEquals(expectedData.get("totalprice"),((Map)actualdata.get("booking")).get("totalprice"));
     assertEquals(expectedData.get("depositpaid"),((Map)actualdata.get("booking")).get("depositpaid"));
     assertEquals(bookingdatesMap.get("checkin"),((Map)((Map)actualdata.get("booking")).get("bookingdates")).get("checkin"));
     assertEquals(bookingdatesMap.get("checkout"),((Map)((Map)actualdata.get("booking")).get("bookingdates")).get("checkout"));









 }

}
