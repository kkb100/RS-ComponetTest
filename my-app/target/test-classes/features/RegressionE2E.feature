@Regression
Feature: This is an end to end test functionality usually for regression purposes
  As a an end to end test
  I want to create a test
  So as to gain overall confidence of the app.


  @wip
  Scenario: From home page to checkout(not purchasing)
    Given I am on the home page
    And I login into account
    When I checkout from the app
    Then I am presented with make a payment
