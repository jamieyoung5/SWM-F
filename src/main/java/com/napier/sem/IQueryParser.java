package com.napier.sem;

import com.napier.sem.models.ReportQuery;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IQueryParser {
    List<ReportQuery> ParseQueries(String pathToQueries) throws IOException;
}
