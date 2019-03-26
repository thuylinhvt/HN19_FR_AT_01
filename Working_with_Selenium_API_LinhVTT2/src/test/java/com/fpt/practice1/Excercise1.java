package com.fpt.practice1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Excercise1 {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
	}

	@Test
	public void testDragAndDrop() throws InterruptedException {
		Actions build = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath("//*[@draggable ='true']"));
		WebElement drop = driver.findElement(By.id("mydropzone"));
		build.dragAndDrop(drag, drop).build().perform();

		Thread.sleep(3000);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
