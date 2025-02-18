package com.day1.advanceproblems.convertcsv;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ConvertCSVToObjectsTest {
    private static final String TEST_FILE = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\resources\\teststudentresult.csv";

    @BeforeEach
    void setUp() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_FILE))) {
            writer.println("ID,Name,Age,Grade");
            writer.println("1,Alice,20,A");
            writer.println("2,Bob,21,B");
            writer.println("3,Charlie,22,A");
            writer.println("4,David,20,C");
            writer.println("5,Eve,21,B+");
        }
    }

    @Test
    void testReadStudentsFromCSV() {
        List<Student> students = ConvertCSVToObjects.readStudentsFromCSV(TEST_FILE);
        assertEquals(5, students.size());

        assertEquals("Student{ID=1, Name='Alice', Age=20, Grade='A'}", students.get(0).toString());
        assertEquals("Student{ID=5, Name='Eve', Age=21, Grade='B+'}", students.get(4).toString());
    }
}
