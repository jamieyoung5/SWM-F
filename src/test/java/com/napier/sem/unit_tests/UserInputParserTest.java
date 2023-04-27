package com.napier.sem.unit_tests;

import static org.junit.Assert.assertEquals;
import java.util.Map;
import com.napier.sem.parsers.UserInputParser;
import org.junit.Test;

public class UserInputParserTest {
    
    private final UserInputParser parser = new UserInputParser();
    
    @Test
    public void testParseUserInput() {
        String path = "/example_report_config.json";
        Map<String, String> actual = parser.parseUserInput(path);
        
        Map<String, String> expected = Map.of(
              "number_2", "2",
              "string_gi", "gi"
        );
        
        assertEquals(expected, actual);
    }
}
