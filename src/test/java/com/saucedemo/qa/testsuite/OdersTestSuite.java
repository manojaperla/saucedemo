package com.saucedemo.qa.testsuite;

import java.util.Map;

import org.testng.annotations.Test;

import com.saucedemo.qa.dp.DataManagement;
import com.saucedemo.qa.pages.CheckoutPage;
import com.saucedemo.qa.pages.InformationPage;
import com.saucedemo.qa.pages.LoginPage;
import com.saucedemo.qa.pages.OrderCompletionPage;
import com.saucedemo.qa.pages.OverviewPage;
import com.saucedemo.qa.pages.ProductPage;

public class OdersTestSuite extends BaseTestSuite {
	
	@Test(dataProvider = "sauceDemoData", dataProviderClass = DataManagement.class)
	public void createOrderForBikeLight(Map<String, String> testData) throws InterruptedException {
		System.out.println(testData);
		
		//Login
		LoginPage login = new LoginPage(this.driver);
		login.doLogin(testData.get("UserName"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		//Add Product to Order
		ProductPage productPage = new ProductPage(this.driver);
		productPage.addItemCart(testData.get("Product_1"));
		productPage.addItemCart(testData.get("Product_2"));
		productPage.addItemCart(testData.get("Product_3"));
		productPage.checkout();
		waitForSomeSeconds(3);
		
		//Checkout
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.doCheckout();
		waitForSomeSeconds(3);
		
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
