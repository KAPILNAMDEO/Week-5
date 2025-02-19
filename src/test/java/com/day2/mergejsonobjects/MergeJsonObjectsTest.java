package com.day2.mergejsonobjects;



import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeJsonObjectsTest {

    @Test
    void testMergeJsonObjects() {
        JSONObject json1 = new JSONObject("{ \"name\": \"Atul\", \"age\": 25 }");
        JSONObject json2 = new JSONObject("{\"city\":\"delhi\",\"age\":25}");

        // Perform merge
        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        // Expected output after merging
        JSONObject expectedJson = new JSONObject("{ \"name\": \"Atul\", \"age\": 25, \"city\": \"delhi\" }");

        assertEquals(expectedJson.toString(), json1.toString(), "Merged JSON does not match expected output");
    }
}
