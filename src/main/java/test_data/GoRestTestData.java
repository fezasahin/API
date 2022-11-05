package test_data;

import java.util.HashMap;
import java.util.Map;

public class GoRestTestData {
    public Map<String,String> dataKeyMapMethod(String name,String email,String gender,String status){
        Map<String,String> dataKeyMap=new HashMap<>();
        dataKeyMap.put("name",name);
        dataKeyMap.put("email",email);
        dataKeyMap.put("gender",gender);
        dataKeyMap.put("status",status);

        return dataKeyMap;
    }
    public Map<String,Object> expectedataMethod(Object meta,Map<String,String> data) {
        Map<String, Object> expectedata = new HashMap<>();
        expectedata.put("meta",meta);
        expectedata.put("data",data);
        return expectedata;
    }
}
