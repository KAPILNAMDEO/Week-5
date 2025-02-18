package com.day1.advanceproblems.jsoncsv;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class JsonCsvConverterTest {
    private static final String TEST_JSON_FILE = "test_students.json";
    private static final String TEST_CSV_FILE = "test_students.csv";
    private static final String TEST_OUTPUT_JSON = "test_converted_students.json";

    @BeforeEach
    void setUp() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_JSON_FILE))) {
            writer.println("[");
            writer.println("{\"id\":1, \"name\":\"Alice\", \"age\":20, \"marks\":85.5},");
            writer.println("{\"id\":2, \"name\":\"Bob\", \"age\":21, \"marks\":78.0},");
            writer.println("{\"id\":3, \"name\":\"Charlie\", \"age\":22, \"marks\":92.0}");
            writer.println("]");
        }
    }

    @Test
    void testJsonToCsvConversion() {
        JsonCsvConverter.convertJsonToCsv(TEST_JSON_FILE, TEST_CSV_FILE);
        assertTrue(new File(TEST_CSV_FILE).exists());
    }

    @Test
    void testCsvToJsonConversion() {
        JsonCsvConverter.convertCsvToJson(TEST_CSV_FILE, TEST_OUTPUT_JSON);
        assertTrue(new File(TEST_OUTPUT_JSON).exists());
    }
}
