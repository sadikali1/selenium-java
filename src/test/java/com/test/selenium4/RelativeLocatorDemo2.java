package com.test.selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class RelativeLocatorDemo2 {

	@Test
	public void seleniumTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.applitools.com");
		String text = driver.findElement(RelativeLocator.with(By.tagName("label")).near(By.id("log-in"))).getText();	
		System.out.println(text);
		
		driver.navigate().to("https://demo.applitools.com/app.html");
		
		WebElement element = driver.findElement(RelativeLocator.with(By.cssSelector("td > span")).toLeftOf(By.xpath("//span[text()='Starbucks coffee']")));
		String todayText = element.getText();
		System.out.println(todayText);
		
		WebElement element1 = driver.findElement(RelativeLocator.with(By.cssSelector("td > span")).toRightOf(By.xpath("//span[text()='Starbucks coffee']")));
		String amountText = element1.getText();
		System.out.println(amountText);
		
		WebElement element2 = driver.findElement(RelativeLocator.with(By.cssSelector("td > a")).toRightOf(By.xpath("//span[text()='Starbucks coffee']")));
		String cat = element2.getText();
		System.out.println(cat);
		
	}
}
