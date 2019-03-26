package com.fpt.excercise2;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JQueryUITabWidgetTest {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/tabs/#ajax");
	}

	@Test
	public void testjQueryUITabWidget() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content']/iframe")));
		List<WebElement> tabs = driver.findElements(By.tagName("li"));
		System.out.println(tabs.size());
		JQueryUITab tab = new JQueryUITab(driver.findElement(By.tagName("li")));
		Thread.sleep(3000);
		// Verify Tab Widget has 5 Tabs
		assertEquals(tab.getTabCount(), 5);
		// Verify Preloaded Tab is selected
		assertEquals("Preloaded", tab.getSelectedTab());
		// Select Tab 1 and verify it is selected
		tab.selectTab("Tab 1");
		assertEquals("Tab 1", tab.getSelectedTab());
		// Select Tab 2 and verify it is selected
		tab.selectTab("Tab 2");
		assertEquals("Tab 2", tab.getSelectedTab());
		// Select Tab 3 (slow) and verify it is selected
		tab.selectTab("Tab 3 (slow)");
		assertEquals("Tab 3 (slow)", tab.getSelectedTab());
		// Select Tab 4 (broken) and verify it is selected
		tab.selectTab("Tab 4 (broken)");
		assertEquals("Tab 4 (broken)", tab.getSelectedTab());
		// Select Preloaded Tab
		tab.selectTab("Preloaded Tab");
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
