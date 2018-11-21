Feature: As a user I can create new tip

  Scenario: tip creation is successful with video tip
    Given command insert and type video tip is selected
    When title "Terminator" and url "conan.com" are entered
    Then system will respond with "Inserting a video succeeded."

  Scenario: tip creation is successful with book tip
    Given command insert tip is selected
    When ...
    Then ...

  Scenario: tip creation is successful with podcast tip
    Given command insert tip is selected
    When ...
    Then ...

  Scenario: tip creation is successful with blogpost tip
    Given command insert tip is selected
    When ...
    Then ...
