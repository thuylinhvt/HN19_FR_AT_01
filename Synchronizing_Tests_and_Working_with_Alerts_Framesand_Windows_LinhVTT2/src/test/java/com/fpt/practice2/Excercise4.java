package com.fpt.practice2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise4 {
 
	private WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_h\n" + 
				"eight_width");
	}
	
	@Test
	public void Test() {
		driver.switchTo().defaultContent(); 
		driver.switchTo().frame("iframeResult");
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@src='demo_iframe.htm']")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element = driver.findElement(By.xpath("/html/body/h1"));
		String expectedResult = "This page is displayed in an iframe";
		String actualResult = element.getText();
		System.out.println(actualResult);
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
