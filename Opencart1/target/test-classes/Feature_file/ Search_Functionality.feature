@regression @search_function
Feature: Search_functionality
  @smoke
  Scenario: Search valid product
Given user opens URL "http://localhost/opencart/"
When user searches for "iPhone"
Then relevant products should be displayed
@regression
Scenario: Search invalid product
Given user opens URL "http://localhost/opencart/"
When user searches for "xyz123"
Then no product found message should be displayed
@regression
Scenario: Partial keyword search
Given user opens URL "http://localhost/opencart/"
When user searches for "iph"
Then relevant products should be displayed

