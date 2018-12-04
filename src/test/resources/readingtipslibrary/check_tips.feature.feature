Feature: As a user I can check tips

  Scenario: all tips are shown as a list
    Given command "find-all" is selected
    When type all is entered
    Then system will respond with "Everything found." message

  Scenario: all video tips are shown as a list
    Given command "find-type" is selected
    When type "video" is entered
    Then system will respond with "Every video found." message

  Scenario: all book tips are shown as a list
    Given command "find-type" is selected
    When type "book" is entered
    Then system will respond with "Every book found." message

  Scenario: all podcast tips are shown as a list
    Given command "find-type" is selected
    When type "podcast" is entered
    Then system will respond with "Every podcast found." message

  Scenario: all blogpost tips are shown as a list
    Given command "find-type" is selected
    When type "blog" is entered
    Then system will respond with "Every blog found." message