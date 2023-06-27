package com.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.report.RetryAnalyzer;

public class TestExample {
	
	@Test //(retryAnalyzer = RetryAnalyzer.class)
	public void test1() {
		System.out.println("Testing1");
		Assert.assertEquals(false, false);
	}
	
	@Test(description = "THis is testing")
	public void test2() {
		System.out.println("Testing1");
	}

}
