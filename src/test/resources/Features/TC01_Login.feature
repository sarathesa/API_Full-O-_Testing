Feature: User verify Login Api

  Scenario: Get user Logtoken from login endpoint
    Given User add header
    And User Add basic authentication for login
    And User send "POST" request for login endpoint
    Then User verify the status code 200
    And User verify successfull response body with message "Login successfully" and get the Logtoken saved