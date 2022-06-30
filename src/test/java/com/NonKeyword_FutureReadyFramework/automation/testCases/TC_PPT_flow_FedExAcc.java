package com.NonKeyword_FutureReadyFramework.automation.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NonKeyword_FutureReadyFramework.automation.application.LoginPage;
import com.NonKeyword_FutureReadyFramework.automation.excelReader.ExcelUtils;
import com.NonKeyword_FutureReadyFramework.automation.testBase.BaseClass;

public class TC_PPT_flow_FedExAcc extends BaseClass{
	@Test(enabled = true)
	public void magentoExecution() throws IOException, InterruptedException {

		LoginPage loginPage = new LoginPage();
		ExcelUtils excelRead = new ExcelUtils();
		int rowNumber = excelRead.excelReadTestCaseRowNo(getClass().getSimpleName());
		System.out.print("TC Row number:"+rowNumber);
		
		loginPage.PPT_Flow_with_CC_and_FedExAcc(rowNumber);
	}

}
