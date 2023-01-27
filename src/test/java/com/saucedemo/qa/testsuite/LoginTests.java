package com.saucedemo.qa.testsuite;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.LoginClass;

public class LoginTests {
	
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
	public void loginTestFor_standard_user() {
		LoginClass loginClass = new LoginClass(driver);
		loginClass.loginTestCase("standard_user");
	}
	
	
	@Test
	public void loginTest_problem_user() {
		LoginClass loginClass = new LoginClass(driver);
		loginClass.loginTestCase("problem_user");
	}
	
	@Test
	public void loginTest_performance_glitch_user() {
		LoginClass loginClass = new LoginClass(driver);
		loginClass.loginTestCase("performance_glitch_user");
	}
	
	
	

}
