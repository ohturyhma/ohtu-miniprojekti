Feature: As a user I can check tips

  Scenario: all tips are shown as a list
    Given database has tip of type "book" and name "About gravity"
    Given command "find-all" is selected
    When type all is entered
    Then system will respond with "-----------------------------------" message

  Scenario: all video tips are shown as a list
    Given database has tip of type "video" and name "Gravity"
    Given command "find-type" is selected
    When type "video" is entered
    Then system will respond with "-----------------------------------" message

  Scenario: all book tips are shown as a list
    Given database has tip of type "book" and name "About gravity"
    Given command "find-type" is selected
    When type "book" is entered
    Then system will respond with "-----------------------------------" message

  Scenario: all podcast tips are shown as a list
    Given database has tip of type "podcast" and name "Podcast"
    Given command "find-type" is selected
    When type "podcast" is entered
    Then system will respond with "-----------------------------------" message

  Scenario: all blogpost tips are shown as a list
    Given database has tip of type "blogpost" and name "Cucumber101"
    Given command "find-type" is selected
    When type "blogpost" is entered
    Then system will respond with "-----------------------------------" message