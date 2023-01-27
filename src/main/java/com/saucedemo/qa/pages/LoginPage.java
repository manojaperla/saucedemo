package com.saucedemo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver = null;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void doLogin(String userName) {
		this.driver.findElement(By.id("user-name")).sendKeys(userName);
		this.driver.findElement(By.id("password")).sendKeys("secret_sauce");
		this.driver.findElement(By.id("login-button")).click();
	}
	
	
}
