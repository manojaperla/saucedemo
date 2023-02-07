package com.saucedemo.qa.dp;

import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.saucedemo.qa.data.ExcelDataInformation;
import com.saucedemo.qa.data.ReadWriteDataInExcel;

public class DataManagement {

	public final String FILE_NAME =  "src/test/resources/TestData/TestData.xlsx";
	
	@DataProvider(name = "sauceDemoData")
	public Object[] sauceDemoData() {
		
		ExcelDataInformation excelDataInformation = new ExcelDataInformation(FILE_NAME, "sauce");
		ReadWriteDataInExcel readWriteDataInExcel = new ReadWriteDataInExcel(excelDataInformation);
		
		//List<Map<String, String>> ls = readWriteDataInExcel.getDataRowsByCondition("TestCaseName=Test_01");
		List<Map<String, String>> ls = readWriteDataInExcel.getAllDataRows();

		
		Object[] retObject = new Object[ls.size()];
		ls.toArray(retObject);

		return retObject;
	}
	 

	
	
}
