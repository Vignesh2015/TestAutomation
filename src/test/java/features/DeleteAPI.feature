Feature: Validating the Delete Place API's

  @DeletePlaceAPI
  Scenario: Verify if Delete place functionality is working
    Given Delete Place API Payloads
    When User calls "DeletePlaceAPI" with the "POST" HTTP Request
    Then the API call got success with the Status code 200
    And "status" in the Response body is "OK"