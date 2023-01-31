package com.saucedemo.qa.pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	
	WebDriver driver = null;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void takePageScreenshot(String fileWithPath) {
		TakesScreenshot screenImage = (TakesScreenshot) driver;
		File file = screenImage.getScreenshotAs(OutputType.FILE);
		
		File DestFile=new File(fileWithPath);
		try {
			FileUtils.copyFile(file, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void javaScriptMethod(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void goToSecondWindow() {
		//How to move to second browser
		String firstHandle = driver.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
		for(String window: allWindows) {
			if(firstHandle.equalsIgnoreCase(window)) {
				continue;
			}else {
				driver.switchTo().window(window);
				break;
			}
		}
		
		driver.close();
		
		driver.switchTo().window(firstHandle);
	}
	
	public void readDataFromTable() {
		List<Map<String, String>> allRowsData = new ArrayList<Map<String, String>>();
		
		//find total rows
		List<WebElement> allRows = driver.findElements(By.xpath("//table/tr"));
		List<WebElement> allColumns = driver.findElements(By.xpath("//table/tr/td"));
		
		for(int i=1; i<=allRows.size(); i++) {
			String sNo = driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText();
			String orderNumber = driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText();
			String orderDate = driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText();
			String orderAmount = driver.findElement(By.xpath("//table/tr["+i+"]/td[4]")).getText();
			Map<String, String> rowData = new HashMap<String, String>();
			rowData.put("sNo", sNo);
			rowData.put("orderNumber", orderNumber);
			rowData.put("orderDate", orderDate);
			rowData.put("orderAmount", orderAmount);
			allRowsData.add(rowData);
		}
		
		
		
	}

}
