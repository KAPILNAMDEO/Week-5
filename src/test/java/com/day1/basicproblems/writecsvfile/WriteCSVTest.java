package com.day1.basicproblems.writecsvfile;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class WriteCSVTest {

    @Test
    void testFileWriting() {
        String testFilePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\resources\\test_employees.csv";

        // Run the main method
        WriteCSV.main(new String[]{testFilePath});

        // Verify file exists
        File file = new File(testFilePath);
        assertTrue(file.exists(), "File should be created");

        // Read file content
        try (BufferedReader reader = new BufferedReader(new FileReader(testFilePath))) {
            String header = reader.readLine();
            assertEquals("ID,Name,Department,Salary", header, "Header should match");

            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }
            assertEquals(5, lineCount, "File should contain 5 employee records");
        } catch (IOException e) {
            fail("Error reading the test file: " + e.getMessage());
        }


    }
}
