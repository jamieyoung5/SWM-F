package com.napier.sem.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfig {

    private static final String CONFIG_FILE = "/home/jamie/git/SWM-F/src/main/java/com/napier/sem/config.properties";
    private final Properties properties;

    public DatabaseConfig() throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE);
        properties.load(fileInputStream);
        fileInputStream.close();
    }

    public String getDatabaseUrl(){
        return properties.getProperty("db.url");
    }

    public String getDatabasePassword(){
        return properties.getProperty("db.password");
    }

    public String getDatabaseUsername(){
        return properties.getProperty("db.username");
    }

}
