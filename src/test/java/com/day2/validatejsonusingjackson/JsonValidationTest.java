package com.day2.validatejsonusingjackson;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JsonValidationTest {

    @Test
    void testValidJson() {
        String validJson = "{ \"name\": \"kapil\", \"age\": 25 }";
        assertTrue(JsonValidation.isvalidJson(validJson), "Valid JSON should return true");
    }

    @Test
    void testInvalidJson() {
        String invalidJson = "{ \"name\": \"kapil\", \"age\": }"; // Missing value for 'age'
        assertFalse(JsonValidation.isvalidJson(invalidJson), "Invalid JSON should return false");
    }


}
