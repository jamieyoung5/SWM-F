package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlQueryService implements ISqlQueryService{
            
    public SqlQueryService(){
        
    }


    // Execute a test query via a given connection
    @Override
    public String ExecuteQuery(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        
        return resultSet.toString();
    }
}
