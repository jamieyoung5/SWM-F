/*Country report */
SELECT Code, Name, Continent, Region, Population, Capital FROM country where Name = 'UserInput()';

/*City Report*/
SELECT city.Name, country.Name, city.District, city.Population from city JOIN country on Code = city.CountryCode WHERE city.Name = 'UserInput()';

/*Capital Report*/
SELECT city.Name, country.Name, city.Population from city JOIN country on Code = city.CountryCode WHERE city.Name = 'UserInput()';