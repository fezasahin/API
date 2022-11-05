package test_data;

import java.util.HashMap;
import java.util.Map;

public class RestfullTestData {
    public Map<String,String> bookingdatesMethod(String checkin,String checkout){
        Map<String,String> bookibgdatesMap=new HashMap<>();
        bookibgdatesMap.put("checkin",checkin);
        bookibgdatesMap.put("checkout",checkout);

        return bookibgdatesMap;
    }

    public Map<String,Object> expectedData(String firstname,String lastname,
                                           Integer totalprice,
                                           Boolean depositpaid,
                                           Map<String,String> bookingdates){

        Map<String,Object> expectedData= new HashMap<>();
        expectedData.put("firstname",firstname);
        expectedData.put("lastname",lastname);
        expectedData.put("totalprice",totalprice);
        expectedData.put("depositpaid",depositpaid);
        expectedData.put("bookingdates",bookingdates);

        return expectedData;

    }

}
