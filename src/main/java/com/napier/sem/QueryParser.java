package com.napier.sem;

import com.napier.sem.models.ReportQuery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.util.Map.entry;

public class QueryParser implements IQueryParser {

    public QueryParser() {

    }

    @Override
    public List<ReportQuery> ParseQueries(String pathToQueries) throws IOException {
        Path file = Paths.get(pathToQueries);
        String queryFileContent = new String(Files.readAllBytes(file));
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

        return new ReportQuery(splitQuery[1], cleanedQueryName);
    }
}
