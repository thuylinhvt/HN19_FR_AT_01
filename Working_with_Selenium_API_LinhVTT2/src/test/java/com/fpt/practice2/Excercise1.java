package com.fpt.practice2;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Excercise1 {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
	}

	@Test
	public void Test() throws InterruptedException, IOException, HeadlessException, AWTException {
		// Using JavaScript code to click WOMEN item
		WebElement element = driver.findElement(By.xpath("//a[@title='Women']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		assertTrue(element.isDisplayed());
		js.executeScript("arguments[0].click();", element);

		// Using JavaScript code to verify display Subcategories TOPS and DRESSES
		List<WebElement> elementTops = (List<WebElement>) js.executeScript("return document.getElementsByTagName('a')");
		assertTrue(elementTops.get(21).isDisplayed());
		assertTrue(elementTops.get(24).isDisplayed());

		// Click TOPS
		elementTops.get(21).click();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().forward();

		File file = new File("CookiesEx1_Assg2.txt");
		try {
			file.delete();
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (Cookie cookie : driver.manage().getCookies()) {
				String s = cookie.getDomain();
				bufferedWriter.write(s);
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			fileWriter.close();
		} catch (Exception e) {
			BufferedImage image = new Robot()
					.createScreenCapture(new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File("excercise1_ass2.png"));
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();

	}
}
