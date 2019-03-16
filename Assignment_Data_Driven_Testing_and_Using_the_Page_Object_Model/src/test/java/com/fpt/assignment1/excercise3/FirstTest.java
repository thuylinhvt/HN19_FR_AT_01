package com.fpt.assignment1.excercise3;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fpt.assignment1.excercise3.services.HomePage;
import com.fpt.assignment1.excercise3.services.NavigationMenu;
import com.fpt.assignment1.excercise3.services.ReadData;
import com.fpt.assignment1.excercise3.services.SearchResultPage;


public class FirstTest {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void openHomePage(String url) {
		driver.navigate().to(url);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "dp")
	public void testSearch(String tcid, String url, String searchKey, String productTitle) throws InterruptedException {
		openHomePage("https://"+url);
		HomePage homePage = new HomePage(driver);
		NavigationMenu navigationMenu = homePage.naMenu();
		SearchResultPage searchResultPage = navigationMenu.searchFor(searchKey);
		Thread.sleep(1000);
		assertEquals(searchResultPage.getFirstResultTitle(), productTitle);
	}

	@DataProvider
	public Object[][] dp() throws Exception {
		return ReadData.readFile();
	}

}
