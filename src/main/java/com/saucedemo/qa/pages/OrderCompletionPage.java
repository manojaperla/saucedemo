package com.saucedemo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCompletionPage {
	
	WebDriver driver = null;
	
	public OrderCompletionPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void backToHome() {
		driver.findElement(By.id("back-to-products")).click();
	}


}
