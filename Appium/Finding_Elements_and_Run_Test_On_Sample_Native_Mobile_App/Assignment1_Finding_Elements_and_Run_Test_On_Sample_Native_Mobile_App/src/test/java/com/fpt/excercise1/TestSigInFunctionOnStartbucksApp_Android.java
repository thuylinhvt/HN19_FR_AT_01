package com.fpt.excercise1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class TestSigInFunctionOnStartbucksApp_Android {
 

	private AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("deviceName", "KENNY");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("appPackage", "com.starbucks.vn");
		capabilities.setCapability("appActivity", "com.starbucks.revamp.activity.SplashActivity");
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("fullReset", "false");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=0)
	public void checkDisplay() {
		WebElement  signIn = driver.findElement(By.id("com.starbucks.vn:id/tv_home_account"));
		signIn.click();
		
		MobileElement email = driver.findElement(By.id("com.starbucks.vn:id/et_sign_in_email"));
		Assert.assertEquals(email.isDisplayed(), true);
		
		MobileElement pw = driver.findElement(By.id("com.starbucks.vn:id/et_sign_in_pw"));
		Assert.assertEquals(pw.isDisplayed(), true);
		
		MobileElement sigInBtn = driver.findElement(By.id("com.starbucks.vn:id/tv_main_button"));
		Assert.assertEquals(sigInBtn.isDisplayed(), true);
		
	}
	
	@Test(priority=1)
	public void test1() {
		MobileElement email = driver.findElement(By.id("com.starbucks.vn:id/et_sign_in_email"));
		email.clear();
		
		MobileElement pw = driver.findElement(By.id("com.starbucks.vn:id/et_sign_in_pw"));
		pw.clear();
		pw.sendKeys("abcd");
		
		MobileElement sigInBtn = driver.findElement(By.id("com.starbucks.vn:id/tv_main_button"));
		sigInBtn.click();
		
		MobileElement message = driver.findElement(By.id("com.starbucks.vn:id/textinput_error"));
		Assert.assertEquals(message.getText(),"Please input Email");
	}
	
	@Test(priority=2)
	public void test2() {
		MobileElement email = driver.findElement(By.id("com.starbucks.vn:id/et_sign_in_email"));
		email.clear();
		email.sendKeys("abcd");
		
		MobileElement pw = driver.findElement(By.id("com.starbucks.vn:id/et_sign_in_pw"));
		pw.clear();
		
		MobileElement sigInBtn = driver.findElement(By.id("com.starbucks.vn:id/tv_main_button"));
		sigInBtn.click();
		
		List<MobileElement> list = driver.findElements(By.id("com.starbucks.vn:id/textinput_error"));
		Assert.assertEquals(list.get(0).getText(),"Please enter valid email address");
		
		Assert.assertEquals(list.get(1).getText(),"Please input Password");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.closeApp();
	}
	
}
