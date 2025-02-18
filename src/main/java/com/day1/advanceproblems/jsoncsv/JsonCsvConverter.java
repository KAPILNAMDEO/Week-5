package com.day1.advanceproblems.jsoncsv;



import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getMarks() { return marks; }
}

public class JsonCsvConverter {
    public static void main(String[] args) {
        String jsonFilePath = "students.json";
        String csvFilePath = "students.csv";
        String outputJsonFilePath = "converted_students.json";

        convertJsonToCsv(jsonFilePath, csvFilePath);
        convertCsvToJson(csvFilePath, outputJsonFilePath);
    }

    public static void convertJsonToCsv(String jsonFilePath, String csvFilePath) {
        try (Reader reader = new FileReader(jsonFilePath);
             CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {

            Gson gson = new Gson();
            Type studentListType = new TypeToken<List<Student>>() {}.getType();
            List<Student> students = gson.fromJson(reader, studentListType);

            if (students == null || students.isEmpty()) {
                System.out.println("No student data found in JSON file.");
                return;
            }

            // Write CSV header
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks"});

            // Write student data
            for (Student student : students) {
                writer.writeNext(new String[]{
                        String.valueOf(student.getId()),
                        student.getName(),
                        String.valueOf(student.getAge()),
                        String.valueOf(student.getMarks())
                });
            }

            System.out.println("✅ JSON converted to CSV successfully!");

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }

    public static void convertCsvToJson(String csvFilePath, String jsonFilePath) {
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath));
             Writer writer = new FileWriter(jsonFilePath)) {

            List<String[]> records = reader.readAll();

            if (records.isEmpty()) {
                System.out.println("CSV file is empty!");
                return;
            }

            records.remove(0); // Remove header

            for (String[] record : records) {
                try {
                    students.add(new Student(
                            Integer.parseInt(record[0]),
                            record[1],
                            Integer.parseInt(record[2]),
                            Double.parseDouble(record[3])
                    ));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid record: " + Arrays.toString(record));
                }
            }

            Gson gson = new Gson();
            writer.write(gson.toJson(students));
            System.out.println("✅ CSV converted to JSON successfully!");

        } catch (IOException | CsvException e) {
            System.err.println("Error reading/writing CSV file: " + e.getMessage());
        }
    }
}
