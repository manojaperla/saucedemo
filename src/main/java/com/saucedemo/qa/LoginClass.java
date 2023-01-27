package com.saucedemo.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginClass {
	
	WebDriver driver = null;
	
	public LoginClass(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginTestCase(String userName) {
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
