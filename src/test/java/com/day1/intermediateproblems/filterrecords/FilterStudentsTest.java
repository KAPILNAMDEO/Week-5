package com.day1.intermediateproblems.filterrecords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class FilterStudentsTest {
    private static final String TEST_FILE = "test_students.csv";

    @BeforeEach
    void setUp() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_FILE))) {
            writer.println("Name,Marks");
            writer.println("Alice,85");
            writer.println("Bob,78");
            writer.println("Charlie,90");
            writer.println("David,65");
            writer.println("Eve,88");
            writer.println("Frank,80");
            writer.println("Grace,95");
        }
    }

    @Test
    void testFilterStudents() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        FilterStudents.filterStudents(TEST_FILE);

        System.setOut(System.out);
        String output = outputStream.toString().trim();

        assertTrue(output.contains("Alice,85"));
        assertTrue(output.contains("Charlie,90"));
        assertTrue(output.contains("Eve,88"));
        assertTrue(output.contains("Grace,95"));
        assertFalse(output.contains("Bob,78"));
        assertFalse(output.contains("David,65"));
        assertFalse(output.contains("Frank,80"));
    }
}
