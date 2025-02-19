package com.day2.jsonfileextractinfo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JsonFieldExtractor {
    public static void main(String[] args) {
        try {
            // Load JSON file
            File jsonFile = new File("C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\data.json"); // Replace with your JSON file path
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON as Tree (JsonNode)
            JsonNode rootNode = objectMapper.readTree(jsonFile);

            // Extract specific fields
            String name = rootNode.path("name").asText();
            String email = rootNode.path("email").asText();

            // Print extracted values
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

