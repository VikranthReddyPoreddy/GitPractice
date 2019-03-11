package com.AutomationFramework.Common;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;

public class ReportManager {
	ExtentReports report;
	ExtentTest logger;
	String Reportpath;
	public static ReportManager instance = null;
	private String scenarioName;
	
	
	public void initializeReport()
	{
		Reportpath = System.getProperty("user.dir")+"//Reports//" +"Run"+ System.currentTimeMillis()+"//";
		String TestID=TestIDSetupManager.getInstace().getTestID();
		String extentReportFile = Reportpath +TestID+"//"+ "report.html";
		report=new ExtentReports(extentReportFile);
		 
		logger=report.startTest(scenarioName);
	}
	
	
	public static ReportManager getInstace() {
		if (instance == null) {
			instance = new ReportManager();
		}
		return instance;
	}
	public void reportLog(String resultStatus, String textInReport, Boolean screenShotstatus)
	{
		if(resultStatus.equals("INFO"))
		{
			logger.log(LogStatus.INFO, textInReport);
		}
		else if(resultStatus.equals("PASS"))
		{
			logger.log(LogStatus.PASS, textInReport);
		}
		else if (resultStatus.equals("FAIL")) {
			logger.log(LogStatus.FAIL, textInReport);
			
		}
		
	}
	public void closeReport()
	{
		report.endTest(logger);
		report.flush();
	}

	public void setScenarioName(String scenarioName) {
		// TODO Auto-generated method stub
		this.scenarioName= scenarioName;
		
	}
	public String featureFileName(Scenario scenario)
	{
		 String featureName = "";
	     String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
	     featureName = rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
	     //System.out.println(featureName); 
	     return featureName;
	}
	
	

}
