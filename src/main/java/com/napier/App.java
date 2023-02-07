package com.napier;
import java.io.*;
import java.sql.*;

public class App {
<<<<<<< Updated upstream
    public static void main(String[] args) {

    }
=======
            public static void main(String[] args) throws SQLException {
                        DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager();
                        Connection connection = databaseConnectionManager.CreateConnection();
                        
                        ISqlQueryService sqlQueryService = new SqlQueryService();
                        sqlQueryService.ExecuteQuery(connection, "SELECT * FROM something");
            }
>>>>>>> Stashed changes
}