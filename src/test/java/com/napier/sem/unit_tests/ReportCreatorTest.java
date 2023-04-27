package com.napier.sem.unit_tests;

import com.napier.sem.IReportDisplayer;
import com.napier.sem.ReportCreator;
import com.napier.sem.database.ISqlQueryService;
import com.napier.sem.models.ReportQuery;
import com.napier.sem.parsers.IQueryParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ReportCreatorTest {

    private IQueryParser queryParser;
    private ISqlQueryService sqlQueryService;
    private IReportDisplayer reportDisplayer;
    private Connection connection;
    private ReportCreator reportCreator;

    @BeforeEach
    public void setUp() throws SQLException {
        queryParser = mock(IQueryParser.class);
        sqlQueryService = mock(ISqlQueryService.class);
        reportDisplayer = mock(IReportDisplayer.class);
        connection = mock(Connection.class);

        reportCreator = new ReportCreator(connection, queryParser, sqlQueryService, reportDisplayer);
    }

    @Test
    public void testCreateReport() throws IOException, SQLException, URISyntaxException {
        List<ReportQuery> queryResultQueue = new ArrayList<>();
        ReportQuery query1 = new ReportQuery("SELECT * FROM table1", "query1");
        queryResultQueue.add(query1);
        ReportQuery query2 = new ReportQuery("SELECT * FROM table2", "query2");
        queryResultQueue.add(query2);

        when(queryParser.ParseQueries("reports.sql")).thenReturn(queryResultQueue);

        when(sqlQueryService.executeQuery(connection, query1.getQuery()))
              .thenReturn("result1");

        when(sqlQueryService.executeQuery(connection, query2.getQuery()))
              .thenReturn("result2");

        reportCreator.CreateReport();

        verify(queryParser).ParseQueries("reports.sql");

        verify(sqlQueryService).executeQuery(connection, query1.getQuery());
        verify(sqlQueryService).executeQuery(connection, query2.getQuery());

        verify(reportDisplayer).displayReport(queryResultQueue);
    }
}
