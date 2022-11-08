package post_requests;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;




import base_url.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Post06 extends DummyRestApiBaseUrl {
   /*
   Given
   URL: https://dummy.restapiexample.com/api/v1/create


   And {
        "employee_name": "Tom Hanks",
            "employee_salary": 111111,
            "employee_age": 23,
            "profile_image": "Perfect image",
            "id": 4891
    }
    wHEN
    USER SEND POST REQUEST
    Then
    i) Status code is 200
    And
    ii) Response body should be like the following
    {
        "status": "success",
            "data": {
        "employee_name": "Tom Hanks",
                "employee_salary": 111111,
                "employee_age": 23,
                "profile_image": "Perfect image",
                "id": 4891
    },
        "message": "Successfully! Record has been added."
    }

     */
    @Test
    public void post06(){
        //Set the url
        spec.pathParam("1","create");
        //set the expected data
        DummyRestApiDataPojo expectedDta=new DummyRestApiDataPojo("Tom Hanks",111111, 23,"Perfect image");
        System.out.println("expectedata : "+expectedDta);
   // REND THE POST AND GET THE RESPONSE
       Response response= given().spec(spec).contentType(ContentType.JSON).body(expectedDta).when().post("/{1}");
       response.prettyPrint();
       //do assertion
        DummyRestApiResponsePojo actualdata= ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiResponsePojo.class);
        System.out.println("actualdata"+actualdata);
    assertEquals(200,response.getStatusCode());
    assertEquals(expectedDta.getEmployee_name(),actualdata.getData().getEmployee_name());
    assertEquals(expectedDta.getEmployee_salary(),actualdata.getData().getEmployee_salary());
    assertEquals(expectedDta.getEmployee_age(),actualdata.getData().getEmployee_age());
    assertEquals(expectedDta.getProfile_image(),actualdata.getData().getProfile_image());










    }
}
