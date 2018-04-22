package ecommerce.shoppingTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ecommerce.AppPages.HomePage;
import ecommerce.AppPages.LoginPage;
import ecommerce.AppPages.ProductPages;
import ecommerce.shopping.DriverSetup;
import ecommerce.shopping.PropertyReader;

public class ProductSearch {
	WebDriver driver;
	DriverSetup driSetUp;
	LoginPage loginObj;
	ProductPages productObj = new ProductPages(driver);
	HomePage homePageObj = new HomePage(driver);
	
	@BeforeClass
	public void setUpDriver(){
		String driverName = "CH";
		driSetUp = new DriverSetup();
		driver = driSetUp.setUpDriver(driverName);
	}
	
	@Test
	public void searchItemAndVerifyResults() {
		driver.get(PropertyReader.readProperty("shoppingPageURL"));
		loginObj = new LoginPage(driver);
		
		homePageObj = loginObj
			.clickLoginButton()
			.loginUser(PropertyReader.readProperty("username"), PropertyReader.readProperty("password"));
		
		homePageObj.searchItem("printed chiffon dress");
	}

	@AfterClass
	public void tearDown(){
	   // driver.manage().deleteAllCookies();
	    //driver.quit();
	}
}
