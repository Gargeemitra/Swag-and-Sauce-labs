package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.CheckoutYourInformationPage;
import pageobjects.LoginPage;
import pageobjects.YourCartPage;

public class CheckoutYourInformation extends Base {
	public  WebDriver driver; 
	 
	LoginPage loginPage ;
	YourCartPage ycp ;
	CheckoutYourInformationPage checkpage;
	
	
	 @BeforeMethod
     public void setup() throws InterruptedException, IOException {
     driver = initializeBrowser();
    
     loginPage= new LoginPage(driver);
     ycp = new YourCartPage(driver);
     driver.get(prop.getProperty("url"));
     
   	
     loginPage.enterusername(prop.getProperty("validusername"));
     loginPage.enterpassword(prop.getProperty("validpassword"));
     loginPage.clickonlogginbutton();
     loginPage.clickonaddtocart();
     loginPage.clickongotocart();
     ycp.clickoncheckoutbutton();
  	 Thread.sleep(1000);
  	checkpage = new CheckoutYourInformationPage(driver);
     }  
	 
	 
	 @Test(priority=1)
  	 public void continuewithvalidcredentials() throws InterruptedException {
		
		checkpage.enterfirstname(prop.getProperty("validfirstname"));
		checkpage.enterlastname(prop.getProperty("validlastname"));
		checkpage.enterpostalcode(prop.getProperty("validpostalcode"));
		Thread.sleep(2000);
		checkpage.clickoncontinueofinformationpage();
		Assert.assertTrue(checkpage.displayfinishpage());
  	 }
	 
	 @Test(priority=2)
  	 public void continuewithinvalidcredential() throws InterruptedException {
		checkpage.enterfirstname(prop.getProperty("invalidfirstname"));
		checkpage.enterlastname(prop.getProperty("invalidlastname"));
		checkpage.enterpostalcode(prop.getProperty("invalidpostalcode"));
		Thread.sleep(2000);
		checkpage.clickoncontinueofinformationpage();
		Assert.assertFalse(checkpage.displayfinishpage());
  	 }
	 
	 @Test(priority=3)
  	 public void continuewithnocredentials() throws InterruptedException {
		
		checkpage.clickoncontinueofinformationpage();
		Thread.sleep(2000);
		Assert.assertTrue(checkpage.displayerrormessage());
  	 }
	 
  	 
  	 @AfterMethod
  	 public void tearDown() {
  		 if(driver!=null)
  			 driver.quit();
  	 }
}

