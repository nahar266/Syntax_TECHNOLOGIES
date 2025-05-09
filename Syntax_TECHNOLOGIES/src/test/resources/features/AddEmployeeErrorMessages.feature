Feature: Employee Form Validation Messages


  Background:
    Given Admin is able to access HRMS application
    When Admin enters valid username and password
    And Admin clicks on login button
    And Admin is successfully logged in
    And Admin clicks on PIM option
    And Admin clicks on Add Employee option

    @firstNameErrorMessageValidation @smoke
  Scenario: Submitting form without entering First Name
    When Admin leaves the First Name field blank
    And Admin enters "Smith" as Last Name
    And Admin clicks on save button
    Then The system should display a clear error message for the First Name field
    And The error message should be visible and placed near the First Name field


  @lastNameErrorMessageValidation @smoke
  Scenario: Submitting form without entering Last Name
    When Admin enters "John" as First Name
    And Admin leaves the Last Name field blank
    And Admin clicks on save button
    Then The system should display a clear error message for the Last Name field
    And The error message should be visible and placed near the Last Name field

@bothFieldEmptyErrorMessageValidation @smoke
  Scenario: Submitting form with both fields blank
    When Admin leaves the First Name field blank
    And Admin leaves the Last Name field blank
    And Admin clicks on save button
    Then The system should display clear error messages for the required fields
    And The error messages should be visible and placed near their respective fields




