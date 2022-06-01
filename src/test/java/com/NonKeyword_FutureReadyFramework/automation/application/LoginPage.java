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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.NonKeyword_FutureReadyFramework.automation.excelReader.ExcelUtils;
import com.NonKeyword_FutureReadyFramework.automation.objectRepository.ObjectRepository_LoginPage;
import com.NonKeyword_FutureReadyFramework.automation.testBase.BaseClass;

public class LoginPage extends BaseClass {

	public void loginFuction_DMT(int row) throws IOException, InterruptedException {
		String path = System.getProperty("user.dir");
		String testDataSheetPath = (path
				+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("Sanity");
		
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
		/*
		expwaitVisibility(or.loginlink);
		clickelement(or.loginlink);
		clickelement(or.loginbutton);
		try {
			expwaitVisibility(or.username);
			System.out.println("[PASSED]" + "Showing Login screen");
		} catch (Exception e) {
			throw new RuntimeException("[FAILED] Not showing Login screen");
		}
		inputtext(or.username, ExcelUtils.excelreadUserName());
		inputtext(or.password, ExcelUtils.excelreadPassword());
		clickelement(or.submitbtn);
		
		*/
		String productName = tocSheet.getRow(row).getCell(3).getStringCellValue();
		waitSync();
		expwaitClickable(driver.findElement(By.xpath("(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='"+productName+"'])[1]")));
		clickelement(driver.findElement(By.xpath("(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='"+productName+"'])[1]")));
		waitSync();

		
		
		
		//Uploading file
		clickelement(or.uploadbutton);
		waitSync();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe#fedex_iframe");
		System.out.println("Switching to the iframe");
		waitSync();
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		waitSync();
		upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\01142022payslip.pdf");
		//upload.sendKeys("X:\\Upload_Files\\"+tocSheet.getRow(row).getCell(4).getStringCellValue()); // Uploading the file using sendKeys
		//upload.sendKeys("C:\\Users\\4652497\\TEST FILE.pdf");
		waitSync();
		System.out.println("File is Uploaded Successfully");
		waitSync();
		expwaitClickable(or.addtocart);
		clickelement(or.addtocart);
		//waitSync();
		//expwaitVisibility(driver.findElement(By.xpath("//tr[@class='grand totals']//strong")));
		expwaitClickable(or.proceedtocheckout);
		clickelement(or.proceedtocheckout);
		waitSync();
		clickelement(or.continueasguest_popup);
		String deliveryOption = tocSheet.getRow(row).getCell(5).getStringCellValue();
		//String deliveryop="Pickup";
		System.out.println("Delivery type is"+deliveryOption);
		waitSync();
		if (deliveryOption.equalsIgnoreCase("Pickup")) 
		{
			System.out.println("Printing inside Pickup IF contion");
			//expwaitVisibility(or.pickupstore_selectionbutton);
			waitSync();
			
			clickelement(or.pickupstore_selectionbutton);
			System.out.println("PickUp option selected");
			expwaitVisibility(or.pickupZipcode);
			inputtext(or.pickupZipcode, "75024");
			clickelement(or.pickupSearchbutton);
			expwaitVisibility(driver.findElement(By.xpath("//div[@class='pickup-location-item-container']")));
			driver.findElement(By.xpath("(//div[@class='pickup-location-item-container']//label[@class='custom-radio-btn pick-up-button'])[2]")).click();
			
			//Contact info
		    expwaitClickable(or.con_fname);
		    inputtext(or.con_fname, "Joe");
			inputtext(or.con_lname, "Doe");
			inputtext(or.con_phoneno, "2149669687");
			inputtext(or.con_ext, "1234");
			inputtext(or.con_email, "email@email.com");
			clickelement(or.alternatepickupperson_checkbox);
			inputtext(or.alternate_fname, "Will");
			inputtext(or.alternate_lname, "Smith");
			inputtext(or.alternate_phoneno, "2149669687");
			inputtext(or.alternate_ext, "1234");
			inputtext(or.alternate_mail, "email@email.com");
			waitSync();
			clickelement(or.pickupFlowcontinueTopaybtn);
			
			
			
		} else 
		{
			expwaitVisibility(or.shiptoaddress_selectionbutton);
			waitSync();
			clickelement(or.shiptoaddress_selectionbutton);
			inputtext(or.shippingaddress_fname, "Joe");
			inputtext(or.shippingaddress_lname, "Doe");
			inputtext(or.shippingaddress_email, "email@email.com");
			inputtext(or.shippingaddress_company, "FedEx");
			inputtext(or.shippingaddress_address, "7900 Legacy Dr");
			inputtext(or.shippingaddress_city, "Plano");
			Select drpState = new Select(driver.findElement(By.xpath("//select[@name='region_id']")));
			drpState.selectByVisibleText("TX");
			inputtext(or.shippingaddress_zipcode, "75024");
			inputtext(or.shippingaddress_phno, "2149669687");
			waitSync();
			clickelement(or.shipingresult_button);
			waitSync();
			
			String deliveryMethod = tocSheet.getRow(row).getCell(6).getStringCellValue();
			waitSync();
			expwaitVisibility(driver.findElement(By.xpath("//div[text()='Delivery methods']")));
			windowScroll();
			clickelement(driver.findElement(By.xpath("//input[@type='radio']/../..//td[@class='col col-carrier']//span[text()='"+deliveryMethod+"']")));
			expwaitClickable(or.continuetopaymentbutton);
			waitSync();
			System.out.println("Printing before continue to payment button");
			clickelement(or.continuetopaymentbutton);
			waitSync();

		}
		
			
			
	//Payment screen
	expwaitVisibility(driver.findElement(By.xpath("//div[@class='payment-container']//div[@class='method-selection-container']")));
	waitSync();
	String paymentOption = tocSheet.getRow(row).getCell(7).getStringCellValue();
	//String paymentOption="Credit Card";
	System.out.println("Payment method selected"+paymentOption);
	
		if(paymentOption.equalsIgnoreCase("Credit Card"))
		{
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
			
			//Billing info
			if(deliveryOption.equalsIgnoreCase("Pickup"))
			{
			System.out.println("Printing from cc flow1");
			inputtext(or.billingadd_companyname, "FedEx");
		    inputtext(or.billingadd_adress, "7900 Legacy Dr");
			inputtext(or.billingadd_adressline2, "Suite 300");
			inputtext(or.billingadd_city, "Plano");
				
			Select drpState = new Select(driver.findElement(By.xpath("//select[@id='add-state']")));
			drpState.selectByVisibleText("TX");
			inputtext(or.billingadd_zipcode, "75024");
			//inputtext(or.shippingaddress_phno, "2149669687");
			System.out.println("Printing from cc flow2");
			Thread.sleep(10000);

			
			}
			
			waitSync();
			windowScroll();
			expwaitClickable(or.cc_reviewbutton);
			waitSync();
			System.out.println("Printing from cc flow");
			clickelement(or.cc_reviewbutton); //cc_revieworder_Prod
			
			
			
		}
			else
			{
				
				System.out.println("Printing from FedEx Acc flow");
				//expwaitClickable(or.fedexacc);
				waitSync();
				clickelement(or.selectfedexacc);
				inputtext(or.fedexacc,"653243286"); //653243286
				waitSync();
				clickelement(or.fedexacc_revieworder);// clicking prod order review button
				
			}
			//clickelement(or.terms_condition_checkbox);
			//clickelement(or.submitorder_button);
			//expwaitVisibility(or.ordergtn);
			//System.out.println(or.ordergtn.getText());
	
		

		tearDown();

	}

}
