package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.framework.BasePage;

public class MagentoLoginPage extends BasePage {

	public MagentoLoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="[id='username']")
	private WebElement userNameField;
	
	@FindBy(css="[id='login']")
	private WebElement passwordField;
	
	@FindBy(css="[class*='action-login']")
	private WebElement loginButton;
	
	@FindBy(css="[class='page-title']")
	private WebElement pageTitleDashboard;

	@FindBy(css="[class='admin-user-account-text']")
	private WebElement userSettingIcon;
	
	@FindBy(css="[class='account-signout']")
	private WebElement logOutButton;
	
	@FindBy(css="[data-ui-id='messages-message-success']")
	private WebElement logOutSuccssMesg;
	
	public void loginApp(String userName, String password) {
		selectDropDownByText(userNameField, userName);
		inputTextWitClear(passwordField, password);
		clickOn(loginButton);	
	}
	
	public void verifyLoginSuccess(String userName) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(getText(userSettingIcon), userName);
	}
	
	public void logOut() {
		clickOn(userSettingIcon);
		clickOn(logOutButton);
		Assert.assertEquals(getText(logOutSuccssMesg), "You have logged out.");
	}
}
