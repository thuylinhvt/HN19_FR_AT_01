/*
*
* (C) Copyright 2019Fresher Academy
* Author apple
* Date Mar 17, 2019
* Version 1.0
*
*/
package com.fpt.excercise1;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTable {

	private WebElement webTable;

	public WebTable(WebElement webTable) {
		setWebTable(webTable);
	}

	public WebElement getWebTable() {
		return webTable;
	}

	public void setWebTable(WebElement webTable) {
		this.webTable = webTable;
	}

	public int getRowCount() {
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		return tableRows.size();
	}

	public int getColumnCount() {
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		WebElement headRow = tableRows.get(0);

		List<WebElement> tableCols = headRow.findElements(By.tagName("th"));
		return tableCols.size();
	}

	public String getCellData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		WebElement currentRow = tableRows.get(rowIdx - 1);
		List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
		WebElement cell = tableCols.get(colIdx - 1);
		return cell.getText();
	}


	public WebElement getCellEditor(int rowIdx, int colIdx, int editorIdx) throws NoSuchElementException {
		try {
			List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
			WebElement currentRow = tableRows.get(rowIdx - 1);
			List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
			WebElement cell = tableCols.get(colIdx - 1);
			WebElement cellEditor = cell.findElements(By.tagName("input")).get(editorIdx);
			return cellEditor;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Failed to get cell editor");
		}
	}

}
