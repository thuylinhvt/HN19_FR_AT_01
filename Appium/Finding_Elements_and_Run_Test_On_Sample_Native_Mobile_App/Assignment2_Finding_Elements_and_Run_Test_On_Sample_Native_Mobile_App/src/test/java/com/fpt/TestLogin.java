package com.fpt;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class TestLogin {
  
	private IOSDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "12.1");
		capabilities.setCapability("deviceName", "iPhone 7 Plus");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("bundleId", "me.lucasfarah.LFLoginControllerExample");
		capabilities.setCapability("udid", "491B3C39-1DC6-45F0-8C6A-CFAF1477A7EC");
		capabilities.setCapability("automationName", "XCUITest");
		
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Test
	public void testLogin() {
		MobileElement loginLink = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Login']"));
		loginLink.click();
		
		MobileElement email = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"LFLoginControllerExample\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeTextField"));
		email.clear();
		email.sendKeys("thuylinhvt.ptit@gmail.com");
		
		MobileElement password = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"LFLoginControllerExample\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeSecureTextField"));
		password.clear();
		password.sendKeys("123456");
		
		MobileElement loginBtn = driver.findElement(By.xpath("(//XCUIElementTypeButton[@name=\"Login\"])[2]"));
		loginBtn.click();
		
		
	}
	
	
	@AfterTest
	public void teardown() {
		driver.closeApp();
	}
}
