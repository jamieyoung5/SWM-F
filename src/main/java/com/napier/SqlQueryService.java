package com.napier;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class SqlQueryService implements ISqlQueryService{
    
    private final QueryResultParser QUERY_RESULT_PARSER;
    
    public SqlQueryService(QueryResultParser queryResultParser){
        QUERY_RESULT_PARSER = queryResultParser;
    }
    
    public List<Map<String, Object>> ExecuteQuery(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        
        return QUERY_RESULT_PARSER.ParseQueryResult(resultSet);
    }
    
}
