Feature: Validation of discovery homepage

  Scenario: Adding recommended videos to favorite list
    Given user is in discovery homepage "Url"
    When user select any two recommended videos at position "1,4" and add to favorite list 
    And navigate to myvideos page "MyvideospageUrl"
    Then validate the video title and description in favorite list
    And closing browser
