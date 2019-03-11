package com.AutomationFramework.Common;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	LinkedHashMap<String, LinkedHashMap<String, String>> TestData;
	private static ExcelManager instance = null;

	public static ExcelManager getInstace() {
		if (instance == null) {
			instance = new ExcelManager();
		}
		return instance;
	}

	public void setTestData(String testDataFileLocation) throws Exception {
		TestData = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		File excel = new File(testDataFileLocation);
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheetAt(0);
		int rowNum = ws.getLastRowNum() + 1;
		int colNum = ws.getRow(0).getLastCellNum();

		for (int i = 1; i < rowNum; i++) {
			String TestID = null;
			LinkedHashMap<String, String> CurrentHashMap = new LinkedHashMap<String, String>();
			for (int j = 0; j < colNum; j++) {
				if (ws.getRow(0).getCell(j) == null) {
					ws.getRow(0).createCell(j);
				}
				if (ws.getRow(i).getCell(j) == null) {
					ws.getRow(i).createCell(j);
				}
				CurrentHashMap.put(ws.getRow(0).getCell(j).getStringCellValue(),
						ws.getRow(i).getCell(j).getStringCellValue());
				if (ws.getRow(0).getCell(j).getStringCellValue().equalsIgnoreCase("TestID")) {
					TestID = ws.getRow(i).getCell(j).getStringCellValue();
				}
				//System.out.println(CurrentHashMap);
			}

			TestData.put(TestID, CurrentHashMap);
		}
		// System.out.println(TestData);
		wb.close();
	}

	public LinkedHashMap<String, LinkedHashMap<String, String>> getTestData() {

		return TestData;
	}

	public String getData(String Value) {
		if (Value.startsWith("#")) {
			Value = Value.substring(1, Value.length());
			// System.out.println(TestIDSetupManager.getInstace().getTestID());
			// System.out.println(ExcelManager.getInstace().getTestData().get(TestIDSetupManager.getInstace().getTestID()).get(Value));
			String TestID = TestIDSetupManager.getInstace().getTestID();
			LinkedHashMap<String, String> TestRow = ExcelManager.getInstace().getTestData().get(TestID);
			return TestRow.get(Value);
		} else {
			return Value;
		}
	}
}
