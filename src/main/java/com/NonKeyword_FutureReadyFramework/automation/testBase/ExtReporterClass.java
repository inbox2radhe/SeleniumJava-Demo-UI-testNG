/* Name: ExtReporterClass Script 
 * Description: This script is used to drive the Extent Reports
 * Developed By: Chyne Chandran
 * Automation Architect: Jayant Naikwade
 * Input = Configurable Excel File  
 * Developed Date: 
 * Updated Date: 
 * Updated Reason:
 */
package com.NonKeyword_FutureReadyFramework.automation.testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtReporterClass {
	
	public static  ExtentReports extent;
	

	public static ExtentReports extReportGenerator() {
		String reportspath = System.getProperty("user.dir")+"\\reports\\AutomationTestReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportspath);
		reporter.config().setReportName("NonKeyword_FutureReadyFramework automation Results");
		reporter.config().setDocumentTitle("Automation Report POD 2.0");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
		
	}
}
