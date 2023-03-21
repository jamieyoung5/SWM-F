package com.napier.sem.parsers;

import com.napier.sem.models.ReportQuery;

import java.io.IOException;
import java.util.List;

public interface IQueryParser {
    List<ReportQuery> ParseQueries(String pathToQueries) throws IOException;
}
