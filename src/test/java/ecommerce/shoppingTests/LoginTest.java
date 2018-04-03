package ecommerce.shoppingTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ecommerce.AppPages.HomePage;
import ecommerce.AppPages.LoginPage;
import ecommerce.AppPages.ProductPages;
import ecommerce.shopping.DriverSetup;

public class LoginTest {

	WebDriver driver;
	DriverSetup driSetUp;
	LoginPage loginObj;
	ProductPages productObj;
	HomePage homePageObj;
	
	Properties property;
	String userName = "";
	String password = "";
	String shoppingPageURL = "http:/automationpractice.com";
	
	@BeforeTest
	public void setUpDriver(){
		String driverName = "CH";
		driSetUp = new DriverSetup();
		driver = driSetUp.setUpDriver(driverName);
		try {
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		property.load(fs);
		userName = property.getProperty("username");
		password = property.getProperty("password");
		} catch(IOException e) {
			System.out.println("Config file could not be read");
		}
	}
	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String userName, String password, boolean isTrue){
		//Navigate to Home page
		driver.get(shoppingPageURL);
		
		homePageObj = new HomePage(driver);
		homePageObj.clickLoginButton();
		
		loginObj = new LoginPage(driver);
		loginObj.loginUser(userName, password);
		
		if(isTrue) {
		    Assert.assertEquals("My account - My Store", driver.getTitle());
		    loginObj.logout();
		} else {
			Assert.assertEquals("Login - My Store", driver.getTitle());
		}
	}
	
	@Test
	public void searchItemAndVerifyResults() {
		loginObj = new LoginPage(driver);
		loginObj.loginUser(userName, password);
		
		productObj = new ProductPages(driver);
		productObj.searchItem("printed chiffon dress");
		
		
	}
	
	@DataProvider
	public Object[][] loginTestData(){
		Object[][] a = { {"Hemant", "Badaya", false},
				{"hemantb_net@yahoo.co.in", "Sondes@123", true},
				{"Hemant", "Bahaar", false}
		};
		return a;
	}
	
	@AfterTest
	public void tearDown(){
	driver.quit();
	}
}