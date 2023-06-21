package com.report;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int counter=1;
	int maxRetry=2;
	
	@Override
	public boolean retry(ITestResult result) {
		if(counter < maxRetry) {
			counter++;
			return true;
		}
		return false;
		
	}

}
