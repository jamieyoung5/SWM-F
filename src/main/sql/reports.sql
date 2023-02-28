/*Country report */
SELECT Code, Name, Continent, Region, Population, Capital FROM country where Name = 'UserInput()';

/*City Report*/
SELECT Name, (country union), District, Population from city WHERE Name = 'UserInput()';

/*Capital Report*/
SELECT Name, (country union), Population FROM City WHERE