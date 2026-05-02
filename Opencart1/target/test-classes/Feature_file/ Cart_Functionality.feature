@regression @cart_functionality
Feature: Cart Functionality

  @smoke
  Scenario: Add product to cart
    Given user opens URL "http://localhost/opencart/"
    When user clicks on Add to Cart
    Then product should be added to cart
@regression
  Scenario: Update product quantity
    Given user opens URL "http://localhost/opencart/"
    When user adds "MacBook" to cart
    And user navigates to cart page
    And user updates quantity to 2
    Then cart total should be updated

@regression
  Scenario: Remove product from cart
    Given user opens URL "http://localhost/opencart/"
    When user removes the product
    Then cart should be empty
@regression
  Scenario: Cart total validation
    Given user opens URL "http://localhost/opencart/"
    And user has added products to cart
    Then total price should be calculated correctly
