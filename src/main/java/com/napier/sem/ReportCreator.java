package com.napier.sem;

import com.napier.sem.database.ISqlQueryService;
import com.napier.sem.models.ReportQuery;
import com.napier.sem.parsers.IQueryParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReportCreator implements IReportCreator {

    private final IQueryParser _queryParser;
    private final ISqlQueryService _sqlQueryService;
    private final IReportDisplayer _reportDisplayer;
    private final Connection _connection;
    
    private final String SQL_PATH = "scripts.sql";

    /**
     * @param connection
     * @param queryParser
     * @param sqlQueryService
     * @param reportDisplayer
     */
    public ReportCreator(Connection connection, IQueryParser queryParser, ISqlQueryService sqlQueryService, IReportDisplayer reportDisplayer) throws SQLException {
        _connection = connection;
        _queryParser = queryParser;
        _sqlQueryService = sqlQueryService;
        _reportDisplayer = reportDisplayer;
    }

    /**
     * @throws IOException
     * @throws SQLException
     * @throws URISyntaxException
     */
    @Override
    public void CreateReport() throws IOException, SQLException, URISyntaxException {
        List<ReportQuery> queryResultQueue = generateReport();
        _reportDisplayer.displayReport(queryResultQueue);
    }

    /**
     * @throws IOException
     * @throws SQLException
     * @throws URISyntaxException
     */
    private List<ReportQuery> generateReport() throws IOException, URISyntaxException, SQLException {
        List<ReportQuery> parsedQueries = _queryParser.ParseQueries(SQL_PATH);
        for(ReportQuery query : parsedQueries) {
            String resultSet = _sqlQueryService.executeQuery(_connection, query.getQuery());
            query.setResult(resultSet.toString());
        }

        return parsedQueries;
    }
}
