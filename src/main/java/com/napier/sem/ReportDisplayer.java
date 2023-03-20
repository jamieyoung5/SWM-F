package com.napier.sem;

import com.napier.sem.models.ReportQuery;

import java.util.List;
import java.util.Map;

public class ReportDisplayer implements IReportDisplayer {

    @Override
    public void displayReport(List<ReportQuery> report, String reportName) {
        System.out.println("========"+reportName+"=======");
        for (ReportQuery queryResult : report) {
            String displayMessage = String.format("%1$s: %2$s", queryResult.getQueryName(), queryResult.getResult());
            System.out.println(displayMessage);
        }
    }

}
