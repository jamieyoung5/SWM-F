package com.napier.sem.parsers;

import com.napier.sem.models.ReportQuery;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Takes sql files and parses the contents into a list of objects, which contains information about the query
 * such as its name, the actual query and the result of running the query.
 */
public class QueryParser implements IQueryParser {

    private final Map<String, String> userInputs;
    private static final String PATH_TO_REPORT_CONFIG = "/report_configuration.json";

    public QueryParser(IUserInputParser userInputParser) {
        userInputs = userInputParser.parseUserInput(PATH_TO_REPORT_CONFIG);
    }

    /**
     * Parses queries into an object storing the query, output and the name of the query
     * @param pathToQueries the path to the sql file with all queries
     * @return a parsed query
     * @throws IOException
     * @throws URISyntaxException
     */
    @Override
    public List<ReportQuery> ParseQueries(String pathToQueries) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream fileInputStream = classloader.getResourceAsStream(pathToQueries);
        
        String queryFileContent = new String(fileInputStream.readAllBytes());
        if (queryFileContent.length() != 0){
            List<String> queries = List.of(queryFileContent.split("\n\n"));
            return SplitAllParsedQueries(queries);
        }

        return Collections.emptyList();
    }

    /**
     * Iterates through all queries in a file, and parses each
     * @param queries a list of queries as raw strings
     * @return a list of parsed queries
     */
    private List<ReportQuery> SplitAllParsedQueries(List<String> queries){
        List<ReportQuery> splitQueries = new ArrayList<>();
        for (String query : queries) {
            ReportQuery mappedQuery = SplitQueryFromName(query);
            splitQueries.add(mappedQuery);
        }

        return splitQueries;
    }

    /**
     * Parses a single query into a ReportQuery object
     * @param query the query to be parsed
     * @return a query Parsed into a ReportQuery object
     */
    private ReportQuery SplitQueryFromName(String query){
        String[] splitQuery = query.split("\n", 2);
        String cleanedQueryName = splitQuery[0].replace("\r", "").replace("\n", "");
        cleanedQueryName = cleanedQueryName.substring(2, cleanedQueryName.length() - 2);
        String filledQuery = fillQueryInputFields(splitQuery[1]);

        return new ReportQuery(filledQuery, cleanedQueryName);
    }

    /**
     * Fills in any required user inputs in a particular query
     * @param query the query to be filled
     * @return a query with any user inputs filled
     */
    private String fillQueryInputFields(String query){
        for (String key : userInputs.keySet()) {
            String formattedKey = String.format("{%s}", key);
            if (query.contains(formattedKey) && userInputs.containsKey(key)) {
                query = query.replace(formattedKey, userInputs.get(key));
            }
        }
        return query;
    }
}
