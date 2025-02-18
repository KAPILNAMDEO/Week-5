package com.day1.advanceproblems.largecsv;




import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "large_students.csv"; // Path to large CSV file
        int batchSize = 100; // Process 100 lines at a time
        readLargeCSVInChunks(filePath, batchSize);
    }

    public static void readLargeCSVInChunks(String filePath, int batchSize) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> allData = reader.readAll(); // Read all records at once

            if (allData.isEmpty()) {
                System.out.println("CSV file is empty!");
                return;
            }

            int totalRecords = allData.size() - 1; // Exclude header
            System.out.println("Total records in file (excluding header): " + totalRecords);

            // Process records in chunks
            for (int i = 1; i < allData.size(); i++) { // Start from index 1 (skip header)
                String[] line = allData.get(i);
                System.out.println("Processing record " + i + ": " + String.join(", ", line));

                if (i % batchSize == 0) {
                    System.out.println("Processed " + i + " records so far...");
                }
            }

            System.out.println("✅ Finished processing all " + totalRecords + " records!");

        } catch (IOException | CsvException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}

