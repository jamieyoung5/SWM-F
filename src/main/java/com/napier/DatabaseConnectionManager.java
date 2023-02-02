package com.napier;

import java.io.Console;
import java.sql.*;

public class DatabaseConnectionManager implements IDatabaseConnectionManager{

            private static final String JDBC_SQL_DRIVER = "com.mysql.cj.jdbc.Driver";
            private static final String DATABASE_USER = "root"; //TO-DO: put this in a config
            private static final String DATABASE_PASS = "my-secret-pw"; //TO-DO: put this in a config
            private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/world"; //TO-DO: put this somewhere else as well
            private static final int MAX_CONNECTION_ATTEMPTS = 3;


            public DatabaseConnectionManager(){

            }

            public void ExecuteQuery(Connection connection) throws SQLException {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM city");
                System.out.println(resultSet.toString());
            }

            public Connection CreateConnection() {
                        VerifyDriver();
                        String url = "jdbc:mysql://localhost:3306/world";

                        for(int connectionAttempts = 0; connectionAttempts < MAX_CONNECTION_ATTEMPTS; connectionAttempts++){
                            ConnectionAttempt();
                        }

                        return connection;
            }

            private boolean ConnectionAttempt(){
                try{
                    Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER,DATABASE_PASS);
                    return true;
                }catch (SQLException exception){
                    return false;
                }

            }

            private void VerifyDriver(){
                        try{
                                    Class.forName(DatabaseConnectionManager.JDBC_SQL_DRIVER);
                        } catch (ClassNotFoundException exception){
                                    throw new RuntimeException("SQL driver not found");
                        }
            }

}
