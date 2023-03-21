package com.napier.sem.unit_tests;

import com.napier.sem.IReportDisplayer;
import com.napier.sem.ReportCreator;
import com.napier.sem.database.ISqlQueryService;
import com.napier.sem.parsers.IQueryParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ReportCreatorTest {
    
    @Mock
    private Connection connectionMock;
    
    @Mock
    private IQueryParser queryParserMock;
    
    @Mock
    private ISqlQueryService sqlQueryServiceMock;
    
    @Mock
    private IReportDisplayer reportDisplayerMock;
    
    @Mock
    private File fileMock;
    
    private ReportCreator reportCreator;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reportCreator = new ReportCreator(connectionMock, queryParserMock, sqlQueryServiceMock, reportDisplayerMock);
    }
    
    /*@Test
    void createReport_shouldExecuteQueriesAndDisplayResults() throws IOException, SQLException {
        // Arrange
        List<Map<String, String>> parsedQueries = Collections.singletonList(Map.of("queryName", "query1", "query", "SELECT 1"));
        List<Map<String, String>> expectedResults = Collections.singletonList(Map.of("queryName", "query1", "query", "SELECT 1", "result", "1"));
        String filename = "test.sql";
        String path = "/path/to/" + filename;
        
        when(fileMock.getAbsolutePath()).thenReturn(path);
        when(fileMock.getName()).thenReturn(filename);
        when(fileMock.isFile()).thenReturn(true);
        
        when(queryParserMock.ParseQueries(path)).thenReturn(parsedQueries);
        when(sqlQueryServiceMock.ExecuteQuery(any(Connection.class), any(String.class))).thenReturn("1");
        
        // Act
        reportCreator.CreateReport();
        
        // Assert
        assertEquals(expectedResults.get(0).get("result"), parsedQueries.get(0).get("result"));
    }*/
    
    @Test
    void createReport_shouldSkipDirectories() throws IOException, SQLException {
        // Arrange
        File sqlDirectoryMock = new File("/path/to/sql/");
        File[] files = {sqlDirectoryMock};
        
        when(fileMock.isFile()).thenReturn(false);
        when(fileMock.listFiles()).thenReturn(files);
        
        // Act
        reportCreator.CreateReport();
        
        // Assert
        // No exception should be thrown
    }
}
