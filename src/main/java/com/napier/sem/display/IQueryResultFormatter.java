package com.napier.sem.display;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IQueryResultFormatter {
    String parseQueryOutputToString(ResultSet resultSet) throws SQLException;
}
