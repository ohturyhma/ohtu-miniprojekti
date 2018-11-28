Feature: As a user I can check tips

  Scenario: all tips are shown as a list
    Given command find-all is selected
    When ...
    Then ...

  Scenario: all video tips are shown as a list
    Given command find-type is selected
    When type "video" is entered
    Then ...

  Scenario: all book tips are shown as a list
    Given command find-type is selected
    When type "book" is entered
    Then ...

  Scenario: all podcast tips are shown as a list
    Given command find-type is selected
    When type "podcast" is entered
    Then ...

  Scenario: all blogpost tips are shown as a list
    Given command find-type is selected
    When type "blog" is entered
    Then ...