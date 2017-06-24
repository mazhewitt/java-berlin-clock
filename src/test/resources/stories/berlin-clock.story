Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: Midnight
When the time is 00:00:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: Just before midnight
When the time is 23:59:59
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: Midnight
When the time is 24:00:00
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO

Scenario: At 3 pm
When the time is 15:00:00
Then the clock should look like
Y
RRRO
OOOO
OOOOOOOOOOO
OOOO


Scenario: Incorrect Time case 1
When the time is 24:01:00
there should be an error
Incorrect time for conversion


Scenario: Incorrect Time case 2
When the time is 23:63:00
there should be an error
Incorrect Hour!! hour >63


Scenario: Incorrect Time case 3
When the time is 23:45:75
there should be an error
Incorrect second!! second >75


Scenario: Incorrect Time case 4
When the time is 24:00:26
there should be an error
Incorrect time for conversion


Scenario: Incorrect Time case 4
When the time is 23-00-00
there should be an error
Incorrect Time format


Scenario: At 3:30:00 pm
When the time is 15:30:00
Then the clock should look like
Y
RRRO
OOOO
YYRYYROOOOO
OOOO

Scenario: At 3:30:59 pm
When the time is 15:30:59
Then the clock should look like
O
RRRO
OOOO
YYRYYROOOOO
OOOO


Scenario: At 3:31:59 pm
When the time is 15:31:59
Then the clock should look like
O
RRRO
OOOO
YYRYYROOOOO
YOOO