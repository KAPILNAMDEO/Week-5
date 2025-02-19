/*/7️⃣ Parse JSON and filter only those records where age > 25./
        package com.day2jsonhandling.practiceproblems.parsefilterjson;*/

package com.day2.filterjsondata;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class ParseAndFilterJSON {
    public static List<String> filterByAge(String jsonString, int ageThreshold) {
        List<String> filteredNames = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonArray = objectMapper.readTree(jsonString);

            for (JsonNode node : jsonArray) {
                int age = node.get("age").asInt();
                if (age > ageThreshold) {
                    filteredNames.add(node.get("name").asText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filteredNames;
    }

    public static void main(String[] args) {
        String jsonInput = "[{\"name\":\"Vidhi\",\"age\":25},{\"name\":\"Kapil\",\"age\":30},{\"name\":\"Suhani\",\"age\":28},{\"name\":\"Gourav\",\"age\":22}]";
        List<String> filteredNames = filterByAge(jsonInput, 25);
        System.out.println("Filtered Names: " + filteredNames);
    }
}