package com.napier.sem.unit_tests;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.napier.sem.display.QueryResultFormatter;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QueryResultFormatterTest {
    
    @Mock
    private ResultSet resultSet;
    
    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    }
    
    @Test
    public void testParseQueryOutputToString() throws SQLException {
        QueryResultFormatter queryResultFormatter = new QueryResultFormatter();
        String formattedResult = queryResultFormatter.parseQueryOutputToString(resultSet);
        assertNotNull(formattedResult);
    }
}