package com.day1.advanceproblems.validatecsvfile;



import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class ValidateCSV {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

    public static void main(String[] args) {
        String filePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\validateemployee.csv"; // Path to the CSV file
        validateCSV(filePath);
    }

    public static void validateCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            if (records.size() <= 1) {
                System.out.println("CSV file is empty or only contains a header.");
                return;
            }

            boolean hasErrors = false;
            for (int i = 1; i < records.size(); i++) { // Skipping header row
                String[] record = records.get(i);
                if (record.length < 3) continue; // Ignore incomplete rows

                String email = record[1].trim();
                String phone = record[2].trim();

                boolean isValidEmail = EMAIL_PATTERN.matcher(email).matches();
                boolean isValidPhone = PHONE_PATTERN.matcher(phone).matches();

                if (!isValidEmail || !isValidPhone) {
                    hasErrors = true;
                    System.out.println("Invalid row: " + String.join(",", record));
                    if (!isValidEmail) System.out.println("  -> Invalid Email: " + email);
                    if (!isValidPhone) System.out.println("  -> Invalid Phone: " + phone);
                }
            }

            if (!hasErrors) {
                System.out.println("All records are valid.");
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}

