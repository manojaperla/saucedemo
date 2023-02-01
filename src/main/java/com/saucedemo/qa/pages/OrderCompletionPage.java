package com.saucedemo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCompletionPage extends BasePage {
	
	public OrderCompletionPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void backToHome() {
		driver.findElement(By.id("back-to-products")).click();
	}


}
