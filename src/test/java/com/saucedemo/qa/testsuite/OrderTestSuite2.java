package com.saucedemo.qa.testsuite;

import org.testng.annotations.Test;

import com.saucedemo.qa.pages.CheckoutPage;
import com.saucedemo.qa.pages.InformationPage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.OrderCompletionPage;
import com.saucedemo.qa.pages.OverviewPage;
import com.saucedemo.qa.pages.ProductPage;

public class OrderTestSuite2 extends BaseTestSuite {
	

	
	@Test
	public void createOrderForBikeLight() throws InterruptedException {
		//Login
		LoginPage login = new LoginPage(this.driver);
		login.doLogin("standard_user");
		waitForSomeSeconds(3);
		
		
		//Add Product to Order
		ProductPage productPage = new ProductPage(this.driver);
		productPage.addItemCart("Sauce Labs Bike Light");
		productPage.addItemCart("Sauce Labs Backpack");
		productPage.checkout();
		waitForSomeSeconds(3);
		
		try {
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			checkoutPage.doCheckout();
			waitForSomeSeconds(3);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		//Checkout
		
		//Information
		InformationPage ip = new InformationPage(driver);
		ip.addInfrormationAndContinue("John", "Doe", "12345");
		waitForSomeSeconds(3);
		
		
		//OverView
		OverviewPage op = new OverviewPage(driver);
		op.completeTheOrder();
		waitForSomeSeconds(3);
		
		//Completed back to Home
		OrderCompletionPage oc = new OrderCompletionPage(driver);
		oc.backToHome();
		waitForSomeSeconds(3);
		
		//Logoff
		productPage = new ProductPage(this.driver);
		productPage.doLogoff();
		
		
	}


}
