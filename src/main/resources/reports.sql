/*All the countries in the world, organised by largest population to smallest.*/
SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population desc;

/*All the countries in a continent organised by largest population to smallest*/
SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Continent = 'Europe' ORDER BY Population desc ;

/*All the countries in a region organised by largest population to smallest.*/
SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Region = 'Caribbean' ORDER BY Population desc;

/*The top N populated countries in the world where N is provided by the user.*/
SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population desc LIMIT {topPopulatedCountriesInWorld};

/*The top N populated countries in a continent where N is provided by the user.*/
SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Continent = 'Europe' ORDER BY Population desc LIMIT {topPopulatedCountriesInContinent};

/*The top N populated countries in a region where N is provided by the user.*/
SELECT Code, Name, Continent, Region, Population, Capital FROM country WHERE Region = 'Caribbean' ORDER BY Population desc LIMIT {topPopulatedCountriesInRegion};

/*All the cities in the world organised by largest population to smallest*/
SELECT city.Name, country.Name AS "Country", city.District, city.Population FROM city JOIN country ON (country.code = city.countrycode) ORDER BY Population desc;

/*All the cities in a continent organised by largest population to smallest.*/
SELECT city.Name, country.Name AS "Country", city.District, city.Population FROM city JOIN country ON (country.code = city.countrycode) WHERE Continent = 'Europe' ORDER BY Population desc;

/*All the cities in a region organised by largest population to smallest.*/
SELECT city.Name, country.Name AS "Country", city.District, city.Population FROM city JOIN country ON (country.code = city.countrycode) where Region = 'Caribbean' ORDER BY Population desc;

/*All the cities in a country organised by largest population to smallest.*/
SELECT city.Name, country.Name AS "Country", city.District, city.Population FROM city JOIN country ON (country.code = city.countrycode) where country.Name = 'Belgium' ORDER BY Population desc;

/*All the cities in a district organised by largest population to smallest.*/
SELECT city.Name, country.Name AS "Country", city.District, city.Population FROM city JOIN country ON (country.code = city.countrycode) where city.District = 'Toscana' ORDER BY Population desc;

/*The top N populated cities in the world where N is provided by the user.*/
SELECT city.Name, country.Name AS "Country", city.District, city.Population FROM city JOIN country ON (country.code = city.countrycode) LIMIT {topPopulatedCitiesInWorld};

/*The top N populated cities in a continent where N is provided by the user.*/
SELECT city.Name, country.Name AS "Country", city.District, city.Population FROM city JOIN country ON (country.code = city.countrycode) WHERE Continent = 'Europe' LIMIT {topPopulatedCitiesInContinent};

/*The top N populated cities in a region where N is provided by the user.*/
Select city.Name, country.Name AS "Country", city.District, city.Population FROM city JOIN country ON (country.code = city.countrycode) where Region = 'Caribbean' LIMIT {topPopulatedCitiesInRegion};

/*The top N populated cities in a country where N is provided by the user.*/
Select city.Name, country.Name AS "Country", city.District, city.Population FROM city JOIN country ON (country.code = city.countrycode) where country.Name = 'Belgium' LIMIT {topPopulatedCitiesInCountry};

/*The top N populated cities in a district where N is provided by the user.*/
Select city.Name, country.Name AS "Country", city.District, city.Population FROM city JOIN country ON (country.code = city.countrycode) where city.District = 'Toscana' LIMIT {topPopulatedCitiesInDistrict};

/*All the capital cities in the world organised by largest population to smallest.*/
SELECT city.Name, c.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital ORDER BY city.Population desc;

/*All the capital cities in a continent organised by largest population to smallest.*/
SELECT city.Name, c.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Continent = "Europe" ORDER BY city.Population desc;

/*All the capital cities in a region organised by largest to smallest.*/
SELECT city.Name, c.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Region = "Caribbean" ORDER BY city.Population desc;

/*The top N populated capital cities in the world where N is provided by the user.*/
SELECT city.Name, c.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital LIMIT {topPopulatedCapCitiesInWorld};

/*The top N populated capital cities in a continent where N is provided by the user.*/
SELECT city.Name, c.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Continent = "Europe" LIMIT {topPopulatedCitiesInContinent};

/*The top N populated capital cities in a region where N is provided by the user.*/
SELECT city.Name, c.Name, city.Population FROM city JOIN country c on city.CountryCode = c.Code where city.ID = c.Capital AND c.Region = "Caribbean" LIMIT {topPopulatedCapCitiesInRegion};

/*The population of people, people living in cities, and people not living in cities in each continent.*/
SELECT c.Continent,SUM(co.Population) AS 'Total Population',SUM(ci.Population) AS 'Population Living in Cities',SUM(co.Population - ci.Population) AS 'Population Not Living in Cities' FROM country AS co JOIN city AS ci ON co.Code = ci.CountryCode JOIN (SELECT DISTINCT Continent FROM country) AS c ON co.Continent = c.Continent GROUP BY c.Continent;

/*The population of people, people living in cities, and people not living in cities in each region.*/
SELECT c.Region,SUM(c.Population) AS TotalPopulation,SUM(city.Population) AS PopulationInCities,SUM(c.Population) - SUM(city.Population) AS PopulationNotInCities FROM country c LEFT JOIN city ON c.Code = city.CountryCode GROUP BY c.Region;

/*The population of people, people living in cities, and people not living in cities in each country.*/
SELECT c.CountryCode, co.Name AS Country, co.Population AS TotalPopulation, SUM(c.Population) AS PopulationInCities, (co.Population - SUM(c.Population)) AS PopulationNotInCities FROM city c JOIN country co ON c.CountryCode = co.Code GROUP BY c.CountryCode, co.Name, co.Population ORDER BY co.Population DESC;

/*Population of the world*/
SELECT SUM(Population) AS "World Population" FROM country;

/*Population of a Continent*/
SELECT SUM(Population) AS "{populationOfContinent} Population" FROM country WHERE Continent = '{populationOfContinent}';

/*Population of a Region*/
SELECT SUM(Population) AS "{populationOfRegion} Population" FROM country WHERE Region = '{populationOfRegion}';

/*Population of a Country*/
SELECT SUM(Population) AS "{populationOfCountry} Population" FROM country WHERE Name = '{populationOfCountry}';

/*Population of a District*/
SELECT SUM(Population) AS '{populationOfDistrict} population' FROM city WHERE District = "{populationOfDistrict}";

/*Population of a city*/
SELECT SUM(Population) AS '{populationOfCity} population' FROM city WHERE Name = "{populationOfCity}";

/*Languages Report*/
SELECT language.Language, ROUND(SUM(country.Population * (language.Percentage / 100))) AS NumberSpeakers, ROUND((SUM(country.Population * (language.Percentage / 100)) / (SELECT SUM(Population) FROM country)) * 100, 2) AS PercentageWorldPopulation FROM countrylanguage AS language JOIN country ON language.CountryCode = country.Code WHERE language.Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') GROUP BY language.Language ORDER BY NumberSpeakers DESC;

