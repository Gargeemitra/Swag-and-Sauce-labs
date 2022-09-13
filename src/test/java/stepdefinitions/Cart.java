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

public class Cart extends Base{
	
	WebDriver driver;
	LoginPage loginPage;
	YourCartPage ycp;
	CheckoutYourInformationPage checkpage;
	
	@Before("@cart") 
	public void setup() throws IOException {
		 driver = initializeBrowser();
	}
	@After("@cart") 
	public void closure() {
		if(driver!=null)
			driver.quit();
	}
	
	 @Given("^Open the Application in any browser for cart$")
	    public void open_the_application_in_any_browser_for_cart() throws Throwable {
		 driver.get(prop.getProperty("url"));
	    }

	    @Then("^Verify user is able to click on continue button$")
	    public void verify_user_is_able_to_click_on_continue_button() throws Throwable {
	    	 ycp = new YourCartPage(driver);
	    	 ycp.clickoncontinuebutton();;
	   	     Assert.assertTrue(ycp.verifyproductpage());
	    }

	    @Then("^Verify user is able to click on checkout button$")
	    public void verify_user_is_able_to_click_on_checkout_button() throws Throwable {
	    	 ycp = new YourCartPage(driver);
	    	 ycp.clickoncheckoutbutton();
	   	     Assert.assertTrue(ycp.verifyyourinformationpage());
	    }

	    @And("^Login using given credentials for displaying your cart$")
	    public void login_using_given_credentials_for_displaying_your_cart() throws Throwable {
	    	loginPage=new LoginPage(driver);
	    	loginPage.enterusername(prop.getProperty("validusername"));
	        loginPage.enterpassword(prop.getProperty("validpassword"));
	        loginPage.clickonlogginbutton();
	    }

	    @And("^User have to select a product and user click on the go to cart icon$")
	    public void user_have_to_select_a_product_and_user_click_on_the_go_to_cart_icon() throws Throwable {
	         loginPage.clickonaddtocart();
	         loginPage.clickongotocart();
	    }
	  

}

