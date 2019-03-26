package com.fpt.practice1;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
	}

	@Test(priority=0)
	public void TestBtnFollowInTwitter() {
		String parentWindowId = driver.getWindowHandle();
		// Click Button Follow On Twitter
		WebElement element = driver.findElement(By.xpath("//*[@title='Follow @seleniumeasy on Twitter']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		for (String winHandle : driver.getWindowHandles()) {
			try {
				Thread.sleep(3000);
				String title = driver.switchTo().window(winHandle).getTitle();
				System.out.println(title);
				driver.switchTo().window(parentWindowId);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test(priority=1)
	public void TestButtonLikeusOnFacebook() {
		// Click Button Like us On Facebook
//		String parentWindowId = driver.getWindowHandle();
//		driver.switchTo().window(parentWindowId);
		WebElement element = driver.findElement(By.xpath("//*[@title='Follow @seleniumeasy on Facebook']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		for (String winHandle : driver.getWindowHandles()) {
			try {
				Thread.sleep(3000);
				String title = driver.switchTo().window(winHandle).getTitle();
				System.out.println(title);
				driver.close();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
