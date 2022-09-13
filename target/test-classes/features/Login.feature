Feature: User login

Users is able to login, go to cart option and checkout
@login @passed @givencredentials
Scenario: Login with valid credentials to show the product in your cart
Given Open the Application in any browser for login
When User enters username as  standard_user  and password as secret_sauce
And User clicks on Login button
And User select an item from product page
Then Verify user is able to see the selected product in your cart option
 





