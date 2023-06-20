package com.test;

import java.time.Duration;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumToken {
	
	@Test
	public void selenuimTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		Cookie cookie = driver.manage().getCookieNamed("orangehrm");
		System.out.println(cookie.getValue());
		Cookie newCookie = new Cookie(cookie.getName(), "f952cb4bb08f719f48943fb9383479d5", cookie.getDomain(), cookie.getPath(), 
				cookie.getExpiry(), cookie.isSecure());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().addCookie(newCookie);		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	}

}
