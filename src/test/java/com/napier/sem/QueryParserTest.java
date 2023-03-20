package com.napier.sem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QueryParserTest {

    private QueryParser queryParser;

    @BeforeEach
    void setUp() {
        queryParser = new QueryParser();
    }

    @Test
    void testParseQueries() throws IOException {
        String pathToQueries = "src/test/resources/test_queries.sql";
        List<Map<String, String>> parsedQueries = queryParser.ParseQueries(pathToQueries);

        assertEquals(2, parsedQueries.size());

        Map<String, String> firstQuery = parsedQueries.get(0);
        assertEquals("Query1", firstQuery.get("queryName"));
        assertEquals("SELECT * FROM table1;", firstQuery.get("query"));

        Map<String, String> secondQuery = parsedQueries.get(1);
        assertEquals("Query2", secondQuery.get("queryName"));
        assertEquals("SELECT * FROM table2;", secondQuery.get("query"));
    }

    @Test
    void testParseQueriesWithEmptyFile() throws IOException {
        String pathToEmptyFile = "src/test/resources/empty_test_queries.sql";

        List<Map<String, String>> parsedQueries = queryParser.ParseQueries(pathToEmptyFile);
        assertTrue(parsedQueries.isEmpty());
    }
}