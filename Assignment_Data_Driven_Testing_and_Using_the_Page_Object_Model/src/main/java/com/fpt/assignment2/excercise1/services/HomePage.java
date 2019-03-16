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

public class HomePage {
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public HomePage open() {
		return null;
	}
	
	public NavigationMenu naMenu() {
		return new NavigationMenu(driver);
	}

}
