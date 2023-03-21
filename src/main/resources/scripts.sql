/*All the countries in the world, organised by largest population to smallest.x*/
SELECT Name, Continent, Population FROM country ORDER BY Population desc;

/*All the countries in a continent organised by largest population to smallest*/
SELECT Name, Continent, Population FROM country WHERE Continent = 'Europe' ORDER BY Population desc ;

/*All the countries in a region organised by largest population to smallest.*/
SELECT Name, Region, Population FROM country WHERE Region = 'Caribbean' ORDER BY Population desc;

/*The top N populated countries in the world where N is provided by the user.*/
SELECT Name, Continent, Population FROM country ORDER BY Population desc LIMIT {topPopulatedCountriesInWorld};

/*The top N populated countries in a continent where N is provided by the user.*/
SELECT Name, Continent, Population FROM country WHERE Continent = 'Europe' ORDER BY Population desc LIMIT {topPopulatedCountriesInContinent};

/*The top N populated countries in a region where N is provided by the user.*/
SELECT Name, Region, Population FROM country WHERE Region = 'Caribbean' ORDER BY Population desc LIMIT {topPopulatedCountriesInRegion};

/*All the cities in the world organised by largest population to smallest*/
SELECT Name, CountryCode, Population FROM city ORDER BY Population desc;

/*All the cities in a continent organised by largest population to smallest.*/
SELECT Name, Continent, Population FROM city WHERE Continent = 'Europe' ORDER BY Population desc;

/*All the cities in a region organised by largest population to smallest.*/
SELECT city.Name, city.Population, c.Region FROM city JOIN country c on city.CountryCode = c.Code where Region = 'Caribbean' ORDER BY Population desc;

/*All the cities in a country organised by largest population to smallest.*/
SELECT city.Name, city.Population, c.Name FROM city JOIN country c on city.CountryCode = c.Code where c.Name = 'Belgium' ORDER BY Population desc;

/*All the cities in a district organised by largest population to smallest.*/
SELECT city.Name, city.Population, city.District FROM city where city.District = 'Toscana' ORDER BY Population desc;

/*The top N populated cities in the world where N is provided by the user.*/
SELECT Name, CountryCode, Population FROM city LIMIT {topPopulatedCitiesInWorld};

/*The top N populated cities in a continent where N is provided by the user.*/
SELECT Name, Continent, Population FROM city WHERE Continent = 'Europe' {topPopulatedCitiesInContinent};

/*The top N populated cities in a region where N is provided by the user.*/
Select city.Name, city.Population, c.Region FROM city JOIN country c on city.CountryCode = c.Code where Region = 'Caribbean' {topPopulatedCitiesInRegion};

/*The top N populated cities in a country where N is provided by the user.*/
Select city.Name, city.Population, c.Name FROM city JOIN country c on city.CountryCode = c.Code where c.Name = 'Belgium' {topPopulatedCitiesInCountry};

/*The top N populated cities in a district where N is provided by the user.*/
Select city.Name, city.Population, city.District FROM city where city.District = 'Toscana' {topPopulatedCitiesInDistrict};

/*All the capital cities in the world organised by largest population to smallest.*/
SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital ORDER BY city.Population desc;

/*All the capital cities in a continent organised by largest population to smallest.*/
SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Continent = "Europe" ORDER BY city.Population desc;

/*All the capital cities in a region organised by largest to smallest.*/
SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Region = "Caribbean" ORDER BY city.Population desc;

/*The top N populated capital cities in the world where N is provided by the user.*/
SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital LIMIT {topPopulatedCapCitiesInWorld};

/*The top N populated capital cities in a continent where N is provided by the user.*/
SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Continent = "Europe" LIMIT {topPopulatedCitiesInContinent};

/*The top N populated capital cities in a region where N is provided by the user.*/
SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Region = "Caribbean" LIMIT {topPopulatedCapCitiesInRegion};

/*Population of the world*/
SELECT SUM(Population) AS "World Population" FROM country;

/*Population of a Continent*/
SELECT SUM(Population) AS "European Population" FROM country WHERE Continent = 'Europe';

/*Population of a Region*/
SELECT SUM(Population) AS "Western European Population" FROM country WHERE Region = 'Western Europe';

/*Population of a Country*/
SELECT Population AS "Dutch Population" FROM country WHERE Name = 'Netherlands';

/*Total pop in and out of cities (THIS IS VERY JANKY AND NEEDS CLEANED UP, JUST POC)*/
SELECT ROUND((SUM(city.Population)/(SELECT country.Population FROM country WHERE country.Name = "Belgium"))*100, 2) AS 'Percentage in Cities' FROM city JOIN country on Code = city.CountryCode WHERE country.Name = "Belgium";

/*Total pop in and out of cities (THIS IS VERY JANKY AND NEEDS CLEANED UP, JUST POC)*/
SELECT ROUND((((SELECT country.Population FROM country WHERE country.Name = "Belgium")  -(SUM(city.Population)))/(SELECT country.Population FROM country WHERE country.Name = "Belgium"))*100, 2) AS 'Percentage out of Cities' FROM city JOIN country on Code = city.CountryCode WHERE country.Name = "Belgium";