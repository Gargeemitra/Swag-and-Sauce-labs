package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
     
WebDriver driver;
    
	public YourCartPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='cart_desc_label']")
	private WebElement showoption;
	
	@FindBy(xpath="//button[@id='continue-shopping']")
	 WebElement continuebutton;
	
	@FindBy(xpath="//button[@id='checkout']")
    WebElement checkoutbutton;
	
	 @FindBy(xpath="//span[@class='title']")
	 WebElement productpage;
	 
	 @FindBy(xpath="//span[text()='Checkout: Your Information']")
	  WebElement yourinformationpagedisplayed;
	 
	
	public void clickoncontinuebutton() {
		continuebutton.click();
	}
	
	 public void clickoncheckoutbutton() {
		 checkoutbutton.click();
	}
	
	


	public boolean displaytheoption() {
		return showoption.isDisplayed();
		
	}
	
	public boolean verifyproductpage() {
		return productpage.isDisplayed();
	}
	
	public boolean verifyyourinformationpage() {
		 return yourinformationpagedisplayed.isDisplayed();
	
	}
}
