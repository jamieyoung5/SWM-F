package com.napier;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IQueryParser {
    public List<Map<String, String>> ParseQueries(String pathToQueries) throws IOException;
}
