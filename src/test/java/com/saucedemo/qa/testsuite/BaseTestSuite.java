package com.saucedemo.qa.testsuite;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTestSuite {
	
	ChromeDriver driver = null;
	
	@BeforeMethod
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/sunilduvvuru/Documents/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
	
	protected void waitForSomeSeconds(int waitSeconds) throws InterruptedException {
		Thread.sleep(waitSeconds*1000);
		
	}

}
