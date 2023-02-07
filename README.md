# SWM-F

A program that builds reports based on data stored in a database

## Programming standards

This project follows the Oracle coding conventions, which you can find here 
https://www.oracle.com/java/technologies/javase/codeconventions-contents.html

## How to build

## Specification

### The organisation has asked for the following reports to be generated 

<ol>
<li>All the countries in the world organised by largest population to smallest. </li>
<li>All the countries in a continent organised by largest population to smallest. </li>
<li>All the countries in a region organised by largest population to smallest.</li>
<li>The top N populated countries in the world where N is provided by the user.</li>
<li>The top N populated countries in a continent where N is provided by the user.</li>
<li>The top N populated countries in a region where N is provided by the user.</li>
<li>All the cities in the world organised by largest population to smallest.</li>
<li>All the cities in a continent organised by largest population to smallest.</li>
<li>All the cities in a region organised by largest population to smallest.</li>
<li>All the cities in a country organised by largest population to smallest.</li>
<li>All the cities in a district organised by largest population to smallest.</li>
<li>The top N populated cities in the world where N is provided by the user.</li>
<li>The top N populated cities in a continent where N is provided by the user.</li>
<li>The top N populated cities in a region where N is provided by the user.</li>
<li>The top N populated cities in a country where N is provided by the user.</li>
<li>The top N populated cities in a district where N is provided by the user.</li>
<li>All the capital cities in the world organised by largest population to smallest.</li>
<li>All the capital cities in a continent organised by largest population to smallest.</li>
<li>All the capital cities in a region organised by largest to smallest.</li>
<li>The top N populated capital cities in the world where N is provided by the user.</li>
<li>The top N populated capital cities in a continent where N is provided by the user.</li>
<li>The top N populated capital cities in a region where N is provided by the user.</li>
<li>The population of people, people living in cities, and people not living in cities in each continent.</li>
<li>The population of people, people living in cities, and people not living in cities in each region.</li>
<li>The population of people, people living in cities, and people not living in cities in each country.</li>
</ol>

#### Additionally, the following information should be accessible to the organisation:

    The population of the world.
    The population of a continent.
    The population of a region.
    The population of a country.
    The population of a district.
    The population of a city.

#### Finally, the organisation has asked if it is possible to provide the number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population:

    Chinese.
    English.
    Hindi.
    Spanish.
    Arabic.

#### Country Report

A country report requires the following columns:

    Code.
    Name.
    Continent.
    Region.
    Population.
    Capital.

#### City Report

A city report requires the following columns:

    Name.
    Country.
    District.
    Population.

#### Capital City Report

A capital city report requires the following columns:

    Name.
    Country.
    Population.

#### Population Report

For the population reports, the following information is requested:

    The name of the continent/region/country.
    The total population of the continent/region/country.
    The total population of the continent/region/country living in cities (including a %).
    The total population of the continent/region/country not living in cities (including a %).
