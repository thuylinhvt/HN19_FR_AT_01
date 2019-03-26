package config;

import static com.fpt.BaseTest.driver;
import static executionEngine.DriverScript.OR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import executionEngine.DriverScript;
import utility.Log;
import utility.WebTable;

public class ActionKeywords {
	//public static WebDriver driver;
	public static Select select;
	public static WebTable webTable;
	// This block of code will decide which browser type to start

	public static void navigate(String object, String data) {
		try {
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Constant Variable is used in place of URL
			driver.get(data);
		} catch (Exception e) {
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void selectItem(String object, String data) {
		try {
			Log.info("Select item on Webelement " + object);
			select = new Select(driver.findElement(OR.getLocator(object)));
			select.selectByVisibleText(data);

		} catch (Exception e) {
			Log.error("Not able to click --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void inputText(String object, String data) {
		try {
			Log.info("Entering the text in " + object);
			WebElement element = driver.findElement(OR.getLocator(object));
			element.clear();
			element.sendKeys(data);
			Thread.sleep(3000);
		} catch (Exception e) {
			Log.error("Not able to Enter text --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}
	
	public static void inputToFieldHasDefaultValue(String object, String data) {
		try {
			Log.info("input " + object);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element = driver.findElement(OR.getLocator(object));
			element.sendKeys(Keys.chord(Keys.CONTROL, "a"), data);// ctrl+A ->input value
			Thread.sleep(2000);
		} catch (Exception e) {
			Log.error("Not able to input --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}
	
	public static void verifyCellData(String object, String data) {
		try {
			Log.info("Verify cell data " + object);
			WebTable webTable = new WebTable(driver.findElement(OR.getLocator(object)));		
			String dataCell = data.split(",")[0];
			int rowIdx = Integer.parseInt(data.split(",")[1]);
			int cellIdx = Integer.parseInt(data.split(",")[2]);
			if(!webTable.getCellData(rowIdx,cellIdx).equals(dataCell)) {
				DriverScript.bResult = false;
			}
		} catch (Exception e) {
			Log.error("Text not correct --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void inputAddText(String object, String data) {
		try {
			Log.info("Entering the text add in " + object);
			WebElement element = driver.findElement(OR.getLocator(object));
			element.sendKeys(data);
			Thread.sleep(3000);
		} catch (Exception e) {
			Log.error("Not able to Enter text --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void clickItem(String object, String data) {
		try {
			Log.info("Clicking on Webelement " + object);
			driver.findElement(OR.getLocator(object)).click();
		} catch (Exception e) {
			Log.error("Not able to click --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void hoverToElement(String object, String data) {
		try {
			Log.info("Hovering on Webelement " + object);
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(OR.getLocator(object));
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			Log.error("Not able to click --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}
	public static void verifyTitle(String object, String data) {
		try {
			Log.info("Verify title page " + object);
			String title = driver.getTitle();
			if (!title.equals(data)) {
				DriverScript.bResult = false;
			}
		} catch (Exception e) {
			Log.error("Title not correct --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void verifyText(String object, String data) {
		try {
			Log.info("Verify text " + object);
			WebElement element = driver.findElement(OR.getLocator(object));
			System.out.println(element.getText());
			if (!element.getText().equals(data)) {
				DriverScript.bResult = false;
			}
		} catch (Exception e) {
			Log.error("Text not correct --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void verifyDisplay(String object, String data) {
		try {
			Log.info("Verify display item " + object);
			WebElement element = driver.findElement(OR.getLocator(object));
			if (!element.isDisplayed()) {
				DriverScript.bResult = false;
			}
		} catch (Exception e) {
			Log.error("Not able to display --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void waitFor(String object, String data) {
		try {
			Log.info("Waiting for item");
			Thread.sleep(3000);
		} catch (Exception e) {
			Log.error("Not able to wait item --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void acceptAlert(String object, String data) {
		try {
			Log.info("Accept alert");
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			Log.error("Not able to accept item --- " + e.getMessage());
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
