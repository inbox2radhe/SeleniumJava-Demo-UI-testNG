package com.NonKeyword_FutureReadyFramework.automation.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NonKeyword_FutureReadyFramework.automation.application.LoginPage;
import com.NonKeyword_FutureReadyFramework.automation.excelReader.ExcelUtils;
import com.NonKeyword_FutureReadyFramework.automation.testBase.BaseClass;

public class sampletest  {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		//launchBrowser();
		//launchURL(ExcelUtils.excelreadURL());
		/*
		 * LoginPage lp = new LoginPage(); lp.loginFuction_DMT();
		 */
		ExcelUtils.excelReadTestCase();
		
	}

}
