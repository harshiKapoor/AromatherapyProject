Feature: Testing products change currency scenario
  Scenario: Change Currency functionality
    Given I land on products page
    When  I select currency
    Then  I should see prices displayed in the selected currency

  Scenario: Default Currency functionality
    Given I land on products page
    When I dont change the currency
    Then I should see prices displayed out in AU Dollars

  Scenario: Buy Button Should Open Reconfirm the product name to customer
    Given I land on products page
    When I click buy button
    Then I should get an alert with product purchased