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
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.NonKeyword_FutureReadyFramework.automation.excelReader.ExcelUtils;

 import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void launchBrowser() throws IOException {
		String browsername = ExcelUtils.excelreadBrowser();
		if (browsername.equalsIgnoreCase("CHROME")) {
			try {
				WebDriverManager.chromedriver().setup();
			   // System.getProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromeDriver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
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
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	public void expwaitVisibility(WebElement webelementref) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(webelementref));
	}

	public void expwaitClickable(WebElement webelementref) {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(webelementref));
	}

}
