package com.fpt.practice1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Excercise4 {
  private WebDriver driver;
  
  @BeforeMethod
  public void setup() {
	  System.setProperty("webdriver.chrome.driver", "chromedriver");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://automationpractice.com/index.php");
  }
  
  @Test
  public void getCookie() {
	  WebElement element = driver.findElement(By.xpath("//a[@title='Women']"));
	  element.click();
	  
	  File file = new File("Cookies.txt");
	  try {
		  file.delete();
		  file.createNewFile();
		  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		  for(Cookie cookie : driver.manage().getCookies()) {
			  String s = cookie.getDomain();
			  bufferedWriter.write(s);
			  bufferedWriter.newLine();
		  }
		  bufferedWriter.close();
	  }catch(Exception e) {
		  
	  }
  }
  
  @AfterMethod
  public void teardown() {
	  driver.quit();
  }
}
