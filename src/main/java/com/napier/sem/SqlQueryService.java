package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlQueryService implements ISqlQueryService{
            
    public SqlQueryService(){
        
    }
    
    // Execute a test query via a given connection
    public void ExecuteQuery(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM city");
        
        System.out.println(resultSet.toString());
    }
}
