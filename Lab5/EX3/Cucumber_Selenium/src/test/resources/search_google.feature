Feature: Search in Google

  Scenario: Seek for BlazeDemo Flight
    When I navigate to "https://blazedemo.com"
    And I buy a flight to "London"
    And I choose a flight "3"
    And I fill the form with my personal info name: "Tiago Oliveira", address: "Rua da Morgadinha 292", city: "Porto", state: "Grijó", zip: "4415-489", cn: "1111111111111111", cnMonth: "10", cnYear: "2021", cnName: "Tiago Oliveira"
    Then I should be shown results including "BlazeDemo Confirmation"