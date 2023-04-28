package com.napier.sem.unit_tests;

import com.napier.sem.database.DatabaseConfig;
import com.napier.sem.database.DatabaseConnectionManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class DatabaseConnectionManagerTest {
    
    private DatabaseConfig testConfig;
    private Connection mockConnection;
    private DatabaseConnectionManager subject;
    
    @BeforeEach
    public void setup() throws IOException {
        testConfig = new DatabaseConfig();
        mockConnection = mock(Connection.class);
        subject = new DatabaseConnectionManager(testConfig);
    }
    
    @Test
    void testCreateConnection() throws InterruptedException, SQLException {
        when(mockConnection.isValid(0)).thenReturn(true);
        mockStatic(DriverManager.class);
        when(DriverManager.getConnection(anyString(), anyString(), anyString())).thenReturn(mockConnection);
        
        Connection connection = subject.CreateConnection();
        assertNotNull(connection);
        
    }
    
}
