package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
    
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="user-name")
	private WebElement usernamefield;
	
	@FindBy(name="password")
	private WebElement passwordfield;
	
	@FindBy(css="#login-button")
	private WebElement loginbutton;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement addtocart;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement gotocart;
	
	public void enterusername(String usernametext) {
		usernamefield.sendKeys(usernametext);
	}
	
	public void enterpassword(String passwordtext) {
		passwordfield.sendKeys(passwordtext);
	}
	
	public void clickonlogginbutton() {
		loginbutton.click();
	}
	
	public void clickonaddtocart() {
		addtocart.click();
	}
	
	public YourCartPage clickongotocart() {
		gotocart.click();
		return new YourCartPage(driver);
		
	}
}

