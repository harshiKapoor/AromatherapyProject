Feature: Buying product function
  Scenario: Change price currency
    Given I land on products page
    When  I select currency
    Then  I should see prices displayed in the selected currency

  Scenario: Display default price currency
    Given I land on products page
    When I dont change the currency
    Then I should see prices displayed out in AU Dollars

  Scenario: Confirm product name when clicking purchase button
    Given I land on products page
    When I click buy button
    Then I should get an alert with product purchased
