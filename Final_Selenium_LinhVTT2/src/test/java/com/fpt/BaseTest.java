package com.fpt;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	public static RemoteWebDriver driver = null;
	public static String index = "";
	// ThreadLocal will keep local copy of driver
	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();

	@BeforeMethod
	// Parameter will get browser from testng.xml on which browser test to run
	@Parameters({ "platform", "browser" })
	public void beforeClass(String platform, String browser) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		// Platform
		if (platform.equalsIgnoreCase("Windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}
		if (platform.equalsIgnoreCase("MAC")) {
			caps.setPlatform(Platform.MAC);
		}

		if (browser.equalsIgnoreCase("Chrome")) {
			index = "Chrome";
			caps = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://localhost:5588/wd/hub"), caps);

		}
		if (browser.equalsIgnoreCase("Firefox")) {
			index = "Firefox";
			caps = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(new URL("http://localhost:5577/wd/hub"), caps);
		}

		setWebDriver(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public WebDriver getDriver() {
		return dr.get();
	}

	public void setWebDriver(RemoteWebDriver driver) {
		dr.set(driver);
	}

	@AfterMethod
	public void afterClass() {
		getDriver().quit();
		dr.set(null);

	}
}
