package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.BasePage;

public class UserManagementPage extends BasePage{
	
	public UserManagementPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[i[contains(@class, 'bi-plus')]]")
	private WebElement addButton;
	
	@FindBy(xpath="//div[div[label[text()='User Role']]]//div[contains(@class, 'oxd-select-text--after')]")
	private WebElement userRoleArow;
	
	@FindBy(xpath="//div[div[label[text()='Employee Name']]]//input")
	private WebElement userInput;
	
	@FindBy(xpath="//div[div[label[text()='Status']]]//div[contains(@class, 'oxd-select-text--after')]")
	private WebElement statusArrow;
	
	@FindBy(xpath="//div[@role='listbox']//span[text()='Enabled']")
	private WebElement enableStatus;
	
	@FindBy(xpath="//div[div[label[text()='Password']]]//input")
	private WebElement passwordInput;
	
	@FindBy(xpath="//div[div[label[text()='Username']]]//input")
	private WebElement userNameInput;
	
	@FindBy(xpath="//div[div[label[text()='Confirm Password']]]//input")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitButton;
	
	public void createUser(String userRole, String empName, String userName, String password) {
		clickOn(addButton);
		clickOn(userRoleArow);
		findElement(By.xpath("//div[@role=\"listbox\"]//span[text()='"+userRole+"']")).click();
		inputText(userInput, empName);
		clickOn(statusArrow);
		clickOn(enableStatus);
		
		inputText(userNameInput, userName);
		inputText(passwordInput, password);
		inputText(confirmPassword, password);
		clickOn(submitButton);
	}
}
