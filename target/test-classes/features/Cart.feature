Feature: Functionality of Your cart page

Background:
Given Open the Application in any browser for cart
And Login using given credentials for displaying your cart
And User have to select a product and user click on the go to cart icon 


@cart @continue
Scenario: Verify the working of continue buttons in yourcart page
Then Verify user is able to click on continue button

@cart @checkout
Scenario: Verify the working of checkout buttons in your cart option
Then Verify user is able to click on checkout button
