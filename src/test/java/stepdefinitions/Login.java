package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageobjects.LoginPage;
import pageobjects.YourCartPage;

public class Login extends Base {

	WebDriver driver;
	LoginPage loginPage;
	YourCartPage ycp ;
	@Before("@login")
	public void setup() throws IOException {
		 driver = initializeBrowser();
	}
	@After("@login")
	public void closure() {
		if(driver!=null)
			driver.quit();
	}
	
	 @Given("^Open the Application in any browser for login$")
	    public void open_the_application_in_any_browser_for_login() throws IOException  {
		   
	        driver.get(prop.getProperty("url"));
	    }

	    @When("^User enters username as  standard_user  and password as secret_sauce$")
	    public void user_enters_username_as_and_password_as()  {
	         loginPage = new LoginPage(driver);
	         loginPage.enterusername(prop.getProperty("validusername"));
	         loginPage.enterpassword(prop.getProperty("validpassword"));
	    }

	    @Then("^Verify user is able to see the selected product in your cart option$")
	    public void verify_user_is_able_to_see_the_selected_product_in_your_cart()  {
	    	 ycp = loginPage.clickongotocart();
	         Assert.assertTrue(ycp.displaytheoption());
	    }

	    @And("^User clicks on Login button$")
	    public void user_clicks_on_login_button()  {
	    	loginPage.clickonlogginbutton();
	    }

	    @And("^User select an item from product page$")
	    public void user_select_an_item_from_product_page()  {
	    	loginPage.clickonaddtocart();
	    }

}
