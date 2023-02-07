package com.napier;

import java.sql.*;

public class DatabaseConnectionManager implements IDatabaseConnectionManager {
        
        private static final String JDBC_SQL_DRIVER = "com.mysql.cj.jdbc.Driver";
        private static final int MAX_CONNECTION_ATTEMPTS = 3;
        
        public DatabaseConnectionManager() {
        
        }
            
        @Override
        public Connection CreateConnection() {
                VerifyDriver();
                Connection connection = EstablishDatabaseConnection();
                        
                if (connection == null) {
                        throw new RuntimeException("Unable to make a connection to the database");
                }
                        
                return connection;
        }
            
        private Connection EstablishDatabaseConnection(){
                int connectionAttempts = 0;
                Connection connection;
                do {
                        connection = ConnectionAttempt();
                        connectionAttempts++;
                } while (connectionAttempts < MAX_CONNECTION_ATTEMPTS && connection != null);
                        
                return connection;
        }
            
        private Connection ConnectionAttempt() {
                try {
                        return DriverManager.getConnection(Config.DATABASE_URL, Config.DATABASE_USER, Config.DATABASE_PASS);
                } catch (SQLException exception) {
                        return null;
                }
                        
        }
            
        private void VerifyDriver() {
                try {
                        Class.forName(DatabaseConnectionManager.JDBC_SQL_DRIVER);
                } catch (ClassNotFoundException exception) {
                        throw new RuntimeException("SQL driver not found");
                }
        }
            
}
