package com.napier.sem.integration_tests;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.napier.sem.database.DatabaseConfig;
import com.napier.sem.display.QueryResultFormatter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
//Select city.Name, country.Name AS "Country", city.District, city.Population FROM city JOIN country ON (country.code = city.countrycode) where Region = 'Caribbean' LIMIT {topPopulatedCitiesInRegion};

public class QueryResultFormatterTest {
    private static Connection conn;
    private static QueryResultFormatter subject;
    private static ResultSet resultSet;
    
    @BeforeAll
    public static void setup() throws SQLException, IOException {
        DatabaseConfig databaseConfig = new DatabaseConfig();
        conn = DriverManager.getConnection(databaseConfig.getDatabaseUrl(), databaseConfig.getDatabaseUsername(), databaseConfig.getDatabasePassword());
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = stmt.executeQuery("Select city.Name, country.Name AS \"Country\", city.District, city.Population FROM city JOIN country ON (country.code = city.countrycode) where Region = 'Caribbean' LIMIT 5;");
        subject = new QueryResultFormatter();
    }
    
    @AfterAll
    public static void tearDown() throws SQLException {
        conn.close();
    }
    
    @Test
    public void testFormatQueryOutput() throws SQLException {
        String formattedOutput = subject.parseQueryOutputToString(resultSet);
        String expectedOutput = "Name                  Name                  District              Population            \n" +
              "Willemstad            Netherlands Antilles  Curaçao               2345                  \n" +
              "South Hill            Anguilla              –                     961                   \n" +
              "The Valley            Anguilla              –                     595                   \n" +
              "Saint John´s          Antigua and Barbuda   St John               24000                 \n" +
              "Oranjestad            Aruba                 –                     29034                 \n";
        assertEquals(expectedOutput, formattedOutput);
    }
}