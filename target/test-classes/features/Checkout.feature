Feature: Functionality of checkout

Background:
Given Open the Application in any browser for checkout
And User enters username as  standard_user  and password as secret_sauce for login
When User clicks on the go to cart icon for checkout
And User clicks on checkout button 
@checkout @pass
Scenario: Checkout with valid users details 
Then Verify user is able to fill firstname say "<firstname>" , lastname say "<lastname>" and postalcode say "<postalcode>"
And User clicks on continue button with details
Examples:
|firstname    |   lastname   |  postalcode  |
| Ananya      |   Kumari     |   8340001    |
@checkout @fail
Scenario: Checkout with invalid users details 
Then Verify user is able to fill firstname say "<firstname>" , lastname say "<lastname>" and postalcode say "<postalcode>"
And User clicks on continue button with invalid details
Examples:
|firstname    |   lastname   |  postalcode  |
| 67766552    |   8754943    |  agdhsnsb    |
@checkout @pass @nodetails
Scenario: Checkout with no users details 
Then Verify user is able to fill firstname say "<firstname>" , lastname say "<lastname>" and postalcode say "<postalcode>"
And User clicks on continue button with no details

Examples:
|firstname    |   lastname   |  postalcode  |
|             |              |              |