package com.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.framework.BaseTest;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.UserManagementPage;

public class UserManagement extends BaseTest{

	@Test
	public void testLogin() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		UserManagementPage userManagementPage = PageFactory.initElements(driver, UserManagementPage.class);
		loginPage.login(userName, password);
		dashboardPage.clickAdmin();
		userManagementPage.createUser("Admin", "username1", "username1", "Password@123");
	}

}
