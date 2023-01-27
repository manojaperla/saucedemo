package com.saucedemo.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	
	WebDriver driver = null;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void addItemCart(String itemName) {
		driver.findElement(By.xpath("//div[text()='"+itemName+"']/../../..//button[text()='Add to cart']")).click();
	}
	
	public void checkout() {
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a")).click();
	}
	
	public void doLogoff() {
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
