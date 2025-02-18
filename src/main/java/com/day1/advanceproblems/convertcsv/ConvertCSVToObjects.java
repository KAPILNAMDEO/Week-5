package com.day1.advanceproblems.convertcsv;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Grade='" + grade + '\'' +
                '}';
    }
}

public class ConvertCSVToObjects {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\studentresult.csv"; // Path to CSV file
        List<Student> students = readStudentsFromCSV(filePath);
        students.forEach(System.out::println);
    }

    public static List<Student> readStudentsFromCSV(String filePath) {
        List<Student> students = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            if (records.size() <= 1) {
                System.out.println("CSV file is empty or only contains a header.");
                return students;
            }

            records.remove(0); // Remove header row
            for (String[] record : records) {
                if (record.length < 4) continue; // Ignore incomplete rows

                try {
                    int id = Integer.parseInt(record[0].trim());
                    String name = record[1].trim();
                    int age = Integer.parseInt(record[2].trim());
                    String grade = record[3].trim();

                    students.add(new Student(id, name, age, grade));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid data format: " + String.join(",", record));
                }
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return students;
    }
}
