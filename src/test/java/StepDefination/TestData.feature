
Feature: Testing with Data Provider

  @tag1
  Scenario: Verify login functionality with different credentials
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    Then I should be logged in successfully

  @tag2
  Scenario Outline: Verify login functionality with different credentials
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    Then I should be logged in successfully

    Examples: 
      | username | password |
      | abc@gmail.com    | 1234    |
      | abc1@gmail.com    | 5678    |
