package com.napier.sem.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private static final String CONFIG_FILE = "config.properties";
    //private final Properties properties;

    /**
     * Loads the projects configuration file into a properties object
     * the configuration file includes database connection details and secrets.
     * @throws IOException
     */
    public DatabaseConfig() throws IOException {
        /*properties = new Properties();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream fileInputStream = classloader.getResourceAsStream(CONFIG_FILE);
        properties.load(fileInputStream);
        fileInputStream.close();*/
    }

    public String getDatabaseUrl(){
        return "jdbc:mysql://localhost:33060/world";
              //properties.getProperty("db.url");
    }

    public String getDatabasePassword(){
        return "example";
              //properties.getProperty("db.password");
    }

    public String getDatabaseUsername(){
        return "root";
              //properties.getProperty("db.username");
    }

}
