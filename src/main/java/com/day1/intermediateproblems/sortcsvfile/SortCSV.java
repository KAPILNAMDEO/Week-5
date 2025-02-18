package com.day1.intermediateproblems.sortcsvfile;



import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\employeerecord.csv"; // Path to the CSV file
        sortAndPrintTopSalaries(filePath);
    }

    public static void sortAndPrintTopSalaries(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            if (records.size() <= 1) {
                System.out.println("CSV file is empty or only contains a header.");
                return;
            }

            // Remove header and sort by salary in descending order
            String[] header = records.remove(0);
            records.sort((a, b) -> Double.compare(Double.parseDouble(b[2]), Double.parseDouble(a[2])));

            // Print top 5 highest-paid employees
            System.out.println(Arrays.toString(header));
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println(Arrays.toString(records.get(i)));
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
