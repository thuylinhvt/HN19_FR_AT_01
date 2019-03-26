/*
*
* (C) Copyright 2019Fresher Academy
* Author apple
* Date Mar 17, 2019
* Version 1.0
*
*/
package com.fpt.excercise2;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

public class JQueryUITab {
	private WebElement _jQueryUITab;

	public JQueryUITab(WebElement _jQueryUITab) {
		super();
		set_jQueryUITab(_jQueryUITab);
	}

	public WebElement get_jQueryUITab() {
		return _jQueryUITab;
	}

	public void set_jQueryUITab(WebElement _jQueryUITab) {
		this._jQueryUITab = _jQueryUITab;
	}

	public int getTabCount() {
		List<WebElement> tabs = _jQueryUITab.findElements(By.tagName("li"));
		return tabs.size();
	}

	public String getSelectedTab() throws InterruptedException {
		Thread.sleep(3000);
		WebElement tab = _jQueryUITab.findElement(By.xpath("//*[@id='tabs']//li[@aria-selected = 'true']"));
		return tab.getText();
	}

	public void selectTab(String tabName) throws InterruptedException {
		Thread.sleep(5000);
		int index = 0;
		boolean found = false;

		List<WebElement> tabs = _jQueryUITab.findElements(By.tagName("li"));
		for (WebElement tab : tabs) {
			if (tabName.equals(tab.getText().toString())) {
				@SuppressWarnings("deprecation")
				WrapsDriver wrappedElement = (WrapsDriver) _jQueryUITab;
				JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
				driver.executeScript("jQuery(arguments[0]).tabs().tabs('select',arguments[1]);", _jQueryUITab, index);
				found = true;
				break;
			}
			index++;
		}
		// Throw an exception if specified tab is not found
		if (found == false)
			throw new IllegalArgumentException("Could not find tab'" + tabName + "'");
	}

}
