package com.saucedemo.qa.testsuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTestSuite {
	
	
	ChromeDriver driver = null;
	
	public static Properties appProperties = null;
	
	
	@BeforeSuite
	public void BeforeSuite() {
        try (InputStream input = new FileInputStream("src/test/resources/app.properties")) {

        	appProperties = new Properties();

            // load a properties file
        	appProperties.load(input);

            // get the property value and print it out
            String envName = appProperties.getProperty("app.env");
            
            InputStream input1 = new FileInputStream("src/test/resources/"+envName+"/env.properties");
            appProperties.load(input1);
            
            System.out.println(appProperties.getProperty("app.url"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

		
	}
	
	
	@BeforeMethod
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/sunilduvvuru/Documents/chromedriver");
		
		driver = new ChromeDriver();
		driver.get(appProperties.getProperty("app.url"));
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
	
	protected void waitForSomeSeconds(int waitSeconds) throws InterruptedException {
		Thread.sleep(waitSeconds*1000);
		
	}

}
