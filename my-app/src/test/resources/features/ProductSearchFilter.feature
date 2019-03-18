@Regression1
Feature: This is a product filter functionality
  As a customer
  I want to filter my search result
  So that the relevant product is displayed

  @sanity
  Scenario: Customer searching for phone
    Given I am on the home page
    When I search for product batteries
    Then I validate product is displayed low to high

  @sanity
  Scenario: Customer searching for phone
    Given I am on the home page
    When I search for product batteries
    Then I validate product is displayed high to low

  @wip1
  Scenario: Filter product by Grid view
  Given I am on the product search result page
  When I choose to filter the result by Grid view
  Then the result is shown in Grid view

  @wip2
  Scenario: Sort product result by relevance
  Given I am on the product search result page
  When I choose to sort the result
  Then the result is sorted by relevance