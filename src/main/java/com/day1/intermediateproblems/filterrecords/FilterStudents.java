package com.day1.intermediateproblems.filterrecords;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FilterStudents {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\studentscore.csv";
        filterStudents(filePath);
    }

    public static void filterStudents(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            if (records.isEmpty()) {
                System.out.println("CSV file is empty!");
                return;
            }

            for (int i = 1; i < records.size(); i++) { // Skip header row
                String[] record = records.get(i);
                System.out.println("Raw Data: " + Arrays.toString(record)); // Debug print

                if (record.length >= 2) {
                    try {
                        int marks = Integer.parseInt(record[1].trim());
                        if (marks > 80) {
                            System.out.println(record[0] + "," + record[1]);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format: " + record[1]);
                    }
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
