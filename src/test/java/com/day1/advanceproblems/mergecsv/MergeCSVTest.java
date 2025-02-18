package com.day1.advanceproblems.mergecsv;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.opencsv.CSVReader;
import java.io.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MergeCSVTest {
    private static final String TEST_FILE1 = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\resources\\teststudent1.csv";
    private static final String TEST_FILE2 = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\resources\\teststudent2.csv";
    private static final String OUTPUT_FILE = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\resources\\testmerge.csv";

    @BeforeEach
    void setUp() throws IOException {
        try (PrintWriter writer1 = new PrintWriter(new FileWriter(TEST_FILE1));
             PrintWriter writer2 = new PrintWriter(new FileWriter(TEST_FILE2))) {

            writer1.println("ID,Name,Age");
            writer1.println("101,John,20");
            writer1.println("102,Alice,22");

            writer2.println("ID,Marks,Grade");
            writer2.println("101,85,A");
            writer2.println("103,78,B");
        }
    }

    @Test
    void testMergeCSV() throws Exception {
        MergeCSV.mergeCSVFiles(TEST_FILE1, TEST_FILE2, OUTPUT_FILE);
        File mergedFile = new File(OUTPUT_FILE);
        assertTrue(mergedFile.exists());

        try (CSVReader reader = new CSVReader(new FileReader(OUTPUT_FILE))) {
            List<String[]> data = reader.readAll();
            assertEquals(4, data.size()); // Header + 3 data rows
        }
    }
}
