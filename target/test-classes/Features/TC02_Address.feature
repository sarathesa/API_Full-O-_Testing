Feature: Verify User Address API with POST,PUT,GET,DELETE

  Scenario Outline: User create Address
    Given User add headers
    And User add response body "<firstName>","<lastName>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<addresstype>"
    And User send "POST" request for with create address endpoints
    And User verify status code 200
    And User verify successfull response body with Create message "Address added successfully"
    Then User get the Address id and saved

    Examples: 
      | firstName | lastName | mobile     | apartment    | state | city | country | zipcode | address | addresstype |
      | sarath    | kumar    | 1234567890 | newApartment |    23 | 3367 |     101 |   60009 | egmore  | Home        |

  Scenario Outline: User Update Address
    Given User add headers
    And User update response body "Address-id","<firstName>","<lastName>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<addresstype>"
    And User send "PUT" request for with Update address endpoints
    And User verify status code 200
    Then User verify successfull response body with Update message "Address updated successfully"

    Examples: 
      | firstName | lastName | mobile     | apartment    | state | city | country | zipcode | address | addresstype |
      | sarath    | esa      | 0987654321 | oldApartment |    23 | 3367 |     101 |    5678 | egmore  | Office      |

  Scenario: User Get Address details
    Given User add headers
    And User send "GET" request for with Get address endpoints
    And User verify status code 200
    Then User verify successfull response body with message "OK"

  Scenario Outline: User Delete Address
    Given User add headers
    And User send payload
    And User send "DELETE" request for with Delete address endpoints
    And User verify status code 200
    Then User verify successfull response body with Delete message "Address deleted successfully"
