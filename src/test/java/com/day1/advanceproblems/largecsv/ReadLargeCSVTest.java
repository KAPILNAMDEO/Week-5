package com.day1.advanceproblems.largecsv;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ReadLargeCSVTest {
    private static final String TEST_FILE = "test_large_students.csv";

    @BeforeEach
    void setUp() throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(TEST_FILE))) {
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});
            for (int i = 1; i <= 500; i++) { // Generating test records
                writer.writeNext(new String[]{String.valueOf(100 + i), "Student" + i, "20", "80", "B"});
            }
        }
    }

    @Test
    void testReadLargeCSV() {
        assertDoesNotThrow(() -> ReadLargeCSV.readLargeCSVInChunks(TEST_FILE, 100));
    }
}
