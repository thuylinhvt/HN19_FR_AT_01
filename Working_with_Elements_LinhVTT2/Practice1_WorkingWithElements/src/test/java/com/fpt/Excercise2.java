package com.fpt;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Excercise2 {
	private WebDriver driver;
	
	@BeforeClass

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/apple/Documents/Fresher Academy/Selenium/Working_with_Elements/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
	}

	@Test

	public void testCheckbox() {
		WebElement checkbox = driver.findElement(By.id("isAgeSelected"));
		if(!checkbox.isSelected()) {
			checkbox.click();
		}
		WebElement result = driver.findElement(By.id("txtAge"));
		Assert.assertEquals(result.getText(), "Success - Check box is checked");
				
	}

	@AfterClass

	public void tearDown() throws Exception {

		driver.quit();

	}
}
