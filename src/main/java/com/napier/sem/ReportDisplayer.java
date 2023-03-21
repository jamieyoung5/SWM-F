package com.napier.sem;

import com.napier.sem.models.ReportQuery;

import java.util.List;

public class ReportDisplayer implements IReportDisplayer {

    /**
     * Displays the report content to the console
     * @param report the generated report
     */
    @Override
    public void displayReport(List<ReportQuery> report) {
        for (ReportQuery queryResult : report) {
            System.out.println("========"+queryResult.getQueryName()+"=======");
            System.out.println(queryResult.getResult());
            System.out.println("\n");
        }
    }

}
