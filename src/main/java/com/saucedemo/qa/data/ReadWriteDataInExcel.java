package com.saucedemo.qa.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;



public class ReadWriteDataInExcel extends ExcelGeneral {
	
	public ReadWriteDataInExcel(ExcelDataInformation excelDataInformation){
		super(excelDataInformation);
	}


	public List<Map<String, String>> getDataRowsByCondition(String strExcelQuery){
		List<Map<String, String>> dataList = null;
		if ((strExcelQuery==null) || strExcelQuery.isEmpty()){
			return getAllDataRows();
		}
		
		Map<String, String> excelQueryValues = getQueryDataInMap(strExcelQuery);
		if (excelQueryValues==null){
			return getAllDataRows();
		}
		
		Workbook workbook = getWorkbook();
		if (workbook==null){return dataList;}
		
		Sheet sheet = getSheetByName(workbook);
		if (sheet==null){closeWorkbook(workbook); return dataList;}
		
		List<String> sheetHeadings = getSheetHeadings(sheet);
		if (sheetHeadings==null){closeWorkbook(workbook); return dataList;}
		int totalCoumns = sheetHeadings.size();
		
		Iterator<Row> iterator = sheet.iterator();
		if(iterator.hasNext()){iterator.next();}
		
		for(Map.Entry<String, String> mapEntry : excelQueryValues.entrySet()){
			boolean blnColumnExists = false;
			for(String strHeading: sheetHeadings){
				if (mapEntry.getKey().equalsIgnoreCase(strHeading)){
					blnColumnExists = true;
					break;
				}
			}
			if (!blnColumnExists){
				return dataList;
			}
		}
		
		dataList = new ArrayList<Map<String, String>>();
		while (iterator.hasNext()) {
			Row currentRow = iterator.next();
			Map<String, String> rowData = new HashMap<String, String>();
			boolean blnRowHasData = false;
			boolean blnRowForScript = true;
			
			for(int scCount = 0;scCount<totalCoumns;scCount++){
				Cell currentCell = currentRow.getCell(scCount);
				String cellValue = getCellValueToString(currentCell);
				if(cellValue!=null){blnRowHasData = true;}
				
				if(excelQueryValues.keySet().contains(sheetHeadings.get(scCount))){
					String strQryStringValue = excelQueryValues.get(sheetHeadings.get(scCount));
					//System.out.println(strQryStringValue + " " + cellValue);
					if ((cellValue==null) && (strQryStringValue==null)) {
						if (blnRowForScript) {
							blnRowForScript = true;
							break;
						}
					}else if (!strQryStringValue.equalsIgnoreCase(cellValue)){
							blnRowForScript = false;
							break;
					}
				}
				rowData.put(sheetHeadings.get(scCount), cellValue);
			}
			
			if(blnRowHasData && blnRowForScript){
				dataList.add(rowData);
			}
		}
		closeWorkbook(workbook);
		return dataList;
	}
	
	public List<Map<String, String>> getAllDataRows(){
		List<Map<String, String>> dataList = null;
		
		Workbook workbook = getWorkbook();
		if (workbook==null){return dataList;}
		
		Sheet sheet = getSheetByName(workbook);
		if (sheet==null){closeWorkbook(workbook); return dataList;}
		
		List<String> sheetHeadings = getSheetHeadings(sheet);
		if (sheetHeadings==null){closeWorkbook(workbook); return dataList;}
		int totalCoumns = sheetHeadings.size();
		
		Iterator<Row> iterator = sheet.iterator();
		if(iterator.hasNext()){iterator.next();}
		
		dataList = new ArrayList<Map<String, String>>();
		while (iterator.hasNext()) {
			
			Row currentRow = iterator.next();
			Map<String, String> rowData = new HashMap<String, String>();
			boolean blnRowHasData = false;
			
			for(int scCount = 0;scCount<totalCoumns;scCount++){
				Cell currentCell = currentRow.getCell(scCount);
				String cellValue = getCellValueToString(currentCell);
				if(cellValue!=null){blnRowHasData = true;}
				rowData.put(sheetHeadings.get(scCount), cellValue);
			}
			if(blnRowHasData){
				dataList.add(rowData);
			}else{
				break;
			}
		}
		closeWorkbook(workbook);
		return dataList;
	}
	
	public void setDataRowsByCondition(String strExcelQuery, String strColumnName, String strColumnValue){
		if ((strExcelQuery==null) || strExcelQuery.isEmpty()){
			return;
		}
		if ((strColumnName==null) || strColumnName.isEmpty()){
			return;
		}
		
		Map<String, String> excelQueryValues = getQueryDataInMap(strExcelQuery);
		if (excelQueryValues==null){
			return;
		}
		
		Workbook workbook = getWorkbook();
		if (workbook==null){return;}
		
		Sheet sheet = getSheetByName(workbook);
		if (sheet==null){closeWorkbook(workbook); return;}
		
		List<String> sheetHeadings = getSheetHeadings(sheet);
		if (sheetHeadings==null){closeWorkbook(workbook); return;}
		int totalCoumns = sheetHeadings.size();
		
		Iterator<Row> iterator = sheet.iterator();
		if(iterator.hasNext()){iterator.next();}
		
		for(Map.Entry<String, String> mapEntry : excelQueryValues.entrySet()){
			boolean blnColumnExists = false;
			for(String strHeading: sheetHeadings){
				if (mapEntry.getKey().equalsIgnoreCase(strHeading)){
					blnColumnExists = true;
					break;
				}
			}
			if (!blnColumnExists){
				return;
			}
		}
		
		while (iterator.hasNext()) {
			Row currentRow = iterator.next();
			boolean blnRowHasData = false;
			boolean blnRowForScript = true;
			
			for(int scCount = 0;scCount<totalCoumns;scCount++){
				Cell currentCell = currentRow.getCell(scCount);
				String cellValue = getCellValueToString(currentCell);
				if(cellValue!=null){blnRowHasData = true;}
				
				if(excelQueryValues.keySet().contains(sheetHeadings.get(scCount))){
					String strQryStringValue = excelQueryValues.get(sheetHeadings.get(scCount));
					//System.out.println(strQryStringValue + " " + cellValue);
					if ((cellValue==null) && (strQryStringValue==null)) {
						if (blnRowForScript) {
							blnRowForScript = true;
							break;
						}
					}else if (!strQryStringValue.equalsIgnoreCase(cellValue)){
							blnRowForScript = false;
							break;
					}
				}
			}
			
			if(blnRowHasData && blnRowForScript){
				for(int scCount = 0;scCount<totalCoumns;scCount++){
					if(strColumnName.equals(sheetHeadings.get(scCount))){
						Cell currentCell = currentRow.getCell(scCount);
						currentCell.setCellValue(strColumnValue);
						writeWorkbookData(workbook);
						break;
					}
				}
			}
		}
		
		closeWorkbook(workbook);
	}
	
	

		



}
