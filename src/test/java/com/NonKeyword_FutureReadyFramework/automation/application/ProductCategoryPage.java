package com.NonKeyword_FutureReadyFramework.automation.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.NonKeyword_FutureReadyFramework.automation.excelReader.ExcelUtils;
import com.NonKeyword_FutureReadyFramework.automation.objectRepository.ObjectRepository_LoginPage;
import com.NonKeyword_FutureReadyFramework.automation.testBase.BaseClass;

import junit.framework.Assert;

public class ProductCategoryPage extends BaseClass {
	
	
	public void Manuals_update_Product_Print_properties_AdvOptions_BlankSheets(int row) throws InterruptedException, IOException {
		

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

		// adding products to cart
		
		addProductTocart(or.selectManuals, "Manuals");
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.advOptions_tabs_blankSheets);
		shortWaitSync();
		clickelement(or.advOptions_tabs_blankSheets_addbtn);
		scrollWindow();
		clickelement(or.advOptions_tabs_blankSheets_paperType_drpdown);
		
		clickelement(or.advOptions_tabs_blankSheets_CLOSEbtn);
		clickelement(or.advOptions_tabs_blankSheets);
		
		
//		driver.findElement(By.xpath("(//div[@class='input-group'])[9]")).click();
//		or.advOptions_tabs_blankSheets_paperType_drpdown.sendKeys(Keys.DOWN);
//		shortWaitSync();
//		or.advOptions_tabs_blankSheets_paperType_drpdown.sendKeys(Keys.DOWN);
//		shortWaitSync();
//		or.advOptions_tabs_blankSheets_paperType_drpdown.sendKeys(Keys.RETURN);
//		Select allOptions=new Select(or.advOptions_tabs_blankSheets_paperType_drpdown);
//		allOptions.deselectByVisibleText("Sun Yellow (24 lb.)");
//		shortWaitSync();
		
		waitSync();
		String productPriceBeforeCart=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart);
		Assert.assertEquals(productPriceBeforeCart, productPriceInCart);
		shortWaitSync();
		proceedToChecout(row);
		
		
	}
	
	private void scrollWindow() {
		// TODO Auto-generated method stub
		
	}

	public void Manuals_update_Product_Print_properties_BindingandFinishing_Lamination(int row) throws InterruptedException, IOException {
		


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

		// adding products to cart
		
		addProductTocart(or.selectManuals, "Manuals");
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.Binding_and_Finishing);
		shortWaitSync();
		clickelement(or.Binding_and_Finishing_binding_lamination_addbtn);
		clickelement(or.Binding_and_Finishing_binding_lamination_noGLossyBorder);
		shortWaitSync();
		clickelement(or.Binding_and_Finishing_binding_lamination_CLOSEbtn);
		clickelement(or.Binding_and_Finishing);
		waitSync();
		String productPriceBeforeCart=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart);
		Assert.assertEquals(productPriceBeforeCart, productPriceInCart);
		shortWaitSync();
		proceedToChecout(row);
	}
	
	public void Manuals_update_Product_Print_properties_BindingandFinishing_Cutting(int row) throws IOException, InterruptedException {
		


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

		// adding products to cart
		
		addProductTocart(or.selectManuals, "Manuals");
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.Binding_and_Finishing);
		clickelement(or.Binding_and_Finishing_binding_Cutting_addbtn);
		shortWaitSync();
		clickelement(or.Binding_and_Finishing_binding_Cutting_HalfVerticle);
		shortWaitSync();
		clickelement(or.Binding_and_Finishing_binding_Cutting_CLOSEbtn);
		clickelement(or.Binding_and_Finishing);
		waitSync();
		String productPriceBeforeCart=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart);
		Assert.assertEquals(productPriceBeforeCart, productPriceInCart);
		shortWaitSync();
		proceedToChecout(row);
		
	}

	public void Manuals_update_Product_Print_properties_BindingandFinishing_Binding(int row) throws IOException, InterruptedException {
		
		

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

		// adding products to cart
		
		addProductTocart(or.selectManuals, "Manuals");
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.Binding_and_Finishing);
//		windowScroll();
		shortWaitSync();
		clickelement(or.Binding_and_Finishing_binding_stapling_addbtn);
		shortWaitSync();
		clickelement(or.Binding_and_Finishing_binding_stapling_StapleRadiobtn);
		shortWaitSync();
		
//		WebElement drpDownlist= driver.findElement(By.xpath("//input[@id='custom-dropdown-39']"));
//		Select stapleOptions=new Select(drpDownlist);
//		stapleOptions.selectByIndex(3);
//		stapleOptions.selectByVisibleText("Top Double Stapled");
		

//		@SuppressWarnings("unchecked")
//		List<WebElement> alloptions= (List<WebElement>) driver.findElement(By.xpath("//div[@class='input-group']//input[@id='custom-dropdown-39']"));
//		for(WebElement e:alloptions) {
//			if(e.getText().equalsIgnoreCase("Top Double Stapled"));
//			e.click();
//		}
		
		clickelement(or.Binding_and_Finishing_binding_stapling_drpdown);
		shortWaitSync();
		clickelement(or.Binding_and_Finishing_binding_stapling_CLOSEbtn);
		clickelement(or.Binding_and_Finishing);
		waitSync();
		String productPriceBeforeCart=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart);
		Assert.assertEquals(productPriceBeforeCart, productPriceInCart);
		shortWaitSync();
		proceedToChecout(row);
		
		
		
	}
	
	public void Manuals_update_Product_Print_properties_Orientation(int row) throws Exception {
		

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

		// adding products to cart
		
		addProductTocart(or.selectManuals, "Manuals");
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.ProductPrint_properties);
		windowScroll();
		clickelement(or.Manuals_Edit_orientation_btn1);
		shortWaitSync();
		clickelement(or.Manuals_Edit_orientation_btn1_Landscape_radiobtn);
		shortWaitSync();
		clickelement(or.Manuals_Edit_orientation_btn1);
		clickelement(or.ProductPrint_properties);
		waitSync();
		String productPriceBeforeCart=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart);
		Assert.assertEquals(productPriceBeforeCart, productPriceInCart);
		shortWaitSync();
		proceedToChecout(row);
		
	}
	
	public void Manuals_update_Product_Print_properties_Sides(int row) throws IOException, InterruptedException {
		
		
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

		// adding products to cart
		
		addProductTocart(or.selectManuals, "Manuals");
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.ProductPrint_properties);
		windowScroll();
		shortWaitSync();
		clickelement(or.Manuals_Edit_Sides_btn);
		shortWaitSync();
		clickelement(or.Manuals_Edit_Sides_doubleSided_radiobtn);
		shortWaitSync();
		clickelement(or.Manuals_Edit_Sides_Close_btn);
		clickelement(or.ProductPrint_properties);
		waitSync();
		String productPriceBeforeCart=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart);
		Assert.assertEquals(productPriceBeforeCart, productPriceInCart);
		shortWaitSync();
		proceedToChecout(row);
	}
	
	
	public void Manuals_update_Product_Print_properties_Color_BlackWhite(int row) throws InterruptedException, IOException {
		
		
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

		// adding products to cart
		
		addProductTocart(or.selectManuals, "Manuals");
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.ProductPrint_properties);
		clickelement(or.Manuals_Edit_colorBW_btn);
		clickelement(or.Manuals_Edit_colorBW_BW_radiobtn);
		shortWaitSync();
		clickelement(or.Manuals_Edit_colorBW_BW_closebtn);
		clickelement(or.ProductPrint_properties);
		waitSync();
		String productPriceBeforeCart=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart);
		Assert.assertEquals(productPriceBeforeCart, productPriceInCart);
		shortWaitSync();
		
		//selecting next radio button- First page color and remaining pages black and white
		
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.ProductPrint_properties);
		clickelement(or.Manuals_Edit_colorBW_btn);
		clickelement(or.Manuals_Edit_colorBW_BW_FirstPageColor_radiobtn);
		shortWaitSync();
		clickelement(or.Manuals_Edit_colorBW_BW_closebtn);
		clickelement(or.ProductPrint_properties);
		waitSync();
		String productPriceBeforeCart1=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart1);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart1=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart1);
		Assert.assertEquals(productPriceBeforeCart1, productPriceInCart1);
		shortWaitSync();
		
		
		proceedToChecout(row);
	}
	
	public void Manuals_update_Product_Print_properties_ProColorPaper(int row) throws InterruptedException, IOException {
		
		
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

		// adding products to cart
		
		addProductTocart(or.selectManuals, "Manuals");
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.ProductPrint_properties);
		clickelement(or.Manuals_Edit_Paperbtn);
		shortWaitSync();
		clickelement(or.Manuals_printProperties_Paper_proColorPaperbtn);
		waitSync();
		clickelement(or.Manuals_printProperties_Paper_proColorPaperbtn);
		clickelement(or.Manuals_printProperties_Paper_Close_btn);
		clickelement(or.ProductPrint_properties);
		clickelement(or.savebtnAfterEdit);
		proceedToChecout(row);
		
	}
	
	public void Manuals_update_Product_Print_properties_StdColorPaper(int row) throws InterruptedException, IOException {
		
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

		// adding products to cart
		
		addProductTocart(or.selectManuals, "Manuals");
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.ProductPrint_properties);
		clickelement(or.Manuals_Edit_Paperbtn);
		shortWaitSync();
		clickelement(or.Manuals_printProperties_Paper_StdColorPaperbtn);
		shortWaitSync();
//		clickelement(or.Manuals_printProperties_Paper_StdColorPaperbtn_Ivory24LB_btn);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", or.Manuals_printProperties_Paper_StdColorPaperbtn_Ivory24LB_btn);
		shortWaitSync();
		clickelement(or.Manuals_printProperties_Paper_StdColorPaperbtn);
		clickelement(or.ProductPrint_properties_Size_Savebtn);
		clickelement(or.ProductPrint_properties);
		shortWaitSync();
		String productPriceBeforeCart=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart);
		Assert.assertEquals(productPriceBeforeCart, productPriceInCart);
		
		proceedToChecout(row);
	}
	
	
	public void Manuals_update_Product_Print_properties_CardStocksSpecialty(int row) throws IOException, InterruptedException {
		

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

		// adding products to cart
		
		addProductTocart(or.selectManuals, "Manuals");
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.ProductPrint_properties);
		clickelement(or.Manuals_Edit_Paperbtn);
		clickelement(or.Manuals_printProperties_Paper_cardStockSpeciality_btn);
		clickelement(or.Manuals_printProperties_Paper_cardStockSpeciality_btn_waterResistant_btn);
		shortWaitSync();
		clickelement(or.Manuals_printProperties_Paper_cardStockSpeciality_btn);
		clickelement(or.Manuals_printProperties_Paper_Close_btn);
		clickelement(or.Manuals_Edit_Paperbtn);
		clickelement(or.ProductPrint_properties_Size_Savebtn);
		clickelement(or.ProductPrint_properties);
		shortWaitSync();
		String productPriceBeforeCart=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart);
		Assert.assertEquals(productPriceBeforeCart, productPriceInCart);
		
//		clickelement(or.editOrderbtn);
//		waitSync();
//		stwichingFrame();
//		clickelement(or.ProductPrint_properties);
//		clickelement(or.Manuals_Edit_Paperbtn);
//		clickelement(or.Manuals_printProperties_Paper_cardStockSpeciality_btn);
//		waitSync();
//		clickelement(or.Manuals_printProperties_Paper_cardStockSpeciality_btn_Ivory65LB_btn);
//		shortWaitSync();
//		clickelement(or.Manuals_printProperties_Paper_cardStockSpeciality_btn);
//		clickelement(or.Manuals_printProperties_Paper_Close_btn);
//		clickelement(or.Manuals_Edit_Paperbtn);
//		clickelement(or.ProductPrint_properties_Size_Savebtn);
//		clickelement(or.ProductPrint_properties);
//		shortWaitSync();
//		String productPriceBeforeCart1=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
//		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart1);
//		clickelement(or.savebtnAfterEdit);
//		waitSync();
//		String productPriceInCart1=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
//		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart1);
//		Assert.assertEquals(productPriceBeforeCart1, productPriceInCart1);
		
		proceedToChecout(row);
		
	}
	
	public  void Manuals_update_Product_Print_properties_ProWhitePaper(int row) throws InterruptedException, IOException {
		

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

		// adding products to cart
		
		addProductTocart(or.selectManuals, "Manuals");
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.ProductPrint_properties);
		clickelement(or.Manuals_Edit_Paperbtn);
		clickelement(or.Manuals_printProperties_Paper_proWhitePaperbtn);
		clickelement(or.Manuals_printProperties_Paper_proWhitePaperbtn_leaser60lb);
		clickelement(or.Manuals_printProperties_Paper_proWhitePaperbtn);
		clickelement(or.ProductPrint_properties_Size_Savebtn);
		
		clickelement(or.ProductPrint_properties);
		shortWaitSync();
		String productPriceBeforeCart=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart);
		Assert.assertEquals(productPriceBeforeCart, productPriceInCart);
		
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.ProductPrint_properties);
		clickelement(or.Manuals_Edit_Paperbtn);
		clickelement(or.Manuals_printProperties_Paper_proWhitePaperbtn);
		clickelement(or.Manuals_printProperties_Paper_proWhitePaperbtn_leaser80lb);
		clickelement(or.Manuals_printProperties_Paper_proWhitePaperbtn);
		clickelement(or.ProductPrint_properties_Size_Savebtn);
		
		clickelement(or.ProductPrint_properties);
		shortWaitSync();
		String productPriceBeforeCart1=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart1);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart1=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart1);
		Assert.assertEquals(productPriceBeforeCart1, productPriceInCart1);
		
		
		proceedToChecout(row);// moving ahead with order creation
		
	}
	
	public void Manuals_update_Product_Print_properties_StdWhitePaper(int row) throws InterruptedException, IOException {
		
		
		

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

		// adding products to cart
		
		addProductTocart(or.selectManuals, "Manuals");
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.ProductPrint_properties);
		clickelement(or.Manuals_Edit_Paperbtn);
		shortWaitSync();
		clickelement(or.Manuals_printProperties_Paper_StdWhitePaperbtn);
		clickelement(or.Manuals_StdPaper_Laser_24lb_radiobtn);
		clickelement(or.ProductPrint_properties_Size_Savebtn);
		clickelement(or.ProductPrint_properties);
		shortWaitSync();
		String productPriceBeforeCart=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart);
		
		Assert.assertEquals(productPriceBeforeCart, productPriceInCart);
		
		clickelement(or.editOrderbtn);
		waitSync();
		stwichingFrame();
		clickelement(or.ProductPrint_properties);
		clickelement(or.Manuals_Edit_Paperbtn);
		shortWaitSync();
		clickelement(or.Manuals_printProperties_Paper_StdWhitePaperbtn);
		shortWaitSync();
		System.out.println("Printing Before seleting 20lb Paper");
		clickelement(or.Manuals_StdPaper_Laser_32lb_radiobtn);
		clickelement(or.ProductPrint_properties_Size_Savebtn);
		clickelement(or.ProductPrint_properties);
		shortWaitSync();
		String productPriceBeforeCart1=or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		System.out.println("Updated Product Price before adding to Cart::"+productPriceBeforeCart1);
		clickelement(or.savebtnAfterEdit);
		waitSync();
		String productPriceInCart1=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		System.out.println("Updated Product Price after adding to Cart::"+productPriceBeforeCart1);
		
		Assert.assertEquals(productPriceBeforeCart1, productPriceInCart1);
		
		proceedToChecout(row);
		
}
	
	public void Manuals_update_Product_Print_properties_AllSize(int row) throws Exception {
		

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

		// adding products to cart
		
		addProductTocart(or.selectManuals, "Manuals");
		clickelement(or.editOrderbtn);
		waitSync();
		String[]price=new String[2];
		int sizeChangeCount=1;
		price= configrutor_Product_Property_EditSize(sizeChangeCount);
		Assert.assertEquals(price[0], price[1]);
		clickelement(or.editOrderbtn);
		waitSync();
		sizeChangeCount++;
		price= configrutor_Product_Property_EditSize(sizeChangeCount);
		Assert.assertEquals(price[0], price[1]);
		
		/*****Code below is comment which is related to third size option available but that option is default option 
		clickelement(or.editOrderbtn);
		waitSync();
		sizeChangeCount++;
		price= configrutor_Product_Property_EditSize(sizeChangeCount);
		Assert.assertEquals(price[0], price[1]);
		clickelement(or.editOrderbtn);
		waitSync();
		*******/
		
		proceedToChecout(row);
		
		
		
		
	}
	
	public void PostCards_update_Product_Print_properties_Size(int row) throws IOException, InterruptedException {
		

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

		// adding products to cart
		System.out.println("Print before adding product to cart");
		addProductTocartSingle(or.selectPostcardsUsingSearch, "PostCards");
		shortWaitSync();
		clickelement(or.editOrderbtn);
		shortWaitSync();
		System.out.println("Print before configurator");
		
		clickelement(or.ProductPrint_properties);
		

		clickelement(or.postCard_ProductPrint_properties_Size);
		shortWaitSync();
		clickelement(or.postCard_ProductPrint_properties_size_4x5);
		waitSync();
		clickelement(or.btn_SaveChanges);
		
		String poductPricePostUpdate= or.price_afterpostCard_ProductPrint_propertiesUpdate.getText();
		String productPriceinCart=or.price_afterpostCard_ProductPrint_propertiesUpdate_Incart.getText();
		
		Assert.assertEquals(poductPricePostUpdate, productPriceinCart);
		System.out.println("Product Updated price matching with Product price in cart");
		
		
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
			clickelement(or.fedexacc_revieworder);// clicking prod order review button

		}
		expwaitClickable(or.terms_condition_checkbox);
		clickelement(or.terms_condition_checkbox);
		clickelement(or.submitorder_button);
		expwaitVisibility(or.ordergtn);
		System.out.println(or.ordergtn.getText());

		tearDown();

		
		
		
		
	}

	public void Yard_Sign_FedExACCflow(int row) throws InterruptedException, IOException {

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

		// adding products to cart

		addProductTocartSingle(or.select_Yard_sign, "Yard Sign");
		waitSync();
		System.out.println("Yard Sign added to cart");

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
			clickelement(or.fedexacc_revieworder);// clicking prod order review button

		}
		expwaitClickable(or.terms_condition_checkbox);
		clickelement(or.terms_condition_checkbox);
		clickelement(or.submitorder_button);
		expwaitVisibility(or.ordergtn);
		System.out.println(or.ordergtn.getText());

		tearDown();

	}

	public void Metal_Sign(int row) throws IOException, InterruptedException {

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

		// adding products to cart

		addProductTocartSingle(or.Select_Metal_Sign, "Metal Sign");
		waitSync();
		System.out.println("Metal Sign added to cart");

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
			// expwaitVisibility(or.shiptoaddress_selectionbutton);
			// waitSync();
			// clickelement(or.shiptoaddress_selectionbutton);
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
			clickelement(or.fedexacc_revieworder);// clicking prod order review button

		}
		clickelement(or.terms_condition_checkbox);
		clickelement(or.submitorder_button);
		expwaitVisibility(or.ordergtn);
		System.out.println(or.ordergtn.getText());

		tearDown();

	}

	public void Corrugated_plastic_sign(int row) throws IOException, InterruptedException {

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

		// adding products to cart

		addProductTocartSingle(or.select_Corrugated_Plastic_Sign, "Corrugated Plastic Sign");
		waitSync();
		System.out.println("Corrugated Plastic Sign added to cart");

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
			// expwaitVisibility(or.shiptoaddress_selectionbutton);
			// waitSync();
			// clickelement(or.shiptoaddress_selectionbutton);
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
			clickelement(or.fedexacc_revieworder);// clicking prod order review button

		}
		clickelement(or.terms_condition_checkbox);
		clickelement(or.submitorder_button);
		expwaitVisibility(or.ordergtn);
		System.out.println(or.ordergtn.getText());

		tearDown();

	}

	/*
	 * public void PromoCode_UpdatedQty(int row, String PromoCode) throws
	 * IOException, InterruptedException {
	 * 
	 * String path = System.getProperty("user.dir"); String testDataSheetPath =
	 * (path +
	 * "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx"
	 * );
	 * 
	 * List<String> list = new ArrayList<String>(); File f = new
	 * File(testDataSheetPath); FileInputStream fis = new FileInputStream(f);
	 * Workbook wb = new XSSFWorkbook(fis); Sheet tocSheet = wb.getSheet("Sanity");
	 * 
	 * System.out.println("test sheet selected");
	 * 
	 * try { launchBrowser(); System.out.println("[PASSED]" +
	 * "browser launched and maximized successfully"); } catch (Exception e) {
	 * System.err.println("[ERROR] Unable to launch " + e.toString()); throw new
	 * RuntimeException("[FAILED] Unable to launch chrome, firefox, edge and ie browsers"
	 * ); }
	 * 
	 * try { launchURL(ExcelUtils.excelreadURL()); System.out.println("[PASSED]" +
	 * "URL launched successfully"); } catch (Exception e) {
	 * System.err.println("[ERROR] Unable to launch " + e.toString()); throw new
	 * RuntimeException("[FAILED] Unable to launch URL"); }
	 * 
	 * ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
	 * PageFactory.initElements(driver, or);
	 * 
	 * 
	 * //adding products to cart
	 * 
	 * addProductTocart(or.selectFlyersUsingSearch,"Flyers"); waitSync();
	 * System.out.println("Flyers added to cart"); clickelement(or.SelectOrderqty);
	 * Select OrderQty = new Select(driver.findElement(By.
	 * xpath("//select[@class='input-text qty product-engine-qty']")));
	 * OrderQty.selectByVisibleText("100"); impwait();
	 * clickelement(or.btn_UpdateShoppingCart); waitSync();
	 * clickelement(or.promoCodeLink); impwait();
	 * 
	 * inputtext(or.promoCodeInput,PromoCode); clickelement(or.applyButton);
	 * if(PromoCode.equals("MGT001")) { String
	 * PromoCode_successMsg=or.successMsg_MGT001.getText();
	 * Assert.assertEquals("You used coupon code \"MGT001\".",
	 * PromoCode_successMsg);
	 * System.out.println("Coupon Code MGT001 applied Successfully");
	 * Assert.assertEquals("$10.00", or.discountValue.getText()); System.out.
	 * println("Discount of $10.00 applied successgully using Promo code MGT001");
	 * //tearDown(); } else { String
	 * PromoCode_successMsg=or.successMsg_MGT002.getText();
	 * Assert.assertEquals("You used coupon code \"MGT002\".",
	 * PromoCode_successMsg);
	 * System.out.println("Coupon Code MGT002 applied Successfully"); String
	 * cartPrice=or.priceBeforeCouponDiscount.getText();
	 * System.out.println("Price of the cart item is as string:"+cartPrice);
	 * StringBuilder act_cartPrice= new StringBuilder(cartPrice); String
	 * ProductPrice=act_cartPrice.deleteCharAt(0).toString(); //String
	 * act_cartPrice=act_cartPrice.deleteChartAt(0); float
	 * Price=Float.parseFloat(ProductPrice);
	 * System.out.println("Price of the cart item is as float:"+Price); float
	 * coupon2Discount=Price/2;
	 * System.out.println("Discount amount is :"+coupon2Discount); DecimalFormat df
	 * = new DecimalFormat("0.00"); df.setRoundingMode(RoundingMode.DOWN); String
	 * act_discountedValue=df.format(coupon2Discount);
	 * System.out.println("Discount amount after roundoff :"+act_discountedValue);
	 * String exp_discountedValue="$"+act_discountedValue;
	 * System.out.println("Discount amount after roundoff and adding dollar sign :"
	 * +exp_discountedValue); Assert.assertEquals(exp_discountedValue,
	 * or.discountValue.getText()); System.out.println("Discount of"
	 * +coupon2Discount+"applied successgully using Promo code MGT002");
	 * //tearDown(); }
	 * 
	 * waitSync(); clickelement(or.proceedtocheckout); waitSync();
	 * clickelement(or.continueasguest_popup);
	 * 
	 * System.out.println("Test Case Row num is: "+row);
	 * 
	 * //Proceed with Shipping delivery methods
	 * 
	 * String deliveryOption1 =
	 * tocSheet.getRow(row).getCell(6).getStringCellValue(); //String
	 * deliveryop="Pickup"; System.out.println("Delivery type is"+deliveryOption1);
	 * waitSync(); if (deliveryOption1.equalsIgnoreCase("Pickup")) {
	 * 
	 * 
	 * 
	 * System.out.println("Printing inside Pickup IF contion");
	 * expwaitVisibility(or.pickupstore_selectionbutton); waitSync();
	 * 
	 * clickelement(or.pickupstore_selectionbutton);
	 * System.out.println("PickUp option selected");
	 * expwaitVisibility(or.pickupZipcode); inputtext(or.pickupZipcode, "75024");
	 * clickelement(or.pickupSearchbutton);
	 * expwaitVisibility(driver.findElement(By.xpath(
	 * "//div[@class='pickup-location-item-container']"))); driver.findElement(By.
	 * xpath("(//div[@class='pickup-location-item-container']//label[@class='custom-radio-btn pick-up-button'])[2]"
	 * )).click();
	 * 
	 * //Contact info expwaitClickable(or.con_fname); inputtext(or.con_fname,
	 * "Joe"); inputtext(or.con_lname, "Doe"); inputtext(or.con_phoneno,
	 * "2149669687"); inputtext(or.con_ext, "1234"); inputtext(or.con_email,
	 * "email@email.com"); waitSync();
	 * clickelement(or.alternatepickupperson_checkbox);
	 * inputtext(or.alternate_fname, "Will"); inputtext(or.alternate_lname,
	 * "Smith"); inputtext(or.alternate_phoneno, "2149669687");
	 * inputtext(or.alternate_ext, "1234"); inputtext(or.alternate_mail,
	 * "email@email.com"); waitSync(); clickelement(or.pickupFlowcontinueTopaybtn);
	 * 
	 * 
	 * 
	 * } else { expwaitVisibility(or.shiptoaddress_selectionbutton); //waitSync();
	 * clickelement(or.shiptoaddress_selectionbutton);
	 * inputtext(or.shippingaddress_fname, "Joe");
	 * inputtext(or.shippingaddress_lname, "Doe");
	 * inputtext(or.shippingaddress_email, "email@email.com");
	 * inputtext(or.shippingaddress_company, "FedEx");
	 * inputtext(or.shippingaddress_address, "7900 Legacy Dr");
	 * inputtext(or.shippingaddress_city, "Plano");
	 * 
	 * Select drpState = new
	 * Select(driver.findElement(By.xpath("//select[@name='region_id']")));
	 * drpState.selectByVisibleText("TX"); inputtext(or.shippingaddress_zipcode,
	 * "75024"); inputtext(or.shippingaddress_phno, "2149669687"); waitSync();
	 * clickelement(or.shipingresult_button); waitSync();
	 * 
	 * String deliveryMethod = tocSheet.getRow(row).getCell(7).getStringCellValue();
	 * waitSync(); expwaitVisibility(driver.findElement(By.
	 * xpath("//div[text()='Delivery methods']"))); windowScroll();
	 * clickelement(driver.findElement(By.
	 * xpath("//input[@type='radio']/../..//td[@class='col col-carrier']//span[text()='"
	 * +deliveryMethod+"']"))); expwaitClickable(or.continuetopaymentbutton);
	 * waitSync(); System.out.println("Printing before continue to payment button");
	 * clickelement(or.continuetopaymentbutton); waitSync();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * //Payment screen expwaitVisibility(driver.findElement(By.xpath(
	 * "//div[@class='payment-container']//div[@class='method-selection-container']"
	 * ))); waitSync(); String paymentOption =
	 * tocSheet.getRow(row).getCell(8).getStringCellValue(); //String
	 * paymentOption="Credit Card";
	 * System.out.println("Payment method selected"+paymentOption);
	 * 
	 * if(paymentOption.equalsIgnoreCase("Credit Card")) { //Credit card info
	 * clickelement(or.selectcc); expwaitClickable(or.nameoncard);
	 * inputtext(or.nameoncard,"Test User");
	 * inputtext(or.cardno,"4111111111111111"); Select month = new
	 * Select(driver.findElement(By.xpath("//select[@class='expiration-month']")));
	 * month.selectByVisibleText("5 - May"); Select year = new
	 * Select(driver.findElement(By.xpath("//select[@class='expiration-year']")));
	 * year.selectByVisibleText("2026"); inputtext(or.cvv,"111");
	 * 
	 * //Billing info if(deliveryOption1.equalsIgnoreCase("Pickup")) {
	 * System.out.println("Printing from cc flow1");
	 * inputtext(or.billingadd_companyname, "FedEx");
	 * inputtext(or.billingadd_adress, "7900 Legacy Dr");
	 * inputtext(or.billingadd_adressline2, "Suite 300");
	 * inputtext(or.billingadd_city, "Plano");
	 * 
	 * Select drpState = new
	 * Select(driver.findElement(By.xpath("//select[@id='add-state']")));
	 * drpState.selectByVisibleText("TX"); inputtext(or.billingadd_zipcode,
	 * "75024"); //inputtext(or.shippingaddress_phno, "2149669687");
	 * System.out.println("Printing from cc flow2"); Thread.sleep(10000);
	 * 
	 * 
	 * }
	 * 
	 * waitSync(); windowScroll(); expwaitClickable(or.cc_reviewbutton); waitSync();
	 * System.out.println("Printing from cc flow");
	 * clickelement(or.cc_reviewbutton); //cc_revieworder_Prod
	 * 
	 * 
	 * 
	 * } else {
	 * 
	 * System.out.println("Printing from FedEx Acc flow");
	 * //expwaitClickable(or.fedexacc); waitSync(); clickelement(or.selectfedexacc);
	 * inputtext(or.fedexacc,"653243286"); //653243286 waitSync();
	 * clickelement(or.fedexacc_revieworder);// clicking prod order review button
	 * 
	 * } clickelement(or.terms_condition_checkbox);
	 * clickelement(or.submitorder_button); expwaitVisibility(or.ordergtn);
	 * System.out.println(or.ordergtn.getText());
	 * 
	 * 
	 * 
	 * tearDown();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * public void PromoCode(int row, String PromoCode) throws IOException,
	 * InterruptedException {
	 * 
	 * String path = System.getProperty("user.dir"); String testDataSheetPath =
	 * (path +
	 * "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx"
	 * );
	 * 
	 * List<String> list = new ArrayList<String>(); File f = new
	 * File(testDataSheetPath); FileInputStream fis = new FileInputStream(f);
	 * Workbook wb = new XSSFWorkbook(fis); Sheet tocSheet = wb.getSheet("Sanity");
	 * 
	 * System.out.println("test sheet selected");
	 * 
	 * try { launchBrowser(); System.out.println("[PASSED]" +
	 * "browser launched and maximized successfully"); } catch (Exception e) {
	 * System.err.println("[ERROR] Unable to launch " + e.toString()); throw new
	 * RuntimeException("[FAILED] Unable to launch chrome, firefox, edge and ie browsers"
	 * ); }
	 * 
	 * try { launchURL(ExcelUtils.excelreadURL()); System.out.println("[PASSED]" +
	 * "URL launched successfully"); } catch (Exception e) {
	 * System.err.println("[ERROR] Unable to launch " + e.toString()); throw new
	 * RuntimeException("[FAILED] Unable to launch URL"); }
	 * 
	 * ObjectRepository_LoginPage or = new ObjectRepository_LoginPage();
	 * PageFactory.initElements(driver, or);
	 * 
	 * 
	 * //adding products to cart
	 * 
	 * addProductTocart(or.selectPostcardsUsingSearch,"PostCards"); waitSync();
	 * System.out.println("PostCards added to cart");
	 * 
	 * clickelement(or.promoCodeLink); impwait();
	 * 
	 * inputtext(or.promoCodeInput,PromoCode); clickelement(or.applyButton);
	 * 
	 * if(PromoCode.equals("MGT001")) { String
	 * PromoCode_successMsg=or.successMsg_MGT001.getText();
	 * Assert.assertEquals("You used coupon code \"MGT001\".",
	 * PromoCode_successMsg);
	 * System.out.println("Coupon Code MGT001 applied Successfully");
	 * Assert.assertEquals("$10.00", or.discountValue.getText()); System.out.
	 * println("Discount of $10.00 applied successgully using Promo code MGT001");
	 * impwait(); //testing Promo code cancellation feature
	 * clickelement(or.cancelCoupon); waitSync(); String
	 * act_discountTitle=or.discount_title.getText();
	 * System.out.println("act_discountTitle"+act_discountTitle); String
	 * exp_discountTitle="+ ADD PROMO CODE";
	 * System.out.println("exp_discountTitle"+exp_discountTitle);
	 * Assert.assertEquals(act_discountTitle, exp_discountTitle);
	 * System.out.println("PromoCode Title available after removing Promo code");
	 * waitSync();
	 * 
	 * clickelement(or.promoCodeLink); impwait();
	 * 
	 * 
	 * 
	 * if(PromoCode.equals("MGT001")) { inputtext(or.promoCodeInput,PromoCode);
	 * clickelement(or.applyButton); String
	 * PromoCode_successMsg1=or.successMsg_MGT001.getText();
	 * Assert.assertEquals("You used coupon code \"MGT001\".",
	 * PromoCode_successMsg1);
	 * System.out.println("Coupon Code MGT001 applied Successfully");
	 * Assert.assertEquals("$10.00", or.discountValue.getText()); System.out.
	 * println("Discount of $10.00 applied successgully using Promo code MGT001");
	 * impwait(); //tearDown(); } } else { //inputtext(or.promoCodeInput,PromoCode);
	 * //clickelement(or.applyButton); String
	 * PromoCode_successMsg1=or.successMsg_MGT002.getText();
	 * System.out.println("PromoCode_successMsg1"+PromoCode_successMsg1);
	 * Assert.assertEquals("You used coupon code \"MGT002\".",
	 * PromoCode_successMsg1);
	 * System.out.println("Coupon Code MGT002 applied Successfully"); String
	 * cartPrice=or.priceBeforeCouponDiscount.getText();
	 * System.out.println("Price of the cart item is as string:"+cartPrice);
	 * StringBuilder act_cartPrice= new StringBuilder(cartPrice); String
	 * ProductPrice=act_cartPrice.deleteCharAt(0).toString(); //String
	 * act_cartPrice=act_cartPrice.deleteChartAt(0); float
	 * Price=Float.parseFloat(ProductPrice);
	 * System.out.println("Price of the cart item is as float:"+Price); float
	 * coupon2Discount=Price/2;
	 * System.out.println("Discount amount is :"+coupon2Discount); String
	 * exp_discountedValue="$"+coupon2Discount;
	 * Assert.assertEquals(exp_discountedValue, or.discountValue.getText());
	 * System.out.println("Discount of"
	 * +coupon2Discount+"applied successgully using Promo code MGT002");
	 * //tearDown(); }
	 * 
	 * waitSync(); clickelement(or.proceedtocheckout); waitSync();
	 * clickelement(or.continueasguest_popup);
	 * 
	 * System.out.println("Test Case Row num is: "+row);
	 * 
	 * //Proceed with Shipping delivery methods
	 * 
	 * String deliveryOption1 =
	 * tocSheet.getRow(row).getCell(6).getStringCellValue(); //String
	 * deliveryop="Pickup"; System.out.println("Delivery type is"+deliveryOption1);
	 * waitSync(); if (deliveryOption1.equalsIgnoreCase("Pickup")) {
	 * 
	 * 
	 * 
	 * System.out.println("Printing inside Pickup IF contion");
	 * expwaitVisibility(or.pickupstore_selectionbutton); waitSync();
	 * 
	 * clickelement(or.pickupstore_selectionbutton);
	 * System.out.println("PickUp option selected");
	 * expwaitVisibility(or.pickupZipcode); inputtext(or.pickupZipcode, "75024");
	 * clickelement(or.pickupSearchbutton);
	 * expwaitVisibility(driver.findElement(By.xpath(
	 * "//div[@class='pickup-location-item-container']"))); driver.findElement(By.
	 * xpath("(//div[@class='pickup-location-item-container']//label[@class='custom-radio-btn pick-up-button'])[2]"
	 * )).click();
	 * 
	 * //Contact info expwaitClickable(or.con_fname); inputtext(or.con_fname,
	 * "Joe"); inputtext(or.con_lname, "Doe"); inputtext(or.con_phoneno,
	 * "2149669687"); inputtext(or.con_ext, "1234"); inputtext(or.con_email,
	 * "email@email.com"); waitSync();
	 * clickelement(or.alternatepickupperson_checkbox);
	 * inputtext(or.alternate_fname, "Will"); inputtext(or.alternate_lname,
	 * "Smith"); inputtext(or.alternate_phoneno, "2149669687");
	 * inputtext(or.alternate_ext, "1234"); inputtext(or.alternate_mail,
	 * "email@email.com"); waitSync(); clickelement(or.pickupFlowcontinueTopaybtn);
	 * 
	 * 
	 * 
	 * } else { expwaitVisibility(or.shiptoaddress_selectionbutton); //waitSync();
	 * clickelement(or.shiptoaddress_selectionbutton);
	 * inputtext(or.shippingaddress_fname, "Joe");
	 * inputtext(or.shippingaddress_lname, "Doe");
	 * inputtext(or.shippingaddress_email, "email@email.com");
	 * inputtext(or.shippingaddress_company, "FedEx");
	 * inputtext(or.shippingaddress_address, "7900 Legacy Dr");
	 * inputtext(or.shippingaddress_city, "Plano");
	 * 
	 * Select drpState = new
	 * Select(driver.findElement(By.xpath("//select[@name='region_id']")));
	 * drpState.selectByVisibleText("TX"); inputtext(or.shippingaddress_zipcode,
	 * "75024"); inputtext(or.shippingaddress_phno, "2149669687"); waitSync();
	 * clickelement(or.shipingresult_button); waitSync();
	 * 
	 * String deliveryMethod = tocSheet.getRow(row).getCell(7).getStringCellValue();
	 * waitSync(); expwaitVisibility(driver.findElement(By.
	 * xpath("//div[text()='Delivery methods']"))); windowScroll();
	 * clickelement(driver.findElement(By.
	 * xpath("//input[@type='radio']/../..//td[@class='col col-carrier']//span[text()='"
	 * +deliveryMethod+"']"))); expwaitClickable(or.continuetopaymentbutton);
	 * waitSync(); System.out.println("Printing before continue to payment button");
	 * clickelement(or.continuetopaymentbutton); waitSync();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * //Payment screen expwaitVisibility(driver.findElement(By.xpath(
	 * "//div[@class='payment-container']//div[@class='method-selection-container']"
	 * ))); waitSync(); String paymentOption =
	 * tocSheet.getRow(row).getCell(8).getStringCellValue(); //String
	 * paymentOption="Credit Card";
	 * System.out.println("Payment method selected"+paymentOption);
	 * 
	 * if(paymentOption.equalsIgnoreCase("Credit Card")) { //Credit card info
	 * clickelement(or.selectcc); expwaitClickable(or.nameoncard);
	 * inputtext(or.nameoncard,"Test User");
	 * inputtext(or.cardno,"4111111111111111"); Select month = new
	 * Select(driver.findElement(By.xpath("//select[@class='expiration-month']")));
	 * month.selectByVisibleText("5 - May"); Select year = new
	 * Select(driver.findElement(By.xpath("//select[@class='expiration-year']")));
	 * year.selectByVisibleText("2026"); inputtext(or.cvv,"111");
	 * 
	 * //Billing info if(deliveryOption1.equalsIgnoreCase("Pickup")) {
	 * System.out.println("Printing from cc flow1");
	 * inputtext(or.billingadd_companyname, "FedEx");
	 * inputtext(or.billingadd_adress, "7900 Legacy Dr");
	 * inputtext(or.billingadd_adressline2, "Suite 300");
	 * inputtext(or.billingadd_city, "Plano");
	 * 
	 * Select drpState = new
	 * Select(driver.findElement(By.xpath("//select[@id='add-state']")));
	 * drpState.selectByVisibleText("TX"); inputtext(or.billingadd_zipcode,
	 * "75024"); //inputtext(or.shippingaddress_phno, "2149669687");
	 * System.out.println("Printing from cc flow2"); Thread.sleep(10000);
	 * 
	 * 
	 * }
	 * 
	 * waitSync(); windowScroll(); expwaitClickable(or.cc_reviewbutton); waitSync();
	 * System.out.println("Printing from cc flow");
	 * clickelement(or.cc_reviewbutton); //cc_revieworder_Prod
	 * 
	 * 
	 * 
	 * } else {
	 * 
	 * System.out.println("Printing from FedEx Acc flow");
	 * //expwaitClickable(or.fedexacc); waitSync(); clickelement(or.selectfedexacc);
	 * inputtext(or.fedexacc,"653243286"); //653243286 waitSync();
	 * clickelement(or.fedexacc_revieworder);// clicking prod order review button
	 * 
	 * }
	 * 
	 * clickelement(or.terms_condition_checkbox);
	 * clickelement(or.submitorder_button); expwaitVisibility(or.ordergtn);
	 * System.out.println(or.ordergtn.getText());
	 * 
	 * 
	 * 
	 * tearDown();
	 * 
	 * }
	 */

	public void QuickLink_Preminumflow(int row) throws IOException, InterruptedException {

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

		String ProductName = tocSheet.getRow(row).getCell(4).getStringCellValue();
		System.out.println("Selected Product is ::" + ProductName);
		if (ProductName.equalsIgnoreCase("Business Cards")) {

			clickelement(or.Business_Career_Essential_lnk);
			clickelement(or.Business_Cards);
			impwait();

			clickelement(or.PreminumQuicklnk);
			clickelement(or.Preminum_quicklnk_shopnowbtn);
			waitSync();
			String act_PreminumitemName = or.BusinessCards_Primunimitem_cnf_title.getText();
			String exp_PreminumitemName = "Business Cards - Premium";
			Assert.assertEquals(exp_PreminumitemName, act_PreminumitemName);
			impwait();
		} else {
			clickelement(or.Business_Career_Essential_lnk);
			clickelement(or.Note_Cards);
			impwait();
			clickelement(or.PreminumQuicklnk);
			clickelement(or.Preminum_quicklnk_shopnowbtn);
			waitSync();

			String act_PreminumitemName = or.NoteCards_Primunimitem_cnf_title.getText();
			String exp_PreminumitemName = "Note Cards & Thank You Cards - Premium";
			Assert.assertEquals(exp_PreminumitemName, act_PreminumitemName);
			impwait();

		}

		clickelement(or.uploadbutton);
		waitSync();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		System.out.println("Switching to the iframe");
		driver.switchTo().frame(0);

		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		upload.sendKeys("C:\\Users\\4652497\\Test File.pdf");
		waitSync();
		System.out.println("File is Uploaded Successfully");
		waitSync();

		expwaitClickable(or.addtocart);
		clickelement(or.addtocart);
		waitSync();

		clickelement(or.proceedtocheckout);
		waitSync();
		/*
		 * if(ProductName.equalsIgnoreCase("Note Cards")) {
		 * clickelement(or.continueasguest_popup); waitSync(); }
		 */
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
		clickelement(driver.findElement(By.xpath(
				"//input[@type='radio']/../..//td[@class='col col-carrier']//span[text()='" + deliveryMethod + "']")));
		expwaitClickable(or.continuetopaymentbutton);
		waitSync();
		System.out.println("Printing before continue to payment button");
		clickelement(or.continuetopaymentbutton);
		waitSync();

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
			/*
			 * //Billing info if(deliveryOption.equalsIgnoreCase("Pickup")) {
			 * System.out.println("Printing from cc flow1");
			 * inputtext(or.billingadd_companyname, "FedEx");
			 * inputtext(or.billingadd_adress, "7900 Legacy Dr");
			 * inputtext(or.billingadd_adressline2, "Suite 300");
			 * inputtext(or.billingadd_city, "Plano");
			 * 
			 * Select drpState = new
			 * Select(driver.findElement(By.xpath("//select[@id='add-state']")));
			 * drpState.selectByVisibleText("TX"); inputtext(or.billingadd_zipcode,
			 * "75024"); //inputtext(or.shippingaddress_phno, "2149669687");
			 * System.out.println("Printing from cc flow2"); Thread.sleep(10000);
			 * 
			 * 
			 * }
			 */
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
			clickelement(or.fedexacc_revieworder);// clicking prod order review button

		}
		clickelement(or.terms_condition_checkbox);
		clickelement(or.submitorder_button);
		expwaitVisibility(or.ordergtn);
		System.out.println(or.ordergtn.getText());

		tearDown();
	}

	public void QuickLink_RegularFlow(int row) throws InterruptedException, IOException {

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

		clickelement(or.Business_Career_Essential_lnk);

		String deliveryOption = tocSheet.getRow(row).getCell(6).getStringCellValue();
		// String deliveryop="Pickup";
		System.out.println("Delivery type is" + deliveryOption);

		String ProductName = tocSheet.getRow(row).getCell(4).getStringCellValue();
		System.out.println("Selected Product is ::" + ProductName);
		if (ProductName.equalsIgnoreCase("Business Cards")) {
			clickelement(or.Business_Cards);
			impwait();

			clickelement(or.quicklnk_shopnowbtn);
			waitSync();
		} else {
			clickelement(or.Note_Cards);
			impwait();

			clickelement(or.quicklnk_shopnowbtn);
			waitSync();

		}
		clickelement(or.uploadbutton);
		waitSync();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		System.out.println("Switching to the iframe");
		driver.switchTo().frame(0);

		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		upload.sendKeys("C:\\Users\\4652497\\Test File.pdf");
		waitSync();
		System.out.println("File is Uploaded Successfully");
		waitSync();

		clickelement(or.NotCards_productProperties);
		waitSync();
		clickelement(or.NoteCards_PremiumProduct_editbtn);
		waitSync();
		clickelement(or.radiobtn_notecard);
		waitSync();
		expwaitClickable(or.addtocart);
		clickelement(or.addtocart);
		waitSync();
		clickelement(or.proceedtocheckout);
		waitSync();
		clickelement(or.continueasguest_popup);

		System.out.println("Test Case Row num is: " + row);

		// Proceed with Shipping delivery methods

		String deliveryOption1 = tocSheet.getRow(row).getCell(6).getStringCellValue();
		// String deliveryop="Pickup";
		System.out.println("Delivery type is" + deliveryOption);
		waitSync();
		if (deliveryOption1.equalsIgnoreCase("Pickup")) {

			System.out.println("Printing inside Pickup IF contion");
			expwaitVisibility(or.pickupstore_selectionbutton);
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
			// waitSync();
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
			clickelement(or.fedexacc_revieworder);// clicking prod order review button

		}
		clickelement(or.terms_condition_checkbox);
		clickelement(or.submitorder_button);
		expwaitVisibility(or.ordergtn);
		System.out.println(or.ordergtn.getText());

		tearDown();

	}

}
