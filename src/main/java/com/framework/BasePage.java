package com.framework;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	int timeOut = 10;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitAndClick(WebElement element) {
		waitForElementClickable(element);
		element.click();
	}

	
	public void clickOn(WebElement element) {
		element.click();
	}


	/**
	 * Click on element using java scripts
	 *
	 * @param webElement
	 */
	public void jsClick(WebElement webElement) {
		waitForElementVisible(webElement);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", webElement);
	}

	public WebElement findElement(By by) {
		return driver.findElement(by);
	}
	/**
	 * Get Page title
	 *
	 * @return
	 */
	public String getTitle() {
		return driver.getTitle();
	}

	/**
	 * Get Page source
	 *
	 * @return
	 */
	public String getPageSource() {
		return driver.getPageSource();
	}

	/**
	 * Enter text in to input box
	 *
	 * @param element : WebElement object
	 * @param text    : text to enter in input box
	 */
	public void inputText(WebElement element, String text) {
		waitForElementVisible(element);
		element.sendKeys(text);
	}

	

	/**
	 * Clear input box and enter text
	 *
	 * @param element : WebElement object
	 * @param text    : text to enter in input box
	 */
	public void inputTextWitClear(WebElement element, String text) {
		waitForElementVisible(element);
		element.clear();
		waitAndClick(element);
		element.sendKeys(text);
	}


	/**
	 * check if element present
	 *
	 * @param element
	 * @return
	 */
	public Boolean isElementPresent(WebElement element) {
		return element.isDisplayed();
	}


	/** Wait for element to be present */
	public WebElement waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}


	/** Wait for element to be present */
	public WebElement waitForElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/** Wait for element to be present */
	public WebElement waitForElementPresent(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	/**
	 * @param by     : By object
	 * @param driver
	 */
	public void waitForElementToBecomeVisible(By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}



	/** Wait for JSLoad to load */
	public boolean _waitForJStoLoad() {
		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = driver -> {
			try {
				return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
			} catch (Exception e) {
				return true;
			}
		};

		/** wait for JavaScript to load */
		ExpectedCondition<Boolean> jsLoad = driver -> {
			Object rsltJs = ((JavascriptExecutor) driver).executeScript("return document.readyState");
			if (rsltJs == null) {
				rsltJs = "";
			}
			return rsltJs.toString().equals("complete") || rsltJs.toString().equals("loaded");
		};
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}


	/**
	 * Wait for element contains text
	 * 
	 * @param element
	 * @param text
	 */
	public void waitForTextPresentInElement(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	/**
	 * Wait element to be in visibility
	 *
	 * @param by
	 */
	public void waitForElementToBecomeInvisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	/**
	 * Wait for page load
	 */
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver)
				.executeScript("return document.readyState").equals("complete");
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(expectation);
	}

	

	/**
	 * Select element by visible text
	 *
	 * @param element
	 * @param targetValue : visible text of Option
	 */
	public void selectDropDownByText(WebElement element, String targetValue) {
		waitForElementVisible(element);
		new Select(element).selectByVisibleText(targetValue);
	}

	/**
	 * Select drop down value using index
	 *
	 * @param element : : WebELement object of drop down
	 * @param index   : index of option
	 */
	public void selectDropDownByIndex(WebElement element, int index) {
		waitForElementVisible(element);
		new Select(element).selectByIndex(index);
	}

	/**
	 * Select drop down value using value
	 *
	 * @param element     : WebELement object of drop down
	 * @param targetValue : value of option
	 */
	public void selectDropDownByValue(WebElement element, String targetValue) {
		waitForElementVisible(element);
		new Select(element).selectByValue(targetValue);
	}

	/**
	 * Get text from locator
	 *
	 * @param element : object of element
	 * @return
	 */
	public String getCssValueValue(WebElement element, String cssName) {
		waitForElementVisible(element);
		return element.getCssValue(cssName);
	}

	/**
	 * Get text from locator
	 *
	 * @param element : object of element
	 * @return
	 */
	public String getText(WebElement element) {
		waitForElementVisible(element);
		return element.getText();
	}

	/**
	 * Get Attribute value of WebElement object
	 *
	 * @param element       : WebElement object
	 * @param attributeName : attribute name
	 * @return
	 */
	public String getAttribute(WebElement element, String attributeName) {
		waitForElementVisible(element);
		return element.getAttribute(attributeName);
	}

	/**
	 * Perform Drag and drop
	 *
	 * @param drag : source webElement object
	 * @param drop : target webElement object
	 */
	public void dragAndDrop(WebElement drag, WebElement drop) {
		Actions builder = new Actions(driver);
		waitForElementVisible(drag);
		waitForElementVisible(drop);
		Action dragAndDrop = builder.clickAndHold(drag).moveToElement(drop).release(drop).build();
		dragAndDrop.perform();
	}

	/**
	 * Move to element
	 *
	 * @param element : WebElement object
	 */
	public void moveToElement(WebElement element) {
		waitForElementVisible(element);
		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
	}

	/**
	 * Move and click on element
	 *
	 * @param element : WebElement object
	 */
	public void moveAndClickOnElement(WebElement element) {
		waitForElementVisible(element);
		Actions builder = new Actions(driver);
		builder.moveToElement(element).click(element).build().perform();
	}

	/**
	 * Move and right click on element
	 *
	 * @param element : WebElement object
	 */
	public void moveAndRigtClickOnElement(WebElement element) {
		waitForElementVisible(element);
		Actions builder = new Actions(driver);
		builder.moveToElement(element).contextClick(element).release().build().perform();
	}


	public Boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

	public Boolean isClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void executeJsScrollToElement(WebElement element) {
		waitForElementVisible(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250)");
	}
	
	public void executeJsScrollToBottom() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void executeJsScrollToTop() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
	}
	
	public String getCurrentURL() {
		waitForPageLoaded();
		return driver.getCurrentUrl();
	}

	
	public void openURL(String url) {
		driver.navigate().to(url);
	}

	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void navigateForward() {
		driver.navigate().forward();
	}

	/*
	 * switch to main window
	 */
	public String switchChildWinow() {
		String parentWinId = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		return parentWinId;
	}

	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

	}

}
