package com.napier.sem;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

public interface IReportCreator {
    void CreateReport() throws IOException, SQLException, URISyntaxException;
}
