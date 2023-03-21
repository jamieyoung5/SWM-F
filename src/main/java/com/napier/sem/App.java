package com.napier.sem;
import com.napier.sem.database.DatabaseConfig;
import com.napier.sem.database.DatabaseConnectionManager;
import com.napier.sem.database.IDatabaseConnectionManager;
import com.napier.sem.database.SqlQueryService;
import com.napier.sem.parsers.QueryParser;
import com.napier.sem.parsers.UserInputParser;

import java.io.IOException;
import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException, IOException, InterruptedException {
        /*System.out.println("test");
        DatabaseConfig config = new DatabaseConfig();
        IDatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager(config);
        Connection connection = databaseConnectionManager.CreateConnection();
        IReportCreator reportCreator = new ReportCreator(connection, new QueryParser(), new SqlQueryService(), new ReportDisplayer());
        reportCreator.CreateReport();*/
        UserInputParser userInputParser = new UserInputParser();
        userInputParser.parseUserInput();
    }
}