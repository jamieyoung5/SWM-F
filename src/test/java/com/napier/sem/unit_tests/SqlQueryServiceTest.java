package com.napier.sem.unit_tests;

import com.napier.sem.database.SqlQueryService;
import com.napier.sem.display.IQueryResultFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SqlQueryServiceTest {
    
    @Mock
    private IQueryResultFormatter queryResultFormatter;
    
    @Mock
    private Connection connection;
    
    @Mock
    private Statement statement;
    
    @Mock
    private ResultSet resultSet;
    
    private SqlQueryService sqlQueryService;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        sqlQueryService = new SqlQueryService(queryResultFormatter);
    }
    
    @Test
    public void testExecuteQuery() throws SQLException {
        String query = "SELECT * FROM countries";
        String expectedResult = "test result";
        
        when(connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)).thenReturn(statement);
        when(statement.executeQuery(query)).thenReturn(resultSet);
        when(queryResultFormatter.parseQueryOutputToString(resultSet)).thenReturn(expectedResult);
        
        String result = sqlQueryService.executeQuery(connection, query);
        
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testExecuteQueryWithException() throws SQLException {
        String query = "SELECT * FROM countries";
        
        when(connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)).thenReturn(statement);
        when(statement.executeQuery(query)).thenThrow(SQLException.class);
        
        String result = sqlQueryService.executeQuery(connection, query);
        
        assertEquals("Couldn't execute query -> java.sql.SQLException", result);
    }
}
