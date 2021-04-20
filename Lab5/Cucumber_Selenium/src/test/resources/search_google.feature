Feature: Search in Google

  Scenario: Seek for BlazeDemo Flight
    When I navigate to "https://blazedemo.com"
    And I buy a flight to "London"
    And I choose a flight
    And I fill the form with my personal info
    Then I should be shown results including "BlazeDemo Confirmation"