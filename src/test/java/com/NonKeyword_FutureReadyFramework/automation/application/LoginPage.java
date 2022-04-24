/* Name: Login Page Script 
 * Description: This script is integration of BaseClass methods and OR
 * Developed By: Chyne Chandran
 * Automation Architect: Jayant Naikwade
 * Input = Configurable Excel File  
 * Developed Date: 
 * Updated Date: 
 * Updated Reason:
 */
package com.NonKeyword_FutureReadyFramework.automation.application;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.NonKeyword_FutureReadyFramework.automation.excelReader.ExcelUtils;
import com.NonKeyword_FutureReadyFramework.automation.objectRepository.ObjectRepository_LoginPage;
import com.NonKeyword_FutureReadyFramework.automation.testBase.BaseClass;

public class LoginPage extends BaseClass {

	public void loginFuction_DMT() throws IOException {

		try {
			launchBrowser();
			System.out.println("[PASSED]" + "browser launched and maximized successfully");
		} catch (Exception e) {
			System.err.println("[ERROR] Unable to launch " + e.toString());
			throw new RuntimeException("[FAILED] Unable to launch chrome, firefox, edge and ie browsers");
		}

		try {
			launchURL(ExcelUtils.excelreadURL());
			System.out.println("[PASSED]" + "URL launched successfully");
		} catch (Exception e) {
			System.err.println("[ERROR] Unable to launch " + e.toString());
			throw new RuntimeException("[FAILED] Unable to launch URL");
		}

		ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
		PageFactory.initElements(driver, or);
		inputtext(or.username, ExcelUtils.excelreadUserName());
		inputtext(or.password, ExcelUtils.excelreadPassword());
		clickelement(or.submitbtn);
		try {
			expwaitVisibility(or.downarrow);
			System.out.println("[PASSED]" + "Logged successfully");
		} catch (Exception e) {
			throw new RuntimeException("[FAILED] LOGIN FAILED");
		}
		expwaitVisibility(or.downarrow);
		clickelement(or.downarrow);
		clickelement(or.logoutbtn);
		driver.close();

	}

}
