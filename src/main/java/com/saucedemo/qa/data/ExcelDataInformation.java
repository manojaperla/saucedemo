package com.saucedemo.qa.data;

public class ExcelDataInformation {
	
	private String xlFileName;
	private String xlSheetName;
	
	public ExcelDataInformation(String xlFileName, String xlSheetName){
		this.xlFileName = xlFileName;
		this.xlSheetName = xlSheetName;
	}
	
	@Override
	public String toString(){
		return "xlFileName: " + getXlFileName() + ", xlSheetName: " + getXlSheetName();
	}
	
	public String getXlFileName() {
		return xlFileName;
	}
	public void setXlFileName(String xlFileName) {
		this.xlFileName = xlFileName;
	}
	public String getXlSheetName() {
		return xlSheetName;
	}
	public void setXlSheetName(String xlSheetName) {
		this.xlSheetName = xlSheetName;
	}



}
