package com.selenium.tests;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.BaseTest;
import com.pages.DashboardPage;
import com.pages.LoginPage;

public class Dashboard extends BaseTest{

	@Test
	public void validateMenus() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		loginPage.login(userName, password);

		List<String> expectedMenu = Stream.of("Admin", "PIM", "Leave", "Time", "Recruitment", "My Info", "Performance",
				"Dashboard", "Directory", "Maintenance", "Buzz").collect(Collectors.toList());

		List<String> allMenus = dashboardPage.getAllMenus();
		Assert.assertEquals(expectedMenu, allMenus);
		
	}

	@Test
	public void validateWidgetMenu() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		loginPage.login(userName, password);

		List<String> expectedSection = Stream
				.of("Time at Work", "My Actions", "Quick Launch", "Buzz Latest Posts", "Employees on Leave Today",
						"Employee Distribution by Sub Unit", "Employee Distribution by Location")
				.collect(Collectors.toList());

		List<String> allSection =dashboardPage.getAllWidgetName();
		Assert.assertEquals(expectedSection, allSection);
	}

}
