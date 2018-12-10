Feature: as a user I can search tips by their name

  Scenario: tips are listed if their whole name is used is in search
    Given database has tip of type "book" and name "About gravity"
    When command "find-by-name" is selected
    When name "About gravity" is entered
    Then system will respond with "Found 1 entries" message

  Scenario: tips with the search term in their name are listed
    Given database has 3 tips with the word comp in their name
    When command "find-by-name" is selected
    When name "comp" is entered
    Then system will respond with "Found 3 entries" message
