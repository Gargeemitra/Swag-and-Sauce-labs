package tests;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LoginPage;
import pageobjects.YourCartPage;

//Login for showing the product
public class LoginTest extends Base {
    
    public WebDriver driver;
    
    @BeforeMethod
    public void setup() throws IOException {
    	driver = initializeBrowser();
        driver.get(prop.getProperty("url"));
       
        }
   
     
     @Test()
     public void LoginWithValidCredentials() throws InterruptedException  {
         LoginPage loginPage = new LoginPage(driver);
         loginPage.enterusername(prop.getProperty("validusername"));
         loginPage.enterpassword(prop.getProperty("validpassword"));
         loginPage.clickonlogginbutton();
         Thread.sleep(2000);
         loginPage.clickonaddtocart();
         Thread.sleep(2000);
         YourCartPage ycp = loginPage.clickongotocart();
    
         Assert.assertTrue(ycp.displaytheoption());
       
     }
     @AfterMethod
     public void tearDown() {
    	 if(driver!=null) {
    	 driver.quit();
     }
     }  
}