package com.napier;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface IQueryResultParser {
        List<Map<String, Object>> ParseQueryResult(ResultSet resultSet);
}
