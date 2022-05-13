/* Name: TC01_LoginFunctionality Script 
 * Description: This script is used to check the Login Functionality
 * Developed By: Chyne Chandran
 * Automation Architect: Jayant Naikwade
 * Input = Configurable Excel File  
 * Developed Date: 
 * Updated Date: 
 * Updated Reason:
 */
package com.NonKeyword_FutureReadyFramework.automation.testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NonKeyword_FutureReadyFramework.automation.application.LoginPage;
import com.NonKeyword_FutureReadyFramework.automation.customListener.ListenTest;
import com.NonKeyword_FutureReadyFramework.automation.testBase.BaseClass;

@Listeners(ListenTest.class)
public class TC04_LoginFunctionality extends BaseClass {

	@Test(enabled = true)
	public void loginfuntionVerfication_TC02() throws IOException, InterruptedException {

		LoginPage loginPage = new LoginPage();
		loginPage.pickUp_Acc();;

	}

}
