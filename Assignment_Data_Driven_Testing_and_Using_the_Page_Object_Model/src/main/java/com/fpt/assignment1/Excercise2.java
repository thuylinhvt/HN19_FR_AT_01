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
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excercise2 {

	private static XSSFWorkbook workbook;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
    { 
        try { 
            FileInputStream file = new FileInputStream(new File("Excercise1_Assignment 1.xlsx")); 
  
            workbook = new XSSFWorkbook(file); 
  
            // Get first/desired sheet from the workbook 
            XSSFSheet sheet = workbook.getSheetAt(0); 
  
            // Iterate through each rows one by one 
            Iterator<Row> rowIterator = sheet.iterator(); 
            while (rowIterator.hasNext()) { 
                Row row = rowIterator.next(); 
                // For each row, iterate through all the columns 
                Iterator<Cell> cellIterator = row.cellIterator(); 
  
                while (cellIterator.hasNext()) { 
                    Cell cell = cellIterator.next(); 
                    
                    // Check the cell type and format accordingly 
                    switch (cell.getCellType()) { 
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print((int)cell.getNumericCellValue() + "\t"); 
                        break; 
                    case Cell.CELL_TYPE_STRING: 
                        System.out.print(cell.getStringCellValue() + "\t"); 
                        break; 
                    } 
                } 
                System.out.println(""); 
            } 
            file.close(); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
}
