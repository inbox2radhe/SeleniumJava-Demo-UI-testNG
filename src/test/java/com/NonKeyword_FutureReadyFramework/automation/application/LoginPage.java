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
		
		//Uploading file
		clickelement(or.uploadbutton);
		Thread.sleep(20000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe#fedex_iframe");
		System.out.println("Switching to the iframe");
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		String path = System.getProperty("user.dir");
		System.out.println(path);
		upload.sendKeys(path + "src//main//java//com//NonKeyword_FutureReadyFramework//automation//config//01142022payslip.pdf"); // Uploading the file using sendKeys
		System.out.println("File is Uploaded Successfully");
		Thread.sleep(10000);
		expwaitClickable(or.addtocart);
		clickelement(or.addtocart);
		Thread.sleep(20000);
		//expwaitVisibility(driver.findElement(By.xpath("//tr[@class='grand totals']//strong")));
		//expwaitClickable(or.proceedtocheckout);
		clickelement(or.proceedtocheckout);
		Thread.sleep(10000);
		clickelement(or.continueasguest_popup);
		Thread.sleep(20000);
		expwaitVisibility(or.shiptoaddress_selectionbutton);
			Thread.sleep(10000);
			clickelement(or.shiptoaddress_selectionbutton);
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
			expwaitVisibility(driver.findElement(By.xpath("//div[text()='Delivery methods']")));
			Thread.sleep(20000);
			clickelement(or.fedexlocaldelivery);
			Thread.sleep(20000);
			expwaitClickable(or.continuetopaymentbutton);
			clickelement(or.continuetopaymentbutton);
			Thread.sleep(10000);
	//Payment screen
	expwaitVisibility(driver.findElement(By.xpath("//div[@class='payment-container']//div[@class='method-selection-container']")));
	//Credit card info
		clickelement(or.selectcc);
		expwaitClickable(or.nameoncard);
		inputtext(or.nameoncard,"Test User");
		inputtext(or.cardno,"4111111111111111");
		Select month = new Select(driver.findElement(By.xpath("//select[@class='expiration-month']")));
			month.selectByVisibleText("5 - May");
			Select year = new Select(driver.findElement(By.xpath("//select[@class='expiration-year']")));
			year.selectByVisibleText("2026");
		inputtext(or.cvv,"111");
		Thread.sleep(2000);
		clickelement(or.cc_reviewbutton);
		Thread.sleep(10000);
		clickelement(or.terms_condition_checkbox);
		clickelement(or.submitorder_button);
		Thread.sleep(10000);
		expwaitVisibility(or.ordergtn);
		Thread.sleep(10000);
		System.out.println(or.ordergtn.getText());
		Thread.sleep(10000);
		driver.close();
		
	}
	
	
	
	public void pickUp_CC() throws IOException, InterruptedException {

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
		
		//Uploading file
		clickelement(or.uploadbutton);
		Thread.sleep(20000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe#fedex_iframe");
		System.out.println("Switching to the iframe");
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		upload.sendKeys("C:\\Users\\3818600\\01142022payslip.pdf"); // Uploading the file using sendKeys
		System.out.println("File is Uploaded Successfully");
		Thread.sleep(10000);
		expwaitClickable(or.addtocart);
		clickelement(or.addtocart);
		Thread.sleep(20000);
		//expwaitVisibility(driver.findElement(By.xpath("//tr[@class='grand totals']//strong")));
		//expwaitClickable(or.proceedtocheckout);
		clickelement(or.proceedtocheckout);
		Thread.sleep(10000);
		clickelement(or.continueasguest_popup);
		Thread.sleep(20000);
		expwaitVisibility(or.pickupstore_selectionbutton);
			clickelement(or.pickupstore_selectionbutton);
			expwaitVisibility(or.pickupZipcode);
			inputtext(or.pickupZipcode, "75024");
			clickelement(or.pickupSearchbutton);
			Thread.sleep(10000);
			expwaitVisibility(driver.findElement(By.xpath("//div[@class='pickup-location-item-container']")));
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//div[@class='pickup-location-item-container']//label[@class='custom-radio-btn pick-up-button'])[2]")).click();
			//Contact info
		    expwaitClickable(or.con_fname);
		    inputtext(or.con_fname, "Giribabu");
			inputtext(or.con_lname, "Kristamsetty");
			inputtext(or.con_phoneno, "2484977204");
			inputtext(or.con_ext, "1234");
			inputtext(or.con_email, "giribabu.kristamsetty.osv@fedex.com");
//			clickelement(or.alternatepickupperson_checkbox);
//			inputtext(or.alternate_fname, "Giri");
//			inputtext(or.alternate_lname, "Kristamsetty");
//			inputtext(or.alternate_phoneno, "2484977204");
//			inputtext(or.alternate_ext, "1234");
//			inputtext(or.alternate_mail, "giribabu.kristamsetty.osv@fedex.com");
			Thread.sleep(10000);
			clickelement(or.continuetopaymentbuttonPickup);
			Thread.sleep(10000);
			//Payment screen
	      expwaitVisibility(driver.findElement(By.xpath("//div[@class='payment-container']//div[@class='method-selection-container']")));
	   	//Credit card info
		clickelement(or.selectcc);
		expwaitClickable(or.nameoncard);
		inputtext(or.nameoncard,"Test User");
		inputtext(or.cardno,"4111111111111111");
		Select month = new Select(driver.findElement(By.xpath("//select[@class='expiration-month']")));
			month.selectByVisibleText("5 - May");
			Select year = new Select(driver.findElement(By.xpath("//select[@class='expiration-year']")));
			year.selectByVisibleText("2026");
		inputtext(or.cvv,"111");
		Thread.sleep(2000);
		//Billing info
				inputtext(or.billingadd_companyname, "FedEx");
			    inputtext(or.billingadd_adress, "1599 Ski Hill Rd");
				inputtext(or.billingadd_adressline2, "1599 Ski Hill Rd");
				inputtext(or.billingadd_city, "Breckenridge");
				Select drpState = new Select(driver.findElement(By.xpath("//select[@id='add-state']")));
				drpState.selectByVisibleText("CO");
				inputtext(or.billingadd_zipcode, "80424");
			    Thread.sleep(2000);
		clickelement(or.cc_reviewbutton);
		Thread.sleep(10000);
		clickelement(or.terms_condition_checkbox);
		Thread.sleep(10000);
		clickelement(or.submitorder_button);
		Thread.sleep(10000);
		expwaitVisibility(or.ordergtn);
		Thread.sleep(10000);
		System.out.println(or.ordergtn.getText());
		Thread.sleep(10000);
		driver.close();
		
		
	}
	
	public void shipping_Acc() throws IOException, InterruptedException {

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
		
		//Uploading file
		clickelement(or.uploadbutton);
		Thread.sleep(20000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe#fedex_iframe");
		System.out.println("Switching to the iframe");
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		upload.sendKeys("C:\\Users\\3818600\\01142022payslip.pdf"); // Uploading the file using sendKeys
		System.out.println("File is Uploaded Successfully");
		Thread.sleep(20000);
		expwaitClickable(or.addtocart);
		clickelement(or.addtocart);
		Thread.sleep(20000);
		//expwaitVisibility(driver.findElement(By.xpath("//tr[@class='grand totals']//strong")));
		//expwaitClickable(or.proceedtocheckout);
		clickelement(or.proceedtocheckout);
		Thread.sleep(10000);
		clickelement(or.continueasguest_popup);
		Thread.sleep(20000);
		expwaitVisibility(or.shiptoaddress_selectionbutton);
			Thread.sleep(10000);
			clickelement(or.shiptoaddress_selectionbutton);
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
			expwaitVisibility(driver.findElement(By.xpath("//div[text()='Delivery methods']")));
			Thread.sleep(20000);
			clickelement(or.fedexlocaldelivery);
			Thread.sleep(20000);
			expwaitClickable(or.continuetopaymentbutton);
			clickelement(or.continuetopaymentbutton);
			Thread.sleep(10000);
	//Payment screen
	expwaitVisibility(driver.findElement(By.xpath("//div[@class='payment-container']//div[@class='method-selection-container']")));
	//Account info
	clickelement(or.selectfedexacc);
	Thread.sleep(10000);
	expwaitClickable(or.fedexacc);
	Thread.sleep(10000);
	inputtext(or.fedexacc,"653243286");
	Thread.sleep(10000);
	clickelement(or.fedexacc_revieworder);
		Thread.sleep(10000);
		clickelement(or.terms_condition_checkbox);
		clickelement(or.submitorder_button);
		Thread.sleep(10000);
		expwaitVisibility(or.ordergtn);
		Thread.sleep(10000);
		System.out.println(or.ordergtn.getText());
		Thread.sleep(10000);
		driver.close();
		
	}

	public void pickUp_Acc() throws IOException, InterruptedException {

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
		
		//Uploading file
		clickelement(or.uploadbutton);
		Thread.sleep(20000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe#fedex_iframe");
		System.out.println("Switching to the iframe");
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		upload.sendKeys("C:\\Users\\3818600\\01142022payslip.pdf"); // Uploading the file using sendKeys
		System.out.println("File is Uploaded Successfully");
		Thread.sleep(10000);
		expwaitClickable(or.addtocart);
		clickelement(or.addtocart);
		Thread.sleep(20000);
		//expwaitVisibility(driver.findElement(By.xpath("//tr[@class='grand totals']//strong")));
		//expwaitClickable(or.proceedtocheckout);
		clickelement(or.proceedtocheckout);
		Thread.sleep(10000);
		clickelement(or.continueasguest_popup);
		Thread.sleep(20000);
		expwaitVisibility(or.pickupstore_selectionbutton);
			clickelement(or.pickupstore_selectionbutton);
			expwaitVisibility(or.pickupZipcode);
			inputtext(or.pickupZipcode, "75024");
			clickelement(or.pickupSearchbutton);
			Thread.sleep(10000);
			expwaitVisibility(driver.findElement(By.xpath("//div[@class='pickup-location-item-container']")));
			Thread.sleep(10000);
			driver.findElement(By.xpath("(//div[@class='pickup-location-item-container']//label[@class='custom-radio-btn pick-up-button'])[2]")).click();
			//Contact info
		    expwaitClickable(or.con_fname);
		    inputtext(or.con_fname, "Giribabu");
			inputtext(or.con_lname, "Kristamsetty");
			inputtext(or.con_phoneno, "2484977204");
			inputtext(or.con_ext, "1234");
			inputtext(or.con_email, "giribabu.kristamsetty.osv@fedex.com");
//			clickelement(or.alternatepickupperson_checkbox);
//			inputtext(or.alternate_fname, "Giri");
//			inputtext(or.alternate_lname, "Kristamsetty");
//			inputtext(or.alternate_phoneno, "2484977204");
//			inputtext(or.alternate_ext, "1234");
//			inputtext(or.alternate_mail, "giribabu.kristamsetty.osv@fedex.com");
			Thread.sleep(10000);
			clickelement(or.continuetopaymentbuttonPickup);
			Thread.sleep(10000);
			//Payment screen
	      expwaitVisibility(driver.findElement(By.xpath("//div[@class='payment-container']//div[@class='method-selection-container']")));
	   	//Account info
	      clickelement(or.selectfedexacc);
	  	Thread.sleep(10000);
	  	expwaitClickable(or.fedexacc);
	  	Thread.sleep(10000);
	  	inputtext(or.fedexacc,"653243286");
	  	Thread.sleep(10000);
	  	clickelement(or.fedexacc_revieworder);
	  		Thread.sleep(10000);
	  	//	clickelement(or.terms_condition_checkbox);
	  		clickelement(or.submitorder_button);
	  		Thread.sleep(10000);
	  		expwaitVisibility(or.ordergtn);
	  		Thread.sleep(10000);
	  		System.out.println(or.ordergtn.getText());
	  		Thread.sleep(10000);
	  		driver.close();
	  			
	}
	}


