package com.napier.sem.unit_tests.database;

import com.napier.sem.database.SqlQueryService;
import org.junit.*;
import org.mockito.Mockito;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SqlQueryServiceTest {

    private SqlQueryService sqlQueryService;
    private Connection connection;

    @Before
    public void setUp() {
        sqlQueryService = new SqlQueryService();
        connection = Mockito.mock(Connection.class);
    }

    @Test
    public void testExecuteQuery() throws SQLException {
        // Setup mock ResultSet with sample data
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        ResultSetMetaData resultSetMetaData = Mockito.mock(ResultSetMetaData.class);
        when(resultSet.getMetaData()).thenReturn(resultSetMetaData);
        when(resultSetMetaData.getColumnCount()).thenReturn(2);
        when(resultSetMetaData.getColumnName(1)).thenReturn("col1");
        when(resultSetMetaData.getColumnName(2)).thenReturn("col2");
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getString(1)).thenReturn("value1");
        when(resultSet.getString(2)).thenReturn("value2");

        // Setup mock Statement to return mock ResultSet
        Statement statement = Mockito.mock(Statement.class);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery("SELECT * FROM table")).thenReturn(resultSet);

        // Execute query and verify result
        String result = sqlQueryService.executeQuery(connection, "SELECT * FROM table");
        String expected = "col1\tcol2\t\nvalue1\tvalue2\t\n";
        assertEquals(expected, result);
    }


    @Test
    public void testExecuteQueryWithError() throws SQLException {
        // Setup mock Statement to throw SQLException
        Statement statement = Mockito.mock(Statement.class);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery("INVALID QUERY")).thenThrow(new SQLException("Invalid query"));

        // Execute query and verify error message
        String result = sqlQueryService.executeQuery(connection, "INVALID QUERY");
        String expected = "Couldn't execute query -> java.sql.SQLException: Invalid query";
        assertEquals(expected, result);
    }
}
