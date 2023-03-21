package com.napier.sem.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface ISqlQueryService {
    String executeQuery(Connection connection, String query) throws SQLException;
}
