package com.napier.sem;

import com.napier.sem.models.ReportQuery;

import java.util.List;

public class ReportDisplayer implements IReportDisplayer {

    @Override
    public void displayReport(List<ReportQuery> report, String reportName) {
        for (ReportQuery queryResult : report) {
            System.out.println("========"+queryResult.getQueryName()+"=======");
            System.out.println(queryResult.getResult());
        }
    }

}
