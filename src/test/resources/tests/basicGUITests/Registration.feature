Feature: Registration

  @registration
  Scenario: Positive registration test
    Given I am on the Registration page
    When I create a user with the valid data
    And I click SignUp button
    Then I see a confirmation message:
    """
    Please, check your email and activate your account.
    """
