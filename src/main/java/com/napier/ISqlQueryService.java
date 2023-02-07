package com.napier;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ISqlQueryService {
        List<Map<String, Object>> ExecuteQuery(Connection connection, String query) throws SQLException;
}
