package com.AutomationFramework.stepDefination;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.AutomationFramework.Common.BrowserManager;
import com.AutomationFramework.Common.ExcelManager;
import com.AutomationFramework.Common.PropertyFileManager;
import com.AutomationFramework.Common.ReportManager;
import com.AutomationFramework.Common.TestIDSetupManager;
import com.AutomationFramework.Common.UIManager;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;


public class StepDefination {
	@Before
    public void beforeScenario(Scenario scenario){
		    // System.out.println(scenario.getName());
		   // ReportManager.getInstace().featureFileName(scenario);
		    
		     ReportManager.getInstace().setScenarioName(scenario.getName());
		
    }	
	
	
	
	
	
	@Given("^user enter credentials to login$")
	public void user_enter_credentials_to_login(List<Mobile> args1) throws Throwable {
		//Write the code to handle Data Table
				/*List<List<String>> data = arg1.raw();
				System.setProperty("webdriver.chrome.driver", "drivers\\ChromeDriver.exe");
				WebDriver driver=new ChromeDriver();
				
				
				for (int i = 0; i < data.size(); i++) {
					List<String> each=data.get(i);
					driver.get("https://www.facebook.com/");
					//This is to get the first data of the set (First Row + First Column)
					driver.findElement(By.id("email")).sendKeys(data.get(i).get(0)); 
			 
					//This is to get the first data of the set (First Row + Second Column)
				    driver.findElement(By.id("pass")).sendKeys(data.get(i).get(1));
			 
				    driver.findElement(By.xpath("//input[@value='Log In']")).click();
					
				}*/
		
		/*List<Map<String,String>> data = arg1.asMaps(String.class,String.class);
		System.out.println(data);
		System.out.println(data.size());
		for (int i = 0; i < data.size(); i++) {
			Map<String,String> mapp=data.get(i);
			System.out.println(mapp);
			System.out.println(mapp.get("Username"));
			System.out.println(mapp.get("Password"));
		}*/
		
		/*for (Map<String,String> data:args1.asMaps(String.class,String.class)) {
			System.out.println(data.get("vky"));
			System.out.println(data.get("Username"));
			System.out.println(data.get("Password"));
		}*/
			
		
			
			for (Mobile mobile : args1) {
				System.out.println(mobile.getLog());
				System.out.println(mobile.getUserName());
				System.out.println(mobile.getPassword());
				
			}	
	}
	
	
	
	
	
	
	
	
	@Given("^user read test data from Excel \"([^\"]*)\"$")
	public void user_read_test_data_from_Excel(String fileLocation) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ReportManager.getInstace().initializeReport();
		ExcelManager.getInstace().setTestData(fileLocation);
	}
	@Given("^user add \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_add_and(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println(arg1+arg2);
	}

	@Given("^set test id \"([^\"]*)\"$")
	public void set_test_id(String testID) throws Throwable {

		TestIDSetupManager.getInstace().setTestID(testID);
	}

	@Given("^user read objects from property file \"([^\"]*)\"$")
	public void user_read_objects_from_property_file(String propertyFileLocation) throws Throwable {
		PropertyFileManager.getInstace().RespositoryParser(propertyFileLocation);

	}
	@Given("^user open browser \"([^\"]*)\"$")
	public void user_open_browser(String browserName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   BrowserManager.getInstace().openBrowser(browserName);
	}

	@Given("^user open Application using URL \"([^\"]*)\"$")
	public void user_open_Application_using_URL(String URL) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		UIManager.getInstace().openAnyURL("#URL");
	}

	@Given("^user enter text \"([^\"]*)\" into textBox \"([^\"]*)\"$")
	public void user_enter_text_into_textBox(String objectProperty, String textBoxValue) throws Throwable {
		UIManager.getInstace().enterValueIntoTextBox(objectProperty, textBoxValue);
	}

	@Given("^user click on \"([^\"]*)\"$")
	public void user_click_on(String objectProperty) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		UIManager.getInstace().clickOnAnyElement(objectProperty);
	}
	@Given("^user close browser$")
	public void user_close_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    BrowserManager.getInstace().closeBrowser();
	    ReportManager.getInstace().closeReport();
	}
	
}
