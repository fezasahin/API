package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class RegresBaseUrl {
    protected RequestSpecification spec;
    @BeforeMethod
    public void setup(){
        spec = new RequestSpecBuilder().setBaseUri("https://regres.in//api.com").build();
    }
}
