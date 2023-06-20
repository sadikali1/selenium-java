package com.test.selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenNewTabWindow {

	@Test
	public void seleniumTest() {
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.google.com");
		String winId = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://facebook.com/");
		String title1 = driver.getTitle();
		System.out.println(title1);
		//driver.close();
		driver.switchTo().window(winId);
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		
	}
}
