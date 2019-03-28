package com.fpt.seleniumGrid;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestParallel extends BaseTest{

	@Test
	public void testGooglePageTitleInChrome() {
		getDriver().navigate().to("http://www.google.com");
		String strPageTitle = getDriver().getTitle();
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}
	
	@Test
	public void testSearchGoogle() {
		System.out.println("Opening Google..");
		getDriver().navigate().to("http://www.google.com");
		getDriver().findElement(By.name("q")).sendKeys("Selenium Easy Grid Tutorials");
		getDriver().findElement(By.name("q")).submit();
	}
}
