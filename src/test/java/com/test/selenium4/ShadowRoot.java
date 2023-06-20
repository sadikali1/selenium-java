package com.test.selenium4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowRoot {
	
	private WebDriver driver;
	
	@Test
	public void testShadowRoot() {
		driver = new ChromeDriver();
		driver.get("http://watir.com/examples/shadow_dom.html");		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		WebElement element = driver.findElement(By.cssSelector("[id='shadow_host']"));
		SearchContext context = element.getShadowRoot();
		
		String text = context.findElement(By.cssSelector("[id='shadow_content']")).getText();
		System.out.println(text);
		
		WebElement elementInnerShadowRoot = driver.findElement(By.cssSelector("[id='nested_shadow_host']"));
		SearchContext contextInner = elementInnerShadowRoot.getShadowRoot();
		
		String innerText = contextInner.findElement(By.cssSelector("[id='nested_shadow_content'] div")).getText();
		System.out.println(innerText);
	}

}
