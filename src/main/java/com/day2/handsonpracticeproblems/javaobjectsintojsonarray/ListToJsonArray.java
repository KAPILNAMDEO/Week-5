package com.day2.handsonpracticeproblems.javaobjectsintojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ListToJsonArray {
    public static void main(String[] args) {
        try{
            //list to store list of data
            List<Person>people=new ArrayList<>();
            people.add(new Person("kapil",25));
            people.add(new Person("atul",32));

            ObjectMapper objectMapper=new ObjectMapper();
            String jsonArray=objectMapper.writeValueAsString(people);
          //print json array
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
