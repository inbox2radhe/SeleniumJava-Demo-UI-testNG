package com.NonKeyword_FutureReadyFramework.automation.testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NonKeyword_FutureReadyFramework.automation.application.LoginPage;
import com.NonKeyword_FutureReadyFramework.automation.customListener.ListenTest;
import com.NonKeyword_FutureReadyFramework.automation.excelReader.ExcelUtils;
import com.NonKeyword_FutureReadyFramework.automation.testBase.BaseClass;

@Listeners(ListenTest.class)
public class TC35 extends BaseClass {

	@Test(enabled = true)
	public void TC35_Flyers_Shipping_FirstOvernight_FedExAcc() throws IOException, InterruptedException {

		LoginPage loginPage = new LoginPage();
		ExcelUtils excelRead = new ExcelUtils();
		int rowNumber = excelRead.excelReadTestCaseRowNo(getClass().getSimpleName());
		System.out.print("TC Row number:"+rowNumber);
		
		loginPage.loginFuction_DMT(rowNumber);

	}

}
