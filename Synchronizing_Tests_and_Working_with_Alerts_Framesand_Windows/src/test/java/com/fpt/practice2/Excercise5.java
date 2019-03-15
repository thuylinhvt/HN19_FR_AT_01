package com.fpt.practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise5 {
 
	private WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_frame_cols");
	}
	
	@Test
	public void Test() {
		driver.switchTo().defaultContent(); 
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		driver.switchTo().frame(0);
		String expectedResult = "Note: The frameset, frame, and noframes elements are not supported in HTML5.";
		WebElement element = driver.findElement(By.xpath("/html/body/p"));
		String actualResult = element.getText();
		if(actualResult.equals(expectedResult)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}	
