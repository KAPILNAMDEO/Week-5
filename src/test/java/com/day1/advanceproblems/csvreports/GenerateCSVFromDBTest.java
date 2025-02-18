package com.day1.advanceproblems.csvreports;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;

class GenerateCSVFromDBTest {
    private static final String TEST_DB_URL = "jdbc:h2:mem:testdb"; // In-memory database for testing
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";
    private static final String TEST_CSV_FILE = "test_employees.csv";

    @BeforeEach
    void setUp() throws SQLException {
        try (Connection conn = DriverManager.getConnection(TEST_DB_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {

            // Create table
            stmt.execute("CREATE TABLE employees (employee_id INT PRIMARY KEY, name VARCHAR(100), department VARCHAR(50), salary DOUBLE)");

            // Insert test data
            stmt.execute("INSERT INTO employees VALUES (1, 'Alice', 'IT', 60000)");
            stmt.execute("INSERT INTO employees VALUES (2, 'Bob', 'HR', 50000)");
            stmt.execute("INSERT INTO employees VALUES (3, 'Charlie', 'Finance', 70000)");
        }
    }

    @Test
    void testGenerateCSVFromDB() throws SQLException {
        GenerateCSVFromDB.generateCSVFromDB(TEST_DB_URL, USERNAME, PASSWORD, TEST_CSV_FILE);
        File file = new File(TEST_CSV_FILE);
        assertTrue(file.exists());
    }
}
