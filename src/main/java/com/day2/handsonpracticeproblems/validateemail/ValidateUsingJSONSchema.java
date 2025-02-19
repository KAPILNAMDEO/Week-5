package com.day2.handsonpracticeproblems.validateemail;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.File;

public class ValidateUsingJSONSchema {
    public static boolean isValidJson(String jsonFilePath, String schemaFilePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(new File(jsonFilePath)); // Read JSON array
            JsonNode jsonSchema = objectMapper.readTree(new File(schemaFilePath)); // Read schema

            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(jsonSchema);

            ProcessingReport report = schema.validate(jsonData);
            System.out.println(report); // Print detailed validation report

            return report.isSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        boolean isValid = isValidJson("C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\data.json", "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\schema.json");
        System.out.println("Is JSON valid? " + isValid);
    }
}
