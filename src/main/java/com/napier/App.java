package com.napier;
import java.sql.*;
public class App {
    public static void main(String[] args) throws SQLException {
        DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager();
        Connection connection = databaseConnectionManager.CreateConnection();
        
        ISqlQueryService sqlQueryService = new SqlQueryService();
        sqlQueryService.ExecuteQuery(connection);
    }
}