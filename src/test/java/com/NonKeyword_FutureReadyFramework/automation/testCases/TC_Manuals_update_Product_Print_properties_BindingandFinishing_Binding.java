package com.NonKeyword_FutureReadyFramework.automation.testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NonKeyword_FutureReadyFramework.automation.application.LoginPage;
import com.NonKeyword_FutureReadyFramework.automation.application.ProductCategoryPage;
import com.NonKeyword_FutureReadyFramework.automation.customListener.ListenTest;
import com.NonKeyword_FutureReadyFramework.automation.excelReader.ExcelUtils;

@Listeners(ListenTest.class)
public class TC_Manuals_update_Product_Print_properties_BindingandFinishing_Binding {
	
	@Test(enabled=true)
	public void TC72_Manuals_update_Product_Print_properties_BindingandFinishing_Binding() throws Exception {
		
		LoginPage loginPage = new LoginPage();
		ProductCategoryPage pc=new ProductCategoryPage();
		ExcelUtils excelRead = new ExcelUtils();
		int rowNumber = excelRead.excelReadTestCaseRowNo(getClass().getSimpleName());
		System.out.print("TC Row number:"+rowNumber);
		pc.Manuals_update_Product_Print_properties_BindingandFinishing_Binding(rowNumber);
		
	}
	

}
