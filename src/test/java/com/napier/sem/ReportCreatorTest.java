import com.napier.sem.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ReportCreatorTest {

    @Mock
    private Connection connectionMock;

    private IReportCreator reportCreator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reportCreator = new ReportCreator(connectionMock);
    }

    @Test
    void createReport_shouldExecuteQueriesAndDisplayResults() throws IOException, SQLException {
        // Arrange
        List<Map<String, String>> parsedQueries = Collections.singletonList(Map.of("queryName", "query1", "query", "SELECT 1"));
        List<Map<String, String>> expectedResults = Collections.singletonList(Map.of("queryName", "query1", "query", "SELECT 1", "result", "1"));
        String filename = "test.sql";
        String path = "/path/to/" + filename;

        File sqlFileMock = new File(path);

        when(sqlFileMock.getAbsolutePath()).thenReturn(path);
        when(sqlFileMock.getName()).thenReturn(filename);
        when(sqlFileMock.isFile()).thenReturn(true);

        when(queryParserMock.ParseQueries(path)).thenReturn(parsedQueries);
        when(sqlQueryServiceMock.ExecuteQuery(any(Connection.class), any(String.class))).thenReturn("1");

        // Act
        reportCreator.CreateReport();

        // Assert
        assertEquals(expectedResults.get(0).get("result"), parsedQueries.get(0).get("result"));
    }

    @Test
    void createReport_shouldSkipDirectories() throws IOException, SQLException {
        // Arrange
        File sqlDirectoryMock = new File("/path/to/sql/");
        File[] files = {sqlDirectoryMock};

        when(sqlDirectoryMock.isFile()).thenReturn(false);
        when(sqlDirectoryMock.listFiles()).thenReturn(files);

        // Act
        reportCreator.CreateReport();

        // Assert
        // No exception should be thrown
    }
}
