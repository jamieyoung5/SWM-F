/*All the countries in thw world, ordered by x*/
SELECT Name, Continent, Population FROM country ORDER BY Population desc;
SELECT Name, Continent, Population FROM country WHERE Continent = 'Europe' ORDER BY Population desc ;
SELECT Name, Region, Population FROM country WHERE Region = 'Caribbean' ORDER BY Population desc;
SELECT Name, Continent, Population FROM country ORDER BY Population desc LIMIT UserInput();
SELECT Name, Continent, Population FROM country WHERE Continent = 'Europe' ORDER BY Population desc LIMIT UserInput();
SELECT Name, Region, Population FROM country WHERE Region = 'Caribbean' ORDER BY Population desc LIMIT UserInput();

/*All the cities in the world ordered by x*/
SELECT Name, CountryCode, Population from city ORDER BY Population desc;
SELECT Name, Continent, Population FROM city WHERE Continent = 'Europe' ORDER BY Population desc ;

/*Total population*/
SELECT SUM(Population) AS "World Population" FROM country;
SELECT SUM(Population) AS "European Population" FROM country WHERE Continent = 'Europe';
SELECT SUM(Population) AS "Western European Population" FROM country WHERE Region = 'Western Europe';
SELECT Population AS "Dutch Population" FROM country WHERE Name = 'Netherlands';

/*Total pop in and out of cities (THIS IS VERY JANKY AND NEEDS CLEANED UP, JUST POC)*/
SELECT ROUND((SUM(city.Population)/(SELECT country.Population FROM country WHERE country.Name = "Belgium"))*100, 2) AS 'Percentage in Cities' FROM city JOIN country on Code = city.CountryCode WHERE country.Name = "Belgium";
SELECT ROUND((((SELECT country.Population FROM country WHERE country.Name = "Belgium")-(SUM(city.Population)))/(SELECT country.Population FROM country WHERE country.Name = "Belgium"))*100, 2) AS 'Percentage out of Cities' FROM city JOIN country on Code = city.CountryCode WHERE country.Name = "Belgium";
