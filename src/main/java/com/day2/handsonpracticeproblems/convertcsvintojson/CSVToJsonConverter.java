package com.day2.handsonpracticeproblems.convertcsvintojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class CSVToJsonConverter {
    public static void main(String[] args) {
        String csvFilePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\iplmatch.csv";
        String jsonFilePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\Week-5\\src\\main\\resources\\jsonfile.json";

        try (FileReader fileReader = new FileReader(csvFilePath)) {
            //CSV to Java Objects
            CsvToBean<Match> csvToBean = new CsvToBeanBuilder<Match>(fileReader)
                    .withType(Match.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<Match> matches = csvToBean.parse();

            //Java Objects to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new FileWriter(jsonFilePath), matches);

            System.out.println("CSV converted to JSON successfully! Check " + jsonFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
