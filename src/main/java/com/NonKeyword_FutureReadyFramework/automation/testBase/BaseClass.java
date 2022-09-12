/* Name: BaseClass 
 * Description: This script is for Reusable Methods
 * Developed By: Chyne Chandran
 * Automation Architect: Jayant Naikwade
 * Input = Configurable Excel File  
 * Developed Date: 
 * Updated Date: 
 * Updated Reason:
 */
package com.NonKeyword_FutureReadyFramework.automation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.NonKeyword_FutureReadyFramework.automation.excelReader.ExcelUtils;
import com.NonKeyword_FutureReadyFramework.automation.objectRepository.ObjectRepository_LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static String StageURL="https://Staging.office.fedex.com";
	public static String Stage2URL="https://Staging2.office.fedex.com";
	public static String Stage3URL="https://Staging3.office.fedex.com";
	public static String ProdURL="https://office.fedex.com";

	
	public static void launchBrowser() throws IOException {
		
		String browsername = ExcelUtils.excelreadBrowser();
		if (browsername.equalsIgnoreCase("CHROME")) {
			try {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				System.out.println("[PASSED]" + browsername + "browser launched maximized successfully");
			} catch (Exception e) {
				System.err.println("[ERROR] Unable to launch " + browsername + e.toString());
			}
		} else if (browsername.equalsIgnoreCase("FIREFOX")) {
			try {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				System.out.println("[PASSED]" + browsername + "browser launched and maximized successfully");
			} catch (Exception e) {
				System.err.println("[ERROR] Unable to launch " + browsername + e.toString());
			}
		}

		else if (browsername.equalsIgnoreCase("EDGE")) {
			try {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				System.out.println("[PASSED]" + browsername + "browser launched and maximized successfully");
			} catch (Exception e) {
				System.err.println("[ERROR] Unable to launch " + browsername + e.toString());
			}
		}

		else if (browsername.equalsIgnoreCase("IE")) {
			try {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				System.out.println("[PASSED]" + browsername + "browser launched and maximized successfully");
			} catch (Exception e) {
				System.err.println("[ERROR] Unable to launch " + browsername + e.toString());
			}
		}

		else {
			throw new RuntimeException("[FAILED] Unable to launch chrome, firefox, edge and ie browsers");
		}
            
	}


	public static String getScreenshotpath(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String despath = System.getProperty("user.dir") + "\\reports\\" + filename + ".jpg";
		File des = new File(despath);
		FileUtils.copyFile(src, des);
		return despath;
	}

	public static void launchURL(String URL) throws IOException {

		try {
			driver.get(URL);

		} catch (Exception e) {
			System.err.println("[ERROR] Unable to launch" + URL + e.toString());
		}
	}
	
		public String readURL() throws IOException {
			return ExcelUtils.excelreadURL();
		}
	
	
	
		public String returnelementTxt(WebElement webelement) {
		
		String updatecardtxt= webelement.getText().toString();
		return updatecardtxt;
		
		}

	public static void inputtext(WebElement webelemeref, String txt) {
		webelemeref.sendKeys(txt);

	}

	public static void inputtextLoginPassword(WebElement webelemeref, String txt) {
		webelemeref.sendKeys(txt);

	}

	public static void clickelement(WebElement webelemeref) {
		webelemeref.click();

	}

	public void impwait() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void expwaitVisibility(WebElement webelementref) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(webelementref));
	}

	public void expwaitClickable(WebElement webelementref) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(webelementref));
	}
	
	public void windowScroll() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	
	public void waitSync() throws InterruptedException {
		Thread.sleep(10000);
	}
	
	public void shortWaitSync() throws InterruptedException {
		Thread.sleep(5000);
	}
	
	
	public void tearDown()
	{
		driver.manage().deleteAllCookies();
		driver.close();
	}
	
	public void addProductTocart(WebElement webelement, String itemName) throws InterruptedException {
		String path = System.getProperty("user.dir");
		ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
		PageFactory.initElements(driver, or);
		clickelement(or.searchbtn);
		inputtext(or.searchbtn,itemName);
		clickelement(or.clicksearch);
		waitSync();
		clickelement(webelement);
		waitSync();
		waitSync();
		clickelement(or.uploadbutton);
		waitSync();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		System.out.println("Switching to the iframe");
		driver.switchTo().frame(0);
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Manuals.pdf");
		waitSync();
		System.out.println("File is Uploaded Successfully");
		waitSync();
		expwaitClickable(or.addtocart);
		waitSync();
		clickelement(or.addtocart);
		waitSync();
	

		}
	public void addProductTocartSingle(WebElement webelement, String itemName) throws InterruptedException {
		String path = System.getProperty("user.dir");
		ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
		PageFactory.initElements(driver, or);
		clickelement(or.searchbtn);
		inputtext(or.searchbtn,itemName);
		clickelement(or.clicksearch);
		waitSync();
		clickelement(webelement);
		waitSync();
		shortWaitSync();
		clickelement(or.uploadbutton);
		waitSync();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		System.out.println("Switching to the iframe");
		driver.switchTo().frame(0);
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		
		switch (itemName)
		{
		case "Postcards":upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Postcards.pdf");
		break;
		case "Flyers":upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Flyers.pdf");
		break;
		case "Brochures":upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Brochures.pdf");
		break;
		case "Resumes":upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Resumes.pdf");
		break;
		case "Business Cards":upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Business Cards.pdf");
		break;
		case "Business Cards - Premium":upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Business Cards - Premium.pdf");
		break;
		case "Business Cards - Quick":upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Business Cards - Quick.pdf");
		break;
		case "Outdoor Banners":upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Outdoor Banners.pdf");
		break;
		case "Manuals":upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Manuals.pdf");
		break;
		case "Presentations":upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Presentations.pptx");
		break;
		
		}
//		upload.sendKeys(path + "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\01142022payslip.pdf");
		waitSync();
		System.out.println("File is Uploaded Successfully");
		waitSync();
		expwaitClickable(or.addtocart);
		waitSync();
		clickelement(or.addtocart);
		waitSync();
	

		}
	public void CC_Flow(int row) throws InterruptedException, IOException {

		ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
		PageFactory.initElements(driver, or);

		String path = System.getProperty("user.dir");
		String testDataSheetPath = (path
		+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet tocSheet = wb.getSheet("Sanity");

		System.out.println("Printing from CC flow");
		waitSync();
		clickelement(or.selectcc);
		waitSync();
		expwaitClickable(or.nameoncard);
		inputtext(or.nameoncard,"Test User");
		inputtext(or.cardno,"4111111111111111");
		Select month = new Select(driver.findElement(By.xpath("//select[@class='expiration-month']")));
		month.selectByVisibleText("5 - May");
		Select year = new Select(driver.findElement(By.xpath("//select[@class='expiration-year']")));
		year.selectByVisibleText("2026");
		inputtext(or.cvv,"111");
		waitSync();

		String deliveryOption = tocSheet.getRow(row).getCell(6).getStringCellValue();
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
		inputtext(or.shippingaddress_phno, "2149669687");
		System.out.println("Printing from cc flow2");
		waitSync();

		}
		}

	public void FedEx_Acc_Flow() throws InterruptedException {

		ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
		PageFactory.initElements(driver, or);
		System.out.println("Printing from FedEx Acc flow");
		//expwaitClickable(or.fedexacc);
		waitSync();
		clickelement(or.selectfedexacc);
		inputtext(or.fedexacc,"653243286"); //653243286
		waitSync();
		clickelement(or.fedexacc_revieworder);// clicking prod order review button
		}
	public void pickUPflow() throws InterruptedException {

		ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
		PageFactory.initElements(driver, or);
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
		/*
		clickelement(or.alternatepickupperson_checkbox);
		inputtext(or.alternate_fname, "Will");
		inputtext(or.alternate_lname, "Smith");
		inputtext(or.alternate_phoneno, "2149669687");
		inputtext(or.alternate_ext, "1234");
		inputtext(or.alternate_mail, "email@email.com");
		waitSync();
		*/
		clickelement(or.pickupFlowcontinueTopaybtn);
		}
	public void shippingFlow(int row) throws IOException, InterruptedException {

		ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
		PageFactory.initElements(driver, or);

		String path = System.getProperty("user.dir");
		String testDataSheetPath = (path
		+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet tocSheet = wb.getSheet("Sanity");

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


		}
	public void loginIntoMagento() throws IOException, InterruptedException {
	    ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
		PageFactory.initElements(driver, or);
		waitSync();
		
		try {
			expwaitVisibility(or.username);
			System.out.println("[PASSED]" + "Showing Login screen");
		} catch (Exception e) {
			throw new RuntimeException("[FAILED] Not showing Login screen");
		}
		inputtext(or.username, ExcelUtils.excelreadUserName());
		inputtext(or.password, ExcelUtils.excelreadPassword());
		clickelement(or.submitbtn);
		waitSync();

	}
	
	public void stwichingFrame() {
		
	    ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
		PageFactory.initElements(driver, or);
		int size = driver.findElements(By.id("fedex_iframe")).size();
		System.out.println(size);
		System.out.println("Switching to the iframe");
		driver.switchTo().frame(0);
	}
	
	/*	
	public String[] configrutor_Product_Property_Edit_Papers(int sizeCount) throws InterruptedException{
		
	    ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
		PageFactory.initElements(driver, or);
		
		stwichingFrame();
		clickelement(or.ProductPrint_properties);
		clickelement(or.Manuals_Edit_Paperbtn);
		shortWaitSync();
		clickelement(or.Manuals_printProperties_Paper_StdWhitePaperbtn);
		if(sizeCount==1) {
		clickelement(or.Manuals_StdPaper_Laser_24lb_radiobtn);
		}
		else if(sizeCount==2) {
			clickelement(or.Manuals_StdPaper_Laser_32lb_radiobtn);
		}
		clickelement(or.ProductPrint_properties_Size_Savebtn);
		clickelement(or.ProductPrint_properties);
		shortWaitSync();
		String[]price=new String[2];
		String productPriceBeforeCart=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart);
		String[] arr=new String[2];
		arr[0]=productPriceBeforeCart;
		arr[1]=productPriceInCart;
		
		return arr;
	}
	
	 */	
	public String[] configrutor_Product_Property_EditSize(int sizeCount) throws InterruptedException {
		
	    ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
		PageFactory.initElements(driver, or);
		int size = driver.findElements(By.id("fedex_iframe")).size();
		System.out.println(size);
		System.out.println("Switching to the iframe");
		driver.switchTo().frame(0);
		
		clickelement(or.ProductPrint_properties);
		clickelement(or.btn_Manual_Size_Edit);
		shortWaitSync();
		if(sizeCount==1) {
		clickelement(or.editSize_Manual_8half_and_11);
		}
		else if(sizeCount==2) {
			clickelement(or.editSize_Manual_8half_and_14);
		}
		else if(sizeCount==3) {
			clickelement(or.editSize_Manual_11_and_17);
		}
		shortWaitSync();
		clickelement(or.ProductPrint_properties_Size_Savebtn);
		String productPriceBeforeCart=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		String[] arr=new String[2];
		arr[0]=productPriceBeforeCart;
		arr[1]=productPriceInCart;
		//Assert.assertEquals(productPriceBeforeCart, productPriceInCart);
		
		return arr;
	}
	
	
	public void proceedToChecout(int row) throws IOException, InterruptedException {
		
	    ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
		PageFactory.initElements(driver, or);
		
		String path = System.getProperty("user.dir");
		String testDataSheetPath = (path
				+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("Sanity");

		System.out.println("test sheet selected");
		expwaitClickable(or.proceedtocheckout);
		clickelement(or.proceedtocheckout);
		waitSync();
		clickelement(or.continueasguest_popup);
		String deliveryOption = tocSheet.getRow(row).getCell(6).getStringCellValue();
		// String deliveryop="Pickup";
		System.out.println("Delivery type is" + deliveryOption);
		waitSync();
		if (deliveryOption.equalsIgnoreCase("Pickup")) {

			System.out.println("Printing inside Pickup IF contion");
			// expwaitVisibility(or.pickupstore_selectionbutton);
			waitSync();

			clickelement(or.pickupstore_selectionbutton);
			System.out.println("PickUp option selected");
			expwaitVisibility(or.pickupZipcode);
			inputtext(or.pickupZipcode, "75024");
			clickelement(or.pickupSearchbutton);
			expwaitVisibility(driver.findElement(By.xpath("//div[@class='pickup-location-item-container']")));
			driver.findElement(By.xpath(
					"(//div[@class='pickup-location-item-container']//label[@class='custom-radio-btn pick-up-button'])[2]"))
					.click();

			// Contact info
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

		} else {
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
			clickelement(driver
					.findElement(By.xpath("//input[@type='radio']/../..//td[@class='col col-carrier']//span[text()='"
							+ deliveryMethod + "']")));
			expwaitClickable(or.continuetopaymentbutton);
			waitSync();
			System.out.println("Printing before continue to payment button");
			clickelement(or.continuetopaymentbutton);
			waitSync();

		}

		// Payment screen
		expwaitVisibility(driver
				.findElement(By.xpath("//div[@class='payment-container']//div[@class='method-selection-container']")));
		waitSync();
		String paymentOption = tocSheet.getRow(row).getCell(8).getStringCellValue();
		// String paymentOption="Credit Card";
		System.out.println("Payment method selected" + paymentOption);

		if (paymentOption.equalsIgnoreCase("Credit Card")) {
			// Credit card info
			clickelement(or.selectcc);
			expwaitClickable(or.nameoncard);
			inputtext(or.nameoncard, "Test User");
			inputtext(or.cardno, "4111111111111111");
			Select month = new Select(driver.findElement(By.xpath("//select[@class='expiration-month']")));
			month.selectByVisibleText("5 - May");
			Select year = new Select(driver.findElement(By.xpath("//select[@class='expiration-year']")));
			year.selectByVisibleText("2026");
			inputtext(or.cvv, "111");

			// Billing info
			if (deliveryOption.equalsIgnoreCase("Pickup")) {
				System.out.println("Printing from cc flow1");
				inputtext(or.billingadd_companyname, "FedEx");
				inputtext(or.billingadd_adress, "7900 Legacy Dr");
				inputtext(or.billingadd_adressline2, "Suite 300");
				inputtext(or.billingadd_city, "Plano");

				Select drpState = new Select(driver.findElement(By.xpath("//select[@id='add-state']")));
				drpState.selectByVisibleText("TX");
				inputtext(or.billingadd_zipcode, "75024");
				// inputtext(or.shippingaddress_phno, "2149669687");
				System.out.println("Printing from cc flow2");
				Thread.sleep(10000);

			}

			waitSync();
			windowScroll();
			expwaitClickable(or.cc_reviewbutton);
			waitSync();
			System.out.println("Printing from cc flow");
			clickelement(or.cc_reviewbutton); // cc_revieworder_Prod

		} else {

			System.out.println("Printing from FedEx Acc flow");
			// expwaitClickable(or.fedexacc);
			waitSync();
			clickelement(or.selectfedexacc);
			inputtext(or.fedexacc, "653243286"); // 653243286
			waitSync();
			if(readURL().equalsIgnoreCase(Stage2URL)) {
			clickelement(or.stage2_fedexacc_revieworder);// clicking prod order review button
			}
			else if(readURL().equalsIgnoreCase(StageURL)) {
				clickelement(or.stage_fedexacc_revieworder);
			}
//			clickelement(or.fedexacc_revieworder);// clicking prod order review button

		}
		expwaitClickable(or.terms_condition_checkbox);
		clickelement(or.terms_condition_checkbox);
		clickelement(or.submitorder_button);
		waitSync();
//		expwaitVisibility(or.ordergtn);
//		System.out.println(or.ordergtn.getText());

		tearDown();

	}
	
	
	
	
	
}
