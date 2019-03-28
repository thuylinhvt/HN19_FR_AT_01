package com.fpt;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
  
private WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?controller=contact");
	}
	
	@Test(priority=0)
	public void clickContactButton() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@title = 'Contact Us']")).click();	
	}
	
	@Test(priority=1)
	public void checkDisplay() throws InterruptedException {
		Thread.sleep(5000);
		WebElement subject = driver.findElement(By.id("id_contact"));
		if(subject.isDisplayed()) {
			System.out.println("Pass");
		}else {
			System.out.println("False");
		}
		
		WebElement email = driver.findElement(By.id("email"));
		if(email.isDisplayed()) {
			System.out.println("Pass");
		}else {
			System.out.println("False");
		}
		
		WebElement order = driver.findElement(By.id("id_order"));
		if(order.isDisplayed()) {
			System.out.println("Pass");
		}else {
			System.out.println("False");
		}
		
		WebElement attachFile = driver.findElement(By.id("fileUpload"));
		if(attachFile.isDisplayed()) {
			System.out.println("Pass");
		}else {
			System.out.println("False");
		}
		
		WebElement message = driver.findElement(By.id("message"));
		if(message.isDisplayed()) {
			System.out.println("Pass");
		}else {
			System.out.println("False");
		}
		WebElement sendBtn = driver.findElement(By.id("submitMessage"));
		if(sendBtn.isDisplayed()) {
			System.out.println("Pass");
		}else {
			System.out.println("False");
		}
		
	}
	
	@Test(priority=2)
	public void testSelectCustomerService() {
		Select select = new Select(driver.findElement(By.id("id_contact")));
		select.selectByVisibleText("Customer service");
	}
	
	@Test(priority=3)
	public void testInputEmail() {
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("thuylinhvt.ptit@gmail.com");
	}
	
	@Test(priority=4)
	public void testInputOrderReference() {
		WebElement order = driver.findElement(By.id("id_order"));
		order.clear();
		order.sendKeys("Hello!");
	}
	
	@Test(priority=6)
	public void testInputMessage() {
		WebElement message = driver.findElement(By.id("message"));
		message.clear();
		message.sendKeys("This is the first test");
	}
	
	@Test(priority=7)
	public void testClickSendButton() {
		driver.findElement(By.id("submitMessage")).click();
	}
	
	@Test(priority=8)
	public void testVerifyText() {
		WebElement txt = driver.findElement(By.xpath("//*[@id='center_column']/p"));
		System.out.println(txt.getText());
		Assert.assertEquals(txt.getText(), "Your message has been successfully sent to our team.");
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
