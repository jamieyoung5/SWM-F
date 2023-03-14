package com.napier.sem;

import java.sql.Connection;
import java.sql.SQLException;

public interface ISqlQueryService {
    void ExecuteQuery(Connection connection) throws SQLException;
}
