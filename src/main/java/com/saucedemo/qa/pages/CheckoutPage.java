package com.saucedemo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	WebDriver driver = null;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void doCheckout() {
		driver.findElement(By.xpath("//button[@id='checkout']")).click();

	}

}
