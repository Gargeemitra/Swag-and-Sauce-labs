package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageobjects.CheckoutYourInformationPage;
import pageobjects.LoginPage;
import pageobjects.YourCartPage;

public class Checkout extends Base {
	
	WebDriver driver;
	LoginPage loginPage;
	YourCartPage ycp ;
	CheckoutYourInformationPage checkpage;
	
	@Before("@checkout") 
	public void setup() throws IOException {
		 driver = initializeBrowser();
	}
	@After("@checkout") 
	public void closure() {
		if(driver!=null)
			driver.quit();
	}
	
	 @Given("^Open the Application in any browser for checkout$")
	    public void open_the_application_in_any_browser_for_checkout() throws Throwable {
		 driver.get(prop.getProperty("url"));
	    }

	    @When("^User clicks on the go to cart icon for checkout$")
	    public void user_clicks_on_the_go_to_cart_icon_for_checkout() throws Throwable {
	    	 loginPage.clickongotocart();
	    }

	    @Then("^Verify user is able to fill firstname say \"([^\"]*)\" , lastname say \"([^\"]*)\" and postalcode say \"([^\"]*)\"$")
	    public void verify_user_is_able_to_fill_firstname_say_something_lastname_say_something(String firstname, String lastname,String postalcode) throws Throwable {
	    	checkpage = new CheckoutYourInformationPage(driver);
	    	checkpage.enterfirstname(firstname);
	    	checkpage.enterlastname(lastname);
	    	checkpage.enterpostalcode(postalcode);
	    	}

	    @And("^User enters username as  standard_user  and password as secret_sauce for login$")
	    public void user_enters_username_as_standarduser_and_password_as_secretsauce_for_login() throws Throwable {
	    	loginPage = new LoginPage(driver);
	    	loginPage.enterusername(prop.getProperty("validusername"));
	        loginPage.enterpassword(prop.getProperty("validpassword"));
	        loginPage.clickonlogginbutton();
	    }

	    @And("^User clicks on checkout button$")
	    public void user_clicks_on_checkout_button() throws Throwable {
	    	ycp = new YourCartPage(driver);
	    	ycp.clickoncheckoutbutton(); 
	   	    Assert.assertTrue(ycp.verifyyourinformationpage());
	    	
	    }

	    @And("^User clicks on continue button with details$")
	    public void user_clicks_on_continue_button_with_details() throws Throwable {
	    	checkpage = new CheckoutYourInformationPage(driver);
	    	checkpage.clickoncontinueofinformationpage();
	    	Assert.assertTrue(checkpage.displayfinishpage());
	    }
       
	    @And("^User clicks on continue button with invalid details$")
	    public void user_clicks_on_continue_button_with_invalid_details() throws Throwable {
	    	checkpage = new CheckoutYourInformationPage(driver);
	    	checkpage.clickoncontinueofinformationpage();
	    	Assert.assertFalse(checkpage.displayfinishpage());
	    }
       
	    @And("^User clicks on continue button with no details$")
	    public void user_clicks_on_continue_button_with_no_details() throws Throwable {
	    	checkpage = new CheckoutYourInformationPage(driver);
	    	checkpage.clickoncontinueofinformationpage();
	    	Assert.assertTrue(checkpage.displayerrormessage());
	    			}
       
	}

