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
import org.openqa.selenium.Keys;
import junit.framework.*;
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
		
//		expwaitVisibility(or.loginlink);
//		waitSync();
//		clickelement(or.loginlink);
//		waitSync();
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
//		
		
		String productName = tocSheet.getRow(row).getCell(4).getStringCellValue();
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
		waitSync();
		String editOrder= tocSheet.getRow(row).getCell(3).getStringCellValue();
		if(editOrder.equalsIgnoreCase("Y")) {
			
			//update item quantity flow
			clickelement(or.editOrderbtn);
			waitSync();
			windowScroll();
			driver.switchTo().frame(0);
			waitSync();
			driver.findElement(By.xpath("//p[text()='Quantity']/..//input")).click();
			driver.findElement(By.xpath("//edl-dropdown-item//div[text()='500 ']")).click();
			System.out.println("Printing after changing qty value");
			
			
			clickelement(or.selectqtybtn);
			System.out.println("Printing3 after selecting quantity dropbox inside edit order");
			
			clickelement(or.btnSaveChanges);
			waitSync();
			String cartUpdatemsg= returnelementTxt(or.validateCartUpdatedmsg);
			System.out.println("Order quantity updated successfully"+cartUpdatemsg);
			
			//String cartUpdatedmsg=productName+"Item Updated Successfully!";
			//String cartUpdatedSuccessfullymsg= returnelementTxt(or.validateCartUpdatedmsg);
			//Assert.assertEquals(cartUpdatedmsg, cartUpdatedSuccessfullymsg);
			
			
			//Update configurator flow: replace file
//			clickelement(or.editOrderbtn);
//			waitSync();
//			//windowScroll();
//			driver.switchTo().frame(0);
//			waitSync();
//			driver.findElement(By.xpath("//edl-accordion//div[@class='accordion-head']")).click();
//			driver.findElement(By.xpath("//div[@class='fpo-remove-replace']//button[text()='Remove or Replace Files']")).click();
//			waitSync();
//			driver.findElement(By.xpath("//span[@class='ng-star-inserted']")).click();
			waitSync();
//			driver.findElement(By.xpath("//button[@id='replaceFileBtn']")).click();
//			waitSync();
//			driver.findElement(By.xpath("//button[@id='newFileBtn']")).click();
//			waitSync();
//			WebElement upload1 = driver.findElement(By.xpath("//input[@type='file']"));
//			waitSync();
//			upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\01142022payslip.pdf");
//			waitSync();
//			System.out.println("File replaced Successfully");
//					
//			driver.findElement(By.xpath("//button[@class='workspace-project__singleProject-button ng-star-inserted']")).click(); //clicking setup project button
//			waitSync();
//			windowScroll();	
//			clickelement(or.btnSaveChanges);
//			waitSync();
//			String cartUpdatemsg1=returnelementTxt(or.validateCartUpdatedmsg);
//			System.out.println("Order updated with file replaced"+cartUpdatemsg1);
			
			//Deleting File flow
//			clickelement(or.editOrderbtn);
//			waitSync();
//			//windowScroll();
//			driver.switchTo().frame(0);
//			waitSync();
//			driver.findElement(By.xpath("//edl-accordion//div[@class='accordion-head']")).click();
//			waitSync();
//			driver.findElement(By.xpath("//div[@class='fpo-remove-replace']//button[text()='Remove or Replace Files']")).click();
//			waitSync();
//			driver.findElement(By.xpath("//span[@class='ng-star-inserted']")).click();
//			waitSync();
//			driver.findElement(By.xpath("//button[@id='removeFileBtn']")).click();
//			waitSync();
//			//String cartUpdatemsg2=returnelementTxt(or.validateCartUpdatedmsg);
//			//System.out.println("Order updated file deleted successfully"+cartUpdatemsg2);
			
			clickelement(or.editOrderbtn);
			waitSync();
			driver.switchTo().frame(0);
			waitSync();
			driver.findElement(By.xpath("//edl-accordion[@id='Product Print Properties']")).click(); //clicking product print properties
			driver.findElement(By.xpath("//edl-accordion[@id='Size']")).click();// Clicking product size
			waitSync();
			driver.findElement(By.xpath("//edl-radio-button[@class='choice__radio-button']//label//div[@class='inner-circle']")).click();//selecting different size
			waitSync();
			windowScroll();	
			clickelement(or.btnSaveChanges);
						
		}
		
		waitSync();
		//expwaitVisibility(driver.findElement(By.xpath("//tr[@class='grand totals']//strong")));
		expwaitClickable(or.proceedtocheckout);
		clickelement(or.proceedtocheckout);
		waitSync();
		clickelement(or.continueasguest_popup);
		String deliveryOption = tocSheet.getRow(row).getCell(6).getStringCellValue();
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
//			clickelement(or.alternatepickupperson_checkbox);
//			inputtext(or.alternate_fname, "Will");
//			inputtext(or.alternate_lname, "Smith");
//			inputtext(or.alternate_phoneno, "2149669687");
//			inputtext(or.alternate_ext, "1234");
//			inputtext(or.alternate_mail, "email@email.com");
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
			
			String deliveryMethod = tocSheet.getRow(row).getCell(7).getStringCellValue();
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
	String paymentOption = tocSheet.getRow(row).getCell(8).getStringCellValue();
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
			waitSync();
//			clickelement(or.terms_condition_checkbox);
//			waitSync();
//			clickelement(or.submitorder_button);
			
			
			
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
				waitSync();
//				clickelement(or.terms_condition_checkbox);
//				waitSync();
//				clickelement(or.submitorder_button);
				
			}
			clickelement(or.terms_condition_checkbox);
			clickelement(or.submitorder_button);
			expwaitVisibility(or.ordergtn);
			System.out.println(or.ordergtn.getText());

		

		tearDown();

	}
	
	public void delete_and_clear_cart() throws IOException, InterruptedException
	{

	String path = System.getProperty("user.dir");
	String testDataSheetPath = (path
	+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx");



	List<String> list = new ArrayList<String>();
	File f = new File(testDataSheetPath);
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fis);
	Sheet tocSheet = wb.getSheet("test");

	System.out.println("test sheet selected");

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

	addProductTocart(or.selectFlyersUsingSearch,"Flyers");
	waitSync();
	addProductTocart(or.selectPostcardsUsingSearch,"Postcards");
	//addPostcardsTocart();
	System.out.println("Flyers and Postcards added to cart");
	waitSync();
	WebElement cartItem1= driver.findElement(By.xpath("//div[@class='cart-container']//div[@class='cart table-wrapper']//tr[@class='item-info']//strong[contains(text(),'Flyer')]"));
	System.out.println("item 1 in cart: "+cartItem1.getText());
	WebElement cartItem2= driver.findElement(By.xpath("//div[@class='cart-container']//div[@class='cart table-wrapper']//tr[@class='item-info']//strong[contains(text(),'Postcards')]"));
	System.out.println("item 2 in cart: "+cartItem2.getText());
	String cartItem1Name= cartItem1.getText();
	String cartItemName2= cartItem2.getText();
	Assert.assertEquals("Flyer", cartItem1Name);
	System.out.println("Flyers exist in cart");
	Assert.assertEquals("Postcards", cartItemName2);
	System.out.println("Postcards exist in cart");
	waitSync();
	clickelement(or.firstitemDeletebtn);

	try {
	WebElement cartItem3= driver.findElement(By.xpath("//div[@class='cart-container']//div[@class='cart table-wrapper']//tr[@class='item-info']//strong[contains(text(),'Flyer')]"));
	}
	catch (Exception e) {
	System.out.println("Item not found in cart : "+e);
	}

	waitSync();
	clickelement(or.firstitemDeletebtn);
	waitSync();
	String exp_cartmsg= "You have no items in your shopping cart.";
	String act_Cartmsg= returnelementTxt(or.cartmsg);
	System.out.println("Empty Cart Message :"+act_Cartmsg);
	Assert.assertEquals(exp_cartmsg, act_Cartmsg);
	waitSync();

	//clear Cart functionality flow
	clickelement(or.emptyCart_clickShoppinglnk);

	addProductTocart(or.selectFlyersUsingSearch,"Flyers");
	waitSync();
	addProductTocart(or.selectPostcardsUsingSearch,"Postcards");
	//addPostcardsTocart();
	waitSync();
	clickelement(or.clrCartbtn);
	waitSync();
	clickelement(or.clearShoppingCart_Yesbtn);
	waitSync();
	String exp_cartmsg1= "You have no items in your shopping cart.";
	String act_Cartmsg1= returnelementTxt(or.cartmsg);
	System.out.println("Empty Cart Message :"+act_Cartmsg1);
	Assert.assertEquals(exp_cartmsg1, act_Cartmsg1);
	waitSync();
	tearDown();

	}
	
	public void uploadFileUsingBanner(int row) throws IOException, InterruptedException {

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

		clickelement(or.uploadbtnFromBannerPage);
		String productName = tocSheet.getRow(row).getCell(4).getStringCellValue();


		//Uploading file
		System.out.println("Uploading from Index Page Banner's upload button");
		waitSync();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);

		System.out.println("Switching to the iframe");
		waitSync();
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		waitSync();
		upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\01142022payslip.pdf");
		waitSync();
		System.out.println("File is Uploaded Successfully");
		waitSync();
		expwaitClickable(or.addtocart);
		clickelement(or.addtocart);
		waitSync();
		expwaitClickable(or.proceedtocheckout);
		clickelement(or.proceedtocheckout);
		waitSync();
		clickelement(or.continueasguest_popup);
		String deliveryOption = tocSheet.getRow(row).getCell(6).getStringCellValue(); //Reading Checkout Method from excel
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
//		clickelement(or.alternatepickupperson_checkbox);
//		inputtext(or.alternate_fname, "Will");
//		inputtext(or.alternate_lname, "Smith");
//		inputtext(or.alternate_phoneno, "2149669687");
//		inputtext(or.alternate_ext, "1234");
//		inputtext(or.alternate_mail, "email@email.com");
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
		System.out.println("Printing before selecting delivery method");
		String deliveryMethod = tocSheet.getRow(row).getCell(7).getStringCellValue();
		System.out.println("Delivery Method Selected as: "+deliveryMethod);

		waitSync();
		expwaitVisibility(driver.findElement(By.xpath("//div[text()='Delivery methods']")));
		System.out.println("Delivery Method Selected as: "+deliveryMethod);
		windowScroll();
		System.out.println("Delivery Method Selected as: "+deliveryMethod);
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
		String paymentOption = tocSheet.getRow(row).getCell(8).getStringCellValue();
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
		month.selectByVisibleText("2 - February");
		Select year = new Select(driver.findElement(By.xpath("//select[@class='expiration-year']")));
		year.selectByVisibleText("2024");
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
//		clickelement(or.terms_condition_checkbox);
//		clickelement(or.submitorder_button);
//		expwaitVisibility(or.ordergtn);
//	    System.out.println(or.ordergtn.getText());
		


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
//		clickelement(or.terms_condition_checkbox);
//		clickelement(or.submitorder_button);
//		expwaitVisibility(or.ordergtn);
//	    System.out.println(or.ordergtn.getText());
		


		}
		
         tearDown();

		}
	public void NDC_Account_Flow(int row) throws IOException, InterruptedException {

		String path = System.getProperty("user.dir");
		String testDataSheetPath = (path
		+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx");



		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("Sanity");

		System.out.println("test sheet selected");

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

		//adding products to cart

		addProductTocart(or.selectFlyersUsingSearch,"Flyers");
		waitSync();
		System.out.println("Flyers added to cart");

		expwaitClickable(or.proceedtocheckout);
		clickelement(or.proceedtocheckout);
		waitSync();
		clickelement(or.continueasguest_popup);
		System.out.println("Test Case Row num is: "+row);
		String deliveryOption = tocSheet.getRow(row).getCell(6).getStringCellValue(); //Reading Checkout Method from excel
		//String deliveryop="Pickup";
		System.out.println("Delivery type is"+deliveryOption);
		waitSync();
		if (deliveryOption.equalsIgnoreCase("Pickup")) {

		System.out.println("callign PickUp method from Base class");
		pickUPflow();

		}
		else {
		System.out.println("calling Shipping method from Base class");
		shippingFlow(row);
		waitSync();
		expwaitClickable(or.continuetopaymentbutton);
		waitSync();
		System.out.println("Printing before continue to payment button");
		clickelement(or.continuetopaymentbutton);
		waitSync();

		}

		expwaitVisibility(driver.findElement(By.xpath("//div[@class='payment-container']//div[@class='method-selection-container']")));
		waitSync();
		String paymentOption = tocSheet.getRow(row).getCell(8).getStringCellValue();
		//String paymentOption="Credit Card";
		System.out.println("Payment method selected"+paymentOption);

		if(paymentOption.equalsIgnoreCase("Credit Card")) {
		CC_Flow(row);
		waitSync();

		//adding NDC flow

		waitSync();
		expwaitVisibility(or.ndcAccLabel);
		clickelement(or.ndcAccCheckbox);
		waitSync();
		clickelement(or.ndcAcc);
		inputtext(or.ndcAcc,"630477964");
		clickelement(or.ndcAcc_applybutton);
		waitSync();
		String msg1 = driver.findElement(By.xpath("//div[@class='applied-fedex-container']//p[@class='applied-fedex-text']")).getText();
		String msg2 = driver.findElement(By.xpath("//div[@class='applied-fedex-container']//p/..//div//p")).getText();
		Assert.assertEquals("FedEx account Ending in *7964",msg1+" "+msg2);
		waitSync();
		//clickelement(or.ndcAcc_Remove);
		//waitSync();

		clickelement(or.fedexacc_revieworder);
		}

		else {

		FedEx_Acc_Flow();
		waitSync();

		}

		clickelement(or.terms_condition_checkbox);
		waitSync();
		clickelement(or.submitorder_button);
		waitSync();
		expwaitVisibility(or.ordergtn);
		System.out.println("Order Confirmation msg: "+or.ordergtn.getText());
		tearDown();

		}
	
	public void canvaflow(int row) throws InterruptedException, IOException {
	String path = System.getProperty("user.dir");
	String testDataSheetPath = (path
	+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx"); List<String> list = new ArrayList<String>();
	File f = new File(testDataSheetPath);
	FileInputStream fis = new FileInputStream(f);
	Workbook wb = new XSSFWorkbook(fis);
	Sheet tocSheet = wb.getSheet("Sanity");
	System.out.println("test sheet selected");
	try {
	launchBrowser();
	System.out.println("[PASSED]" + "browser launched and maximized successfully");
	} catch (Exception e) {
	System.err.println("[ERROR] Unable to launch " + e.toString());
	throw new RuntimeException("[FAILED] Unable to launch chrome, firefox, edge and ie browsers");
	} try {
	launchURL(ExcelUtils.excelreadURL());
	System.out.println("[PASSED]" + "URL launched successfully");
	} catch (Exception e) {
	System.err.println("[ERROR] Unable to launch " + e.toString());
	throw new RuntimeException("[FAILED] Unable to launch URL");
	}
	ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
	PageFactory.initElements(driver, or);
	String productName = tocSheet.getRow(row).getCell(4).getStringCellValue();
	waitSync();
	expwaitClickable(driver.findElement(By.xpath("(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='"+productName+"'])[1]")));
	clickelement(driver.findElement(By.xpath("(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='"+productName+"'])[1]")));
	waitSync();
	System.out.println("Selected product is :"+productName);
	//Canva flow starts
	System.out.println("Printing before clicking Canva Flowl link::");
	clickelement(or.canvaflowlnk);
	System.out.println("Canva Flowl link clicked::");
	waitSync();
	clickelement(or.startdesign_btn);
	waitSync();
	expwaitVisibility(or.contiueAsgustInCanvaFlow);
	waitSync();
	clickelement(or.contiueAsgustInCanvaFlow);
	waitSync();
	clickelement(or.selectCanvatmplate);
	waitSync();
	clickelement(or.canvaPublishbtn);
	clickelement(or.continute_btn_after_canvaPublish1);
	waitSync();
	clickelement(or.continute_btn_after_canvaPublish2);
	waitSync();
	clickelement(or.continute_btn_after_canvaPublish3);
	waitSync();
	}
	public void OutDoor_Banners_Flow(int row) throws IOException, InterruptedException{
		
		
		String path = System.getProperty("user.dir");
		String testDataSheetPath = (path
				+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("Sanity");
		
		System.out.println("test sheet selected");
		
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
		
		String productName = tocSheet.getRow(row).getCell(4).getStringCellValue();
		waitSync();
		//expwaitClickable(driver.findElement(By.xpath("(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='"+productName+"'])[1]")));
		//clickelement(driver.findElement(By.xpath("(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='"+productName+"'])[1]")));
		//waitSync();
		System.out.println("Selected product is :"+productName);
		waitSync();
		clickelement(or.searchbtn);
		inputtext(or.searchbtn,productName);
		clickelement(or.clicksearch);
		impwait();
		clickelement(or.selectOutdoorBanner);
		impwait();
		String act_OutddorBanner_title=or.getoutdoorBannertitle.getText();
		String exp_OutddorBanner_title="Outdoor Banners";
		
		try {
		Assert.assertEquals(act_OutddorBanner_title, exp_OutddorBanner_title);
		}catch(AssertionError e) {
			System.out.println("Presentations product not selected: "+e);
			tearDown();
		}
		
		System.out.println("Uploading using upload button");
		waitSync();
		clickelement(or.uploadbutton);

		System.out.println("Switching to the iframe");
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);
		waitSync();
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		waitSync();
		upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\01142022payslip.pdf");
		waitSync();
		
		System.out.println("File is Uploaded Successfully");
		waitSync();
		impwait();
		expwaitClickable(or.addtocart);
		clickelement(or.addtocart);
		waitSync();
		expwaitClickable(or.proceedtocheckout);
		clickelement(or.proceedtocheckout);
		waitSync();
		
		clickelement(or.continueasguest_popup);
		
		//Proceed with Shipping delivery methods
		
		String deliveryOption = tocSheet.getRow(row).getCell(6).getStringCellValue();
		//String deliveryop="Pickup";
		System.out.println("Delivery type is"+deliveryOption);
		waitSync();
		if (deliveryOption.equalsIgnoreCase("Pickup")) 
		{
			
			
			
			System.out.println("Printing inside Pickup IF contion");
			expwaitVisibility(or.pickupstore_selectionbutton);
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
			waitSync();
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
			//waitSync();
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
			
			String deliveryMethod = tocSheet.getRow(row).getCell(7).getStringCellValue();
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
	String paymentOption = tocSheet.getRow(row).getCell(8).getStringCellValue();
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
			clickelement(or.terms_condition_checkbox);
			clickelement(or.submitorder_button);
			expwaitVisibility(or.ordergtn);
			System.out.println(or.ordergtn.getText());
	
		

		tearDown();

		
		
		
		
	}

	
	public void PPT_Flow_with_CC_and_FedExAcc(int row) throws InterruptedException, IOException{
		
		String path = System.getProperty("user.dir");
		String testDataSheetPath = (path
				+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("Sanity");
		
		System.out.println("test sheet selected");
		
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
		
		String productName = tocSheet.getRow(row).getCell(4).getStringCellValue();
		waitSync();

		System.out.println("Selected product is :"+productName);
		waitSync();
		clickelement(or.searchbtn);
		inputtext(or.searchbtn,productName);
		clickelement(or.clicksearch);
		impwait();
		clickelement(or.selectPPT);
		impwait();
		String act_product_title= or.getPPTtitle.getText();
		String exp_product_title= "Presentations";
		try {
		Assert.assertEquals(act_product_title, exp_product_title);
		}catch(AssertionError e) {
			System.out.println("Presentations product not selected: "+e);
			tearDown();
		}
		
		System.out.println("Uploading using upload button");
		waitSync();
		clickelement(or.uploadbutton);

		System.out.println("Switching to the iframe");
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);
		waitSync();
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		waitSync();
		upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\QA Magento Updates.pptx");
		waitSync();
		clickelement(or.select2PageHandouts);
		clickelement(or.clickNxt);
		waitSync();
		System.out.println("File is Uploaded Successfully");
		waitSync();
		impwait();
		expwaitClickable(or.addtocart);
		waitSync();
		clickelement(or.addtocart);
		waitSync();
		expwaitClickable(or.proceedtocheckout);
		clickelement(or.proceedtocheckout);
		waitSync();
		clickelement(or.continueasguest_popup);
		
		//Proceed with Shipping delivery methods
		
		String deliveryOption = tocSheet.getRow(row).getCell(6).getStringCellValue();
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
			waitSync();
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
			//waitSync();
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
			
			String deliveryMethod = tocSheet.getRow(row).getCell(7).getStringCellValue();
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
	String paymentOption = tocSheet.getRow(row).getCell(8).getStringCellValue();
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
			clickelement(or.terms_condition_checkbox);
			clickelement(or.submitorder_button);
			expwaitVisibility(or.ordergtn);
			System.out.println(or.ordergtn.getText());
	
		

		tearDown();

		
		
		
		
	}
		
	public void BusinessCard_Preminum_CC_and_FedAccFlow(int row) throws InterruptedException, IOException {
		
		String path = System.getProperty("user.dir");
		String testDataSheetPath = (path
				+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("Sanity");
		
		System.out.println("test sheet selected");
		
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
		
		String productName = tocSheet.getRow(row).getCell(4).getStringCellValue();
		waitSync();
		//expwaitClickable(driver.findElement(By.xpath("(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='"+productName+"'])[1]")));
		//clickelement(driver.findElement(By.xpath("(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='"+productName+"'])[1]")));
		//waitSync();
		System.out.println("Selected product is :"+productName);
		waitSync();
		clickelement(or.searchbtn);
		inputtext(or.searchbtn,productName);
		clickelement(or.clicksearch);
		impwait();
		clickelement(or.businessCards_preminum);
		impwait();
		String act_product_title= or.getProductTitle.getText();
		String exp_product_title= "Business Cards - Premium";
		try {
		Assert.assertEquals(act_product_title, exp_product_title);
		}catch(AssertionError e) {
			System.out.println("Business Cards -Preminum product not selected: "+e);
			tearDown();
		}
		
		System.out.println("Uploading using upload button");
		waitSync();
		clickelement(or.uploadbutton);

		System.out.println("Switching to the iframe");
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);
		waitSync();
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		waitSync();
		upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\01142022payslip.pdf");
		waitSync();
		System.out.println("File is Uploaded Successfully");
		waitSync();

		expwaitClickable(or.addtocart);
		clickelement(or.addtocart);
		waitSync();
		
		expwaitClickable(or.proceedtocheckout);
		clickelement(or.proceedtocheckout);
		waitSync();
	//	clickelement(or.continueasguest_popup);
		String deliveryOption = tocSheet.getRow(row).getCell(6).getStringCellValue();
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
			waitSync();
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
			//expwaitVisibility(or.shiptoaddress_selectionbutton);
			//waitSync();
			//clickelement(or.shiptoaddress_selectionbutton);
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
			
			String deliveryMethod = tocSheet.getRow(row).getCell(7).getStringCellValue();
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
	String paymentOption = tocSheet.getRow(row).getCell(8).getStringCellValue();
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
			clickelement(or.terms_condition_checkbox);
			clickelement(or.submitorder_button);
			expwaitVisibility(or.ordergtn);
			System.out.println(or.ordergtn.getText());
	
		

		tearDown();

		
		
	}
	
	public void MiniCartFlow(int row) throws IOException, InterruptedException {
		
		String path = System.getProperty("user.dir");
		String testDataSheetPath = (path
				+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("Sanity");
		
		System.out.println("test sheet selected");
		
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
		
		String productName = tocSheet.getRow(row).getCell(4).getStringCellValue();
		waitSync();
		//expwaitClickable(driver.findElement(By.xpath("(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='"+productName+"'])[1]")));
		//clickelement(driver.findElement(By.xpath("(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='"+productName+"'])[1]")));
		//waitSync();
		System.out.println("Selected product is :"+productName);
		waitSync();
		if (productName.equals("Manuals"))
		addProductTocart(or.selectManuals,productName);
		else
		addProductTocart(or.selectResumes,productName);	
		waitSync();
		clickelement(or.miniCart);
		waitSync();
		String act_MiniCart_ProductName= driver.findElement(By.xpath("//strong[@class='product-item-name']//span[contains(text(),'"+productName+"')]")).getText();
		String exp_MiniCart_ProductName=productName;
		Assert.assertEquals(act_MiniCart_ProductName, exp_MiniCart_ProductName);
		System.out.println("Product In Mini Cart matching with DataSheet");
		clickelement(or.mimiCart_proceedTochkoutbtn);
		waitSync();
		clickelement(or.continueasguest_popup);
		waitSync();
		System.out.println("Test Case Row num is: "+row);

		//Proceed with Shipping delivery methods
		
		String deliveryOption = tocSheet.getRow(row).getCell(6).getStringCellValue();
		//String deliveryop="Pickup";
		System.out.println("Delivery type is"+deliveryOption);
		waitSync();
		if (deliveryOption.equalsIgnoreCase("Pickup")) 
		{
			
			
			
			System.out.println("Printing inside Pickup IF contion");
			expwaitVisibility(or.pickupstore_selectionbutton);
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
			waitSync();
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
			//waitSync();
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
			
			String deliveryMethod = tocSheet.getRow(row).getCell(7).getStringCellValue();
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
	String paymentOption = tocSheet.getRow(row).getCell(8).getStringCellValue();
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
				waitSync();
				
			}
			clickelement(or.terms_condition_checkbox);
			waitSync();
			clickelement(or.submitorder_button);
			waitSync();
			expwaitVisibility(or.ordergtn);
			waitSync();
			System.out.println(or.ordergtn.getText());
	
		

		tearDown();

		
	}
public void MiniCart_delete_and_clear_cart(int row) throws IOException, InterruptedException {
		
		

		String path = System.getProperty("user.dir");
		String testDataSheetPath = (path
				+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("test");
		
		System.out.println("test sheet selected");
		
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
		
		addProductTocartSingle(or.selectFlyersUsingSearch,"Flyers");
		waitSync();
		addProductTocartSingle(or.selectPostcardsUsingSearch,"Postcards");
		//addPostcardsTocart();
		
		System.out.println("Flyers and Postcards added to cart");
		
		waitSync();
		
		clickelement(or.miniCart);
		waitSync();
		
		WebElement cartItem1= driver.findElement(By.xpath("(//div[@class='minicart-items-wrapper']//strong[@class='product-item-name'])[1]"));
		System.out.println("item 1 in cart: "+cartItem1.getText());
		WebElement cartItem2= driver.findElement(By.xpath("(//div[@class='minicart-items-wrapper']//strong[@class='product-item-name'])[2]"));
		System.out.println("item 2 in cart: "+cartItem2.getText());
		String cartItem1Name= cartItem1.getText();
		String cartItemName2= cartItem2.getText();
		Assert.assertEquals("Postcards", cartItem1Name);
		System.out.println("Postcards exist in cart");
		Assert.assertEquals("Flyer", cartItemName2);
		System.out.println("Flyers exist in cart");
		waitSync();
		
		clickelement(or.MiniCart_DeleteFirstCartItem);
		waitSync();
		clickelement(or.MiniCart_acceptbtn);
		waitSync();
		clickelement(or.miniCart);
		waitSync();
		Assert.assertEquals("Flyer", cartItemName2);
		System.out.println(cartItemName2+" "+"exist in Mini cart");
		clickelement(or.MiniCart_DeleteFirstCartItem);
		waitSync();
		clickelement(or.MiniCart_acceptbtn);
		waitSync();
		String act_emptyMiniCartmsg=or.emptyMiniCartmsg.getText();
		String exp_emptyMiniCartmsg="You have no items in your shopping cart.";
		Assert.assertEquals(act_emptyMiniCartmsg, exp_emptyMiniCartmsg);
		System.out.println("All items from MiniCart is deleted successfully!!");
		impwait();
		
		tearDown();
		
		
		
	}
	
	public void editMiniCart(int row) throws IOException, InterruptedException {
		
		
		String path = System.getProperty("user.dir");
		String testDataSheetPath = (path
				+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("Sanity");
		
		System.out.println("test sheet selected");
		
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
		
		String editFlag= tocSheet.getRow(row).getCell(3).getStringCellValue();
		String productName = tocSheet.getRow(row).getCell(4).getStringCellValue();
		waitSync();
		if(editFlag.equalsIgnoreCase("Y")) {
		//expwaitClickable(driver.findElement(By.xpath("(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='"+productName+"'])[1]")));
		//clickelement(driver.findElement(By.xpath("(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='"+productName+"'])[1]")));
		//waitSync();
		System.out.println("Selected product is :"+productName);
		waitSync();
		addProductTocart(or.selectManuals,productName);
		waitSync();
		clickelement(or.miniCart);
		waitSync();
		String act_MiniCart_ProductName= driver.findElement(By.xpath("//strong[@class='product-item-name']//span[contains(text(),'"+productName+"')]")).getText();
		String exp_MiniCart_ProductName=productName;
		Assert.assertEquals(act_MiniCart_ProductName, exp_MiniCart_ProductName);
		System.out.println("Product In Mini Cart matching with DataSheet:"+act_MiniCart_ProductName);
		
		
		
		clickelement(or.MiniCart_Editbtn);
		waitSync();
		windowScroll();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		System.out.println("Switching to the iframe");
		driver.switchTo().frame(0);
		clickelement(or.MiniCart_editqty);
		waitSync();

		
		/*
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = ''", or.editqty);
		or.MiniCart_editqty.sendKeys("5");
		*/
		or.MiniCart_editqty.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "55");
		/*
		or.MiniCart_editqty.sendKeys(Keys.CONTROL+"a");
		waitSync();
		or.MiniCart_editqty.sendKeys(Keys.DELETE);
		or.MiniCart_editqty.sendKeys("10");
		*/
		waitSync();
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String act_cartUpdatedMsg= or.successmsg_afterCartEdit.getText();
		System.out.println("Printing Success msg post quantity Updated::"+act_cartUpdatedMsg);
		String exp_cartUpdatedMsg=productName+" "+"Item Updated Successfully!";
		waitSync();		
		
		}

		clickelement(or.miniCart);
		impwait();
		clickelement(or.mimiCart_proceedTochkoutbtn);
		waitSync();
		clickelement(or.continueasguest_popup);
		System.out.println("Test Case Row num is: "+row);

		//Proceed with Shipping delivery methods
		
		String deliveryOption = tocSheet.getRow(row).getCell(6).getStringCellValue();
		//String deliveryop="Pickup";
		System.out.println("Delivery type is"+deliveryOption);
		waitSync();
		if (deliveryOption.equalsIgnoreCase("Pickup")) 
		{
			
			
			
			System.out.println("Printing inside Pickup IF contion");
			expwaitVisibility(or.pickupstore_selectionbutton);
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
			waitSync();
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
			//waitSync();
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
			
			String deliveryMethod = tocSheet.getRow(row).getCell(7).getStringCellValue();
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
	String paymentOption = tocSheet.getRow(row).getCell(8).getStringCellValue();
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
			clickelement(or.terms_condition_checkbox);
			clickelement(or.submitorder_button);
			expwaitVisibility(or.ordergtn);
			System.out.println(or.ordergtn.getText());
	
		

		tearDown();

		
	}
	
}