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

public class ProductDetailPage {

	private WebDriver driver;

	@FindBy(xpath = Constants1.XPATH_TITLE_PRODUCT)
	private WebElement titleProduct;
	
	@FindBy(xpath =Constants1.XPATH_PRICE)
	private WebElement priceProduct;
	
	@FindBy(xpath = Constants1.XPATH_BUTTON_ADD_CART)
	private WebElement btnAddToCart;
	
		
	public ProductDetailPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProductTitle() throws InterruptedException {
		Thread.sleep(3000);
		return titleProduct.getText();
	}
	
	public String getProductPrice() throws InterruptedException {
		Thread.sleep(3000);
		return priceProduct.getText();
	}
	
	public AddToCartConfirmPage addToCart() throws InterruptedException {
		Thread.sleep(5000);
		btnAddToCart.click();
		return new AddToCartConfirmPage(driver);
	}
}
