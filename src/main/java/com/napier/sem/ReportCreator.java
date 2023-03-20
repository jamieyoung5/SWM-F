package com.napier.sem;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReportCreator implements IReportCreator {

    private final IQueryParser queryParser;
    private final ISqlQueryService sqlQueryService;
    private final IReportDisplayer reportDisplayer;
    private final Connection _connection;
    
    private final String SQL_PATH = "../../../sql";
    
    public ReportCreator(Connection connection){
        _connection = connection;
        queryParser = new QueryParser();
        sqlQueryService = new SqlQueryService();
        reportDisplayer = new ReportDisplayer();
    }
    
    @Override
    public void CreateReport() throws IOException, SQLException {
        File pathToSqlFiles= new File(SQL_PATH);
        File [] sqlFiles = pathToSqlFiles.listFiles();
        for(int i = 0; i < Objects.requireNonNull(sqlFiles).length; i++){
            if(sqlFiles[i].isFile()){
                List<Map<String, String>> queryResultQueue = RunQueryQueue(sqlFiles[i].getAbsolutePath());
                reportDisplayer.displayReport(queryResultQueue, sqlFiles[i].getName());
            }
        }
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
