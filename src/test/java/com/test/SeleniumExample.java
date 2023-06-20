package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumExample {
	
	@Test
	public void seleniumTest() {	
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.selenium.dev/blog/2022/introducing-selenium-manager/");
	}

}
