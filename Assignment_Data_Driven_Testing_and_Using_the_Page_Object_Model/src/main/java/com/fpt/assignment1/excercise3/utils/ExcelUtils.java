/*
*
* (C) Copyright 2019Fresher Academy
* Author apple
* Date Mar 13, 2019
* Version 1.0
*
*/
package com.fpt.assignment1.excercise3.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private XSSFSheet ExcelWSheet;
	private XSSFWorkbook ExcelWBook;
	private XSSFCell Cell;
	private XSSFRow Row;

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
