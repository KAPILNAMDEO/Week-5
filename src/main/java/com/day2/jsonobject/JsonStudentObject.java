/*1️⃣ Create a JSON object for a Student with fields: name, age, and subjects (array).

 */
package com.day2.jsonobject;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonStudentObject {
    public static void main(String[] args) {
        // Create a JSON object
        JSONObject student = new JSONObject();

        // Add basic details
        student.put("name", "Kapil");
        student.put("age", 18);

        // Create JSON array for subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Maths");
        subjects.put("Physics");
        subjects.put("Chemistry");

        // Add subjects array to the student JSON
        student.put("subjects", subjects);

        // Print formatted JSON
        System.out.println(student.toString(4)); // Pretty print with indentation
    }
}



