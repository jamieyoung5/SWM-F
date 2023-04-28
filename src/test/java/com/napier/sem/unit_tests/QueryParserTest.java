package com.napier.sem.unit_tests;

import com.napier.sem.models.ReportQuery;
import com.napier.sem.parsers.IUserInputParser;
import com.napier.sem.parsers.QueryParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class QueryParserTest {
    
    private QueryParser queryParser;
    
    @Mock
    private IUserInputParser userInputParser;
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        when(userInputParser.parseUserInput(anyString())).thenReturn(getMockUserInputs());
        queryParser = new QueryParser(userInputParser);
    }
    
    @Test
    public void testParseQueriesWithEmptyFile() throws IOException {
        List<ReportQuery> expectedQueries = Collections.emptyList();
        assertEquals(expectedQueries, queryParser.ParseQueries("empty_test_queries.sql"));
    }
    
    @Test
    public void testParseQueries() throws IOException {
        List<ReportQuery> result = queryParser.ParseQueries("test_queries.sql");
        //expectedQueries.add(new ReportQuery("SELECT * FROM example", "Example query"));
        //expectedQueries.add(new ReportQuery("SELECT * FROM example2", "Example query 2"));
        assertEquals("Example query", result.get(0).getQueryName());
        
        
        //assertEquals(expectedQueries, queryParser.ParseQueries("test_queries.sql"));
    }
    
    private Map<String, String> getMockUserInputs() {
        Map<String, String> userInput = new HashMap<>();
        userInput.put("user_input", "John");
        return userInput;
    }
}
