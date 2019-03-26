/*
*
* (C) Copyright 2019Fresher Academy
* Author apple
* Date Mar 14, 2019
* Version 1.0
*
*/
package com.fpt.assignment2.excercise2.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private XSSFSheet ExcelWSheet;
	private XSSFWorkbook ExcelWBook;
	private XSSFCell Cell;
	private XSSFRow Row;

	public static List<String> lsData = new ArrayList<String>();

	public static Object[][] readFile() throws Exception {
		Object[][] data = null;

		try {
			FileInputStream fileInputStream = new FileInputStream(new File("LoginInfor.xlsx"));
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet dataSheet = workbook.getSheetAt(0);
			int totalRows = dataSheet.getLastRowNum();
			int totalCols = dataSheet.getRow(0).getPhysicalNumberOfCells() - 1;
			data = new Object[totalRows][totalCols];
			int ci = 0;
			for (int i = 1; i <= totalRows; i++, ci++) {
				int cj = 0;
				for (int j = 0; j < totalCols; j++, cj++) {

					data[ci][cj] = ExcelUtils.getCellData(dataSheet, i, j);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static String getCellData(Sheet dataSheet, int rowNum, int colNum) {
		String value = "";
		try {
			Cell cell = dataSheet.getRow(rowNum).getCell(colNum);
			value = cell.getStringCellValue().toString();
		} catch (Exception e) {

		}
		return value;
	}


	public void setExcelFile(String Path, String SheetName) {

	}

	public void setCellData(String Result, int RowNum) {

	}

}
