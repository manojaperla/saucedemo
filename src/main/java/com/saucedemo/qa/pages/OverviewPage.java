package com.saucedemo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
	
	WebDriver driver = null;
	
	public OverviewPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void completeTheOrder() {
		driver.findElement(By.id("finish")).click();
	}

}
