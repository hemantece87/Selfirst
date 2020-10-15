package ecommerce.shoppingTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ecommerce.AppPages.LoginPage;
import ecommerce.shopping.DriverSetup;

public class BaseTest {
	
	WebDriver driver;
	DriverSetup driSetUp;
	LoginPage loginObj;
	
	@BeforeSuite
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
	
	@AfterSuite
	public void tearDown(){
	   driver.manage().deleteAllCookies();
	   driver.quit();
	}

}
