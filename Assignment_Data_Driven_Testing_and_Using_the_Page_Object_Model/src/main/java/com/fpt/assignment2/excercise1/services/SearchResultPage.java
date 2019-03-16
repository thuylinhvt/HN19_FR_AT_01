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

public class SearchResultPage {

	private WebDriver driver;
	
	@FindBy(xpath= Constants1.XPATH_TITLE_PRODUCT_FIRST )
	private WebElement firstProduct;

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
	
	public String getFirstResultTitle() {
		return firstProduct.getText();
	}
	
	public ProductDetailPage clickProductTitle()  throws InterruptedException {
		Thread.sleep(5000);
		firstProduct.click();
		return new ProductDetailPage(driver);
	}
	
}
