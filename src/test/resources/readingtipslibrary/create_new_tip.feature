Feature: As a user I can create new tip

  Scenario: tip creation is successful with video tip
    Given command insert and type video tip is selected
    When title "Terminator" and url "conan.com" are entered
    Then system will respond with "Inserting a video succeeded." message

  Scenario: tip creation is successful with book tip
    Given command insert tip and type book is selected
    When author "Alcott" and title "Little Women" and isbn "123" are entered
    Then system will respond with "Inserting a book succeeded." message

  Scenario: tip creation is successful with podcast tip
    Given command insert tip and type podcast is selected
    When podcastName "Name" and title "Title" and description "goodie" are entered
    Then system will respond with "Inserting a podcast succeeded." message

  Scenario: tip creation is successful with blogpost tip
    Given command insert tip and type blogpost is selected
    When author "Sonny" and title "Boring" and url "hellsinki.fi" are entered
    Then system will respond with "Inserting a blog succeeded." message
