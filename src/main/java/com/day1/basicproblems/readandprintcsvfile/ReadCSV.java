package com.day1.basicproblems.readandprintcsvfile;

import java.io.*;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week5\\src\\main\\resources\\students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.printf("%-5s %-15s %-5s %-5s\n", "ID", "Name", "Age", "Marks");
            System.out.println("--------------------------------");
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 4) {
                    System.out.printf("%-5s %-15s %-5s %-5s\n", values[0], values[1], values[2], values[3]);
                } else {
                    System.out.println("Skipping malformed line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
