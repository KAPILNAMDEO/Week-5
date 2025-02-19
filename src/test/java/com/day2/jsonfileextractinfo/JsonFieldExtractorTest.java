package com.day2.jsonfileextractinfo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class JsonFieldExtractorTest {

    @Test
    void testExtractSpecificFields() throws Exception {
        // Arrange: Load JSON file
        File jsonFile = new File("C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\testdata.json"); // Ensure the file exists with test data
        ObjectMapper objectMapper = new ObjectMapper();

        // Act: Read JSON as Tree and extract fields
        JsonNode rootNode = objectMapper.readTree(jsonFile);
        String name = rootNode.path("name").asText();
        String email = rootNode.path("email").asText();

        // Assert: Verify extracted values
        assertNotNull(name);
        assertNotNull(email);
        assertEquals("kapil", name); // Expected test value
        assertEquals("kapil12@example.com", email); // Expected test value
    }
}
