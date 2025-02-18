package com.day1.advanceproblems.encrptdecrpt;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class EncryptDecryptCSVTest {
    private static final String TEST_CSV = "test_employees.csv";
    private static final String ENCRYPTED_CSV = "test_encrypted.csv";
    private static final String DECRYPTED_CSV = "test_decrypted.csv";

    @BeforeEach
    void setUp() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_CSV))) {
            writer.println("ID,Name,Email,Salary");
            writer.println("1,Alice,alice@example.com,60000");
            writer.println("2,Bob,bob@example.com,50000");
        }
    }

    @Test
    void testEncryptionDecryption() {
        EncryptDecryptCSV.encryptCSV(TEST_CSV, ENCRYPTED_CSV);
        EncryptDecryptCSV.decryptCSV(ENCRYPTED_CSV, DECRYPTED_CSV);

        File decryptedFile = new File(DECRYPTED_CSV);
        assertTrue(decryptedFile.exists());
    }
}
