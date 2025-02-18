package com.day1.basicproblems.readandprintcsvfile;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class ReadCSVTest {

    @Test
    void testFileReading() {
        String testFilePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\resources\\test_students.csv";

        // Create a sample CSV file for testing
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath))) {
            writer.write("101,John Doe,20,85\n");
            writer.write("102,Jane Smith,21,90\n");
            writer.write("103,Emily Johnson,19,78\n");
        } catch (IOException e) {
            fail("Error setting up test file: " + e.getMessage());
        }

        // Capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        ReadCSV.main(new String[]{testFilePath});

        // Restore console output
        System.setOut(originalOut);

        // Expected output
        String expectedOutput = "ID    Name           Age   Marks\n"
                + "--------------------------------\n"
                + "101   John Doe       20    85   \n"
                + "102   Jane Smith     21    90   \n"
                + "103   Emily Johnson  19    78   \n";

        assertTrue(outputStream.toString().contains("101   John Doe"), "Output should contain student data");
    }
}
