package com.NonKeyword_FutureReadyFramework.automation.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import com.NonKeyword_FutureReadyFramework.automation.application.LoginPage;
import com.NonKeyword_FutureReadyFramework.automation.excelReader.ExcelUtils;
import com.NonKeyword_FutureReadyFramework.automation.testBase.BaseClass;
import com.NonKeyword_FutureReadyFramework.automation.customListener.ListenTest;





@Listeners(ListenTest.class)
public class TC_uploadFile_From_BannerOfIndexPage_PickUpFexAccFlow extends BaseClass {
	
	@Test(enabled = true)
	public void TC39_uploadFile_From_BannerOfIndexPage_PickUpFexAccFlow() throws IOException, InterruptedException {

		LoginPage loginPage = new LoginPage();
		ExcelUtils excelRead = new ExcelUtils();
		int rowNumber = excelRead.excelReadTestCaseRowNo(getClass().getSimpleName());
		System.out.print("TC Row number:"+rowNumber);
		
		loginPage.uploadFileUsingBanner(rowNumber);

	}
	
	

}
