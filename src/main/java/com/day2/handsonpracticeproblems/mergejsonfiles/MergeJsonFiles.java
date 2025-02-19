package com.day2.handsonpracticeproblems.mergejsonfiles;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read two JSON files into JsonNode objects
            JsonNode json1 = objectMapper.readTree(new File("C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\jsonfile1.json"));
            JsonNode json2 = objectMapper.readTree(new File("C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\jsonfile2.json"));

            // Merge JSON objects (creates a mutable copy)
            JsonNode mergedJson = mergeJsonObjects(json1, json2);

            // Print merged JSON
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));

            // Optionally write merged JSON to a new file
            objectMapper.writeValue(new File("merged.json"), mergedJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to merge two JSON objects
    public static JsonNode mergeJsonObjects(JsonNode mainNode, JsonNode updateNode) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode mergedNode = objectMapper.createObjectNode();

        // Copy all fields from mainNode
        mergedNode = mainNode.deepCopy();

        // Merge fields from updateNode
        ((com.fasterxml.jackson.databind.node.ObjectNode) mergedNode).setAll((com.fasterxml.jackson.databind.node.ObjectNode) updateNode);

        return mergedNode;
    }
}

