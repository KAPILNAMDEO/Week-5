package com.day1.advanceproblems.csvreports;


import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class GenerateCSVFromDB {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/companydb"; // Change DB details
        String username = "root"; // DB username
        String password = "password"; // DB password
        String csvFilePath = "employees.csv"; // Output CSV file path

        generateCSVFromDB(jdbcURL, username, password, csvFilePath);
    }

    public static void generateCSVFromDB(String jdbcURL, String username, String password, String csvFilePath) {
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {

            // Write header
            writer.writeNext(new String[]{"Employee ID", "Name", "Department", "Salary"});

            // Write data rows
            while (rs.next()) {
                String employeeId = String.valueOf(rs.getInt("employee_id"));
                String name = rs.getString("name");
                String department = rs.getString("department");
                String salary = String.valueOf(rs.getDouble("salary"));
                writer.writeNext(new String[]{employeeId, name, department, salary});
            }

            System.out.println("CSV file created successfully: " + csvFilePath);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

