package ecommerce.AppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
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
	
	public void loginUser(String userName, String password) {
		System.out.println(emailID.getAttribute("name"));
		emailID.sendKeys(userName);
		passwordEle.sendKeys(password);
		submitButton.click();
	}

	public void logout() {
		logoutButton.click();
	}
}
