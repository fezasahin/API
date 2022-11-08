package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get15 extends RestfulBaseUrl {
    /*
        Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
           {
                ""firstname": "Guoqiang",
          "lastname": "Morante Briones",
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
    public void get15() {
        //set the url
        spec.pathParams("1", "booking", "2", 22);
        //set the expexted data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Guoqiang", "Morante Briones", 111, true, bookingDatesPojo, "Breakfast");
        //sent the request and get the response
        Response response = given().spec(spec).when().get("{1}/{2}");
        response.prettyPrint();

        //do assertion
        BookingPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),BookingPojo.class);
        //hard assertion
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());

        assertEquals(bookingDatesPojo.getCheckin(),bookingDatesPojo.getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),bookingDatesPojo.getCheckout());

        //soft assertion
        //1. adım :soft assert objesi oluştur
        SoftAssert softAssert=new SoftAssert();
        //2. adım aseertion yap
        softAssert.assertEquals(actualData.getFirstname(),expectedData.getFirstname(),"firstmane uyusmadi");
        softAssert.assertEquals(actualData.getLastname(),expectedData.getLastname(),"Lastmane uyusmadi");
        softAssert.assertEquals(actualData.getTotalprice(),expectedData.getTotalprice(),"Totalprice uyusmadi");
        softAssert.assertEquals(actualData.getDepositpaid(),expectedData.getDepositpaid(),"Depositpaid uyusmadi");
         softAssert.assertEquals(actualData.getBookingdates().getCheckin(),expectedData.getBookingdates().getCheckin(),"Checkin uyusmadı");
        softAssert.assertEquals(actualData.getBookingdates().getCheckout(),expectedData.getBookingdates().getCheckout(),"Checkout uyusmadı");
        //3. adım aseert all metodunu kullan
        softAssert.assertAll();

    }
}
