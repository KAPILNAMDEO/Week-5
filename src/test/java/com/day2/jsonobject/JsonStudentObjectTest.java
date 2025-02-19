package com.day2.jsonobject;

import static org.junit.jupiter.api.Assertions.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class JsonStudentObjectTest {

    @Test
    void testStudentJsonStructure() {
        // Create JSON object for testing
        JSONObject student = new JSONObject();
        student.put("name", "Kapil");
        student.put("age", 18);

        JSONArray subjects = new JSONArray();
        subjects.put("Maths");
        subjects.put("Physics");
        subjects.put("Chemistry");
        student.put("subjects", subjects);

        // Assertions to verify JSON structure
        assertEquals("Kapil", student.getString("name"));
        assertEquals(18, student.getInt("age"));

        JSONArray retrievedSubjects = student.getJSONArray("subjects");
        assertEquals(3, retrievedSubjects.length());
        assertEquals("Maths", retrievedSubjects.getString(0));
        assertEquals("Physics", retrievedSubjects.getString(1));
        assertEquals("Chemistry", retrievedSubjects.getString(2));
    }
}
