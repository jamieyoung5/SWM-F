package com.napier.sem;

import java.util.List;
import java.util.Map;

public interface IReportDisplayer {
    void displayReport(List<Map<String, String>> report, String reportName);
}
