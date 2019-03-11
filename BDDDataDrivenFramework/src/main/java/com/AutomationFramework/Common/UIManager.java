package com.AutomationFramework.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UIManager extends BrowserManager {
	
	private static UIManager instance = null;
	
	public static UIManager getInstace() {
		if (instance == null) {
			instance = new UIManager();
		}
		return instance;
	}
	
	public void openAnyURL(String URL) {
		try {
			URL = ExcelManager.getInstace().getData(URL);
			getDriver().get(URL);
			System.out.println("Application " + URL + " successfully launched");
			ReportManager.getInstace().reportLog("PASS", "Application " + URL + " successfully launched", true);
		} catch (Exception e) {
			ReportManager.getInstace().reportLog("FAIL", "Unable to launch Application with URL " + URL, true);
		}
	}

	public WebElement findElemet(String objectName) {
		String locatorProperty = PropertyFileManager.getInstace().getlocatorProperty(objectName);
		String locatorType = locatorProperty.split(":")[0];
		String locatorValue = locatorProperty.split(":")[1];
		WebElement element = null;
		try {
			switch (locatorType) {
			case "xpath":
				if (element == null) {
					element = getDriver().findElement(By.xpath(locatorValue));
				}
				break;
			case "cssSelector":
				if (element == null) {
					element = getDriver().findElement(By.cssSelector(locatorValue));

				}
				break;
			case "id":

				if (element == null) {
					element = getDriver().findElement(By.id(locatorValue));

				}
				break;

			case "name":

				if (element == null) {
					element = getDriver().findElement(By.name(locatorValue));

				}
				break;
			case "linkText":

				if (element == null) {
					element = getDriver().findElement(By.linkText(locatorValue));

				}
				break;

			case "partiallinkText":

				if (element == null) {
					element = getDriver().findElement(By.partialLinkText(locatorValue));

				}
				break;

			case "tagname":

				if (element == null) {
					element = getDriver().findElement(By.tagName(locatorValue));

				}
				break;

			}
			ReportManager.getInstace().reportLog("PASS",
					"Successfully Found " + objectName + "with " + locatorType + " having value " + locatorValue,
					true);
		} catch (Exception e) {
			ReportManager.getInstace().reportLog("FAIL",
					"Unable to Find " + objectName + "with " + locatorType + " having value " + locatorValue,
					true);

		}

		return element;
	}

	public void enterValueIntoTextBox(String objectProperty, String textBoxValue) {
		try {
			System.out.println(objectProperty+"----------------------------------------------------");
			findElemet(objectProperty).sendKeys(ExcelManager.getInstace().getData(textBoxValue));
			ReportManager.getInstace().reportLog("PASS",
					"Text Box Value " + textBoxValue + " successfully entered into " + objectProperty, true);
		} catch (Exception e) {
			ReportManager.getInstace().reportLog("FAIL",
					"Text Box Value " + textBoxValue + " is unable to enter into " + objectProperty, true);
		}

	}

	public void clickOnAnyElement(String objectProperty) {
		try {
			findElemet(objectProperty).click();
			ReportManager.getInstace().reportLog("PASS", "successfully clicked on " + objectProperty, true);
		} catch (Exception e) {
			ReportManager.getInstace().reportLog("FAIL", "unable to click on " + objectProperty, true);
		}
	}

	public static void main(String[] args) throws Exception {
		ReportManager.getInstace().initializeReport();
		ExcelManager.getInstace()
				.setTestData("E:\\SpringWorkspace\\BDDDataDrivenFramework\\ExcelSheets\\TestData.xlsx");
		TestIDSetupManager.getInstace().setTestID("Test2");
		PropertyFileManager.getInstace()
				.RespositoryParser("E:\\SpringWorkspace\\BDDDataDrivenFramework\\PropertyFiles\\PF1.properties");
		UIManager obj = new UIManager();
		obj.openBrowser("Chrome");
		obj.openAnyURL("#URL");
		obj.enterValueIntoTextBox("#homepageUsernameTextBox", "#Gmail");
		obj.enterValueIntoTextBox("#homepagePasswordTextBox", "#Password");
		obj.clickOnAnyElement("#homepageLoginButton");
		BrowserManager.getInstace().closeBrowser();

		ReportManager.getInstace().closeReport();
		ReportManager.getInstace().initializeReport();
		ExcelManager.getInstace()
				.setTestData("E:\\SpringWorkspace\\BDDDataDrivenFramework\\ExcelSheets\\TestData.xlsx");
		TestIDSetupManager.getInstace().setTestID("Test2");
		PropertyFileManager.getInstace()
				.RespositoryParser("E:\\SpringWorkspace\\BDDDataDrivenFramework\\PropertyFiles\\PF1.properties");
		
		obj.openBrowser("Chrome");
		obj.openAnyURL("#URL");
		obj.enterValueIntoTextBox("#homepageUsernameTextBox", "#Gmail");
		obj.enterValueIntoTextBox("#homepagePasswordTextBox", "#Password");
		obj.clickOnAnyElement("#homepageLoginButton");
		BrowserManager.getInstace().closeBrowser();

		ReportManager.getInstace().closeReport();

	}
}
