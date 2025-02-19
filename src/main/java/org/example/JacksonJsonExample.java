package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
class User {
    public String name;
    public int age;
    public String email;
    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
public class JacksonJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            User user = new User("Alice", 25, "alice@example.com");
            // Convert Java Object to JSON String
            String jsonString = objectMapper.writeValueAsString(user);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
