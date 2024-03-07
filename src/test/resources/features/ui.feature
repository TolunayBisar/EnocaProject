@UiTest
Feature: Registered user can login , add item to cart and checkout successfully.
  Background:
    Given User login and on dashboard page

    @ClearCart
    Scenario: Registered User can check the cart and clear it
      When User can go to the cart and clear it
      Then Cart should be empty

      @AddItemToCart
      Scenario: User can add random item to cart
        When User select random item and add to the cart
        Then there is item in cart

        @CheckOut
        Scenario: User can check out successfully
          When User go to the cart
          And User check out with Fake Credit Card
          Then There should be warning massage about credit card no.

          @AddQuantityInCart
          Scenario: User can add quantity in cart after unsuccessful checkout
            When User go to my cart
            And User add quantity in cart
            Then Item quantity added successfully

            @LogOut
            Scenario: User can logout
              When User logout
              Then User logout successfully
