package com.napier.sem.database;

import java.sql.Connection;

public interface IDatabaseConnectionManager {
    Connection CreateConnection() throws InterruptedException;
}
