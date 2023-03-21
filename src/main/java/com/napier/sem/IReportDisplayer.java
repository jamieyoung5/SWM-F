package com.napier.sem;

import com.napier.sem.models.ReportQuery;

import java.util.List;

public interface IReportDisplayer {
    void displayReport(List<ReportQuery> report);
}
