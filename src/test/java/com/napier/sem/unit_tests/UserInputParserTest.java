package com.napier.sem.unit_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import com.napier.sem.parsers.IUserInputParser;
import com.napier.sem.parsers.UserInputParser;
import org.junit.Before;
import org.junit.Test;

public class UserInputParserTest {

    private IUserInputParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new UserInputParser();
    }

    @Test
    public void testParseUserInput() {
        Map<String, String> result = parser.parseUserInput("/example_report_config.json");
        assertNotNull(result);
        assertEquals("2", result.get("number_2"));
        assertEquals("gi", result.get("string_gi"));
    }
}
