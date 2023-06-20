package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.BasePage;

public class DashboardPage extends BasePage{

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="[class='oxd-main-menu'] > li > a> span")
	private List<WebElement> menusElement;
	
	@FindBy(css="[class='oxd-main-menu'] > li > a> span")
	private List<WebElement> widgetElement;
	
	@FindBy(xpath="//a/span[text()='Admin']")
	private WebElement adminMenu;
	
	public List<String> getAllMenus() {
		List<String> allMenus = new ArrayList<>();
		menusElement.stream().forEach(menuElement -> allMenus.add(menuElement.getText()));
		return allMenus;
	}
	
	public List<String>  getAllWidgetName() {
		List<String> allMenus = new ArrayList<>();
		widgetElement.stream().forEach(menuElement -> allMenus.add(menuElement.getText()));
		return allMenus;
	}
	
	public void clickAdmin() {
		adminMenu.click();
	}
}
