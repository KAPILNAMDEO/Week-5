package com.day1.intermediateproblems.updatecsvfile;



import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.List;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\employeerecord.csv"; // Original CSV file
        String outputFilePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\updated_employees.csv"; // Updated CSV file
        updateSalaries(inputFilePath, outputFilePath);
    }

    public static void updateSalaries(String inputFilePath, String outputFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            List<String[]> records = reader.readAll();
            if (records.isEmpty()) {
                System.out.println("CSV file is empty!");
                return;
            }

            for (int i = 0; i < records.size(); i++) {
                String[] record = records.get(i);

                if (i == 0) {
                    writer.writeNext(record); // Write header row as is
                    continue;
                }

                if (record.length >= 3 && record[1].equalsIgnoreCase("IT")) {
                    try {
                        double salary = Double.parseDouble(record[2]);
                        salary *= 1.10; // Increase by 10%
                        record[2] = String.format("%.2f", salary);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid salary format: " + record[2]);
                    }
                }

                writer.writeNext(record);
            }
            System.out.println("Updated salaries saved to " + outputFilePath);

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}

