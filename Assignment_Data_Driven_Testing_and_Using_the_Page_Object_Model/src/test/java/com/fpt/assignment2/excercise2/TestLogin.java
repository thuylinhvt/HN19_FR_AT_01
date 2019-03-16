package com.fpt.assignment2.excercise2;

import static org.testng.Assert.assertEquals;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fpt.assignment2.excercise2.services.HomePage;
import com.fpt.assignment2.excercise2.services.LoginPage;
import com.fpt.assignment2.excercise2.utils.ExcelUtils;

public class TestLogin {

	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication");
	}

	@Test(dataProvider = "dataLogin")
	public void Test(String testcaseID, String email, String password, String message) throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.loginPage();
		loginPage.login(email, password);
		// Thread.sleep(5000);
		String title = driver.getTitle();
		if (!title.equals("Login - My Store")) {
			System.out.println("PASS");
		} else {
			String mes = loginPage.getMessage(email, password);
			if (mes.equals(message)) {
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
		}

	}

	@DataProvider
	public Object[][] dataLogin() throws Exception {
		return ExcelUtils.readFile();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
