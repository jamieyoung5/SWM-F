## Group Submission

The coursework **must** be delivered by a group.  The aim of the module is to assess your ability to work as a team to deliver a product.  Therefore, the majority of your coursework grade will be based on your team's ability to work together using the methods defined in the module.

The submission is monitored during lab stand-up meetings, and formally via the 5 assessment points.  Your submissions are delivered via your GitHub repository. The master branch of your GitHub repository should also be submitted to Moodle at each assessment point along with a spreadsheet in Excel format (csv, xls or xlsx) detailing Individual team members' contributions.

## Individual Assessment

Individual contributions to the team will be assessed by your peers and the module teaching team based on attendance at the various meetings and individual contributions towards each code review, and via the metrics gathered from tools such as GitHub.  **Individual contributions will lead to a scaling of the overall coursework grade if the module team have evidence that illustrates a lack of contribution to the team deliverable.**

#### Groups must maintain a spreadsheet detailing individual team members contribution at each of the 5 assessment points

We wish to determine the individual contribution to the team project.  To do this, the team have to submit a single spreadsheet to Moodle defining the agreed contribution of each team member to the individual delivery points.  This should be submitted in percentages with the total sum of individual contributions adding up to 100% at each point of assessment.  For example:

| Matriculation Number | Code Review 1 | Code Review 2 | Code Review 3 | Code Review 4 | Final Deliverable |
| ---- | ------------- | ------------- | ------------- | ------------- | ----------------- |
| 4000xxxx | 25          | 50          | 0.0           | 0.25          | 0.2               |
| 4000xxxx | 25          | 50          | 0.5           | 0.25          | 0.4               |
| 4000xxxx | 25          | 0         | 0.5           | 0.25          | 0.2               |
| 4000xxxx | 25          | 0           | 0.0           | 0.25          | 0.2               |
| **Total** | **100**   | **100** | **100**      | **100**   | **100** 				|
The team need to agree these scores.  **If the team cannot agree, or a team member believes the spreadsheet submitted does not represent the actual contributions, then contact a member of the teaching team.**  In these circumstances, the metrics and other information provided on GitHub will be used.

The data supplied in this spreadsheet will be used to weight each team members final mark for each assessment point.

For example, if the group received 18 out of 20 for code review one then all 4 members would get the full 18 marks as all had contributed equally. For code review 2 Members 1 & 2 would get the group mark but Members 3 & 4 would receive zero

## Disciplinary Procedures

The coursework **must** be delivered as part of a team.  **If anyone is dismissed from their team this means they cannot deliver the coursework and will fail.**  Dismissal from a team involved the following process:

- An individual is evidenced as breaching the code of conduct as set-out by the student team.
- Evidence is presented at the next available meeting with a member of the module delivery team.
- The individual evidenced will have the opportunity to evidence mitigating circumstances either to the student team or privately to a member of the module delivery team.
- The module delivery team retains the right to the final decision of whether the dismissal is warranted.

Any dismissed team member has a week to appeal the decision to the module team with suitable evidence provided.


## Code Review Meetings

Each group will undertake **four** graded code reviews as well as a final submission at the end of Week 13:

Note that Teaching starts in Week 2. Week Commencing 25th January

1. Week 4 Code Review 1 (20% of CW mark).
2. Week 7 Code Review 2 (20% of CW mark).
3. Week 10 Code Review 3 (20% of CW mark).
4. Week 13 Code Review 4 (20% of CW mark).
5. Week 13 Final submission (20% of CW Mark)

The code reviews will take place during your usual Lab sessions.  Each group will be given **15 minutes maximum** for the code review.  Your group will be **allocated a time for the code review**.  The details of the individual review points are below.  These meetings **must be attended** at the **stated time**.  Guidelines for grading the group:

- **Being late** for the meeting or **not being ready** when the meeting starts will result in the grade for that review being capped at 40%.
- **Not attending** the meeting will mean the code review will be marked at 0%.

**All team members** should attend the code review, however commitments and other considerations will be taken into account.  **Individuals attendance at reviews will be monitored** to ensure the team is contributing collectively to the project.

**Being ready** means that you are ready to present the points for the code review.  This means that you have a computer with the various tools logged into (e.g., GitHub, etc.) and a building version of the application in IntelliJ.

### Code Review 1

#### REVIEW MEETING: Lab of Week 4

The aim of this code review meeting is to check that the project workflow is set-up for the team.  You may choose to meet some of the feature requirements during this review point, but it is not as necessary.

#### Checklist Submission 1 (16% of CW mark)

The following must be in place:

-  GitHub project for coursework set-up.
-  Product Backlog created.
-  Project builds to self-contained JAR with Maven.
-  Dockerfile for project set-up and works.
-  GitHub Actions for project set-up and build is working using JAR, and Docker on GitHub Actions.
-  Correct branches for GitFlow workflow created - includes `master`, `develop`, and `release` branches.
-  First release created on GitHub.
-  Code of Conduct defined.

#### Graded Criteria Submission 1 (4% of CW mark)

The following criteria will be assessed for overall quality:

- Metrics from GitHub.  Also used to assess individual contribution.
- Code quality including comments.

### Code Review 2

#### REVIEW MEETING: Lab of Week 7

The aim of this code review is to check that task management is set-up and that the initial requirements gathering has taken place via user stories and use cases.  You should have completed at least 25% of the work for the project at this point based on your own estimates.

#### Checklist Submission 2 (14% of CW mark)

The following must be in place:

-  Issues being used on GitHub.
-  Tasks defined as user stories.
-  Project integrated with Zube.io.
-  Kanban/Project Board being used.
-  Sprint Boards being used.
-  Full use cases defined.
-  Use case diagram created.

#### Graded Criteria Submission 2 (6% of CW mark)

The following criteria will be assessed for overall quality:

- Metrics from GitHub.  Also used to assess individual contribution.
- Code quality including comments.
- Correct usage of branches.
- Continuous integration working.
- Use cases well defined.
- Project requirements met.

### Code Review 3

#### REVIEW MEETING: Lab of of Week 10

The aim of this code review is to check that testing has been correctly specified.  At this stage, at least 50% of the work of the project should be completed.

#### Checklist Submission 3 (12% of CW mark)

The following must be in place:

-  Suitable unit tests defined.
-  Suitable integration tests defined.
-  Tests running on GitHub Actions.

#### Graded Criteria Submission 3 (8% of CW mark)

The following criteria will be assessed for overall quality:

- Metrics from GitHub.  Also used to assess individual contribution.
- Code quality including comments.
- Correct usage of branches.
- Continuous integration working.
- Kanban/Project Board being used.
- Quality and coverage of unit tests.
- Project requirements met.

### Code Review 4

#### REVIEW MEETING: Lab of Week 13

The aim of this code review is to check that the project is deploying correctly.  At this stage, at least 75% of the work of the project should be completed.

#### Checklist Submission 4 (10% of CW mark)

The following must be in place:

-  Deployment working.
-  Bug reporting system set-up.

#### Graded Criteria Submission 4 (10% of CW mark)

The following criteria will be assessed for overall quality:

- Metrics from GitHub.  Also used to assess individual contribution.
- Code quality including comments.
- Correct usage of branches.
- Continuous integration working.
- Kanban/Project Board being used.
- Quality and coverage of unit tests.
- Project requirements met.

### Final Submission (20% of CW mark)

#### SUBMISSION DEADLINE: Friday at 15:00 of Week 13

The final deliverable will be compared automatically to your GitHub repository.  The final submission will be assessed based on the following criteria:

- Metrics from GitHub.  Also used to assess individual contribution.
- Code quality including comments.
- Correct usage of branches.
- Continuous integration working.
- Kanban/Project Board being used.
- Quality and coverage of unit tests.
- Project requirements met.
