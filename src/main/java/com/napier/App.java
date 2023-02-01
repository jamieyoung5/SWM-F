package com.napier;
import java.io.*;
import java.sql.*;

public class App {
            public static void main(String[] args) throws SQLException {
                        DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager();
                        databaseConnectionManager.CreateConnection();
            }
}