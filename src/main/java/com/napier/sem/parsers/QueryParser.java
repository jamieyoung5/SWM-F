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

public class QueryParser implements IQueryParser {

    private final Map<String, String> userInputs;
    private static final String PATH_TO_REPORT_CONFIG = "/report_configuration.json";

    public QueryParser(IUserInputParser userInputParser) {
        userInputs = userInputParser.parseUserInput(PATH_TO_REPORT_CONFIG);
    }

    @Override
    public List<ReportQuery> ParseQueries(String pathToQueries) throws IOException, URISyntaxException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream fileInputStream = classloader.getResourceAsStream(pathToQueries);
        
        String queryFileContent = new String(fileInputStream.readAllBytes());
        if (queryFileContent.length() != 0){
            List<String> queries = List.of(queryFileContent.split("\n\n"));
            return SplitAllParsedQueries(queries);
        }

        return Collections.emptyList();
    }

    private List<ReportQuery> SplitAllParsedQueries(List<String> queries){
        List<ReportQuery> splitQueries = new ArrayList<>();
        for (String query : queries) {
            ReportQuery mappedQuery = SplitQueryFromName(query);
            splitQueries.add(mappedQuery);
        }

        return splitQueries;
    }

    private ReportQuery SplitQueryFromName(String query){
        String[] splitQuery = query.split("\n", 2);
        String cleanedQueryName = splitQuery[0].substring(2, splitQuery[0].length() - 2);
        String filledQuery = fillQueryInputFields(splitQuery[1]);

        return new ReportQuery(filledQuery, cleanedQueryName);
    }

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
