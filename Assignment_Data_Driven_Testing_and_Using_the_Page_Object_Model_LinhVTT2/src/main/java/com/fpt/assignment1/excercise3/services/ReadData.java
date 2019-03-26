/*
*
* (C) Copyright 2019Fresher Academy
* Author apple
* Date Mar 13, 2019
* Version 1.0
*
*/
package com.fpt.assignment1.excercise3.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fpt.assignment1.excercise3.utils.ExcelUtils;

public class ReadData {

	public static List<String> lsData = new ArrayList<String>();

	public static Object[][] readFile() throws Exception {
		Object[][] data = null;

		try {
			FileInputStream fileInputStream = new FileInputStream(new File("Book.xlsx"));
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

}
