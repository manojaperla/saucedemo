package com.saucedemo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {
	
	public OverviewPage(WebDriver driver) {
		super(driver);
	}
	
	public void completeTheOrder() {
		driver.findElement(By.id("finish")).click();
	}

}
