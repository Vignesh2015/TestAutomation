Feature: Validating the Add Place API's

@AddPlaceAPI_TEST001
  Scenario Outline: Verify the place is being successfully added using the AddPlaceAPI
    Given Add Place API Payload with "<name>" "<language>" "<Address>" "<Phonenumber>"
    When User calls the "AddPlaceAPI" with the "POST" HTTP Request
    Then the API call got success with Status code 200
    And "status" in Response body is "OK"
    And "scope" in Response body is "APP"
    And verify place_id created maps to "<name>" using "GetPlaceAPI"

    Examples:
      | name    | language | Address            | Phonenumber       |
      | AAHouse | English  | World Cross center | (+91)989 789 6688 |
     # | Brandon Street | Spanish  | Spain racy         | +78 664 899 6679  |
     # | BBStreet | Canadian | Canada Dacy        | +28 664 989 3462  |


@AddPlaceAPI_TEST002
  Scenario Outline: Verify the place is successfully configured using the AddPlaceAPI
    Given Add Place API Payload with "<name>" "<language>" "<Address>"
    When User calls the "AddPlaceAPI" with the "POST" HTTP Request
    Then the API call got success with Status code 200
    And "status" in Response body is "OK"
    And "scope" in Response body is "APP"
    And verify place_id created maps to "<name>" using "GetPlaceAPI"

  Examples:
    | name     | language | Address             |
    | DD House | English  | Washington Bay area |

@AddPlaceAPI_TEST003
  Scenario Outline: Verify the place is successfully configured using the AddPlaceAPI
    Given Add Place API Payload with "<name>" "<language>" "<Address>"
    When User calls the "AddPlaceAPI" with the "POST" HTTP Request
    Then the API call got success with Status code 200
    And "status" in Response body is "OK"
    And "scope" in Response body is "APP"
    And verify place_id created maps to "<name>" using "GetPlaceAPI"

    Examples:
      | name      | language | Address          |
      | mckinksey | English  | Redmond Bay area |





