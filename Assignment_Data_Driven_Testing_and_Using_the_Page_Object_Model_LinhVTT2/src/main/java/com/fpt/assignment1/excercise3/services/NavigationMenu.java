/*
*
* (C) Copyright 2019Fresher Academy
* Author apple
* Date Mar 13, 2019
* Version 1.0
*
*/
package com.fpt.assignment1.excercise3.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.fpt.assignment1.excercise3.utils.Constants;


public class NavigationMenu {

	private WebDriver driver;

	@FindBy(xpath = Constants.XPATH_SEARCH_DROPDOWN)
	private WebElement dropdown;

	@FindBy(xpath = Constants.SEARCH_INPUT)
	private WebElement searchInput;

	@FindBy(xpath = Constants.SEARCH_BUTTON)
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
		Select select = new Select(dropdown);
		select.selectByValue(Constants.VALUE_DROPDOWN_SELECTED);
		Thread.sleep(2000);
		searchInput.sendKeys(input);
		btnSearch.click();
		return new SearchResultPage(driver);
	}

}
