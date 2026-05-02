@login @regression
Feature: Login Functionality

@smoke
  Scenario: Login with valid credentials
  Given user opens URL "http://localhost/opencart/"
  And user clicks on login link
    And user enters email "vaishnavajay952@gmail.com" and password "admin123"
    And user clicks on login button
    Then user should be redirected to dashboard


   @regression
  Scenario: Login with invalid credentials
    When user opens URL "http://localhost/opencart/"
    And user clicks on login link
    And user enters email "jay123@gmail.com" and password "admin123"
    And user clicks on login button
    Then user should see error message "Warning: No match for E-Mail Address and/or Password."


  @regression
  Scenario: Empty login validation
    When user opens URL "http://localhost/opencart/"
    And user clicks on login link
    And user clicks on login button
    Then user should see error message "Warning: No match for E-Mail Address and/or Password."

     @regression
    Scenario: Logout validation
      When user opens URL "http://localhost/opencart/"
      And user clicks on login link
      And user enters email "vaishnavajay952@gmail.com" and password "admin123"
      And user clicks on login button
      When user clicks on logout button
      Then user should logout Seccusfully and should see the page title as "Account Logout"



       @regression
      Scenario: Forgot Password
        When user opens URL "http://localhost/opencart/"
        And user clicks on login link
        And user clicks on Forgot Password
        Then Forgot password page should display






