package com.napier.sem.unit_tests;

import com.napier.sem.ReportDisplayer;
import com.napier.sem.models.ReportQuery;
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
        List<ReportQuery> reportData = Collections.singletonList(
              new ReportQuery("query1", "SELECT 1", "1")
        );
        String expectedOutput = "========SELECT 1=======\n" +
              "1\n" +
              "\n" +
              "\n";
    
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    
        ReportDisplayer reportDisplayer = new ReportDisplayer();
    
        // Act
        reportDisplayer.displayReport(reportData);
    
        // Assert
        assertEquals(expectedOutput, outContent.toString());
    }
}