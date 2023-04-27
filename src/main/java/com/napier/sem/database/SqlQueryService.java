package com.napier.sem.database;

import com.napier.sem.display.IQueryResultFormatter;

import java.sql.*;

/**
 * Responsible for running SQL queries on a database and parsing the output of those queries
 */
public class SqlQueryService implements ISqlQueryService{
    
    private final IQueryResultFormatter _queryResultFormatter;
    
    public SqlQueryService(IQueryResultFormatter queryResultFormatter){
        _queryResultFormatter = queryResultFormatter;
    }

    @Override
    public String executeQuery(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        try {
            ResultSet resultSet = statement.executeQuery(query);
            return  _queryResultFormatter.parseQueryOutputToString(resultSet);
        }catch (Exception exception){
            return "Couldn't execute query -> " + exception;
        }
    }
}
