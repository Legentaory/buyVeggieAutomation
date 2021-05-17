Feature: Search and place order for vegetables

  @SeleniumTest
  Scenario: Search fro items and validate results
    Given User is on GreenCart Landing Page
    When User searched for "Cucumber" Vegetable
    Then "Cucumber" results are displayed

  @SeleniumTest
  Scenario: Search for items and move to checkout page
    Given User is on GreenCart Landing Page
    When User searched for "Brinjal" Vegetable
    And Add items to cart
    And User proceed to checkout page for purchase
    Then verify selected "Brinjal" items are displayed in checkout page