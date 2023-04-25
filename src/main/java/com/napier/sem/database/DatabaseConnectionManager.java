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
     * Initiates a connection to a database with a variable number of retry attempts
     * @return a connection object which other classes can use to execute sql statements
     * @throws InterruptedException
     */
    @Override
    public Connection CreateConnection() throws InterruptedException {
        wait(5000);
        VerifyDriver();
        Connection connection = EstablishDatabaseConnection();
        
        if (connection == null) {
            throw new RuntimeException("Unable to make a connection to the database");
        }
        
        return connection;
    }

    /**
     * Attempts a certain amount of times to create a connection to a database
     * @return a connection or null if it failed on all attempts
     * @throws InterruptedException
     */
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
     * Attempts a single connection to a database
     * @return a connection if it was successfull and null if it failed
     */
    private Connection ConnectionAttempt() {
        try {
            System.out.println("------");
            System.out.println(config.getDatabasePassword());
            System.out.println(config.getDatabaseUrl());
            System.out.println(config.getDatabaseUsername());
            System.out.println("------");
            return DriverManager.getConnection(config.getDatabaseUrl(), config.getDatabaseUsername(), config.getDatabasePassword());
        } catch (SQLException exception) {
            return null;
        }
    }

    /**
     * Make sure that the correct jdbc dirvers are present
     */
    private void VerifyDriver() {
        try {
            Class.forName(DatabaseConnectionManager.JDBC_SQL_DRIVER);
        } catch (ClassNotFoundException exception) {
            throw new RuntimeException("SQL driver not found");
        }
    }
}
