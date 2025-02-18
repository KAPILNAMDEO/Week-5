package com.day1.basicproblems.readandcountrowcsvfile;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CSVRowCounterTest {
    @Test
    public void testCountRows() {
        String testFilePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\test\\resources\\test_employees.csv";
        int expectedCount = 5; // Excluding the header
        assertEquals(expectedCount, CSVRowCounter.countRows(testFilePath));
    }
}
