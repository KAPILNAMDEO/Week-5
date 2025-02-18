package com.day1.basicproblems.writecsvfile;

import java.io.*;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\employees.csv";

        // Sample employee data
        String[] employees = {
                "101,John Doe,HR,50000",
                "102,Jane Smith,IT,60000",
                "103,Emily Johnson,Finance,55000",
                "104,Michael Brown,Marketing,58000",
                "105,Chris Evans,Sales,62000"
        };

        // Writing data to CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary\n"); // Header row
            for (String employee : employees) {
                writer.write(employee + "\n");
            }
            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

