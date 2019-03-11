package com.AutomationFramework.Common;

public class TestIDSetupManager {
	String testId;
	private static TestIDSetupManager instance = null;
	public void setTestID(String TestId)
	{
		testId=TestId;
	}
	
public String getTestID()
{
	return testId;
}
public static TestIDSetupManager getInstace() {
	if (instance == null) {
		instance = new TestIDSetupManager();
	}
	return instance;
}
}
