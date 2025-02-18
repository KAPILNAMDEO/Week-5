package com.day1.advanceproblems.encrptdecrpt;



import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Base64;
import java.util.List;

public class EncryptDecryptCSV {
    private static SecretKey secretKey;

    static {
        try {
            secretKey = generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String originalCsv = "employees.csv";
        String encryptedCsv = "encrypted_employees.csv";
        String decryptedCsv = "decrypted_employees.csv";

        encryptCSV(originalCsv, encryptedCsv);
        decryptCSV(encryptedCsv, decryptedCsv);
    }

    public static void encryptCSV(String inputFilePath, String outputFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            List<String[]> records = reader.readAll();
            writer.writeNext(records.get(0)); // Write header

            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);
                record[2] = encrypt(record[2]); // Encrypt Email
                record[3] = encrypt(record[3]); // Encrypt Salary
                writer.writeNext(record);
            }

            System.out.println("CSV file encrypted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void decryptCSV(String inputFilePath, String outputFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            List<String[]> records = reader.readAll();
            writer.writeNext(records.get(0)); // Write header

            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);
                record[2] = decrypt(record[2]); // Decrypt Email
                record[3] = decrypt(record[3]); // Decrypt Salary
                writer.writeNext(record);
            }

            System.out.println("CSV file decrypted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        return keyGen.generateKey();
    }

    private static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    private static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }
}
