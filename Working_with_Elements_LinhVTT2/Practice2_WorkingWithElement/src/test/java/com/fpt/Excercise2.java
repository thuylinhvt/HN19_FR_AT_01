package com.fpt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise2 {
	private WebDriver driver;

	@BeforeClass

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	@Test(priority = 0)
	public void TestTitle() {
		String expectedresult = "My Store";
		String actualResult = driver.getTitle();
		if (actualResult.equals(expectedresult)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@Test(priority = 1)
	public void TestLogo() {
		WebElement logo = driver.findElement(By.xpath("//*[@id='header_logo']//img"));
		if (logo.isDisplayed()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@Test(priority = 2)
	public void TestTextSearchBox() {
		WebElement textSearchbox = driver.findElement(By.id("search_query_top"));
		if (textSearchbox.isDisplayed()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@Test(priority = 3)
	public void TestBtnSearchBox() {
		WebElement btnSearchbox = driver.findElement(By.xpath("//*[@id='searchbox']//button"));
		if (btnSearchbox.isDisplayed()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@Test(priority = 4)
	public void TestInputSearchbox() {
		WebElement textSearchbox = driver.findElement(By.id("search_query_top"));
		textSearchbox.clear();
		String expectedResult = "Faded Short Sleeve T-shirts";
		textSearchbox.sendKeys(expectedResult);
		String actualResult = textSearchbox.getText();
		if (actualResult.equals(expectedResult)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@Test(priority = 5)
	public void TestClickSearchButton() {
		WebElement btnSearchbox = driver.findElement(By.xpath("//button[@name=\'submit_search\']"));
		if (!btnSearchbox.isSelected()) {
			btnSearchbox.click();
		}

	}

	@Test(priority = 6)
	public void TestDisplayProductName() {
		WebElement product = driver.findElement(By.xpath("//*[@title='Faded Short Sleeve T-shirts']"));
		if (product.isDisplayed()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@Test(priority = 7)
	public void TestDisplayPriceProduct() {
		WebElement price = driver.findElement(By.xpath("//span[@itemprop ='price']"));
		String expectedResult = "$16.51";
		String actualResult = price.getText();
		if (actualResult.equals(expectedResult)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@Test(priority = 8)
	public void TestGoToProductDetail() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement web_Element_To_Be_Hovered = driver.findElement(By.xpath("//*[@title='Faded Short Sleeve T-shirts']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		WebElement btnMore = driver.findElement(By.className("quick-view"));
		btnMore.click();
	}

	@Test(priority = 9)
	public void TestInputQty() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement input = driver.findElement(By.xpath("//*[@style='border: 1px solid rgb(189, 194, 201);']"));
		input.clear();
		input.sendKeys("3");
	}

	@Test(priority = 10)
	public void TestClickAddToCart() {
		WebElement btnAddToCart = driver.findElement(By.xpath("//button[@type = 'submit']"));
		btnAddToCart.click();
	}

	@Test(priority = 11)
	public void TestClickpProceedToCheckout() {
		WebElement btnProceedToCheckout = driver
				.findElement(By.xpath("//*[@title='Proceed to checkout' and @rel ='nofollow']"));
		btnProceedToCheckout.click();
	}

	@Test(priority = 12)
	public void TestVerifyProductInYourCart() {
		String expectedName = "Faded Short Sleeve T-shirts";
		String expectedUnitPrice = "$16.51";
		String expectedQty = "3";
		String expectedTotal = "$49.53";

		WebElement name = driver.findElement(By.linkText("Faded Short Sleeve T-shirts"));
		String actualName = name.getText();
		WebElement unitPrice = driver.findElement(By.xpath("//*[@id=\"product_price_1_1_0\"]"));
		String actualUnitPrice = unitPrice.getText();
		WebElement qty = driver.findElement(By.name("quantity_1_1_0_0"));
		String actualQty = qty.getText();
		WebElement total = driver.findElement(By.id("total_product_price_1_1_0"));
		String actualTotal = total.getText();
		if (actualName.equals(expectedName) && actualUnitPrice.equals(expectedUnitPrice)
				&& actualQty.equals(expectedQty) && actualTotal.equals(expectedTotal)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@AfterClass

	public void teardown() {
		driver.quit();
	}

}
