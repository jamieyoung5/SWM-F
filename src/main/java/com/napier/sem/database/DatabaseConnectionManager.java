package com.napier.sem.database;

import java.io.Console;
import java.sql.*;

public class DatabaseConnectionManager implements IDatabaseConnectionManager {

    private final DatabaseConfig config;
    private static final String JDBC_SQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final int MAX_CONNECTION_ATTEMPTS = 3;
    
    public DatabaseConnectionManager(DatabaseConfig config) {
        this.config = config;
    }

    /**
    @Override
    public Connection CreateConnection() throws InterruptedException {
        VerifyDriver();
        Connection connection = EstablishDatabaseConnection();
                
        if (connection == null) {
            throw new RuntimeException("Unable to make a connection to the database");
        }
                
        return connection;
    }

    /**
    private Connection EstablishDatabaseConnection() throws InterruptedException {
        int connectionAttempts = 0;
        Connection connection;
        do {
            Thread.sleep(5000);
            connection = ConnectionAttempt();
            connectionAttempts++;
        } while (connectionAttempts < MAX_CONNECTION_ATTEMPTS && connection != null);
                
        return connection;
    }

    /**
    private Connection ConnectionAttempt() {
        try {
            return DriverManager.getConnection(config.getDatabaseUrl(), config.getDatabaseUsername(), config.getDatabasePassword());
        } catch (SQLException exception) {
            return null;
        }     
    }

    /**
    private void VerifyDriver() {
        try {
            Class.forName(DatabaseConnectionManager.JDBC_SQL_DRIVER);
        } catch (ClassNotFoundException exception) {
            throw new RuntimeException("SQL driver not found");
        }
    }      
}
