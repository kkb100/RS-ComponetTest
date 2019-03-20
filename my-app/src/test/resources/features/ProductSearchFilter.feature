@Regression1
Feature: This is a product filter functionality
  As a customer
  I want to filter my search result
  So that the relevant product is displayed

  @sanity
  Scenario: Customer search for a product and apply a low to high filter
    Given I am on the home page
    When I search for product batteries
    Then I validate product is displayed low to high

  @sanity
  Scenario: Customer search for a product and apply a high to low filter
    Given I am on the home page
    When I search for product batteries
    Then I validate product is displayed high to low

