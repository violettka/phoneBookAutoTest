Feature: Add Contact

  Background:
    Given I have access token

  @api
  Scenario: Add new contact

    When I make POST request for the endpoint 'contact'
    Then I see status code 200

  @api
  Scenario: Get contact

    Given I have existing contact
    When I make GET request for the endpoint 'contact'
    Then I see status code 200
