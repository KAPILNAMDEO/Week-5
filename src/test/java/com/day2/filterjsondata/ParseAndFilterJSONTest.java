package com.day2.filterjsondata;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ParseAndFilterJSONTest {
    @Test
    void testFilterByAge() {
        String jsonInput = "[{\"name\":\"Alice\",\"age\":25},{\"name\":\"Bob\",\"age\":30},{\"name\":\"Charlie\",\"age\":28},{\"name\":\"David\",\"age\":22}]";
        List<String> result = ParseAndFilterJSON.filterByAge(jsonInput, 25);
        List<String> expected = List.of("Bob", "Charlie");
        assertEquals(expected, result);
    }
}