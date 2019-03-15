package com.fpt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Excercise4 {

	private WebDriver driver;

	@BeforeClass

	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/apple/Documents/Fresher Academy/Selenium/Working_with_Elements/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
	}

	@Test
	public void TestList() {
		Select oSelect = new Select(driver.findElement(By.id("select-demo")));
		oSelect.selectByVisibleText("Monday");

		WebElement result = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[2]"));
		AssertJUnit.assertEquals(result.getText(), "Day selected :- Monday");

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
