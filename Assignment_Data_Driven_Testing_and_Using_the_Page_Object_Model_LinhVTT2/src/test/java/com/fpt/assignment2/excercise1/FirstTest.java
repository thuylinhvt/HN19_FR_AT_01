package com.fpt.assignment2.excercise1;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fpt.assignment2.excercise1.services.AddToCartConfirmPage;
import com.fpt.assignment2.excercise1.services.HomePage;
import com.fpt.assignment2.excercise1.services.NavigationMenu;
import com.fpt.assignment2.excercise1.services.ProductDetailPage;
import com.fpt.assignment2.excercise1.services.SearchResultPage;
import com.fpt.assignment2.excercise1.utils.ExcelUtils;


public class FirstTest {
  

	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
	}
	
	@Test(dataProvider="dataTest")
	public void Test(String testcaseid, String productTitle, String priceProduct) throws InterruptedException {
	HomePage homePage = new HomePage(driver);
	NavigationMenu navigationMenu = homePage.naMenu();
	SearchResultPage searchResultPage = navigationMenu.searchFor(productTitle);
	ProductDetailPage productDetailPage = searchResultPage.clickProductTitle();
	//Verify that product title is correct
	assertEquals(productDetailPage.getProductTitle(), productTitle);
	//Verify that product price is correct
	String actualPrice = productDetailPage.getProductPrice();
	assertEquals(actualPrice, priceProduct);
	//Verify confirmation test appears: “1 item added to Cart”
	AddToCartConfirmPage addToCartConfirmPage = productDetailPage.addToCart();
	assertEquals(addToCartConfirmPage.getConfirmText(), "There is 1 item in your cart.");
	}
	
	@DataProvider 
	public Object[][] dataTest() throws Exception{
		return ExcelUtils.readFile();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
