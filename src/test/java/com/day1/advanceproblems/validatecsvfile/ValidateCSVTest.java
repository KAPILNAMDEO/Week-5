package com.day1.advanceproblems.validatecsvfile;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class ValidateCSVTest {
    private static final String TEST_FILE = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\resources\\test_validateemployee.csv";

    @BeforeEach
    void setUp() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_FILE))) {
            writer.println("Name,Email,Phone");
            writer.println("Alice,alice@example.com,9876543210");
            writer.println("Bob,bob.example.com,123456789");
            writer.println("Charlie,charlie@example.com,98765432101");
            writer.println("David,david@company.com,8765432109");
            writer.println("Eve,eve@company,9876543212");
            writer.println("Frank,frank@example.com,9988776655");
            writer.println("Grace,grace@work.com,12345");
        }
    }

    @Test
    void testValidateCSV() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ValidateCSV.validateCSV(TEST_FILE);

        System.setOut(System.out);
        String output = outputStream.toString().trim();
        List<String> lines = List.of(output.split("\n"));

        assertTrue(lines.contains("Invalid row: Bob,bob.example.com,123456789"));
        assertTrue(lines.contains("  -> Invalid Email: bob.example.com"));
        assertTrue(lines.contains("  -> Invalid Phone: 123456789"));

        assertTrue(lines.contains("Invalid row: Charlie,charlie@example.com,98765432101"));
        assertTrue(lines.contains("  -> Invalid Phone: 98765432101"));

        assertTrue(lines.contains("Invalid row: Eve,eve@company,9876543212"));
        assertTrue(lines.contains("  -> Invalid Email: eve@company"));

        assertTrue(lines.contains("Invalid row: Grace,grace@work.com,12345"));
        assertTrue(lines.contains("  -> Invalid Phone: 12345"));
    }
}
