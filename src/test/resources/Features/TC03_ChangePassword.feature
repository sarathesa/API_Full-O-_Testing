Feature: User verify Change Password API

  Scenario: User verify change password
    Given User add headers
    And User add response body "currentPassword","newPassword", "confirmPassword"
    And User send "PUT" request for with changePassord address endpoints
    And User verify status code 200
    Then User verify successfull response body with changePassord message "Your password has been updated"
