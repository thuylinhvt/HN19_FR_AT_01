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

import org.openqa.selenium.By;
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
	  driver.get("http://demo.guru99.com/test/simple_context_menu.html");
  }
  
  @Test
  public void Test() {
	  //test double click me display
	  WebElement element = driver.findElement(By.xpath("//*[@id='authentication']/button"));
	  if(element.isDisplayed()) {
		  System.out.println("PASS");
	  }else {
		  System.out.println("FAIL");
	  }
	  
	  //double click the button
	  Actions builder = new Actions(driver);
	  builder.doubleClick(element).perform();
	  
	  BufferedImage image;
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File("alert_ex2_practice1.png"));
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	  
  }
  
  @AfterClass
  public void teardown() {
	  driver.quit();
  }
}
