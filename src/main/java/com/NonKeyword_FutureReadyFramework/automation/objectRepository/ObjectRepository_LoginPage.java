/* Name: ObjectRepository_LoginPage 
 * Description: This script is Central Hub for Reusable Global Locators
 * Developed By: Chyne Chandran
 * Automation Architect: Jayant Naikwade
 * Input = Configurable Excel File  
 * Developed Date: 
 * Updated Date: 
 * Updated Reason:
 */
package com.NonKeyword_FutureReadyFramework.automation.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ObjectRepository_LoginPage {

	@FindBy(how = How.ID, using = "username")
	public WebElement username;
	@FindBy(how = How.ID, using = "password")
	public WebElement password;
	@FindBy(how = How.NAME, using = "submit")
	public WebElement submitbtn;
	@FindBy(xpath = "//a[text()='User Profile ']")
	public WebElement downarrow;
	@FindBy(xpath = "//a[text()='LogOut']")
	public WebElement logoutbtn;
	
}
