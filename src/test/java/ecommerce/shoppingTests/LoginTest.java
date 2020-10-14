package ecommerce.shoppingTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;

import ecommerce.AppPages.LoginPage;
import ecommerce.shopping.DriverSetup;
import ecommerce.shopping.PropertyReader;

public class LoginTest {

	WebDriver driver;
	DriverSetup driSetUp;
	LoginPage loginObj;
	
	@BeforeClass
	public void setUpDriver(){
		String driverName = "CH";
		driSetUp = new DriverSetup();
		driver = driSetUp.setUpDriver(driverName);
		/*
		 * Wait wait = new FluentWait(driver). withTimeout(20, TimeUnit.SECONDS).
		 * pollingEvery(200, TimeUnit.MILLISECONDS). ignoring(Exception.class);
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,1000)");
		 * 
		 * js.executeScript("arguement[0].click;", button1);
		 * js.executeScript("alert('welcome to Test');");
		 * js.executeScript("return document.title;");
		 */
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
		    Assert.assertEquals(driver.getTitle(), "My account - My Store");
		    loginObj.logout();
		} else {
			Assert.assertEquals(driver.getTitle(), "Login - My Store");
		}
	}
	
	@DataProvider
	public Object[][] loginTestData(){
		Object[][] a = { {"Hemant", "Badaya", false},
				{"hemantb_net@yahoo.co.in", "Sondes@123", true},
				{"Hemant", "Bahaar", false},
				{"TestInvalid", "Pwdinvalis", false}
		};
		return a;
	}
	
	@AfterClass
	public void tearDown(){
	    driver.manage().deleteAllCookies();
	    driver.quit();
	}
}