package com.NonKeyword_FutureReadyFramework.automation.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NonKeyword_FutureReadyFramework.automation.application.ProductCategoryPage;
import com.NonKeyword_FutureReadyFramework.automation.excelReader.ExcelUtils;
import com.NonKeyword_FutureReadyFramework.automation.testBase.BaseClass;

public class TC_Yard_Sign_Pickup_FedExACCflow extends BaseClass{
	
	@Test(enabled = true)
	public void magentoExecution() throws IOException, InterruptedException {

		ProductCategoryPage pcp = new ProductCategoryPage();
		ExcelUtils excelRead = new ExcelUtils();
		String className= getClass().getSimpleName();
		System.out.println("Class Name is::"+className);
		int rowNumber = excelRead.excelReadTestCaseRowNo(getClass().getSimpleName());
		System.out.print("TC Row number:"+rowNumber);
		pcp.Yard_Sign_FedExACCflow(rowNumber);
	}

}
