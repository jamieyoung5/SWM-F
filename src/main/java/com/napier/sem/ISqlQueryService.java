package com.napier.sem;

import java.sql.Connection;
import java.sql.SQLException;

public interface ISqlQueryService {
    String ExecuteQuery(Connection connection, String query) throws SQLException;
}
