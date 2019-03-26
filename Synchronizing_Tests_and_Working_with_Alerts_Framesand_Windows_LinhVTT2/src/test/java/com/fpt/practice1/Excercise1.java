package com.fpt.practice1;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise1 {
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-\n" + "demo.html");
	}

	@Test
	public void TestAlertBox() {
		WebElement element = driver.findElement(By.xpath("//*[@id='easycont']//button[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

		BufferedImage image;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File("alert_ex1_practice1.png"));
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			driver.switchTo().alert().accept();
			String alertTextActual = alert.getText();
			String alertTextExpected = "I am an alert box!";
			if (alertTextActual.equals(alertTextExpected)) {
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void TestConfirmBox() {
		WebElement element = driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

		BufferedImage image;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File("confirmBox.png"));
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String expectedResult = "You pressed OK!";
		WebElement message = driver.findElement(By.id("confirm-demo"));
		String actualResult = message.getText();
		if (actualResult.equals(expectedResult)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@Test
	public void TestPromptBox() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[3]/div[2]/button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Thuy Linh");
		alert.accept();
		String expectedResult = "You have entered 'Thuy Linh' !";
		WebElement name = driver.findElement(By.id("prompt-demo"));
		String actualResult = name.getText();
		if (actualResult.equals(expectedResult)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
