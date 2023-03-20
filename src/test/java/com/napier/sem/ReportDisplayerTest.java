package com.napier.sem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class ReportDisplayerTest {
    
    @Test
    void displayReport() {
        // Arrange
        List<Map<String, String>> reportData = Collections.singletonList(
              Map.of("queryName", "query1", "query", "SELECT 1", "result", "1")
        );
        String reportName = "testReport";
        String expectedOutput = "========testReport=======\n1\n";
    
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    
        ReportDisplayer reportDisplayer = new ReportDisplayer();
    
        // Act
        reportDisplayer.displayReport(reportData, reportName);
    
        // Assert
        assertEquals(expectedOutput, outContent.toString());
    }
}