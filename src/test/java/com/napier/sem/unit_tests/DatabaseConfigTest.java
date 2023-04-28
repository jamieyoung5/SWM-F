package com.napier.sem.unit_tests;

import com.napier.sem.database.DatabaseConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConfigTest {
    
    private DatabaseConfig config;
    
    @BeforeEach
    void setUp() throws IOException {
    }
    
    @Test
    public void DataBaseConfigConstructor() throws IOException {
        config = new DatabaseConfig();
        
        assertEquals("url", config.getDatabaseUrl());
        assertEquals("password", config.getDatabasePassword());
        assertEquals("username", config.getDatabaseUsername());
    }
    
    
}