package com.yashraj.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.yashraj.base.BaseTest;
import com.yashraj.utils.ExtentManager;
import com.yashraj.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

	private static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		test = ExtentManager.getExtentReports().createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, result.getThrowable());

		String screenshot = ScreenshotUtil.capture(BaseTest.getPage(), result.getMethod().getMethodName());

		test.addScreenCaptureFromPath(screenshot);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("******** TestListener Started ********");
		ExtentManager.getExtentReports();
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("******** Flushing Report ********");
		ExtentManager.getExtentReports().flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, "Test Skipped");
	}

}