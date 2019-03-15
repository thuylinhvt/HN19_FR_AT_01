package com.fpt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise1 {
	private WebDriver driver;

	@BeforeClass
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/apple/Documents/Fresher Academy/Selenium/Working_with_Elements/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
	}

	@Test

	public void testInputFiled() {
		WebElement element = driver.findElement(By.id("user-message"));
		element.clear();
		element.sendKeys("Fresher Automation Tester");
		driver.findElement(By.xpath("//*[@id=\"get-input\"]/button")).click();
		Assert.assertEquals(driver.findElement(By.id("display")).getText(), "Fresher Automation Tester");
	}

	@AfterClass

	public void tearDown() throws Exception {
		driver.quit();

	}
}
