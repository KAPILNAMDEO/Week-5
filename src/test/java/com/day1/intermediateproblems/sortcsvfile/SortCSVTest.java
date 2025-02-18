package com.day1.intermediateproblems.sortcsvfile;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class SortCSVTest {
    private static final String TEST_FILE = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\resources\\test_employees.csv";

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
            writer.println("Hank,IT,72000");
            writer.println("Ivy,Sales,67000");
            writer.println("Jack,Engineering,80000");
        }
    }

    @Test
    void testSortAndPrintTopSalaries() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SortCSV.sortAndPrintTopSalaries(TEST_FILE);

        System.setOut(System.out);
        String output = outputStream.toString().trim();
        List<String> lines = List.of(output.split("\n"));

        assertTrue(lines.get(1).contains("Jack,Engineering,80000"));
        assertTrue(lines.get(2).contains("Eve,IT,75000"));
        assertTrue(lines.get(3).contains("Hank,IT,72000"));
        assertTrue(lines.get(4).contains("Charlie,Finance,70000"));
        assertTrue(lines.get(5).contains("Grace,Finance,68000"));
    }
}
