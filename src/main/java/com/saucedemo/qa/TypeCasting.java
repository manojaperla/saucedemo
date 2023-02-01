package com.saucedemo.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TypeCasting {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sunilduvvuru/Documents/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		ChromeDriver cd = (ChromeDriver) driver;

	}

}
