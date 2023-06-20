package com.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.BaseTest;
import com.pages.LoginPage;
import com.report.TestListener;

public class Login extends BaseTest{

	@Test
	public void testLogin() {
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(userName, password);
		
	}

}
