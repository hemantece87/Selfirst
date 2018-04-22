package ecommerce.AppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(className="login")
	private WebElement loginLink;
	
	@FindBy(id="email")
	private WebElement emailID;
		
	@FindBy(id="passwd")
	private WebElement passwordEle;
	
	@FindBy(id="SubmitLogin")
	private WebElement submitButton;
	
	@FindBy(className="logout")
	private WebElement logoutButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickLoginButton() {
		loginLink.click();
		return this;
	}

	public HomePage loginUser(String userName, String password) {
		emailID.sendKeys(userName);
		passwordEle.sendKeys(password);
		submitButton.click();
		return new HomePage(driver);
	}

	public LoginPage logout() {
		logoutButton.click();
		return this;
	}
}
