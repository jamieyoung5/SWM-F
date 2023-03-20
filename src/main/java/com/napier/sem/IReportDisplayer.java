package com.napier.sem;

import com.napier.sem.models.ReportQuery;

import java.util.List;
import java.util.Map;

public interface IReportDisplayer {
    void displayReport(List<ReportQuery> report, String reportName);
}
