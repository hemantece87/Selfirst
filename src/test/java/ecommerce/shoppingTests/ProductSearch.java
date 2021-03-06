package ecommerce.shoppingTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ecommerce.AppPages.HomePage;
import ecommerce.AppPages.LoginPage;
import ecommerce.AppPages.ProductPages;
import ecommerce.shopping.PropertyReader;

public class ProductSearch extends BaseTest {
	
	LoginPage loginObj;
	ProductPages productObj = new ProductPages(driver);
	HomePage homePageObj = new HomePage(driver);
	
	/*
	 * @BeforeClass public void setUpDriver(){ String driverName = "CH"; driSetUp =
	 * new DriverSetup(); driver = driSetUp.setUpDriver(driverName); }
	 */
	
	
	@Test
	public void searchItemAfterLoginAndVerifyResults() {
	  driver.get(PropertyReader.readProperty("shoppingPageURL")); 
	  loginObj = new LoginPage(driver);
	  
	  homePageObj = loginObj .clickLoginButton()
	  .loginUser(PropertyReader.readProperty("username"),
	  PropertyReader.readProperty("password"));
	  
	  homePageObj.searchItem("printed chiffon dress");
	  
	  }
	 
	
	@Test
	public void searchItemWithoutLoginAndVerifyResults() {
		driver.get(PropertyReader.readProperty("shoppingPageURL"));
		
		homePageObj.searchItem("printed chiffon dress");
		//Assert.assertEquals(expected, actual);\
		//productObj.hoverToCategory();
	}

	/*
	 * @AfterClass public void tearDown(){ driver.manage().deleteAllCookies();
	 * driver.quit(); }
	 */
}
