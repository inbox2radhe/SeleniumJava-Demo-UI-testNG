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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.NonKeyword_FutureReadyFramework.automation.excelReader.ExcelUtils;
import com.NonKeyword_FutureReadyFramework.automation.objectRepository.ObjectRepository_LoginPage;
import com.NonKeyword_FutureReadyFramework.automation.testBase.BaseClass;

public class LoginPage extends BaseClass {

	public void shipping_CC() throws IOException, InterruptedException {

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
		
		// PageFactory is used to find elements with @FindBy specified
		PageFactory.initElements(driver, or);
//		expwaitVisibility(or.loginlink);
//		clickelement(or.loginlink);
//		clickelement(or.loginbutton);
//		try {
//			expwaitVisibility(or.username);
//			System.out.println("[PASSED]" + "Showing Login screen");
//		} catch (Exception e) {
//			throw new RuntimeException("[FAILED] Not showing Login screen");
//		}
//		inputtext(or.username, ExcelUtils.excelreadUserName());
//		inputtext(or.password, ExcelUtils.excelreadPassword());
//		clickelement(or.submitbtn);
		expwaitClickable(or.selectProduct);
		clickelement(or.selectProduct);
		System.out.println("PostCards Product Selected");
		
		//Uploading file
		clickelement(or.uploadbutton);
		Thread.sleep(20000);
		System.out.println("Upload button clicked");
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe#fedex_iframe");
		System.out.println("Switching to the iframe");
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		String path = System.getProperty("user.dir");
		System.out.println(path);
		upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\01142022payslip.pdf"); // Uploading the file using sendKeys
		System.out.println("File is Uploaded Successfully");
		Thread.sleep(10000);
		expwaitClickable(or.addtocart);
		clickelement(or.addtocart);
		Thread.sleep(20000);
		System.out.println("Clicked on addtoCart button");
		//expwaitVisibility(driver.findElement(By.xpath("//tr[@class='grand totals']//strong")));
		//expwaitClickable(or.proceedtocheckout);
		clickelement(or.proceedtocheckout);
		Thread.sleep(10000);
		System.out.println("Clicked on proceedToCheckout buton");
		clickelement(or.continueasguest_popup);
		Thread.sleep(20000);
		System.out.println("Clicked on Guest User");
		expwaitVisibility(or.shiptoaddress_selectionbutton);
			Thread.sleep(10000);
			clickelement(or.shiptoaddress_selectionbutton);
			System.out.println("Clicked on shipping button");
			inputtext(or.shippingaddress_fname, "Giribabu");
			inputtext(or.shippingaddress_lname, "Kristamsetty");
			inputtext(or.shippingaddress_email, "giribabu.kristamsetty.osv@fedex.com");
			inputtext(or.shippingaddress_company, "fedex");
			inputtext(or.shippingaddress_address, "7900 Legacy Dr");
			inputtext(or.shippingaddress_city, "Plano");
			Select drpState = new Select(driver.findElement(By.xpath("//select[@name='region_id']")));
			drpState.selectByVisibleText("TX");
			inputtext(or.shippingaddress_zipcode, "75024");
			inputtext(or.shippingaddress_phno, "2484977204");
			Thread.sleep(10000);
			clickelement(or.shipingresult_button);
			Thread.sleep(20000);
			try {
			expwaitVisibility(driver.findElement(By.xpath("//div[text()='Delivery methods']")));
			clickelement(or.fedexfirstovernight);
			System.out.println("[Shipping Options]" + "Available");
		} catch (Exception e) {
			System.err.println("[Shipping Options]" + "Not Available");
			throw new RuntimeException("[FAILED] Unable to launch chrome, firefox, edge and ie browsers");
			driver.close();
		}
	
	}

	}


