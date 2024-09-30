Feature: Sign Up as New Customer
  Scenario: Sign Up as Valid New Customer
    Given I launch google chrome browser
    When I open cermati sign up page
    And I fill the phone number
    And I fill the email
    And I fill first name
    And I fill last name
    And I click sign up button
    Then I should get redirected to phone number verification