package com.AutomationFramework.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserManager {

	protected static WebDriver driver = null;
	private static BrowserManager instance = null;

	public static WebDriver getDriver() {
		return driver;
	}

	public static BrowserManager getInstace() {
		if (instance == null) {
			instance = new BrowserManager();
		}
		return instance;
	}

	public void openBrowser(String browserName) {
		try {
			switch (browserName) {
			case "Firefox":

				System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
				driver = new FirefoxDriver();

				break;
			case "IE":

				System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

				break;
			case "Chrome":

				System.setProperty("webdriver.chrome.driver", "drivers\\ChromeDriver.exe");
				driver = new ChromeDriver();

				break;

			case "Edge":

				System.setProperty("webdriver.edge.driver", "drivers\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();

				break;

			}

			ReportManager.getInstace().reportLog("PASS", browserName + " browser successfully opened", true);
			System.out.println(browserName + " browser successfully opened");
		} catch (Exception e) {
			ReportManager.getInstace().reportLog("FAIL", "Please check some issue with opening browser " + browserName,
					true);
			System.out.println("Please check some issue with opening browser " + browserName);
			e.printStackTrace();
		}
	}

	public void closeBrowser() {
		try {

			driver.quit();
			driver = null;
			ReportManager.getInstace().reportLog("PASS", " browser successfully closed", true);
		} catch (Exception e) {
			ReportManager.getInstace().reportLog("FAIL", " browser not closed", true);
		}

	}

}
