package com.selenium.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.data.MyDataProvider;
import com.framework.BaseTest;
import com.pages.MagentoLoginPage;

public class MagentoLogin extends BaseTest implements ITest {
	
	 private ThreadLocal<String> testName = new ThreadLocal<>();
	 
	@BeforeMethod
	public void setupMethod(Method method, Object[] testData) {
		testName.set(method.getName() + "_"+((String)testData[2]));
	}
	
	@Test(dataProvider = "TestData", dataProviderClass = MyDataProvider.class)
	public void testLogin(String user, String password, String userName) {
		MagentoLoginPage magentoLoginPage = PageFactory.initElements(getWebDriver(), MagentoLoginPage.class);
		super.addLog("Login into application with user name "+user);
		magentoLoginPage.loginApp(user, password);
		
		super.addLog("Verify user "+userName+" login successfully");
		magentoLoginPage.verifyLoginSuccess(userName);
		
		super.addLog("Log out from application");
		magentoLoginPage.logOut();
	}
	
	@Test(dataProvider = "TestDataExcel", dataProviderClass = MyDataProvider.class)
	public void testLoginWithExcelData(String user, String password, String userName) {
		MagentoLoginPage magentoLoginPage = PageFactory.initElements(getWebDriver(), MagentoLoginPage.class);
		super.addLog("Login into application with user name "+user);
		magentoLoginPage.loginApp(user, password);
		
		super.addLog("Verify user "+userName+" login successfully");
		magentoLoginPage.verifyLoginSuccess(userName);
		
		super.addLog("Log out from application");
		magentoLoginPage.logOut();
	}

	@Override
	public String getTestName() {
		return testName.get();
	}
}
