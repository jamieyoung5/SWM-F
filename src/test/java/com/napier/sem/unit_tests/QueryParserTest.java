package com.napier.sem.unit_tests;

import com.napier.sem.models.ReportQuery;
import com.napier.sem.parsers.IUserInputParser;
import com.napier.sem.parsers.QueryParser;
import com.napier.sem.parsers.UserInputParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueryParserTest {

    private QueryParser queryParser;
    private IUserInputParser userInputParser;

    @BeforeEach
    void setUp() {
        userInputParser = new UserInputParser();
        queryParser = new QueryParser(userInputParser);
    }

    @Test
    void testParseQueries() throws IOException, URISyntaxException {
        String pathToQueries = "test_queries.sql";
        List<ReportQuery> parsedQueries = queryParser.ParseQueries(pathToQueries);

        assertEquals(2, parsedQueries.size());

        ReportQuery firstQuery = parsedQueries.get(0);
        assertEquals("Query1", firstQuery.getQueryName());
        assertEquals("SELECT * FROM table1;", firstQuery.getQuery());

        ReportQuery secondQuery = parsedQueries.get(1);
        assertEquals("Query2", secondQuery.getQueryName());
        assertEquals("SELECT * FROM table2;", secondQuery.getQuery());
    }

    @Test
    void testParseQueriesWithEmptyFile() throws IOException, URISyntaxException {
        String pathToEmptyFile = "empty_test_queries.sql";

        List<ReportQuery> parsedQueries = queryParser.ParseQueries(pathToEmptyFile);
        assertTrue(parsedQueries.isEmpty());
    }
}