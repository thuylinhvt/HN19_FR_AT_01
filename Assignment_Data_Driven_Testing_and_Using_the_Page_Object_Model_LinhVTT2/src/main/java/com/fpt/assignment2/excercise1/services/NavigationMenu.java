/*
*
* (C) Copyright 2019Fresher Academy
* Author apple
* Date Mar 13, 2019
* Version 1.0
*
*/
package com.fpt.assignment2.excercise1.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fpt.assignment2.excercise1.utils.Constants1;

public class NavigationMenu {

	private WebDriver driver;

	@FindBy(xpath = Constants1.XPATH_INPUT_SEARCH)
	private WebElement inputSearch;
	
	@FindBy(xpath = Constants1.XPATH_BUTTON_SEARCH)
	private WebElement btnSearch;
	
	public NavigationMenu() {
		super();
	}

	public NavigationMenu(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SearchResultPage searchFor(String input) throws InterruptedException {
		Thread.sleep(3000);
		inputSearch.clear();
		inputSearch.sendKeys(input);
		btnSearch.click();
		return new SearchResultPage(driver);
	}

}
