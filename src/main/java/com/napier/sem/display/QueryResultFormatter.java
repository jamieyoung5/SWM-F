package com.napier.sem.display;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Takes a ResultSet (output from a query) and formats it into a readable string that can be printed.
 * Will only work with ResultSets are are Type-Scroll-Sensitive.
 */
public class QueryResultFormatter implements IQueryResultFormatter {
    
    private static final int MAX_LENGTH = 6;
    
    /**
     * Gets information about the ResultSet and orchestrates class methods to create
     * a formatted string of the ResultSet contents
     * @param resultSet The ResultSet to format
     * @return a string containing the contents of the ResultSet, formatted.
     */
    public String parseQueryOutputToString(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        
        int maxFieldLength = getMaxFieldLength(resultSet, columnCount, metaData);
        String headerRow = buildHeaderRow(maxFieldLength, columnCount, metaData);
        resultSet.beforeFirst();
        String dataRows = buildDataRows(maxFieldLength, columnCount, resultSet);
        
        return headerRow + "\n" + dataRows;
    }
    
    /**
     * Iterates through everything in a ResultSet and finds the biggest field
     * @param resultSet The ResultSet to be iterated through
     * @param columnCount The amount of columns in the ResultSet
     * @param resultSetMetadata The metadata of the ResultSet
     * @return the size in characters of the longest field in a ResultSet
     */
    private int getMaxFieldLength(ResultSet resultSet, int columnCount, ResultSetMetaData resultSetMetadata) throws SQLException {
        int maxLength = MAX_LENGTH;
        while (resultSet.next()) {
            for(int i = 1; i <= columnCount; i++) {
                String currentResult = resultSet.getString(i);
                if (currentResult != null) {
                    if (currentResult.length() > maxLength) {
                        maxLength = currentResult.length();
                    }
                    if (resultSetMetadata.getColumnName(i).length() > maxLength) {
                        maxLength = resultSetMetadata.getColumnName(i).length();
                    }
                }
                
            }
        }
        
        return maxLength;
    }
    
    /**
     * Builds all the headers from a ResultSet into an organised row, where everything is evenly spaces
     * @param maxLength the size of the largest field in the ResultSet
     * @param columnCount The amount of columns in the ResultSet
     * @param resultSetMetaData The Metadata of the ResultSet
     * @return the string containing the formatted headers
     */
    private String buildHeaderRow(int maxLength, int columnCount, ResultSetMetaData resultSetMetaData) throws SQLException {
        StringBuilder headerBuilder = new StringBuilder();
        
        for (int i = 1; i <= columnCount; i++) {
            headerBuilder.append(String.format("%-"+ (maxLength + 2) +"s", resultSetMetaData.getColumnName(i)));
        }
        return headerBuilder.toString();
    }
    
    /**
     * Builds all the rows of data from the result set, evenly spacing them out
     * @param maxLength the size of the largest field in the ResultSet
     * @param columnCount The amount of columns in the ResultSet
     * @param resultSet the ResultSet
     * @return the string containing the formatted data
     */
    private String buildDataRows(int maxLength, int columnCount, ResultSet resultSet) throws SQLException {
        StringBuilder dataBuilder = new StringBuilder();
        
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                dataBuilder.append(String.format("%-"+ (maxLength + 2) +"s", resultSet.getString(i)));
            }
            dataBuilder.append("\n");
        }
        
        
        return dataBuilder.toString();
    }
}
