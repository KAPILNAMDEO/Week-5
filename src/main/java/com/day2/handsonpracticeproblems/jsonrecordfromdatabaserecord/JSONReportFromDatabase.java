package com.day2.handsonpracticeproblems.jsonrecordfromdatabaserecord;

/*8️⃣ Generate a JSON report from database records./
        package com.day2jsonhandling.handsonpracticeproblems.jsonreport;*/

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JSONReportFromDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "1234";

        String jsonFilePath = "src/main/resources/students.json";

        List<Student> students = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, name, email, age FROM students";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getInt("age")
                );
                students.add(student);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new FileWriter(jsonFilePath), students);

            System.out.println("✅ JSON Report Generated: " + jsonFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
