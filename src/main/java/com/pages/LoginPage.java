package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.framework.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name= "username")
	private WebElement userInput;
	
	@FindBy(name= "password")
	private WebElement passwordInput;
	
	@FindBy(tagName = "button")
	private WebElement submitButton;
	
	@FindBy(tagName = "h6")
	private WebElement headerLebel;
	
	public void login(String userName, String password) {
		inputText(userInput, userName);
		inputText(passwordInput, password);
		clickOn(submitButton);
	
		String text = getText(headerLebel);
		Assert.assertEquals(text, "Dashboard");
	}
}
