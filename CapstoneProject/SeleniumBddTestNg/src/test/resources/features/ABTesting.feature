Feature: Sample feature for capstone project
  Scenario: Verify Page
    Given User has landed on the screen
    When Clicked on AB Testing Link
    Then text is verified ok
    When Back to Home page
    And Clicked on Dropdown Link
    And Select Option1
    And Back to Home page
    And Clicked on Frames
    Then Verify hyperlinks are present