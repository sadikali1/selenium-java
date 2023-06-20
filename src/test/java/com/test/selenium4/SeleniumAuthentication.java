package com.test.selenium4;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SeleniumAuthentication {

	@Test
	public void seleniumTest() {
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOption);
		
		HasAuthentication authentication = (HasAuthentication) driver;
		authentication.register(() -> new UsernameAndPassword("admin", "admin"));

		driver.get("https://the-internet.herokuapp.com/basic_auth");
	}
}
