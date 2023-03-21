package com.napier.sem.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private static final String CONFIG_FILE = "config.properties";
    private final Properties properties;

    /**
     * Configures database parameters, pulling data from a properties file and creating a config object to hold it
     * @throws IOException
     */
    public DatabaseConfig() throws IOException {
        properties = new Properties();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream fileInputStream = classloader.getResourceAsStream(CONFIG_FILE);
        properties.load(fileInputStream);
        fileInputStream.close();
    }

    /**
     * @return Database URL defined in properties file
     */
    public String getDatabaseUrl(){
        return properties.getProperty("db.url");
    }

    /**
     * @return Database password defined in properties file
     */
    public String getDatabasePassword(){
        return properties.getProperty("db.password");
    }

    /**
     * @return Database username defined in properties file
     */
    public String getDatabaseUsername(){
        return properties.getProperty("db.username");
    }

}
