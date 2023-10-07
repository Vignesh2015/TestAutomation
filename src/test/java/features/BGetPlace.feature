Feature: Validating the GET Place API's


  @GetPlaceAPI
  Scenario: Verify if Get place functionality is working

    Given Get Place API Payload
    When User calls the "GetPlaceAPI" with a "GET" HTTP Request
    Then the API call got success with a Status code 200
    And "language" in a Response body is "English"