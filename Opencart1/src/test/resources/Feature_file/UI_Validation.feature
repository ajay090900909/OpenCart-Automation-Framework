@regression @ui_validation
Feature: Ui validation
  @smoke
  Scenario: Verify error message
    When user opens URL "http://localhost/opencart/"
    And user enters invalid login details
    Then "Invalid credentials" error message should be displayed
  @regression
  Scenario: Required field validation
    When user opens URL "http://localhost/opencart/"
    And user submits empty form
    Then required field messages should be shown
  @regression
  Scenario: Button enable/disable
    When user opens URL "http://localhost/opencart/"
    And user is on login page
    Then login button should be disabled until fields are filled
  @regression
  Scenario: Page title validation
    When user opens URL "http://localhost/opencart/"
    Then page title should be "Your Store"
  @regression
  Scenario: URL validation
    When user opens URL "http://localhost/opencart/"
    And user logs in successfully
    Then URL should contain "account"
