package ecommerce.shopping;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverSetup {
	//WebDriver driver;
		
	public WebDriver setUpDriver(String driverName){
		WebDriver driver;
		int num = 2;
		switch(num){
			case 1:
				driver = new FirefoxDriver();
				break;
			case 2:
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
						"\\src\\test\\java\\ecommerce\\testResources\\chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");
				 
				driver = new ChromeDriver(chromeOptions);
				break;
				default:
					driver = new InternetExplorerDriver();
					break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

}
