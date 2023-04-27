package com.napier.sem.integration_tests;

import com.napier.sem.database.DatabaseConfig;
import com.napier.sem.database.DatabaseConnectionManager;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DatabaseConnectionManagerTest {

    private DatabaseConnectionManager dbConnectionManager;

    @BeforeAll
    void setup() throws IOException {
        DatabaseConfig config = new DatabaseConfig();
        dbConnectionManager = new DatabaseConnectionManager(config);
    }

    @Test
    void createConnection_shouldReturnConnection_whenDatabaseIsAvailable() throws InterruptedException, SQLException {
        // Arrange

        // Act
        Connection connection = dbConnectionManager.CreateConnection();

        // Assert
        assertNotNull(connection);
        assertFalse(connection.isClosed());
    }

    @Test
    void createConnection_shouldThrowException_whenDatabaseIsUnavailable() throws SQLException, IOException {
        // Arrange
        DatabaseConfig config = new DatabaseConfig();
        config.setDatabaseUrl("test");
        DatabaseConnectionManager dbConnectionManager = new DatabaseConnectionManager(config);

        // Act & Assert
        assertThrows(RuntimeException.class, dbConnectionManager::CreateConnection);
    }
    
}
