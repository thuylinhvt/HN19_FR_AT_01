package com.fpt.assignment2.excercise3;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.fpt.assignment2.excercise3.services.HomePage;
import com.fpt.assignment2.excercise3.services.LoginPage;
import com.fpt.assignment2.excercise3.utils.ExcelUtils;

public class TestCreatAccount {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication");

	}

	@Test(dataProvider = "dataTest")
	public void Test(String testcaseID, String email, String message) throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.loginPage();
		loginPage.creatAccount(email);
		String urlCurrent = driver.getCurrentUrl();
		if (urlCurrent.equals("http://automationpractice.com/index.php?controller=authentication#account-creation")) {
			System.out.println("PASS");
		} else {
			String mes = loginPage.getMessage(email);
			if (mes.equals(message)) {
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
		}
	}

	@DataProvider
	public Object[][] dataTest() throws Exception {
		return ExcelUtils.readFile();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
