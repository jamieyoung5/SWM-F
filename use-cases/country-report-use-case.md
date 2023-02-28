# Produce a report with information of a country

### Goal in Context

As a user, I want to be able to generate a report that pulls information on a country.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

We currently leverage an existing database with accurate data regarding population, regions, capital, continent, etc for each country.

### Success End Condition

A report is generated with the country: code, name, continent, region, population and capital information for the organisation.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation employee.

### Trigger

A user of the system would call the query to generate the report (through an out-of-scope frontend ideally).

## Success Scenario

1. User will input the name of the country they want a report on
2. The program will query the database for a matching country name
3. The query will return a report listing the code, name, continent, region, population and capital of the country.
4. This information will be passed out through the console.

### Extensions
1. **No country found**: The program will throw an exception and inform the user they have made an incorrect input.