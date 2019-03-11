package com.AutomationFramework.Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileManager {
	private FileInputStream stream;
	private String RepositoryFile;
	private Properties propertyFile;
	private static PropertyFileManager instance = null;
	public static PropertyFileManager getInstace() {
		if (instance == null) {
			instance = new PropertyFileManager();
		}
		return instance;
	}
	public void RespositoryParser(String fileName) throws IOException {
		propertyFile = new Properties();
		this.RepositoryFile = fileName;
		stream = new FileInputStream(RepositoryFile);
		propertyFile.load(stream);
		System.out.println("-----------------------------------");
		System.out.println(propertyFile);
	}

	public String getlocatorProperty(String objectName) {
		String locatorProperty;
		if (objectName.startsWith("#")) {
			objectName=objectName.substring(1, objectName.length());
			locatorProperty = propertyFile.getProperty(objectName);
		} else {
			locatorProperty = objectName;
		}
		System.out.println("locatr property-----"+locatorProperty);
		return locatorProperty;

	}
	
	
}
