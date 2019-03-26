package com.fpt.practice2;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise2 {
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void Test() throws InterruptedException, IOException, HeadlessException, AWTException {
		try {
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

			// Using JavaScript code to click DRESSES item
			WebElement elementDresses = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/a"));

			javascriptExecutor.executeScript("arguments[0].click();", elementDresses);

			// Select Summer Dresses in Catalog
			WebElement elementSummerDresses = driver
					.findElement(By.xpath("//div[@id='categories_block_left']//li[3]//a"));
			elementSummerDresses.click();
			driver.findElement(By.id("layered_id_attribute_group_1")).click();
			driver.findElement(By.id("layered_id_attribute_group_8")).click();

			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(
					By.xpath("//ul[@class='product_list grid row']//li[1]//div[@class='product-container']"))).build()
					.perform();
			driver.findElement(By.xpath("//div[@id='center_column']//li[1]//a[1]//span")).click();
			Thread.sleep(4000);

			WebElement elementProductName = driver.findElement(By.xpath("//span[@class='product-name']"));
			WebElement elementSize = driver.findElement(By.id("layer_cart_product_attributes"));

			WebElement elementQuantity = driver.findElement(By.id("layer_cart_product_quantity"));
			WebElement elementTotalValue = driver.findElement(By.id("layer_cart_product_price"));

			assertEquals(elementSize.getText(), "Yellow, S");
			assertEquals(elementProductName.getText(), "Printed Summer Dress");
			assertEquals(elementQuantity.getText(), "1");
			assertEquals(elementTotalValue.getText(), "$28.98");
		} catch (Exception e) {
			BufferedImage image = new Robot()
					.createScreenCapture(new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File("excercise2_ass2.png"));
			e.printStackTrace();
		}
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
