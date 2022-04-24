/* Name: ExcelUtils 
 * Description: This script is to read the data's from TestData and Config file
 * Developed By: Chyne Chandran
 * Automation Architect: Jayant Naikwade
 * Input = Configurable Excel File  
 * Developed Date: 
 * Updated Date: 
 * Updated Reason:
 */
package com.NonKeyword_FutureReadyFramework.automation.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static String testCellValue;
	public static String testDataSheetPath;
	public static String testConfigSheetPath;
	public static String userNameCellValue;
	public static String passwordCellValue;
	public static String urlCellValue;
	public static String browserCellValue;

	// ******READING CLASS WITH FLAG STATUS "Y"*****
	public static List<String> excelReadTestCase() throws IOException {

		String path = System.getProperty("user.dir");
		testDataSheetPath = (path
				+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\data\\TestData.xlsx");

		List<String> list = new ArrayList<String>();
		File f = new File(testDataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet tocSheet = wb.getSheet("TOC");
		int numberOfRows = tocSheet.getPhysicalNumberOfRows();
		for (int i = 1; i < numberOfRows; i++) {

			Row datarow = tocSheet.getRow(i);
			Cell flagstatuscell = datarow.getCell(2);
			String flagstatuscellValuestr = flagstatuscell.getStringCellValue();

			if (flagstatuscellValuestr.equalsIgnoreCase("Y")) {
				Cell descriptionCell = datarow.getCell(1);
				String descriptionCellValuestr = descriptionCell.getStringCellValue();

				if (descriptionCellValuestr.equalsIgnoreCase("Sanity")) {
					Sheet sanitySheet = wb.getSheet("Sanity");
					int sanityNumberOfRows = sanitySheet.getPhysicalNumberOfRows();
					String packageCellValue = sanitySheet.getRow(0).getCell(2).getStringCellValue();
					for (int j = 2; j < sanityNumberOfRows; j++) {
						Row sanitySheetrow = sanitySheet.getRow(j);
						Cell sanityflagstatuscell = sanitySheetrow.getCell(2);
						String sanityflagstatuscellValuestr = sanityflagstatuscell.getStringCellValue();
						if (sanityflagstatuscellValuestr.equalsIgnoreCase("Y")) {
							Cell sanityTestNameCell = sanitySheetrow.getCell(1);
							String classCellValue = sanityTestNameCell.getStringCellValue();
							testCellValue = packageCellValue + classCellValue;

						}
					}

				}

				else if (descriptionCellValuestr.equalsIgnoreCase("Regression")) {
					Sheet regressionSheet = wb.getSheet("Regression");
					int regressionNumberOfRows = regressionSheet.getPhysicalNumberOfRows();

					String packageCellValue = regressionSheet.getRow(0).getCell(2).getStringCellValue();
					for (int k = 2; k < regressionNumberOfRows; k++) {
						Row regressionSheetrow = regressionSheet.getRow(k);
						Cell regressionflagstatuscell = regressionSheetrow.getCell(2);
						String regressionflagstatuscellValuestr = regressionflagstatuscell.getStringCellValue();
						if (regressionflagstatuscellValuestr.equalsIgnoreCase("Y")) {
							Cell regressionTestNameCell = regressionSheetrow.getCell(1);
							String classCellValue = regressionTestNameCell.getStringCellValue();
							testCellValue = packageCellValue + classCellValue;

						}

					}
				}

			}

			list.add(testCellValue);

		}

		return list;

	}

	// ********READING BROWSER VALUE**********
	public static String excelreadBrowser() throws IOException {

		testConfigSheetPath = (System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Config.xlsx");
		File f = new File(testConfigSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet credsheet = wb.getSheet("configdata");
		Row datarow = credsheet.getRow(4);
		Cell datacell = datarow.getCell(2);
		int cellType = datacell.getCellType();

		if (cellType == 1) {
			browserCellValue = datacell.getStringCellValue();
		} else {
			double numericCellValue = datacell.getNumericCellValue();
			int numericCellValueint = (int) numericCellValue;
			browserCellValue = Integer.toString(numericCellValueint);
		}

		return browserCellValue;
	}

	// *********************************READING URL
	// VALUE***************************************************
	public static String excelreadURL() throws IOException {

		testConfigSheetPath = (System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Config.xlsx");
		File f = new File(testConfigSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet credsheet = wb.getSheet("configdata");
		Row datarow = credsheet.getRow(1);
		Cell datacell = datarow.getCell(2);
		int cellType = datacell.getCellType();

		if (cellType == 1) {
			urlCellValue = datacell.getStringCellValue();
		} else {
			double numericCellValue = datacell.getNumericCellValue();
			int numericCellValueint = (int) numericCellValue;
			urlCellValue = Integer.toString(numericCellValueint);
		}

		return urlCellValue;
	}

	// ********READING USERNAME VALUE********
	public static String excelreadUserName() throws IOException {

		testConfigSheetPath = (System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Config.xlsx");
		File f = new File(testConfigSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet credsheet = wb.getSheet("configdata");
		Row datarow = credsheet.getRow(2);
		Cell datacell = datarow.getCell(2);
		int cellType = datacell.getCellType();

		if (cellType == 1) {
			userNameCellValue = datacell.getStringCellValue();
		} else {
			double numericCellValue = datacell.getNumericCellValue();
			int numericCellValueint = (int) numericCellValue;
			userNameCellValue = Integer.toString(numericCellValueint);
		}

		return userNameCellValue;
	}

//*********************************READING PASSWORD VALUE***************************************************

	public static String excelreadPassword() throws IOException {

		testConfigSheetPath = (System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\NonKeyword_FutureReadyFramework\\automation\\config\\Config.xlsx");
		File f = new File(testConfigSheetPath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet credsheet = wb.getSheet("configdata");
		Row datarow = credsheet.getRow(3);
		Cell datacell = datarow.getCell(2);
		int cellType = datacell.getCellType();

		if (cellType == 0) {
			double numericCellValue = datacell.getNumericCellValue();
			int numericCellValueint = (int) numericCellValue;
			passwordCellValue = Integer.toString(numericCellValueint);
		} else if (cellType == 1) {
			passwordCellValue = datacell.getStringCellValue();
		} else {
			System.out.println("Formula: " + datacell.getCellFormula());
			int cachedFormulaResultType = datacell.getCachedFormulaResultType();
			if (cachedFormulaResultType == 1) {
				passwordCellValue = datacell.getStringCellValue();
			} else {
				double numericCellValue = datacell.getNumericCellValue();
				int numericCellValueint = (int) numericCellValue;
				passwordCellValue = Integer.toString(numericCellValueint);
			}
		}

		return passwordCellValue;

	}
}
