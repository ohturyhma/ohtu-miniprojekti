Feature: As a user I can delete tips

  Scenario: tip destruction is successful with video tip
    Given command delete-type is selected
    When type "videos" is entered
    Then system will respond with "Deleting all videos succeeded." message

  Scenario: tip destruction is successful with book tip
    Given command delete-type is selected
    When type "books" is entered
    Then system will respond with "Deleting all books succeeded." message

  Scenario: tip destruction is successful with podcast tip
    Given command delete-type is selected
    When type "blogs" is entered
    Then system will respond with "Deleting all podcasts succeeded." message

  Scenario: tip destruction is successful with blogpost tip
    Given command delete-type is selected
    When type "podcasts" is entered
    Then system will respond with "Deleting all blogs succeeded." message