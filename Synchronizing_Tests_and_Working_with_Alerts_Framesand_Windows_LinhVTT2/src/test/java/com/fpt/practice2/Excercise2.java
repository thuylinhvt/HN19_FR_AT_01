package com.fpt.practice2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		driver.get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
	}
	
	@Test
	public void Test() {
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String expectedResult = "You pressed OK";
		WebElement message = driver.findElement(By.id("demo"));
		String actualResult = message.getText();
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
