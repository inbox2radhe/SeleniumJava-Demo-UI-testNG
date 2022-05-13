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

	
	@FindBy(xpath = "//a[text()='User Profile ']")
	public WebElement downarrow;
	@FindBy(xpath = "//a[text()='LogOut']")
	public WebElement logoutbtn;
	
	
	//login
	@FindBy(xpath="//div[@class='fcl-login']//div[@class='customer-name']")
	public WebElement loginlink;
	@FindBy(how = How.CSS, using = "div#login-register-popup a.btn-popup-login span.span-popup-login")
	public WebElement loginbutton;
	@FindBy(how = How.ID, using = "userId")
	public WebElement username;
	@FindBy(how = How.ID, using = "password")
	public WebElement password;
	@FindBy(how = How.ID, using = "login-btn")
	public WebElement submitbtn;
	
	//select product
	//@FindBy(xpath = "(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='Flyers'])[1]")
	@FindBy(xpath = "(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='Postcards'])[1]")
	public WebElement selectProduct;
	@FindBy(css="button#upload-a-file-button")
	public WebElement uploadbutton;
	
	@FindBy(xpath ="//button//span[text()='Add To Cart']")
	public WebElement addtocart;
	@FindBy(xpath ="//button[@title='Go To Checkout']")
	public WebElement proceedtocheckout;
	@FindBy(how =How.ID, using = "checkout-continue-guest")
	public WebElement continueasguest_popup;
	@FindBy(xpath ="//button[@class='anchor-pickup']")
	public WebElement pickupstore_selectionbutton;
	@FindBy(xpath ="//button[@class='anchor-ship']")
	public WebElement shiptoaddress_selectionbutton;
	@FindBy(xpath ="//input[@class='input-text zipcodePickup']")
	public WebElement pickupZipcode; 
	@FindBy(xpath ="//div[@class='search-button-container']")
	public WebElement pickupSearchbutton;
	@FindBy(xpath ="//input[@name='firstname']")
	public WebElement shippingaddress_fname;
	@FindBy(xpath ="//input[@name='lastname']")
	public WebElement shippingaddress_lname;
	@FindBy(xpath ="//input[@name='custom_attributes[email_id]']")
	public WebElement shippingaddress_email;
	@FindBy(xpath ="//input[@name='company']")
	public WebElement shippingaddress_company;
	@FindBy(xpath ="//select[@class='select'] //option[@data-title='United States']")
	public WebElement shippingaddress_country; 
	@FindBy(xpath ="//input[@name='street[0]']")
	public WebElement shippingaddress_address;
	@FindBy(xpath ="//input[@name='city']")
	public WebElement shippingaddress_city;
	@FindBy(xpath ="//select[@name='region_id']")
	public WebElement shippingaddress_state;
	@FindBy(xpath ="//input[@name='postcode']")
	public WebElement shippingaddress_zipcode;
    @FindBy(xpath = "//input[@name='telephone']")
    public WebElement shippingaddress_phno;

	@FindBy(xpath ="(//label[@class='custom-radio-btn pick-up-button'])[1]")
	public WebElement pickuplocation_radiobutton; 
	@FindBy(how = How.ID, using = "contact-fname")
	public WebElement con_fname;
	@FindBy(how =How.ID, using = "contact-lname")
	public WebElement con_lname;
	@FindBy(how = How.ID, using ="contact-number")
	public WebElement con_phoneno;
	@FindBy(how =How.ID, using ="contact-ext")
	public WebElement con_ext;
	@FindBy(how =How.ID, using ="contact-email")
	public WebElement con_email;
	@FindBy(xpath ="(//span[@class='checkmark'])[1]")
	public WebElement alternatepickupperson_checkbox; 
	@FindBy(how =How.ID, using ="alternate-fname")
	public WebElement alternate_fname;
	@FindBy(how =How.ID, using ="alternate-lname")
	public WebElement alternate_lname;
	@FindBy(how =How.ID, using ="alternate-number")
	public WebElement alternate_phoneno;
	@FindBy(how =How.ID, using ="alternate-ext")
	public WebElement alternate_ext;
	@FindBy(how = How.ID, using ="alternate-email")
	public WebElement alternate_mail;

	//Payment Screen
	@FindBy(xpath ="//div[@class='select-credit-card']")
	public WebElement selectcc; 
	@FindBy(xpath ="//div[@class='select-fedex-acc']")
	public WebElement selectfedexacc; 

	//CCFlow
	@FindBy(how =How.ID, using ="name-card")
	public WebElement nameoncard;
	@FindBy(how =How.ID, using ="card-number")
	public WebElement cardno;
	@FindBy(how = How.ID, using ="expiration-month")
	public WebElement cardexpiration_month;
	@FindBy(how =How.ID, using ="expiration-year")
	public WebElement cardexpiration_year;
	@FindBy(how =How.ID, using ="cvv-number")
	public WebElement cvv;
	
	//Fedex Account flow
	@FindBy(how = How.ID, using = "fedex-account-number")
	public WebElement fedexacc;
	@FindBy(xpath = "//button[@class='fedex-account-number-review-button']")
	public WebElement fedexacc_revieworder;
	
	//Billing Address
	@FindBy(how =How.ID, using ="company-name")
	public WebElement billingadd_companyname;
	@FindBy(how =How.ID, using ="address-one")
	public WebElement billingadd_adress;
	@FindBy(how =How.ID, using ="address-two")
	public WebElement billingadd_adressline2;
	@FindBy(how =How.ID, using ="add-city")
	public WebElement billingadd_city;
	@FindBy(how =How.ID, using ="add-zip")
	public WebElement billingadd_zipcode;
	@FindBy(how =How.ID, using="account-number")
	public WebElement ndcAcc;
	@FindBy(xpath ="//button[@class='apply-account']")
	public WebElement ndcAcc_applybutton;
	@FindBy(xpath = "//button[@class='credit-card-review-button']")
	public WebElement cc_reviewbutton;

	

	//Delivery Flow
	@FindBy(how =How.ID, using ="get-Shipping-result")
	public WebElement shipingresult_button;
	@FindBy(how =How.ID, using ="fedExAccountNumber")
	public WebElement fedexshippingaccno;
	@FindBy(how =How.ID, using ="addFedExAccountNumberButton")
	public WebElement fedexshippingaccno_applybutton;
	@FindBy(xpath ="//*[@class='button action continue primary create_quote']")
	public WebElement continuetopaymentbutton;
	@FindBy(xpath ="//button//span[text()='CONTINUE TO PAYMENT']")
	public WebElement continuetopaymentbuttonPickup;
	
	//Delivery Methods(Dynamic xpath)
	@FindBy(xpath ="//input[@type='radio']/../..//td[@class='col col-carrier']//span[text()='FedEx Ground US']")
	public WebElement groundus;
	@FindBy(xpath ="//input[@type='radio']/../..//td[@class='col col-carrier']//span[text()='FedEx Local Delivery']")
	public WebElement fedexlocaldelivery;
	@FindBy(xpath ="//input[@type='radio']/../..//td[@class='col col-carrier']//span[contains(text(),'FedEx Express Saver')]")
	public WebElement fedexexpresssaver;
	@FindBy(xpath ="//input[@type='radio']/../..//td[@class='col col-carrier']//span[text()='FedEx 2 Day']")
	public WebElement fedex2day;
	@FindBy(xpath ="//input[@type='radio']/../..//td[@class='col col-carrier']//span[text()='FedEx Standard Overnight']")
	public WebElement fedexstandardovernight;
	@FindBy(xpath ="//input[@type='radio']/../..//td[@class='col col-carrier']//span[text()='FedEx Priority Overnight']")
	public WebElement fedexpriorityovernight;
	@FindBy(xpath ="//input[@type='radio']/../..//td[@class='col col-carrier']//span[text()='FedEx First Overnight']")
	public WebElement fedexfirstovernight;
	
	
	//Review Order screen
	@FindBy(xpath ="//*[@class='required-entry agreement_enable']")
	public WebElement terms_condition_checkbox;
	@FindBy(xpath ="//span[@class='order-span']")
	public WebElement submitorder_button;

	//OrderConfirmationPage
	@FindBy(xpath= "//div[@class='order_no']")
	public WebElement ordergtn;





	
	
	
	
}
