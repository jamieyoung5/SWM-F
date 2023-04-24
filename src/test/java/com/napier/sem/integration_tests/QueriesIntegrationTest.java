package com.napier.sem.integration_tests;

import com.napier.sem.database.DatabaseConfig;
import com.napier.sem.database.DatabaseConnectionManager;
import com.napier.sem.database.SqlQueryService;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QueriesIntegrationTest {
    
    private DatabaseConnectionManager dbConnectionManager;
    private SqlQueryService sqlQueryService;
    private Connection connection;
    @BeforeAll
    void setup() throws IOException, InterruptedException {
        DatabaseConfig config = new DatabaseConfig();
        config.setDatabaseUrl("jdbc:mysql://localhost:33060/world");
        config.setDatabaseUsername("root");
        config.setDatabasePassword("example");
        dbConnectionManager = new DatabaseConnectionManager(config);
        sqlQueryService = new SqlQueryService();
        connection = dbConnectionManager.CreateConnection();
    }
    
    @ParameterizedTest
    @MethodSource("testCases")
    void createConnection_shouldReturnConnection_whenDatabaseIsAvailable(String input) throws SQLException {
        String output = sqlQueryService.executeQuery(connection, input);
        assertNotNull(output);
        assertTrue(output.length() > 0);
    }
    
    private static Collection<Object[]> testCases() {
        return Arrays.asList(new Object[][] {
              { "SELECT Name, Continent, Population FROM country ORDER BY Population desc;"},
              { "SELECT Name, Continent, Population FROM country WHERE Continent = 'Europe' ORDER BY Population desc ;"},
              { "SELECT Name, Region, Population FROM country WHERE Region = 'Caribbean' ORDER BY Population desc;"},
              { "SELECT Name, Continent, Population FROM country ORDER BY Population desc LIMIT {topPopulatedCountriesInWorld};"},
              {"SELECT Name, Continent, Population FROM country WHERE Continent = 'Europe' ORDER BY Population desc LIMIT {topPopulatedCountriesInContinent};"},
              {"SELECT Name, Region, Population FROM country WHERE Region = 'Caribbean' ORDER BY Population desc LIMIT {topPopulatedCountriesInRegion};"},
              {"SELECT Name, CountryCode, Population FROM city ORDER BY Population desc;"},
              {"SELECT Name, Continent, Population FROM city WHERE Continent = 'Europe' ORDER BY Population desc;"},
              {"SELECT city.Name, city.Population, c.Region FROM city JOIN country c on city.CountryCode = c.Code where Region = 'Caribbean' ORDER BY Population desc;"},
              {"SELECT city.Name, city.Population, c.Name FROM city JOIN country c on city.CountryCode = c.Code where c.Name = 'Belgium' ORDER BY Population desc;"},
              {"SELECT city.Name, city.Population, city.District FROM city where city.District = 'Toscana' ORDER BY Population desc;"},
              {"SELECT Name, CountryCode, Population FROM city LIMIT {topPopulatedCitiesInWorld};"},
              {"SELECT Name, Continent, Population FROM city WHERE Continent = 'Europe' {topPopulatedCitiesInContinent};"},
              {"Select city.Name, city.Population, c.Region FROM city JOIN country c on city.CountryCode = c.Code where Region = 'Caribbean' {topPopulatedCitiesInRegion};"},
              {"Select city.Name, city.Population, c.Name FROM city JOIN country c on city.CountryCode = c.Code where c.Name = 'Belgium' {topPopulatedCitiesInCountry};"},
              {"Select city.Name, city.Population, city.District FROM city where city.District = 'Toscana' {topPopulatedCitiesInDistrict};"},
              {"SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital ORDER BY city.Population desc;"},
              {"SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Continent = \"Europe\" ORDER BY city.Population desc;"},
              {"SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Region = \"Caribbean\" ORDER BY city.Population desc;"},
              {"SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital LIMIT {topPopulatedCapCitiesInWorld};"},
              {"SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Continent = \"Europe\" LIMIT {topPopulatedCitiesInContinent};"},
              {"SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Region = \"Caribbean\" LIMIT {topPopulatedCapCitiesInRegion};"},
              {"SELECT SUM(Population) AS \"World Population\" FROM country;"},
              {"SELECT SUM(Population) AS \"European Population\" FROM country WHERE Continent = 'Europe';"},
              {"SELECT SUM(Population) AS \"Western European Population\" FROM country WHERE Region = 'Western Europe';"},
              {"SELECT Population AS \"Dutch Population\" FROM country WHERE Name = 'Netherlands';"},
              {"SELECT ROUND((SUM(city.Population)/(SELECT country.Population FROM country WHERE country.Name = \"Belgium\"))*100, 2) AS 'Percentage in Cities' FROM city JOIN country on Code = city.CountryCode WHERE country.Name = \"Belgium\";"},
              {"SELECT ROUND((((SELECT country.Population FROM country WHERE country.Name = \"Belgium\")  -(SUM(city.Population)))/(SELECT country.Population FROM country WHERE country.Name = \"Belgium\"))*100, 2) AS 'Percentage out of Cities' FROM city JOIN country on Code = city.CountryCode WHERE country.Name = \"Belgium\";"}
        });
    }
    
}
