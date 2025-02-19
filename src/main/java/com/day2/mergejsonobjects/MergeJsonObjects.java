package com.day2.mergejsonobjects;
import org.json.JSONObject;


public class MergeJsonObjects {
    public static void main(String[] args) throws Exception{

        JSONObject json1=new JSONObject("{ \"name\": \"Alice\", \"age\": 25 }");
        JSONObject json2=new JSONObject("{\"city\":\"delhi\",\"age\":25}");

        for(String key: json2.keySet()){
            // Overwrites if key exists
            json1.put(key,json2.get(key));
        }
        // Pretty print with indentation
        System.out.println(json1.toString(2));
    }
}
