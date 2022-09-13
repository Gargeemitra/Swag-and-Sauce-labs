package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYourInformationPage {
     
   WebDriver driver;
    
	public CheckoutYourInformationPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="first-name")
	private WebElement firstnamefield;
	
	@FindBy(id="last-name")
	private WebElement lastnamefield;
	
	@FindBy(name="postalCode")
	private WebElement postalcodefield;
	
	@FindBy(id="continue")
	WebElement secondcontinuebutton;
	
	@FindBy(xpath="//span[@class='title']")
	 WebElement showpage;
	
	@FindBy(xpath="//div[@class='error-message-container error']")
	 WebElement showerror;
	
	
	public void enterfirstname(CharSequence firstnametext) {
		firstnamefield.sendKeys(firstnametext);
	}
	
	public void enterlastname(CharSequence lastnametext) {
		lastnamefield.sendKeys(lastnametext);
	}
	
	public void enterpostalcode(CharSequence postalcode) {
		postalcodefield.sendKeys(postalcode);
	}
	
	public void clickoncontinueofinformationpage() {
		secondcontinuebutton.click();
	}
	public boolean displayfinishpage() {
	  return showpage.isDisplayed();
	}
	
	public boolean displayerrormessage() {
		return showerror.isDisplayed();
	}	
}
