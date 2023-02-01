package com.saucedemo.qa.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutPage extends BasePage {
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public void doCheckout() {
		
		takePageScreenshot("src/main/resources/abc.png");
		
		
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
	}

}
