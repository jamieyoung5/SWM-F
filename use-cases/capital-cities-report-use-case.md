# Produce a report on population information of a Capital city

### Goal in Context

As a user, I want to be able to generate a report that pulls population information of a given capital city, and the country the city is the capital of.

### Scope

Organisation.

### Level

Primary task.

### Preconditions

We currently leverage an existing database with accurate data regarding population information for each country.

### Success End Condition

A report is generated with the population information for the organisation.

### Failed End Condition

No report is produced.

### Primary Actor

Organisation employee.

### Trigger

A user of the system would call the query to generate the report (through an out-of-scope frontend ideally)

## Success Scenario

1. User will input the name of the capital city they want a report on.
2. The program will query the database for a matching Capital city name
3. The query will return a report listing the Country name, Capital city name, and population of the city.
4. This information will be passed out through the console.

### Extensions
1. **No city found**: The program will throw an exception and inform the user they have made an incorrect input.