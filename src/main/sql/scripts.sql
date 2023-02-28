/*All the countries in the world, ordered by x*/
SELECT Name, Continent, Population FROM country ORDER BY Population desc;
SELECT Name, Continent, Population FROM country WHERE Continent = 'Europe' ORDER BY Population desc ;
SELECT Name, Region, Population FROM country WHERE Region = 'Caribbean' ORDER BY Population desc;
SELECT Name, Continent, Population FROM country ORDER BY Population desc LIMIT UserInput();
SELECT Name, Continent, Population FROM country WHERE Continent = 'Europe' ORDER BY Population desc LIMIT UserInput();
SELECT Name, Region, Population FROM country WHERE Region = 'Caribbean' ORDER BY Population desc LIMIT UserInput();

/*All the cities in the world ordered by x*/
SELECT Name, CountryCode, Population FROM city ORDER BY Population desc;
SELECT Name, Continent, Population FROM city WHERE Continent = 'Europe' ORDER BY Population desc;
SELECT city.Name, city.Population, c.Region FROM city JOIN country c on city.CountryCode = c.Code where Region = 'Caribbean' ORDER BY Population desc;
SELECT city.Name, city.Population, c.Name FROM city JOIN country c on city.CountryCode = c.Code where c.Name = 'Belgium' ORDER BY Population desc;
SELECT city.Name, city.Population, city.District FROM city where city.District = 'Toscana' ORDER BY Population desc;

/*N cities in the world where N is provided by user*/
SELECT Name, CountryCode, Population FROM city LIMIT UserInput();
SELECT Name, Continent, Population FROM city WHERE Continent = 'Europe' UserInput();
Select city.Name, city.Population, c.Region FROM city JOIN country c on city.CountryCode = c.Code where Region = 'Caribbean' UserInput();
Select city.Name, city.Population, c.Name FROM city JOIN country c on city.CountryCode = c.Code where c.Name = 'Belgium' UserInput();
Select city.Name, city.Population, city.District FROM city where city.District = 'Toscana' UserInput();

/*Capital cities ordered by x*/
SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital ORDER BY city.Population desc;
SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Continent = "Europe" ORDER BY city.Population desc;
SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Region = "Caribbean" ORDER BY city.Population desc;

/*N Capital cities where N is provided by user*/
SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital LIMIT UserInput();
SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Continent = "Europe" LIMIT UserInput();
SELECT c.Name, city.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Region = "Caribbean" LIMIT UserInput();

/*Total population*/
SELECT SUM(Population) AS "World Population" FROM country;
SELECT SUM(Population) AS "European Population" FROM country WHERE Continent = 'Europe';
SELECT SUM(Population) AS "Western European Population" FROM country WHERE Region = 'Western Europe';
SELECT Population AS "Dutch Population" FROM country WHERE Name = 'Netherlands';

/*Total pop in and out of cities (THIS IS VERY JANKY AND NEEDS CLEANED UP, JUST POC)*/
SELECT ROUND((SUM(city.Population)/(SELECT country.Population FROM country WHERE country.Name = "Belgium"))*100, 2) AS 'Percentage in Cities' FROM city JOIN country on Code = city.CountryCode WHERE country.Name = "Belgium";
SELECT ROUND((((SELECT country.Population FROM country WHERE country.Name = "Belgium")  -(SUM(city.Population)))/(SELECT country.Population FROM country WHERE country.Name = "Belgium"))*100, 2) AS 'Percentage out of Cities' FROM city JOIN country on Code = city.CountryCode WHERE country.Name = "Belgium";
