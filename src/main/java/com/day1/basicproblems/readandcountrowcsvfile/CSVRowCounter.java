
/* read and Count Rows in a CSV File
Read a CSV file and count the number of records (excluding the header row).*/
package com.day1.basicproblems.readandcountrowcsvfile;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CSVRowCounter {
    public static int countRows(String filePath) {
        int rowCount = 0;
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext(); // Skip header row
            while (reader.readNext() != null) {
                rowCount++;
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\employees.csv";
        System.out.println("Total Records: " + countRows(filePath));
    }
}
