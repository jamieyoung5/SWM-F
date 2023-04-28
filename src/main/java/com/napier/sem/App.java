package com.napier.sem;
import com.napier.sem.database.*;
import com.napier.sem.display.QueryResultFormatter;
import com.napier.sem.display.ReportDisplayer;
import com.napier.sem.parsers.QueryParser;
import com.napier.sem.parsers.UserInputParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;

public class App {
    
    private static final ReportDisplayer reportDisplayer = new ReportDisplayer();
    private static final QueryResultFormatter queryResultFormatter = new QueryResultFormatter();
    private static final SqlQueryService sqlQueryService = new SqlQueryService(queryResultFormatter);
    private static final UserInputParser userInputParser = new UserInputParser();
    private static final QueryParser queryParser = new QueryParser(userInputParser);
    
    public static void main(String[] args) throws SQLException, IOException, InterruptedException, URISyntaxException {
        DatabaseConfig config = new DatabaseConfig();
        IDatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager(config);
        Connection connection = databaseConnectionManager.CreateConnection();
        IReportCreator reportCreator = new ReportCreator(connection, queryParser, sqlQueryService, reportDisplayer);
        reportCreator.CreateReport();
    }
}