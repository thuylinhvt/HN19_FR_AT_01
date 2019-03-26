package com.fpt.practice1;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise3 {
  
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
	}
	
	@Test
	public void Test() throws HeadlessException, AWTException, IOException {
		//Verify “Right click me” displayed
		WebElement element = driver.findElement(By.xpath("//*[@id='authentication']/span"));
		WebElement elementSub = driver.findElement(By.xpath("//*[@id='authentication']/ul/li[1]"));
		if(element.isDisplayed()) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		//5.	Right Click “Right click me”
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
		elementSub.click();
		
		//capture screen
		BufferedImage image = new Robot().createScreenCapture(new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File("excercise3.png"));
		driver.switchTo().alert().accept();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
