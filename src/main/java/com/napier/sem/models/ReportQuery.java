package com.napier.sem.models;

public class ReportQuery {
    private final String query;
    private final String queryName;
    private String result;
    
    public ReportQuery(String query, String queryName) {
        this.query = query;
        this.queryName = queryName;
    }
    
    public String getQuery() {
        return query;
    }
    
    public String getQueryName() {
        return queryName;
    }
    
    public String getResult() {
        return result;
    }
    
    public void setResult(String result) {
        this.result = result;
    }
}
