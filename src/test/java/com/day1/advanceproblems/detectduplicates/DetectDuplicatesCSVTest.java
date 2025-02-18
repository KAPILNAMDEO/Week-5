package com.day1.advanceproblems.detectduplicates;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DetectDuplicatesCSVTest {
    private static final String TEST_FILE = "test_students.csv";

    @BeforeEach
    void setUp() throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(TEST_FILE))) {
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});
            writer.writeNext(new String[]{"101", "John", "20", "85", "A"});
            writer.writeNext(new String[]{"102", "Alice", "22", "78", "B"});
            writer.writeNext(new String[]{"101", "John", "20", "85", "A"}); // Duplicate
            writer.writeNext(new String[]{"103", "Bob", "21", "90", "A"});
            writer.writeNext(new String[]{"103", "Bob", "21", "90", "A"}); // Duplicate
        }
    }

    @Test
    void testDetectDuplicates() {
        assertDoesNotThrow(() -> DetectDuplicatesCSV.detectDuplicates(TEST_FILE));
    }
}
