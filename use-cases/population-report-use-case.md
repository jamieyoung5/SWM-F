# Produce a report with information on urbanisation within a country

### Goal in Context

As a user, I want to be able to generate a report that pulls urban and rural population information  on a country.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

We currently leverage an existing database with accurate data regarding population, regions, capital, continent, etc for 
each country.

### Success End Condition

A report is generated with the name, total population, urban population, and rural population of the continent or region
or capital for the organisation.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation employee.

### Trigger

A user of the system would call the query to generate the report (through an out-of-scope frontend ideally).

## Success Scenario

1. User will input the name of the country, continent, or region they want a report on
2. The program will query the database for a matching country, continent, or region name
3. The query will return a report listing the name, total population, urban population, and rural population of the 
requested location.
4. This information will be passed out through the console.

### Extensions
1. **No location found**: The program will throw an exception and inform the user they have made an incorrect input.