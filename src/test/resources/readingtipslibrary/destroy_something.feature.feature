Feature: As a user I can delete tips

  Scenario: tip destruction is successful with video tip
    Given command "delete-type" is selected
    When type "video" is entered
    Then system will respond with "Deleting all videos successful!" message

  Scenario: tip destruction is successful with book tip
    Given command "delete-type" is selected
    When type "book" is entered
    Then system will respond with "Deleting all books successful!" message

  Scenario: tip destruction is successful with podcast tip
    Given command "delete-type" is selected
    When type "blogpost" is entered
    Then system will respond with "Deleting all blogposts successful!" message

  Scenario: tip destruction is successful with blogpost tip
    Given command "delete-type" is selected
    When type "podcast" is entered
    Then system will respond with "Deleting all podcasts successful!" message

  Scenario: tip destruction is successful with all tips
    Given command "delete-all" is selected
    When type all is entered
    Then system will respond with "Everything deleted!" message