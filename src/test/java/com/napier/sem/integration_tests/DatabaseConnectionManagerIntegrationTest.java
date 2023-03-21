package com.napier.sem.database;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DatabaseConnectionManagerIntegrationTest {

    private DatabaseConnectionManager dbConnectionManager;

    /*@BeforeAll
    void setup() {
        DatabaseConfig config = new DatabaseConfig();
        config.setDatabaseUrl("jdbc:mysql://localhost:3306/mydatabase");
        config.setDatabaseUsername("root");
        config.setDatabasePassword("password");
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
        DatabaseConnectionManager dbConnectionManager = new DatabaseConnectionManager(config);

        // Act & Assert
        assertThrows(RuntimeException.class, dbConnectionManager::CreateConnection);
    }

    @Test
    void createConnection_shouldRetry_whenDatabaseIsUnavailableAtFirst() throws SQLException, InterruptedException, IOException {
        // Arrange
        DatabaseConfig config = new DatabaseConfig();
        DatabaseConnectionManager dbConnectionManager = new DatabaseConnectionManager(config);

        // Act
        assertThrows(RuntimeException.class, dbConnectionManager::CreateConnection);

        // Assert
        assertEquals(3, ((MockDriver) DriverManager.getDriver("jdbc:mysql://localhost:3306/invalid")).getConnectionAttempts());
    }
*/

}
