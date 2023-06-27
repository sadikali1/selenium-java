package com.data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.ExcelUtils;

public class MyDataProvider {
	
	private String excelName= "DataFile.xlsx";
	
	@DataProvider(name="TestData")
	public Object[][] getData(){
		Object[][] obj = new Object[][] {
			{"Visual Merchandiser", "demo123", "Visual Merchandiser"},
			{"Other Extensions", "demo123", "demo_other"},
			{"ACM & A3M", "demo123", "demo"},
			{"Estimated Delivery Date", "demo123", "demo_edd"},
			{"Customer Item Stock Alert", "demo123", "cisa"},
			{"ConditionalCheckout", "demo123", "ConditionalCheckout" },
			{"Monetico", "demo123", "monetico"},
			{"PWA", "demo123", "pwa"},
		};
		return obj;
	}

	
	@DataProvider(name="TestDataExcel")
	public Object[][] getDataExcel(){

		ExcelUtils read = new ExcelUtils(excelName, "testdata/");
		Object[][] objs = new Object[read.retrieveNoOfRows("UserDetail") - 1][read.retrieveNoOfCols("UserDetail")];
		objs = read.retrieveTestData("UserDetail");
		return objs;
	}

	
	@Test(dataProvider = "TestDataExcel")
	public void testData(String user, String password, String userName) {
		System.out.println(user + " "+password + " "+userName);
	}
}
