Feature: As a user I can create new tip

  Scenario: tip creation is successful with video tip
    Given command "insert" and type "video" is selected
    When title "Terminator" and description "machines" and url "https://videourl.com" are entered
    Then system will respond with "Successfully added a video!" message

  Scenario: tip creation is successful with book tip
    Given command "insert" and type "book" is selected
    When author "Alcott" and title "Little Women" and isbn "isbn" and description "some description" and url "https://bookurl.com" are entered
    Then system will respond with "Successfully added a book!" message

  Scenario: tip creation is successful with podcast tip
    Given command "insert" and type "podcast" is selected
    When name "name" and title "Title" and description "goodie" and url "https://podcasturl.com" are entered
    Then system will respond with "Successfully added a podcast!" message

  Scenario: tip creation is successful with blogpost tip
    Given command "insert" and type "blogpost" is selected
    When author "Sonny" and title "Boring" and description "awesome description" and url "https://blogposturl.com" are entered
    Then system will respond with "Successfully added a blogpost!" message
