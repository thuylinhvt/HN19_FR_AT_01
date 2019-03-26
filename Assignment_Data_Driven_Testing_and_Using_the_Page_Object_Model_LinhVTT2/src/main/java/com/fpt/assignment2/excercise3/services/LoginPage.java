/*
*
* (C) Copyright 2019Fresher Academy
* Author apple
* Date Mar 14, 2019
* Version 1.0
*
*/
package com.fpt.assignment2.excercise3.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fpt.assignment2.excercise3.utils.Constants3;

public class LoginPage {

	private WebDriver driver;

	@FindBy(xpath = Constants3.XPATH_INPUT_EMAIL)
	private WebElement emailInput;
	
	@FindBy(xpath = Constants3.XPATH_BUTTON_CREAT_ACCOUNT)
	private WebElement btn_creat_account;
	
	@FindBy(xpath = Constants3.XPATH_MESSAGE)
	private WebElement message;
	
	public LoginPage() {
		super();
	}

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void creatAccount(String email) throws InterruptedException {
		emailInput.clear();
		emailInput.sendKeys(email);
		btn_creat_account.click();
		Thread.sleep(5000);
	}
	
	
	public String getMessage(String email) throws InterruptedException {
		return message.getText();	
	}
	
}
