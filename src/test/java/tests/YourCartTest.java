package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LoginPage;
import pageobjects.YourCartPage;

public class YourCartTest extends Base {
	WebDriver driver; 
	LoginPage loginPage ;
	YourCartPage ycp ;
	 @BeforeMethod
     public void setup() throws InterruptedException, IOException {
     driver = initializeBrowser();
     driver.get(prop.getProperty("url"));
     loginPage= new LoginPage(driver);
     ycp = new YourCartPage(driver);
   	 
   	
    loginPage.enterusername(prop.getProperty("validusername"));
    loginPage.enterpassword(prop.getProperty("validpassword"));
    loginPage.clickonlogginbutton();
    loginPage.clickonaddtocart();
    loginPage.clickongotocart();

   	Thread.sleep(2000);
	}
     @Test(priority=1)
     public void clickoncontinue() throws InterruptedException {
    	  
    	 ycp.clickoncontinuebutton();
    	 Thread.sleep(2000);
    	 Assert.assertTrue(ycp.verifyproductpage());
    	 
     }
     @Test(priority=2)
     public void clickoncheckout() throws InterruptedException {
    	
    	 ycp.clickoncheckoutbutton();
    	 Thread.sleep(2000);
    	 Assert.assertTrue(ycp.verifyyourinformationpage());
     }
     @AfterMethod
     public void tearDown() {
    	 if(driver!=null) {
    	 driver.quit();
     }
     }  
}
