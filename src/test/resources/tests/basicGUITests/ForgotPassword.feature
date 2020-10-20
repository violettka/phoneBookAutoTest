Feature: Forgot Password Feature

  Background:
    Given I am on the 'Forgot Password' page

  Scenario: Login link exists on Forgot Password Page

    When I click on the Login link
    Then I see Login button

  Scenario: Reset user password
    When I reset non-existing user password
    Then I see validation message

