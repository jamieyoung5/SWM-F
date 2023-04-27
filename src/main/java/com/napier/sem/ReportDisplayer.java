package com.napier.sem;

import com.napier.sem.models.ReportQuery;

import java.util.List;

/**
 * Takes a list of query objects and prints each of them to the console in a readable format
 */
public class ReportDisplayer implements IReportDisplayer {
    
    @Override
    public void displayReport(List<ReportQuery> report) {
        for (ReportQuery queryResult : report) {
            System.out.println("========"+queryResult.getQueryName()+"=======");
            System.out.println(queryResult.getResult());
            System.out.println("\n");
        }
    }

}
