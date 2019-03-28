package com.fpt.excercise2;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestSettingFunctionOnStarbucksApp_Android {
private AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("deviceName", "Nexus 5X API 25");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("appPackage", "com.starbucks.vn");
		capabilities.setCapability("appActivity", "com.starbucks.revamp.activity.SplashActivity");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}
	
  @Test
  public void test() throws InterruptedException {
	  MobileElement settingIcon = driver.findElement(By.id("com.starbucks.vn:id/iv_home_setting"));
	  settingIcon.click();
	  
	  MobileElement termOfUse = driver.findElement(By.id("com.starbucks.vn:id/tv_term_of_use"));
	  termOfUse.click();
	  
	  MobileElement content = driver.findElement(By.xpath("//android.view.View[contains(@text, 'READ')]"));
	  Thread.sleep(4000);
	 Assert.assertEquals(content.getText().contains("PLEASE READ THESE TERMS OF USE CAREFULLY"), true);
	  //assertEquals(content.getText().split("\\.")[0], "PLEASE READ THESE TERMS OF USE CAREFULLY");
  }
  
  @AfterTest
	public void teardown() {
		driver.closeApp();
	}
}
