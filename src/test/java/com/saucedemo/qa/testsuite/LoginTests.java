package com.saucedemo.qa.testsuite;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
		loginTestCase("standard_user");
	}
	
	
	@Test
	public void loginTest_problem_user() {
		loginTestCase("problem_user");
	}
	
	@Test
	public void loginTest_performance_glitch_user() {
		loginTestCase("performance_glitch_user");
	}
	
	
	private void loginTestCase(String userName) {
		//Login Here
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();;
		
		
		//driver.switchTo().alert().accept();

		driver.findElement(By.id("react-burger-menu-btn")).click();
		
		driver.findElement(By.id("logout_sidebar_link")).click();;
		
		System.out.println(driver.findElement(By.id("login_button_container")).isDisplayed());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
