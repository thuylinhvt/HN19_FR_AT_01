package com.fpt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excercise5 {
  private WebDriver driver;
  
  @BeforeClass

  public void setup() {
	  System.setProperty("webdriver.chrome.driver", "/Users/apple/Documents/Fresher Academy/Selenium/Working_with_Elements/chromedriver");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html");
  }
  
  @Test
  public void Display() {
	  WebElement fisrtRow = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tr[1]"));
	  List<WebElement> cols = fisrtRow.findElements(By.tagName("td"));
	  for (WebElement col : cols) {
		System.out.print(col.getText() + "\t");
	}
	  
  }

  @AfterClass
  
  public void teardown() {
	  driver.quit();
  }
}
