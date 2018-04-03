package ecommerce.AppPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPages {

WebDriver driver;
	
	@FindBy(how = How.ID, using="search_query_top")
	private WebElement searchBox;
		
	@FindBy(how = How.XPATH, using="//form[@id='searchbox']/button")
	private WebElement searchButton;
	
	@FindBy(how = How.ID, using="SubmitLogin")
	private WebElement submitButton;
	
	@FindBy(how = How.CLASS_NAME, using="logout")
	private WebElement logoutButton;
	
	@FindBy(css = ".product-image-container")
	private List<WebElement> listProducts;
	
	
	public ProductPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchItem(String searchText) {
		searchBox.sendKeys(searchText);
		searchButton.click();
	}
	
	public boolean verifySearchResults() {
		if(listProducts.size() > 0) {
		return true;	
		} else
		    return false;
	}
	
	public void addToCart(String item){
		
	}
}
