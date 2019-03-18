package com.fpt.excercise1;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableTest {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://techcanvass.com/examples/webtable.html");
	}

	@Test
	public void testWebTable() {
		WebTable table = new WebTable(driver.findElement(By.xpath("//*[@id='t01']")));
		// Verify that table has three rows
		assertEquals(3, table.getColumnCount());
		// Verify that it has three columns
		assertEquals(3, table.getColumnCount());
		// Verify that specified value exists in first cell of four row
		assertEquals("Honda", table.getCellData(4, 1));
		// Get in cell editor and enter value
		WebElement cellEdit = table.getCellEditor(3, 3, 0);
		cellEdit.clear();
		cellEdit.sendKeys("2");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
