package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String,Object> expectedData(Integer userId, String title, Boolean completed ){


        Map<String,Object> expectedDataMap = new HashMap<>();
        if(userId!=null){
            expectedDataMap.put("userId",userId);
        }
        if(userId!=null){
            expectedDataMap.put("title",title);
        }
        if(userId!=null){
            expectedDataMap.put("completed",completed);
        }


        return expectedDataMap;
    }

    public String expectedDataInString(int userId,String title,Boolean completed){
        String expectedData="{\n" +
                "                 \"userId\":"+userId+",\n" +
                "                 \"title\": \""+title+"\",\n" +
                "                 \"completed\": "+completed+"\n" +
                "               }";

        return expectedData;
    }






}
