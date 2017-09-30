Feature: Buying product on mobile viewport
  Scenario: Display Default currency
    Given I view site on mobile viewport
    When  I dont change the currency
    Then  I should see prices displayed out in AU Dollars