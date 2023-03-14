package com.napier.sem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ReportCreator implements IReportCreator {

    private final QueryParser queryParser = new QueryParser();
    private final SqlQueryService sqlQueryService = new SqlQueryService();
    private final Connection _connection;

    private final String reportsPath = "../sql/reports.sql";
    private final String scriptsPath = "../sql/scripts.sql";

    public ReportCreator(Connection connection){
        _connection = connection;
    }
        
    @Override
    public void CreateReport() throws IOException, SQLException {
        List<Map<String, String>> reports = RunQueryQueue(reportsPath);
        List<Map<String, String>> scripts = RunQueryQueue(scriptsPath);
    }

    private List<Map<String, String>> RunQueryQueue(String queryPath) throws IOException, SQLException {
        List<Map<String, String>> parsedQueries = queryParser.ParseQueries(queryPath);
        for(Map<String, String> query : parsedQueries) {
            String resultSet = sqlQueryService.ExecuteQuery(_connection, query.get("query"));
            query.put("result", resultSet);
        }

        return parsedQueries;
    }
}
