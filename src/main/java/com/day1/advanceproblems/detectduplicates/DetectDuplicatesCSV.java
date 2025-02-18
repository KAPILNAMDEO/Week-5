package com.day1.advanceproblems.detectduplicates;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicatesCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Path to CSV file
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Set<String> uniqueRecords = new HashSet<>();
        Set<String> duplicateRecords = new HashSet<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            if (records.isEmpty()) {
                System.out.println("CSV file is empty!");
                return;
            }

            String[] header = records.get(0); // Store header (optional)
            records.remove(0); // Skip header row

            for (String[] record : records) {
                if (record.length > 0) {
                    String id = record[0].trim().toLowerCase(); // Normalize ID
                    String fullRecord = String.join(",", record);

                    if (!uniqueRecords.add(id)) {
                        duplicateRecords.add(fullRecord);
                    }
                }
            }

            if (duplicateRecords.isEmpty()) {
                System.out.println(" No duplicate records found.");
            } else {
                System.out.println(" Duplicate Records Found:");
                duplicateRecords.forEach(System.out::println);
            }

        } catch (IOException | CsvException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}


