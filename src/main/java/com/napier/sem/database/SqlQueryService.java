package com.napier.sem.database;

import java.sql.*;

public class SqlQueryService implements ISqlQueryService{
            
    public SqlQueryService(){
        
    }


    // Execute a test query via a given connection
    @Override
    public String executeQuery(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        return parseQueryOutputToString(resultSet);
    }



    private String parseQueryOutputToString(ResultSet resultSet) throws SQLException {
        StringBuilder sb = new StringBuilder();

        // Get column names
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            sb.append(resultSet.getMetaData().getColumnName(i)).append("\t");
        }
        sb.append("\n");

        // Iterate through rows
        while (resultSet.next()) {
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                sb.append(String.format("%s\t", resultSet.getString(i)));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
