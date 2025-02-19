package com.day2.javaobjectsintojsonarray;



import com.day2.handsonpracticeproblems.javaobjectsintojsonarray.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListToJsonArrayTest {

    @Test
    void testListToJsonConversion() {
        try {
            // Create a sample list of Person objects
            List<Person> people = new ArrayList<>();
            people.add(new Person("kapil", 25));
            people.add(new Person("atul", 32));

            // Convert the list to JSON array
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(people);

            // Expected JSON output
            String expectedJson = "[{\"name\":\"kapil\",\"age\":25},{\"name\":\"atul\",\"age\":32}]";

            // Assertion: Check if actual JSON matches expected JSON
            assertEquals(expectedJson, jsonArray, "JSON array does not match expected output");

        } catch (Exception e) {
            fail("Exception occurred during JSON conversion: " + e.getMessage());
        }
    }
}
