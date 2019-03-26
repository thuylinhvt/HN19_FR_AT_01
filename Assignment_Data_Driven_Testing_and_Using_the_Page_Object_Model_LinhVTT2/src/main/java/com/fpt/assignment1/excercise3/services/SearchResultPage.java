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
import com.fpt.assignment1.excercise3.utils.Constants;


public class SearchResultPage {

	private WebDriver driver;

	@FindBy(xpath = Constants.XPATH_FIRST_ITEM)
	private WebElement productElement;
	
	@FindBy(xpath = Constants.XPATH_TITLE_PRODUCT)
	private WebElement titleProduct;
	
	
	public SearchResultPage() {
		super();
	}
	
	public SearchResultPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SearchResultPage(WebDriver driver, String query) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, query);
	}
	
	public String getFirstResultTitle() throws InterruptedException {
		productElement.click();
		Thread.sleep(2000);
		return titleProduct.getText();
	}
	
}
