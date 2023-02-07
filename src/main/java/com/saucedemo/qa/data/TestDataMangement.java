package com.saucedemo.qa.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.*;
public class TestDataMangement {
	
	
	public final static String FILE_NAME =  "src/test/resources/TestData/TestData.xlsx";



	public static void main(String[] args)  {
		
		ExcelDataInformation excelDataInformation = new ExcelDataInformation(FILE_NAME, "sauce");
		ReadWriteDataInExcel readWriteDataInExcel = new ReadWriteDataInExcel(excelDataInformation);
		
		List<Map<String, String>> ls = readWriteDataInExcel.getAllDataRows();
		
		System.out.println(ls.size());
		for(Map<String, String> rowInfo: ls) {
			System.out.println(rowInfo.toString());
		}
	}
	
	
	private void readExcelDataExpaple() throws Exception {
		FileInputStream file=new FileInputStream("src/test/resources/TestData/TestData.xlsx");

		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		
		XSSFSheet sheet=workbook.getSheet("sauce");//with Sheet No
		
		
	 // XSSFSheet sheet=workbook.getSheetAt(0); //with sheet index
		int rowcount=sheet.getLastRowNum();
    	int colcount =sheet.getRow(0).getLastCellNum();
    	
    	System.out.println(rowcount);
    	System.out.println(colcount);
    	
    	for(int i=0;i<=rowcount;i++)
    	{
    		XSSFRow currentrow=sheet.getRow(i);
    	
    		for(int j=0;j<colcount;j++)
    		{
    		    System.out.print(currentrow.getCell(j).getStringCellValue()+"|| ");
    		}
    		System.out.println();
    	}
		 
	
	}
		

}
