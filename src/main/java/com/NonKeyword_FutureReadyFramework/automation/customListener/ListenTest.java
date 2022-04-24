/* Name: ListenTest 
 * Description: This script is to log report for all Criteria
 * Developed By: Chyne Chandran
 * Automation Architect: Jayant Naikwade
 * Input = Configurable Excel File  
 * Developed Date: 
 * Updated Date: 
 * Updated Reason:
 */
package com.NonKeyword_FutureReadyFramework.automation.customListener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.NonKeyword_FutureReadyFramework.automation.testBase.BaseClass;
import com.NonKeyword_FutureReadyFramework.automation.testBase.ExtReporterClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenTest extends BaseClass implements ITestListener {
	ExtentReports extent = ExtReporterClass.extReportGenerator();
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "SUCCESSFULL: " +result.getMethod().getMethodName());

	}

	public void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable());

		try {
			test.addScreenCaptureFromPath(getScreenshotpath(result.getMethod().getMethodName()), "FAILED");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
