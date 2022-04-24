/* Name: Driver Script 
 * Description: This driver script is used to drive end to end Test Automation
 * Developed By: Chyne Chandran
 * Automation Architect: Jayant Naikwade
 * Input = Configurable Excel File  
 * Developed Date: 
 * Updated Date: 
 * Updated Reason:
 */

package com.NonKeyword_FutureReadyFramework.automation.frameworkDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.NonKeyword_FutureReadyFramework.automation.excelReader.ExcelUtils;

public class DriverScript extends ExcelUtils {

	private void testRunner() throws Throwable {

		TestNG testNG = new TestNG();

		XmlSuite suite = getXmlSuite();

		XmlTest test = getXmlTest(suite);

		List<XmlClass> classes = getXmlClasses();

		test.setXmlClasses(classes);

		List<XmlTest> tests = new ArrayList<XmlTest>();

		tests.add(test);

		suite.setTests(tests);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();

		suites.add(suite);

		testNG.setXmlSuites(suites);

		testNG.run();

	}

	private XmlSuite getXmlSuite() {

		XmlSuite suite = new XmlSuite();

		suite.setName("Test Suite");

		return suite;

	}

	private XmlTest getXmlTest(XmlSuite suite) {

		XmlTest test = new XmlTest(suite);

		test.setName("test");

		return test;

	}

	private List<XmlClass> getXmlClasses() throws IOException {

		List<XmlClass> classlistSatusY = new ArrayList<XmlClass>();
		for (String xmlClass : ExcelUtils.excelReadTestCase()) {
			classlistSatusY.add(new XmlClass(xmlClass));
		}
		return classlistSatusY;

	}

	public static void main(String args[]) throws Throwable {

		DriverScript driverscript = new DriverScript();

		try {
			driverscript.testRunner();

		} catch (Exception e) {

			System.err.println(e.toString());
			throw new RuntimeException("[FAILED] 'Y' FLAG STATUS NOT FOUND IN TESTDATA SHEET");
		}

	}
}
