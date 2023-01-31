package com.saucedemo.qa.testsuite;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.pages.LoginPage;

public class CheckStaleElementIssues {
	
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
	
	@Test
	public void staleelementTest() {
		//Login
		LoginPage login = new LoginPage(this.driver);
		login.doLogin("standard_user");
		login = new LoginPage(this.driver);
		login.doLogin2("standard_user");
		
		
		
	}

}
