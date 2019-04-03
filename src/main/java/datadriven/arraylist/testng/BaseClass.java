package datadriven.arraylist.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/mosudahmed/Desktop/Selenium/selenium-necessary/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.target.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		
	}
	
	@AfterTest
	public void closeBrowser()

	{
		//driver.quit();
		
	}
}
