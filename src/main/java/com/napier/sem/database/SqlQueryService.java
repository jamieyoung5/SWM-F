package com.napier.sem.database;

import java.sql.*;

public class SqlQueryService implements ISqlQueryService{
            
    public SqlQueryService(){
        
    }

    /**
     *
     * @param connection Connection object gained from the DatabaseConnectionManager
     * @param query the query to be executed
     * @return The querys output as a string or a message if it was not able to execute
     * @throws SQLException
     */
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
