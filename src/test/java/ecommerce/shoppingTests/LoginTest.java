package ecommerce.shoppingTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import ecommerce.AppPages.LoginPage;
import ecommerce.shopping.DriverSetup;
import ecommerce.shopping.PropertyReader;;

public class LoginTest {

	WebDriver driver;
	DriverSetup driSetUp;
	LoginPage loginObj;
	
	@BeforeClass
	public void setUpDriver(){
		String driverName = "CH";
		driSetUp = new DriverSetup();
		driver = driSetUp.setUpDriver(driverName);
	}
	
	@Test(dataProvider = "loginTestData")
	public void loginTest(String userName, String password, boolean isTrue){
		
		loginObj = new LoginPage(driver);
		//Navigate to Login page
		driver.get(PropertyReader.readProperty("shoppingPageURL"));
		
		loginObj
		    .clickLoginButton()
		    .loginUser(userName, password);
		
		if(isTrue) {
		    Assert.assertEquals("My account - My Store", driver.getTitle());
		    loginObj.logout();
		} else {
			Assert.assertEquals("Login - My Store", driver.getTitle());
		}
	}
	
	@DataProvider
	public Object[][] loginTestData(){
		Object[][] a = { {"Hemant", "Badaya", false},
				{"hemantb_net@yahoo.co.in", "Sondes@123", true},
				{"Hemant", "Bahaar", false}
		};
		return a;
	}
	
	@AfterClass
	public void tearDown(){
	    driver.manage().deleteAllCookies();
	    driver.quit();
	}
}