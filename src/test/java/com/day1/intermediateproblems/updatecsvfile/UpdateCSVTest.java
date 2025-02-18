package com.day1.intermediateproblems.updatecsvfile;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class UpdateCSVTest {
    private static final String TEST_INPUT_FILE = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\resources\\test_employeerecord.csv";
    private static final String TEST_OUTPUT_FILE = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\resources\\testupdatecsvrecord.csv";

    @BeforeEach
    void setUp() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_INPUT_FILE))) {
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
    void testUpdateSalaries() throws IOException {
        UpdateCSV.updateSalaries(TEST_INPUT_FILE, TEST_OUTPUT_FILE);

        // Read the updated file and check if IT salaries increased
        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_OUTPUT_FILE))) {
            reader.readLine(); // Skip header
            String line;
            boolean bobUpdated = false, eveUpdated = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String department = parts[1].trim();
                    double salary = Double.parseDouble(parts[2].trim());

                    if (name.equals("Bob") && department.equals("IT")) {
                        assertEquals(66000.00, salary, 0.01);
                        bobUpdated = true;
                    }
                    if (name.equals("Eve") && department.equals("IT")) {
                        assertEquals(82500.00, salary, 0.01);
                        eveUpdated = true;
                    }
                }
            }
            assertTrue(bobUpdated);
            assertTrue(eveUpdated);
        }
    }
}
