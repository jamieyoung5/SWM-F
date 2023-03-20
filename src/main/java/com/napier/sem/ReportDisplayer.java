package com.napier.sem;

import java.util.List;
import java.util.Map;

public class ReportDisplayer implements IReportDisplayer {

    @Override
    public void displayReport(List<Map<String, String>> reportData, String reportName) {
        System.out.println("========"+reportName+"=======");
        for (Map<String, String> queryResult : reportData) {
            System.out.println(queryResult.get("result"));
        }
    }

}
