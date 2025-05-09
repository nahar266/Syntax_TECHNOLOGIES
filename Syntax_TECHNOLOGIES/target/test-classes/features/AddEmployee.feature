Feature: Add Employee functionality in HRMS

  Background:
    Given Admin is able to access HRMS application
    When Admin enters valid username and password
    And Admin clicks on login button
    And Admin is successfully logged in
    And Admin clicks on PIM option
    And Admin clicks on Add Employee option
    And Admin clicks on save button


  @noID @smoke
  Scenario: Add employee without providing employee ID
    Given Admin is able to access HRMS application
    When Admin enters valid username and password
    And Admin clicks on login button
    And Admin is successfully logged in
    And Admin clicks on PIM option
    And Admin clicks on Add Employee option
    And Admin enters First Name and Last Name
    Then Admin submit the form without providing Employee ID

  @withID @smoke
  Scenario: Add employee providing an unique employee ID
    Given Admin clicks on Add Employee option on the "Add employee page"
    When Admin enters "Jack" as First Name and "Smith" as Last Name
    And Admin enters "EMP0070" as Employee ID
    And Admin clicks on save button
    Then The employee should be added successfully with Employee ID "EMP0070"



