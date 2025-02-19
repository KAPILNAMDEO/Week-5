package com.day2.javaobjectintojson;



import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarToJsonTest {

    @Test
    void testCarToJsonConversion() throws Exception {
        // Arrange: Create a Car object
        Car car = new Car("Toyota", "Camry", 2022);
        ObjectMapper objectMapper = new ObjectMapper();

        // Act: Convert Car to JSON string
        String jsonString = objectMapper.writeValueAsString(car);

        // Assert: Verify JSON output contains correct values
        assertNotNull(jsonString);
        assertTrue(jsonString.contains("\"brand\":\"Toyota\""));
        assertTrue(jsonString.contains("\"model\":\"Camry\""));
        assertTrue(jsonString.contains("\"year\":2022"));
    }
}

