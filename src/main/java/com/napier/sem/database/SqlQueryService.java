package com.napier.sem.database;

import java.sql.*;

/**
 * Responsible for running SQL queries on a database and parsing the output of those queries
 */
public class SqlQueryService implements ISqlQueryService{
            
    public SqlQueryService(){
        
    }

    @Override
    public String executeQuery(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            String parsedQuery = parseQueryOutputToString(resultSet);

            return parsedQuery;
        }catch (Exception exception){
            return "Couldn't execute query -> " + exception;
        }
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
