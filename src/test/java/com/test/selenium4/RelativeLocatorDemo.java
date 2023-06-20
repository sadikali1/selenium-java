package com.test.selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.testng.annotations.Test;

public class RelativeLocatorDemo {

	@Test
	public void seleniumTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.applitools.com/index.html");
		
		String heading = driver.findElement(with(By.tagName("h4")).above(By.id("username"))).getText();
		System.out.println(heading);
		
		String text1 = driver.findElement(with(By.tagName("label")).above(By.id("username"))).getText();
		System.out.println(text1);
		
		String text2 = driver.findElement(with(By.tagName("label")).below(By.id("username"))).getText();
		System.out.println(text2);
		
		driver.findElement(with(By.tagName("a")).below(By.id("username"))).click();
		
	}
}
