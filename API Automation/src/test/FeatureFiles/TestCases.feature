Feature: Create new User and check data is correct after creation

  Scenario: create new user
    Given User is creating new account
    And account is created successfully
    When User try to get account data
    Then Data is retrieved with correct values

