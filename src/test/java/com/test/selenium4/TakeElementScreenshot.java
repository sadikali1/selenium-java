package com.test.selenium4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeElementScreenshot {

	@Test
	public void seleniumTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		WebElement buttonElement = driver.findElement(By.cssSelector("[data-testid='open-registration-form-button']"));
		File fileSource = buttonElement.getScreenshotAs(OutputType.FILE);
		File fileTarget = new File("button.png");
		FileUtils.copyFile(fileSource, fileTarget);
		
	
	}
}
