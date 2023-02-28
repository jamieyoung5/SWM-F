package com.napier;
import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
        DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager();
        ISqlQueryService sqlQueryService = new SqlQueryService();
    }
}