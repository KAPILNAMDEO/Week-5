package com.day2.handsonpracticeproblems.readjsonfile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonFile {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into JsonNode
            File file = new File("C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\data.json");  // Ensure this file exists
            JsonNode jsonNode = objectMapper.readTree(file);

            // Print all keys and values
            printJsonKeysAndValues(jsonNode, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Recursive method to print JSON keys and values
    public static void printJsonKeysAndValues(JsonNode node, String parentKey) {
        if (node.isObject()) { // If node is an object, iterate over fields
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJsonKeysAndValues(entry.getValue(), parentKey + entry.getKey() + ".");
            }
        } else if (node.isArray()) { // If node is an array, iterate over elements
            int index = 0;
            for (JsonNode element : node) {
                printJsonKeysAndValues(element, parentKey + "[" + index + "].");
                index++;
            }
        } else { // If node is a value, print it
            System.out.println(parentKey.substring(0, parentKey.length() - 1) + " = " + node.asText());
        }
    }
}
