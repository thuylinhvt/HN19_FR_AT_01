/*
*
* (C) Copyright 2019Fresher Academy
* Author apple
* Date Mar 14, 2019
* Version 1.0
*
*/
package com.fpt.assignment2.excercise2.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fpt.assignment2.excercise2.utils.Constants2;

public class LoginPage {

	private WebDriver driver;

	@FindBy(xpath = Constants2.XPATH_INPUT_EMAIL)
	private WebElement emailInput;
	
	@FindBy(xpath = Constants2.XPATH_INPUT_PASSWORD)
	private WebElement passwordInput;
	
	@FindBy(xpath = Constants2.XPATH_BUTTON_SUBMIT)
	private WebElement btnSignin;
	
	@FindBy(xpath = Constants2.XPATH_MESSAGE)
	private WebElement message;
	
	public LoginPage() {
		super();
	}

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String email, String pw) throws InterruptedException {
		emailInput.clear();
		emailInput.sendKeys(email);
		passwordInput.clear();
		passwordInput.sendKeys(pw);
		btnSignin.click();
		Thread.sleep(5000);
	}
	
	public String getMessage(String email, String pw) throws InterruptedException {
		return message.getText();	
	}
	
}
