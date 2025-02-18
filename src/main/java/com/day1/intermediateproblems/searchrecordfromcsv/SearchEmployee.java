package com.day1.intermediateproblems.searchrecordfromcsv;



import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SearchEmployee {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\employeerecord.csv"; // Path to the CSV file
        String searchName = "Eve"; // Employee name to search
        searchEmployee(filePath, searchName);
    }

    public static void searchEmployee(String filePath, String name) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            boolean found = false;

            for (int i = 1; i < records.size(); i++) { // Skipping header row
                String[] record = records.get(i);
                if (record.length >= 3 && record[0].equalsIgnoreCase(name)) {
                    System.out.println("Department: " + record[1] + ", Salary: " + record[2]);
                    found = true;
                    break; // Stop searching after finding the first match
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
