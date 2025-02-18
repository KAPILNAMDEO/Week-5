package com.day1.advanceproblems.mergecsv;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\student1.csv"; // First CSV file (ID, Name, Age)
        String file2 = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\student2.csv"; // Second CSV file (ID, Marks, Grade)
        String outputFile = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\resources\\testmerge.csv"; // Output file for merged data

        try {
            mergeCSVFiles(file1, file2, outputFile);
            System.out.println(" Merged CSV created successfully: " + outputFile);
        } catch (IOException | CsvException e) {
            System.err.println("Error occurred while merging CSV files: " + e.getMessage());
        }
    }

    public static void mergeCSVFiles(String file1, String file2, String outputFile) throws IOException, CsvException {
        Map<String, String[]> studentData = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(file1));
             CSVReader reader2 = new CSVReader(new FileReader(file2));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            // Read first file and store data (ID, Name, Age)
            List<String[]> records1 = reader1.readAll();
            if (!records1.isEmpty()) {
                records1.remove(0); // Remove header
                for (String[] record : records1) {
                    if (record.length >= 3) {
                        studentData.put(record[0], new String[]{record[0], record[1], record[2], "N/A", "N/A"});
                    }
                }
            }

            // Read second file and merge data (ID, Marks, Grade)
            List<String[]> records2 = reader2.readAll();
            if (!records2.isEmpty()) {
                records2.remove(0); // Remove header
                for (String[] record : records2) {
                    if (record.length >= 3) {
                        String id = record[0];
                        if (studentData.containsKey(id)) {
                            String[] student = studentData.get(id);
                            student[3] = record[1]; // Marks
                            student[4] = record[2]; // Grade
                        } else {
                            studentData.put(id, new String[]{id, "Unknown", "Unknown", record[1], record[2]});
                        }
                    }
                }
            }

            // Write merged data to output file
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});
            for (String[] data : studentData.values()) {
                writer.writeNext(data);
            }
        }
    }
}


