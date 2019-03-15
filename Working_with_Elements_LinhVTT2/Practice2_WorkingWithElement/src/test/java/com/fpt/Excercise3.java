package com.fpt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Excercise3 {
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
		String expectedTitle = "My Store";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@Test(priority = 1)
	public void TestLogo() {
		WebElement logo = driver.findElement(By.xpath("//a[@title='My Store']/img"));
		if (logo.isDisplayed()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@Test(priority = 2)
	public void TestSignIn() {
		WebElement signIn = driver.findElement(By.xpath("//*[@title='Log in to your customer account']"));
		if (signIn.isDisplayed()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@Test (priority =3)
	public void TestClickSignIn() {
		WebElement signIn = driver.findElement(By.xpath("//*[@title='Log in to your customer account']"));
		if(!signIn.isSelected()) {
			signIn.click();
		}
	}
	@Test(priority = 4)
	public void TestDisplayEmailTextbox() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement mailTextbox = driver.findElement(By.xpath("//*[@id='email_create']"));
		if (mailTextbox.isDisplayed()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}

	@Test(priority = 5)
	public void TestBtnCreatAnAccount() {
		WebElement btn = driver.findElement(By.name("SubmitCreate"));
		if (btn.isDisplayed()) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

	}

	@Test(priority = 6)
	public void verifyCreatAccount() {
		WebElement mailTextbox = driver.findElement(By.xpath("//*[@id='email_create']"));
		mailTextbox.clear();
		mailTextbox.sendKeys("linhvtt.ptit@gmail.com");

		WebElement btn = driver.findElement(By.xpath("//*[@id='SubmitCreate']"));
		btn.click();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement title = driver.findElement(By.id("id_gender2"));
		if (!title.isSelected()) {
			title.click();
		}

		WebElement cus_fisrtName = driver.findElement(By.xpath("//*[@id='customer_firstname']"));
		cus_fisrtName.clear();
		cus_fisrtName.sendKeys("Vũ Thị");

		WebElement cus_lastName = driver.findElement(By.id("customer_lastname"));
		cus_lastName.clear();
		cus_lastName.sendKeys("Linh");

		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("linhvtt.ptit@gmail.com");

		WebElement pw = driver.findElement(By.id("passwd"));
		pw.clear();
		pw.sendKeys("12345678");
				
		Select day = new Select(driver.findElement(By.id("days")));
		day.selectByValue("27");

		Select month = new Select(driver.findElement(By.id("months")));
		month.selectByValue("6");

		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByValue("1996");

		WebElement checkboxNewLeter = driver.findElement(By.id("newsletter"));
		if (!checkboxNewLeter.isSelected()) {
			checkboxNewLeter.click();
		}

		WebElement firstname = driver.findElement(By.id("firstname"));
		firstname.clear();
		firstname.sendKeys("Vũ Thị");

		WebElement lastname = driver.findElement(By.id("lastname"));
		lastname.clear();
		lastname.sendKeys("Linh");

		WebElement company = driver.findElement(By.id("company"));
		company.clear();
		company.sendKeys("FPT");

		WebElement address1 = driver.findElement(By.id("address1"));
		address1.clear();
		address1.sendKeys("17 Duy Tan");

		WebElement address2 = driver.findElement(By.id("address2"));
		address2.clear();
		address2.sendKeys("3A Building");

		WebElement city = driver.findElement(By.id("city"));
		city.clear();
		city.sendKeys("Ha Noi");

		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByValue("5");;

		WebElement postcode = driver.findElement(By.id("postcode"));
		postcode.clear();
		postcode.sendKeys("88888");

		Select country = new Select(driver.findElement(By.id("id_country")));
		country.selectByValue("21");

		WebElement other = driver.findElement(By.id("other"));
		other.clear();
		other.sendKeys("Major in IT");

		WebElement homePhone = driver.findElement(By.id("phone"));
		homePhone.clear();
		homePhone.sendKeys("0901723924");

		WebElement mobilePhone = driver.findElement(By.id("phone_mobile"));
		mobilePhone.clear();
		mobilePhone.sendKeys("0969175462");

		WebElement myAddress = driver.findElement(By.id("alias"));
		myAddress.clear();
		myAddress.sendKeys("Ha Nam");

		WebElement btnRegister = driver.findElement(By.id("submitAccount"));
		if (!btnRegister.isSelected()) {
			btnRegister.click();
		}

		String expectedTitle = "My account - My Store";
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
