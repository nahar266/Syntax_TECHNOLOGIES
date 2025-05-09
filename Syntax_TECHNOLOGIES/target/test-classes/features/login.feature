Feature: login page functionality

  Background:  User is able to access to HRMS application
  User click on login button

  @emptyusernamefield @smoke
  Scenario: User try to log in with empty username field
    Given User is able to access to HRMS application
    When User leave empty username field
    And User enter password
    And User click on login button
    Then User able to see error message "username cannot be empty"

  @emptypasswordfield @smoke @F2
  Scenario: User try to log in with empty password field
    Given User is able to access to HRMS application
    When User enter username
    And User leave empty password field
    And User click on login button
    Then User able to see error message {string} "Password is empty"

  @invalidcredential @smoke
  Scenario: User try to log in with invalid credential
    Given User is able to access to HRMS application
    When User enter invalid username and invalid password
    And User click on login button
    Then User able to see "Invalid credentials"



  @retryAfterError @smoke @F1
  Scenario: User enters incorrect credentials, sees error, and retries with correct credentials
    When User enters invalid username
    And User enters invalid password
    And User clicks the login button
    Then User should see error message "Invalid credentials" near the login form

    When User clears the login form
    And User enters valid username into the username field
    And User enters valid password into the password field
    And User clicks the login button
    Then User should be redirected to the dashboard
    And User should see "Welcome" message on the homepage