package com.framework;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListners implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println(arg0.getName());
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println(arg0.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println(arg0.getStatus());

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println(arg0.getStatus());

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println(arg0.getStatus());

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println(arg0.getStatus());

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println(arg0.getStatus());

	}

}
