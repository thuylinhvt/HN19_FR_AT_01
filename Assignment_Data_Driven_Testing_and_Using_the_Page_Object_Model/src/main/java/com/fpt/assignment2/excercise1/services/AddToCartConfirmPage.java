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

public class AddToCartConfirmPage {

	private WebDriver driver;

	@FindBy(xpath=Constants1.XPATH_CONFIRM_ONE_ITEM_ADDED_TO_CART)
	private WebElement confirm;
	
	public AddToCartConfirmPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AddToCartConfirmPage(WebDriver driver, String query) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, query);
	}
	
	public String getConfirmText() throws InterruptedException {
		Thread.sleep(5000);
		return confirm.getText();
	}
	
}
