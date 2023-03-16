package com.napier.sem;

import java.sql.Connection;

public interface IDatabaseConnectionManager {
    Connection CreateConnection() throws InterruptedException;
}
