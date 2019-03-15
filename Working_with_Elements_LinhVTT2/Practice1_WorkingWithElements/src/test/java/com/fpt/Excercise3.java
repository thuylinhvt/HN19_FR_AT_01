package com.fpt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excercise3 {
	private WebDriver driver;

  @BeforeClass

  public void setup() {
	  System.setProperty("webdriver.chrome.driver", "/Users/apple/Documents/Fresher Academy/Selenium/Working_with_Elements/chromedriver");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
  }
  
  @Test
  public void TestRadioButton() {
	  String result = "";
	  WebElement sex = driver.findElement(By.xpath("//*[@value='Male']"));
	  if(!sex.isSelected()) {
		  sex.click();
		  result += "Sex : "+ sex.getAttribute("value") + "\n";
	  }

	  WebElement age = driver.findElement(By.xpath("//*[@value='5 - 15']"));
	  if(!age.isSelected()) {
		  age.click();
		  result += "Age group: "+ age.getAttribute("value");
	  }
	
	 driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")).click();
	 AssertJUnit.assertEquals(result, "Sex : Male\nAge group: 5 - 15");
	  
	  
	  
  }

  @AfterClass
  public void teardown() {
	  driver.quit();
  }
}
