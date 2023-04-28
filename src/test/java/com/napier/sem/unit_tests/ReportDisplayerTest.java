package com.napier.sem.unit_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import com.napier.sem.display.ReportDisplayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.napier.sem.models.ReportQuery;

class ReportDisplayerTest {
    
    private ReportDisplayer reportDisplayer;
    
    @BeforeEach
    void setUp(){
        reportDisplayer = new ReportDisplayer();
    }
    
    @Test
    void testDisplayReportWithEmptyList() {
        List<ReportQuery> emptyList = new ArrayList<>();
        assertDoesNotThrow(() -> reportDisplayer.displayReport(emptyList));
    }
    
    @Test
    void testDisplayReport() {
        List<ReportQuery> report = new ArrayList<>();
        report.add(new ReportQuery("query1", "result1"));
        assertDoesNotThrow(() -> reportDisplayer.displayReport(report));
    }
    
}
