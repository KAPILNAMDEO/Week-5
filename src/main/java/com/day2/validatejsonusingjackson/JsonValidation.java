/*5️⃣ Validate JSON structure using Jackson.

 */

package com.day2.validatejsonusingjackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidation {
    public static void main(String[] args) {
        String jsonString="{ \"name\": \"kapil\", \"age\": 25 }";
        boolean isvalid=isvalidJson(jsonString);
        System.out.println(isvalid);
    }
    public static boolean isvalidJson(String jsonString){
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            JsonNode jsonNode=objectMapper.readTree(jsonString);
            //If parsed successfully, it's valid
            return jsonNode!=null;

        } catch (Exception e) {
            return false;
        }

    }
}
