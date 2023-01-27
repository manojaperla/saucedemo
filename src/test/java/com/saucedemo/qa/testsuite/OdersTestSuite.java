package com.saucedemo.qa.testsuite;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucedemo.qa.pages.CheckoutPage;
import com.saucedemo.qa.pages.InformationPage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.OrderCompletionPage;
import com.saucedemo.qa.pages.OverviewPage;
import com.saucedemo.qa.pages.ProductPage;

public class OdersTestSuite {
	
	ChromeDriver driver = null;
	
	@BeforeMethod
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/sunilduvvuru/Documents/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void createOrderForBikeLight() {
		//Login
		LoginPage login = new LoginPage(this.driver);
		login.doLogin("standard_user");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//Add Product to Order
		ProductPage productPage = new ProductPage(this.driver);
		productPage.addItemCart("Sauce Labs Bike Light");
		productPage.addItemCart("Sauce Labs Backpack");
		productPage.addItemCart("Sauce Labs Fleece Jacket");
		productPage.checkout();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Checkout
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.doCheckout();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Information
		InformationPage ip = new InformationPage(driver);
		ip.addInfrormationAndContinue("John", "Doe", "12345");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//OverView
		OverviewPage op = new OverviewPage(driver);
		op.completeTheOrder();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Completed back to Home
		OrderCompletionPage oc = new OrderCompletionPage(driver);
		oc.backToHome();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Logoff
		productPage = new ProductPage(this.driver);
		productPage.doLogoff();
		
		
	}

}
