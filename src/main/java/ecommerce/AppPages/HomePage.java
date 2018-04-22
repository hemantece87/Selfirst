package ecommerce.AppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	@FindBy(how = How.ID, using="search_query_top")
	private WebElement searchBox;
		
	@FindBy(how = How.XPATH, using="//form[@id='searchbox']/button")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ProductPages searchItem(String searchText) {
		searchBox.sendKeys(searchText);
		searchButton.click();
		return new ProductPages(driver);
	}
	
	public LoginPage clickLoginButton() {
		return new LoginPage(driver);
	}
}
