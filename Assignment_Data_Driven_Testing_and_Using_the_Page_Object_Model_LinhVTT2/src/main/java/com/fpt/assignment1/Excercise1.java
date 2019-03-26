/*
*
* (C) Copyright 2019Fresher Academy
* Author apple
* Date Mar 12, 2019
* Version 1.0
*
*/
package com.fpt.assignment1;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excercise1 {
	private static XSSFWorkbook workbook;

	public static void main(String[] args) {
		workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Excercise 1");

		// This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "ID", "NAME", "LASTNAME" });
		data.put("2", new Object[] { 1, "Amit", "Shukla" });
		data.put("3", new Object[] { 2, "Lokesh", "Gupta" });
		data.put("4", new Object[] { 3, "John", "Adwards" });
		data.put("5", new Object[] { 4, "Brian", "Schultz" });

		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			// this creates a new row in the sheet
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				// this line creates a cell in the next column of that row
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// this Writes the workbook Assignment 1
			FileOutputStream out = new FileOutputStream(new File("Excercise1_Assignment 1.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Excercise1_Assignment 1.xlsx written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
