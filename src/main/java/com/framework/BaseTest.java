package com.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.report.ReportTestManager;

public class BaseTest {
	
	protected WebDriver driver;
	protected String userName;
	protected String password;
	protected String appUrl;
	private String browserType;
	protected static Properties properties;
	

	@Parameters({"BrowserName"})
	@BeforeMethod
	public void setup(@Optional String browserName) {
		userName = getConfig("UserName");
		password = getConfig("Password");
		appUrl = getConfig("Url");
		browserType = getConfig("BrowserType");
		if(browserName != null) {
			this.browserType = browserName;
		}
		if(browserType.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if(browserType.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			throw new RuntimeException("Please provide valid value of browser");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(appUrl);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	public void addLog(String message) {
		if (ReportTestManager.getTest()!=null)
			ReportTestManager.getTest().log(Status.PASS, message);
	}
	
	public static String getConfig(String key) {
		return properties.get(key).toString();
	}
	
	static {
		properties = new Properties();
		try {
			FileInputStream file= new FileInputStream(new File("config.properties"));
			properties.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
}
