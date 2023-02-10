SELECT Name, Continent, Population FROM country ORDER BY Population desc;
SELECT Name, Continent, Population FROM country WHERE Continent = 'Europe' ORDER BY Population desc ;
SELECT Name, Region, Population FROM country WHERE Region = 'Caribbean' ORDER BY Population desc;
SELECT Name, Continent, Population FROM country ORDER BY Population desc LIMIT UserInput();
SELECT Name, Continent, Population FROM country WHERE Continent = 'Europe' ORDER BY Population desc LIMIT UserInput();
SELECT Name, Region, Population FROM country WHERE Region = 'Caribbean' ORDER BY Population desc LIMIT UserInput();
SELECT Name, CountryCode, Population from city ORDER BY Population desc;