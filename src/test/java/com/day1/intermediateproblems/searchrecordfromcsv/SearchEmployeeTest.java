package com.day1.intermediateproblems.searchrecordfromcsv;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class SearchEmployeeTest {
    private static final String TEST_FILE = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\resources\\test_employeerecord.csv";

    @BeforeEach
    void setUp() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_FILE))) {
            writer.println("Name,Department,Salary");
            writer.println("Alice,HR,50000");
            writer.println("Bob,IT,60000");
            writer.println("Charlie,Finance,70000");
            writer.println("David,Marketing,55000");
            writer.println("Eve,IT,75000");
            writer.println("Frank,HR,48000");
            writer.println("Grace,Finance,68000");
        }
    }

    @Test
    void testSearchEmployeeFound() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SearchEmployee.searchEmployee(TEST_FILE, "Eve");

        System.setOut(System.out);
        String output = outputStream.toString().trim();

        assertTrue(output.contains("Department: IT, Salary: 75000"));
    }

    @Test
    void testSearchEmployeeNotFound() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SearchEmployee.searchEmployee(TEST_FILE, "Zara");

        System.setOut(System.out);
        String output = outputStream.toString().trim();

        assertTrue(output.contains("Employee not found."));
    }
}
