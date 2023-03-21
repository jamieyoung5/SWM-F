package com.napier.sem;

import com.napier.sem.database.ISqlQueryService;
import com.napier.sem.models.ReportQuery;
import com.napier.sem.parsers.IQueryParser;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
 
public class ReportCreator implements IReportCreator {

    private final IQueryParser _queryParser;
    private final ISqlQueryService _sqlQueryService;
    private final IReportDisplayer _reportDisplayer;
    private final Connection _connection;
    
    private final String SQL_PATH = "/home/jamie/git/SWM-F/src/main/sql";
    
    public ReportCreator(Connection connection, IQueryParser queryParser, ISqlQueryService sqlQueryService, IReportDisplayer reportDisplayer){
        _connection = connection;
        _queryParser = queryParser;
        _sqlQueryService = sqlQueryService;
        _reportDisplayer = reportDisplayer;
    }
    
    @Override
    public void CreateReport() throws IOException, SQLException {
        File pathToSqlFiles= new File(SQL_PATH);
        File [] sqlFiles = pathToSqlFiles.listFiles();
        for(int i = 0; i < Objects.requireNonNull(sqlFiles).length; i++){
            if(sqlFiles[i].isFile()){
                List<ReportQuery> queryResultQueue = RunQueryQueue(sqlFiles[i].getAbsolutePath());
                _reportDisplayer.displayReport(queryResultQueue, sqlFiles[i].getName());
            }
        }
    }
    
    private List<ReportQuery> RunQueryQueue(String queryPath) throws IOException, SQLException {
        List<ReportQuery> parsedQueries = _queryParser.ParseQueries(queryPath);
        for(ReportQuery query : parsedQueries) {
            String resultSet = _sqlQueryService.executeQuery(_connection, query.getQuery());
            query.setResult(resultSet.toString());
        }

        return parsedQueries;
    }
}
