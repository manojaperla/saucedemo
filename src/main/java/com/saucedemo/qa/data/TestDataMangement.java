package com.saucedemo.qa.data;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.*;
public class TestDataMangement {

	public static void main(String[] args) throws Exception {
		FileInputStream file=new FileInputStream("C:\\Users\\sivab\\git\\"
				+ "saucedemo\\saucedemo\\src\\test\\resources\\TestData\\TestData.xlsx");

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
