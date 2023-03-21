package com.napier.sem;

import com.napier.sem.database.ISqlQueryService;
import com.napier.sem.models.ReportQuery;
import com.napier.sem.parsers.IQueryParser;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
 
public class ReportCreator implements IReportCreator {

    private final IQueryParser _queryParser;
    private final ISqlQueryService _sqlQueryService;
    private final IReportDisplayer _reportDisplayer;
    private final Connection _connection;
    
    private final String SQL_PATH = "scripts.sql";
    
    public ReportCreator(Connection connection, IQueryParser queryParser, ISqlQueryService sqlQueryService, IReportDisplayer reportDisplayer){
        _connection = connection;
        _queryParser = queryParser;
        _sqlQueryService = sqlQueryService;
        _reportDisplayer = reportDisplayer;
    }
    
    @Override
    public void CreateReport() throws IOException, SQLException, URISyntaxException {
        List<ReportQuery> queryResultQueue = RunReportQueries();
        _reportDisplayer.displayReport(queryResultQueue);
    }
    
    private List<ReportQuery> RunReportQueries() throws IOException, SQLException, URISyntaxException {
        List<ReportQuery> parsedQueries = _queryParser.ParseQueries(SQL_PATH);
        for(ReportQuery query : parsedQueries) {
            String resultSet = _sqlQueryService.executeQuery(_connection, query.getQuery());
            query.setResult(resultSet.toString());
        }

        return parsedQueries;
    }
}
