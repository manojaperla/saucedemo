package com.saucedemo.qa.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="user-name")
	WebElement txtUserName;
	
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="login-button")
	WebElement btnLogin;
	
	
	public void doLogin(String userName) {
		txtUserName.sendKeys(userName);
		txtPassword.sendKeys("sdfdsfds");
		javaScriptMethod(btnLogin);
		
		
		
	}
	
	public void doLogin2(String userName) {
		txtUserName.sendKeys(userName);
		txtPassword.sendKeys("secret_sauce");
		btnLogin.click();
	}
	
	
	
}
