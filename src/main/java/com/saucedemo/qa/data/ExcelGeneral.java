package com.saucedemo.qa.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ExcelGeneral {

	private ExcelDataInformation excelDataInformation;

	public ExcelGeneral(ExcelDataInformation excelDataInformation) {
		this.excelDataInformation = excelDataInformation;
	}

	public ExcelDataInformation getExcelDataInformation() {
		return excelDataInformation;
	}

	public void setExcelDataInformation(ExcelDataInformation excelDataInformation) {
		this.excelDataInformation = excelDataInformation;
	}

	public List<String> getSheetHeadings(Sheet sheet) {
		if (sheet == null) {
			return null;
		}
		List<String> headings = null;

		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			headings = new ArrayList<String>();
			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			while (cellIterator.hasNext()) {
				Cell currentCell = cellIterator.next();
				if (currentCell.getCellType() == CellType.STRING) {
					headings.add(currentCell.getStringCellValue());
				} else if (currentCell.getCellType() == CellType.BLANK) {
					break;
				} else if (currentCell.getCellType() == CellType.NUMERIC) {
					headings = null;
					break;
				}
			}
			break;
		}
		return headings;
	}

	public Sheet getSheetByName(Workbook workbook) {
		if (workbook != null) {
			return workbook.getSheet(excelDataInformation.getXlSheetName());
		}
		return null;
	}

	public String getCellValueToString(Cell currentCell) {
		if (currentCell != null) {
			if (currentCell.getCellType() == CellType.STRING) {
				return currentCell.getStringCellValue();
			} else if (currentCell.getCellType() == CellType.NUMERIC) {
				double cellValue = currentCell.getNumericCellValue();
				if (cellValue == (long) cellValue) {
					return String.valueOf((long) cellValue);
				}
				return String.valueOf(cellValue);
			} else if (currentCell.getCellType() == CellType.BLANK) {
				return null;
			}
		}
		return null;
	}

	public Workbook getWorkbook() {
		try {
			FileInputStream excelFile = new FileInputStream(new File(excelDataInformation.getXlFileName()));
			return new XSSFWorkbook(excelFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void closeWorkbook(Workbook workbook) {
		if (workbook != null) {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void writeWorkbookData(Workbook workbook) {
		if (workbook != null) {
			try {
				FileOutputStream outputStream = new FileOutputStream(excelDataInformation.getXlFileName());
				workbook.write(outputStream);
				outputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public Map<String, String> getQueryDataInMap(String strValue) {
		if (strValue == null) {
			return null;
		}

		Map<String, String> excelQueryValues = new HashMap<String, String>();

		String sourceDataArray[] = strValue.split(";");
		for (int sCount = 0; sCount < sourceDataArray.length; sCount++) {
			excelQueryValues.put(sourceDataArray[sCount].split("=")[0], sourceDataArray[sCount].split("=")[1]);
		}
		return excelQueryValues;

	}

	public static String fmt(double d) {
		if (d == (long) d)
			return String.format("%d", (long) d);
		else
			return String.format("%s", d);
	}

}
