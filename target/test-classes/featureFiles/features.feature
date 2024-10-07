Feature: Test android app flow
  Scenario: add 2 items in cart and place the order
    Given App is opened
    When User login in app
    Then Add item to cart
    When User navigates to the cart
    Then User checkout the items
    Then Validate the order details