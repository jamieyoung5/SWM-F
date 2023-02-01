package com.napier;

import java.io.*;
import java.sql.*;

public class DatabaseConnectionManager implements IDatabaseConnectionManager{

            private static final String JDBC_SQL_DRIVER = "com.mysql.cj.jdbc.Driver";

            public DatabaseConnectionManager(){

            }

            public void CreateConnection() throws SQLException {
                        VerifyDriver(JDBC_SQL_DRIVER);
                        String url = "jdbc:mysql://localhost:3306/world";

                        Connection connection = DriverManager.getConnection(url,"root","");
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM city");
                        connection.close();
            }

            private void VerifyDriver(String driverPath){
                        try{
                                    Class.forName(driverPath);
                        } catch (ClassNotFoundException exception){
                                    throw new RuntimeException("SQL driver not found");
                        }
            }

}
