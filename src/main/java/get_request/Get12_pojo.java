package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get12_pojo extends RestfulBaseUrl {
     /*
     Given
         https://restful-booker.herokuapp.com/booking/18
     When
    I send GET Request to the URL
   Then
    Status code is 200
And
    Response body is like:
                        {
                             ""firstname": "Dane",
    "lastname": "Combs",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
    }
  */
    @Test
    public void get12pojo(){
        //Set the url
        spec.pathParams("1","booking","2",18);
        //set the expected data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");
        bookingDatesPojo.toString();
        BookingPojo expectedData=new BookingPojo("Dane","Combs",111,true,bookingDatesPojo,"Breakfast");
        System.out.println("expectedData"+expectedData);

        //Send the request
        Response response=given().spec(spec).when().get("/{1}/{2}");
        response.prettyPrint();

        //do assertion
        BookingPojo actualData=response.as(BookingPojo.class);
        System.out.println("actual data"+actualData);

        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
        //booking dates 2.yol
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());
    }
















}
