package com.napier;

import java.sql.Connection;

public interface IDatabaseConnectionManager {
    Connection CreateConnection();
}
