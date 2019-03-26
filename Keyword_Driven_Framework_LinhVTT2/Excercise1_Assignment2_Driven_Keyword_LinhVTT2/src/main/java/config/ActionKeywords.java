package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import executionEngine.DriverScript;
import utility.Log;

import static executionEngine.DriverScript.OR;
import static org.testng.Assert.assertEquals;

public class ActionKeywords {
	public static WebDriver driver;
	public static Select select;

	// This block of code will decide which browser type to start
	public static void openBrowser(String object, String data) {
		Log.info("Opening Browser");

		try {
			// If value of the parameter is Mozilla, this will execute
			if (data.equals("Mozilla")) {
				driver = new FirefoxDriver();
				Log.info("Mozilla browser started");
			} else if (data.equals("IE")) {
				// You may need to change the code here to start IE Driver
				driver = new InternetExplorerDriver();
				Log.info("IE browser started");
			} else if (data.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver");
				driver = new ChromeDriver();
				Log.info("Chrome browser started");
			}

			int implicitWaitTime = (10);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		} catch (Exception e) {
			Log.info("Not able to open the Browser --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void navigate(String object, String data) {
		try {
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Constant Variable is used in place of URL
			driver.manage().window().maximize();
			System.out.println(data);
			driver.get(data);
		} catch (Exception e) {
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}
	

	public static void verifyDisplay(String object, String data) {
		try {
			Log.info("Verify display item" + object);
			if (!driver.findElement(By.xpath(OR.getProperty(object).trim())).isDisplayed()) {
				DriverScript.bResult = false;
			}

		} catch (Exception e) {
			Log.error("Not able display --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}


	public static void closeBrowser(String object, String data) {
		try {
			Log.info("Closing the browser");
			driver.quit();
		} catch (Exception e) {
			Log.error("Not able to Close the Browser --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}
}
