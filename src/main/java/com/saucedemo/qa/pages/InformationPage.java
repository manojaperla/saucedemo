package com.saucedemo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationPage {
	
	WebDriver driver = null;
	
	public InformationPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void addInfrormationAndContinue(String firstName, String lastName, String zipCode) {
		
		driver.findElement(By.id("first-name")).sendKeys(firstName);
		driver.findElement(By.id("last-name")).sendKeys(lastName);
		driver.findElement(By.id("postal-code")).sendKeys(zipCode);
		
		driver.findElement(By.id("continue")).click();
	}

}
