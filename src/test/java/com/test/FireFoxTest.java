package com.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FireFoxTest {
	
	@Test
	public void seleniumTest() {	
		WebDriver driver = new FirefoxDriver();	
		driver.get("https://www.selenium.dev/blog/2022/introducing-selenium-manager/");
		
		String js = 
				   "var performance = window.performance || window.mozPerformance" +
				                   " || window.msPerformance || window.webkitPerformance || {};" +
				   " return performance.getEntries();";
		
		JavascriptExecutor jsExecutor = ((JavascriptExecutor)driver);
		String str = jsExecutor.executeScript(js).toString();
		System.out.println(str);
	}

}
