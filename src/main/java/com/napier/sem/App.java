package com.napier.sem;
import java.io.IOException;
import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException, IOException, InterruptedException {
        System.out.println("test");
        IDatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager();
        Connection connection = databaseConnectionManager.CreateConnection();
        IReportCreator reportCreator = new ReportCreator(connection, new QueryParser(), new SqlQueryService(), new ReportDisplayer());
        reportCreator.CreateReport();
        
    }
}