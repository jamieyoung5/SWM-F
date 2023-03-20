package com.napier.sem;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SqlQueryServiceTest {

    private SqlQueryService sqlQueryService;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    @BeforeEach
    public void setup() throws SQLException {
        sqlQueryService = new SqlQueryService();
        connection = mock(Connection.class);
        statement = mock(Statement.class);
        resultSet = mock(ResultSet.class);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeQuery("SELECT * FROM table")).thenReturn(resultSet);
    }

    @Test
    public void testExecuteQuery() throws SQLException {
        when(resultSet.toString()).thenReturn("Result Set");
        String result = sqlQueryService.ExecuteQuery(connection, "SELECT * FROM table");
        assertEquals("Result Set", result);
    }
}