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

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ObjectRepository_LoginPage {
	
	List<WebElement> shippingMethods;

	
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
	@FindBy(how =How.ID, using="search")
	public WebElement searchbtn;
	
	@FindBy(xpath="//button[@class='action search p-0']")
	public WebElement clicksearch;
	
	@FindBy(xpath="//*[@id='product-item-info_13685']/a/span/span/img")
	public WebElement clickflyers;
	
	@FindBy(xpath = "(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='Flyers'])[1]")
	public WebElement selectflyers;
	@FindBy(xpath = "(//div[@class='products-grid grid']//strong[@class='product-item-name']//a[@title='Postcards'])[1]")
	public WebElement selectpostCards;
	@FindBy(css="button#upload-a-file-button")
	public WebElement uploadbutton;
	
	@FindBy(xpath ="//button//span[text()='Add To Cart']")
	public WebElement addtocart;
	@FindBy(xpath ="(//button[@title='Go To Checkout'])[2]")
    public WebElement proceedtocheckout;
	@FindBy(how =How.ID, using = "checkout-continue-guest")// //*[@id="checkout-continue-guest"]/a
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
	@FindBy(xpath ="//div[@class='select-credit-card pointer']") ////*[@id="step_code"]/div[3]/div[1]/div[1]
	public WebElement selectcc; 
	//@FindBy(xpath ="//div[@class='select-fedex-acc']")//Stage FedEx acc xpath
	@FindBy(xpath="//div[@class='select-fedex-acc pointer']") //Prod FedEx acc xpath
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
	//@FindBy(xpath="//button[@class='credit-card-review-button']")
	//public WebElement cc_revieworder_Prod;
	
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
//	@FindBy(how =How.ID, using="account-number")
//	public WebElement ndcAcc;
//	@FindBy(xpath ="//button[@class='apply-account']")
//	public WebElement ndcAcc_applybutton;
	@FindBy(xpath = "//button[@class='credit-card-review-button']")// credit-card-review-button
	 //@FindBy(xpath="//button[text()='REVIEW ORDER'][1]")
	 public WebElement cc_reviewbutton;

	// update Order flow
	
		@FindBy(how =How.NAME, using="update_cart_action")
		public WebElement updateOdrbtn;
		@FindBy(xpath="//*[@class='action action-edit']")
		public WebElement editOrderbtn;
		@FindBy(xpath="//div[@class='input-group']")
		public WebElement selectqtybtn;
		//@FindBy(xpath="//*[@class='price-footer__cart price-footer__add-to-cart ng-star-inserted']")//Save Changes
		@FindBy(xpath ="//button//span[text()='Save Changes']")
		public WebElement btnSaveChanges;
		//@FindBy(xpath="//div[@id='checkout-cart-validationmessages-message-success']")
		@FindBy(xpath="//div[@class='message message-success success']")
		public WebElement validateCartUpdatedmsg;

	//Delivery Flow
	@FindBy(how =How.ID, using ="get-Shipping-result")
	public WebElement shipingresult_button;
	@FindBy(how =How.ID, using ="fedExAccountNumber")
	public WebElement fedexshippingaccno;
	@FindBy(how =How.ID, using ="addFedExAccountNumberButton")
	public WebElement fedexshippingaccno_applybutton;
	@FindBy(xpath ="//*[@class='place-pickup-order']")////*[@id="shipping-method-buttons-container"]/div/button
	public WebElement pickupFlowcontinueTopaybtn;
	@FindBy(xpath="//button[@class='button action continue primary create_quote']") //continue to payment Prod
	public WebElement continuetopaymentbutton;
	
	//Delivery Methods
	@FindBy(xpath="//div[text()='Delivery methods']")
	public WebElement deliveryMethods;

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
	
	public List<WebElement> shipppingOptions(){
		
		shippingMethods= new ArrayList<WebElement>();
		
		shippingMethods.add(groundus);
		shippingMethods.add(fedexlocaldelivery);
		shippingMethods.add(fedexexpresssaver);
		shippingMethods.add(fedex2day);
		shippingMethods.add(fedexstandardovernight);
		shippingMethods.add(fedexpriorityovernight);
		shippingMethods.add(fedexfirstovernight);
	
		return shippingMethods;
		
	}
	
	
	//Review Order screen
	@FindBy(xpath ="//*[@class='required-entry agreement_enable']")
	public WebElement terms_condition_checkbox;
	@FindBy(xpath ="//span[@class='order-span']")
	public WebElement submitorder_button;

	//OrderConfirmationPage
	@FindBy(xpath= "//div[@class='order_no']")
	public WebElement ordergtn;
	
	
	//delete button from cart
	@FindBy(xpath="(//div[@class='cart table-wrapper']//tr[@class='item-actions']//a[@class='action action-delete'])[1]")
	public WebElement firstitemDeletebtn;
	@FindBy(xpath="(//div[@class='cart table-wrapper']//tr[@class='item-actions']//a[@class='action action-delete'])[2]")
	public WebElement seconditemDeletebtn;
	@FindBy(xpath="//div[@class='cart-empty']//p")
	public WebElement cartmsg;
	@FindBy(xpath="//div[@class='cart-empty']//a")
	public WebElement emptyCart_clickShoppinglnk;
	//clear cart button
	@FindBy(xpath="//button[@id='empty_cart_button']")
	public WebElement clrCartbtn;
	@FindBy(xpath="//button[@class='clear-action-primary clear-action-accept']")
	public WebElement clearShoppingCart_Yesbtn;

	
	//Upload file from Index page and use banner upload button
			//@FindBy(xpath="//a[@class='pagebuilder-button-primary']")
	@FindBy(xpath="//div[@class='pagebuilder-poster-content']//button[contains(text(),'UPLOAD & PRINT')]")
	public WebElement uploadbtnFromBannerPage;
	
	@FindBy(xpath="(//div[@class='search results']//li[@class='item product product-item']//strong[@class='product name product-item-name']//a[contains(text(),'Flyers')])[1]")
	public WebElement selectFlyersUsingSearch;

	@FindBy (xpath="//div[@class='products wrapper retail-session grid products-grid']//div[@class='product-item-info']//div[@class='product details product-item-details']//strong[@class='product name product-item-name']//a[contains(text(),'Postcards')]")
	public WebElement selectPostcardsUsingSearch;
	//NDC Account object repo
	@FindBy(xpath = "//div[@class='fedex-acc-text']")
	public WebElement ndcAccLabel;
	@FindBy(xpath = "//label[@class='fedex-account-checkbox']//span")
	public WebElement ndcAccCheckbox;
	@FindBy(xpath = "//input[@id='account-number']")
	public WebElement ndcAcc;
	@FindBy(xpath ="//button[@class='apply-account']")
	public WebElement ndcAcc_applybutton;
	@FindBy(xpath = "//a[@class='fedex-acc-remove-button']")
	public WebElement ndcAcc_Remove;
	
	//Canva flow

	@FindBy(xpath="//div[@class='product-info-main mt-95-lg']//a[@class='link canva-modal-link']")
	public WebElement canvaflowlnk;
	@FindBy(xpath="//div[@class='modal-body-content']//button[@class='btn-primary btn-start lh-24 start-design']")
	public WebElement startdesign_btn;
	@FindBy(xpath="//footer[@class='modal-footer']//button[@class='continue-btn']//span")
	public WebElement contiueAsgustInCanvaFlow;
	@FindBy(xpath="(//div[@class='BE2rWg'])[1]")
	public WebElement selectCanvatmplate;
	@FindBy(xpath="//div[@class='M9tVdQ UAeX5g o3oPVg CXbsQw']//div[@class='CXbsQw']")
	public WebElement canvaPublishbtn;
	@FindBy(xpath="//div[@class='Q0yqLQ _93Ozvg']//button[@class='_1QoxDw Qkd66A tYI0Vw o4TrkA zKTE_w Qkd66A tYI0Vw lsXp-w ubW6qw cwOZMg zQlusQ uRvRjQ sRJKqA']//span")
	public WebElement continute_btn_after_canvaPublish1;
	@FindBy(xpath="//div[@class='Q0yqLQ _93Ozvg']//button[@class='_1QoxDw Qkd66A tYI0Vw o4TrkA zKTE_w Qkd66A tYI0Vw lsXp-w ubW6qw cwOZMg zQlusQ uRvRjQ sRJKqA']//span")
	public WebElement continute_btn_after_canvaPublish2;
	@FindBy(xpath="//div[@class='Q0yqLQ _93Ozvg']//button[@class='_1QoxDw Qkd66A tYI0Vw o4TrkA zKTE_w Qkd66A tYI0Vw lsXp-w ubW6qw cwOZMg zQlusQ uRvRjQ sRJKqA']//span")
	public WebElement continute_btn_after_canvaPublish3;

	// Business- Cards Preminum flow

    @FindBy(xpath="(//div[@class='products wrapper retail-session grid products-grid']//li[@class='item product product-item'])[2]")
    public WebElement businessCards_preminum;
    @FindBy(xpath="//div[@class='product media sticky']//span[contains(text(),'Business Cards - Premium')]")
    public WebElement getProductTitle;

    //Presentations (PPT) flow

    @FindBy(xpath="//div[@class='product details product-item-details']//a[@class='product-item-link']")
    public WebElement selectPPT;
    @FindBy(xpath="//div[@class='product media sticky']//span[contains(text(),'Presentations')]")
    public WebElement getPPTtitle;
    @FindBy(xpath="(//div[@class='card-body'])[2]//edl-radio-button[@class='radio']")
    public WebElement select2PageHandouts;
    @FindBy(xpath="//button[@class='app-convert-ppt-settings__element-next-button']")
    public WebElement clickNxt;


    //Outdoor Banners flow

    @FindBy(xpath="//li[@class='item product product-item']//a[contains(text(),'Outdoor Banners')]")
    public WebElement selectOutdoorBanner;
    @FindBy(xpath="//div[@class='product media sticky']//span[contains(text(),'Outdoor Banners')]")
    public WebElement getoutdoorBannertitle;
    
    //Mini Cart flow

//    @FindBy(xpath="//div[@class='products wrapper retail-session grid products-grid']//a[contains(text(),'Resumes')]")
//    public WebElement selectResumes;
//
//    @FindBy(xpath="//div[@class='products wrapper retail-session grid products-grid']//a[contains(text(),'Manuals')]")
//    public WebElement selectManuals;
//
//    @FindBy(xpath="(//div[@class='retail-minicart'])[1]")
//    public WebElement miniCart;
//
//    @FindBy(xpath="//button[@id='top-cart-btn-checkout']")
//    public WebElement mimiCart_proceedTochkoutbtn;
    
    @FindBy(xpath="//div[@class='products wrapper retail-session grid products-grid']//a[contains(text(),'Resumes')]")
    public WebElement selectResumes;
    @FindBy(xpath="//div[@class='products wrapper retail-session grid products-grid']//a[contains(text(),'Manuals')]")
    public WebElement selectManuals;
    @FindBy(xpath="(//div[@class='retail-minicart'])[1]")
    public WebElement miniCart;
    @FindBy(xpath="//button[@id='top-cart-btn-checkout']")
    public WebElement mimiCart_proceedTochkoutbtn;

    //Edit MiniCart Flow
    @FindBy(xpath="//div[@class='actions']//a[@class='action viewcart']//span")
    public WebElement view_editCart_lnk;
    @FindBy(xpath="//a[@title='Edit item']")
    public WebElement MiniCart_Editbtn;
    @FindBy(xpath="//div[@class='input-number']//div[@class='input-number__input-content'])[2]")
    public WebElement MiniCart_updateQtyBox;
    @FindBy(xpath="(//div[@class='input-number']//div[@class='input-number__input-content'])[2]//input[@class='input-number__input ng-untouched ng-pristine ng-valid']")
    public WebElement MiniCart_editqty;
    @FindBy(xpath="//button[@class='price-footer__cart price-footer__add-to-cart ng-star-inserted']//span")
    public WebElement savebtnAfterEdit;
    @FindBy(xpath="//div[@class='message message-success success']")
    public WebElement successmsg_afterCartEdit;
    @FindBy(xpath="(//div[@class='product actions'])[1]//a[@class='action delete']")
    public WebElement MiniCart_DeleteFirstCartItem;
    @FindBy(xpath="(//div[@class='product actions'])[2]//a[@class='action delete']")
    public WebElement MiniCart_DeleteSecondCartItem;
    @FindBy(xpath="//button[@class='clear-action-primary clear-action-accept']")
    public WebElement MiniCart_acceptbtn;
    @FindBy(xpath="(//div[@class='cart-empty']//p)[1]")
    public WebElement emptyMiniCartmsg;
    
  //Product Category- Quick link flow

    @FindBy(xpath="//div[@class='menu horizontal centre ']//li[@class='menu-dropdown-icon dropdown category-item nav-1828 custom_mega_menu']")
    public WebElement Business_Career_Essential_lnk;
    @FindBy(xpath="(//strong[@class='product-item-name static-link']//a[@class='product-item-link'])[1]")
    public WebElement Business_Cards;
    @FindBy(xpath="(//div[@class='block widget block-new-products-names']//a[@class='product-item-link'])[12]")
    public WebElement Note_Cards;
    @FindBy(xpath="(//div[@class='shopnow-product-pricing-container']//a[contains(text(),'SHOP NOW')])[1]")
    public WebElement quicklnk_shopnowbtn;
    @FindBy(xpath="(//div[@class='shopnow-product-pricing-container']//a[contains(text(),'SHOP NOW')])[2]")
    public WebElement Preminum_quicklnk_shopnowbtn;
    @FindBy(xpath="//h1[@class='page-title']//span[contains(text(),'Business Cards - Premium')]")
    public WebElement BusinessCards_Primunimitem_cnf_title;
    @FindBy(xpath="//h1[@class='page-title']//span[contains(text(),'Note Cards & Thank You Cards - Premium')]")
    public WebElement NoteCards_Primunimitem_cnf_title;
    @FindBy(xpath="(//a[@class='tab-title ui-tabs-anchor']//span[@class='tab-title'])[2]")
    public WebElement PreminumQuicklnk;
    @FindBy(xpath="//edl-accordion[@id='Product Print Properties']")
    public WebElement NotCards_productProperties;
    @FindBy(xpath="(//button[@class='accordion-list__button ng-tns-c58-9 accordion-list__button--no-icon ng-star-inserted'])[1]")
    public WebElement NoteCards_PremiumProduct_editbtn;
    @FindBy(xpath="(//label[@class='radio-button-layout no-select'])[2]//div[@class='radio-container']")
    public WebElement radiobtn_notecard;
    @FindBy(xpath="//strong[@class='product name product-item-name']//a[contains(text(),'Corrugated Plastic Sign')]")
    public WebElement select_Corrugated_Plastic_Sign;
    @FindBy(xpath="//strong[@class='product name product-item-name']//a[contains(text(),'Metal Sign')]")
    public WebElement Select_Metal_Sign;
    
    //Yard Sign
   @FindBy(xpath="//strong[@class='product name product-item-name']//a[contains(text(),'Yard Sign')]")
   public WebElement select_Yard_sign;
 
   //FCL Checkout Login popup
 	@FindBy(how = How.CSS, using = "div#fcl-checkout-login-popup a.btn-popup-login span.span-popup-login")
 	public WebElement checkout_Loginbutton;
 	@FindBy(xpath = "//div[@id='fcl-checkout-login-popup']//span[@class='span-popup-create-user']")
 	public WebElement checkout_CreateUserId;
 	
 	
 	//change to pickup to shipping and vice versa
 	@FindBy(xpath = "//a[@class='checkout-sub' and contains(text(),'CHANGE TO SHIPPING')]")
 	public WebElement changeToShipping;
 	@FindBy(xpath = "//a[@class='checkout-sub' and contains(text(),'CHANGE TO PICK UP IN STORE')]")
 	public WebElement changeToPickup;


 	//Configurator Flow webelements
	
 		//Product Properties webelements
 			//@FindBy(xpath="//*[@id='Product Print Properties']/div[1]/h3")
 	@FindBy(xpath="//edl-accordion[@id='Product Print Properties']/div[1]/h3")
	public WebElement ProductPrint_properties;
	
	@FindBy(xpath="(//button[contains(text(),'Edit')])[2]")
	public WebElement postCard_ProductPrint_properties_Size;
	@FindBy(xpath="(//edl-radio-group[@Name='choicesRdGrp'])[2]//label[@class='radio-button-layout no-select']//div[@class='inner-circle']")
	public WebElement postCard_ProductPrint_properties_size_4x5;
	@FindBy(xpath="//button[@class='price-footer__cart price-footer__add-to-cart ng-star-inserted']")
	public WebElement btn_SaveChanges;
	@FindBy(xpath="//p[@class='price-footer__total-number ng-star-inserted']")
	public WebElement price_afterpostCard_ProductPrint_propertiesUpdate;
	@FindBy(xpath="//td[@class='col price']//span")
	public WebElement price_afterpostCard_ProductPrint_propertiesUpdate_Incart;
	
	//Manuals configurator webelement
	@FindBy(xpath="(//button[contains(text(),'Edit')])[1]")
	public WebElement btn_Manual_Size_Edit;
	
	@FindBy(xpath="(//label[@class='radio-button-layout no-select'])[1]")
	public WebElement editSize_Manual_8half_and_11;
	@FindBy(xpath="(//label[@class='radio-button-layout no-select'])[2]")
	public WebElement editSize_Manual_8half_and_14;
	@FindBy(xpath="(//label[@class='radio-button-layout no-select'])[3]")
	public WebElement editSize_Manual_11_and_17;
	
	@FindBy(xpath="//button[contains(text(),' Close ')]")
	public WebElement ProductPrint_properties_Size_Savebtn;
	
	@FindBy(xpath="(//button[contains(text(),'Edit')])[2]")
	public WebElement Manuals_Edit_Paperbtn;

	@FindBy(xpath="(//button[contains(text(),'Edit')])[4]")
	public WebElement Manuals_Edit_sides_btn;
	@FindBy(xpath="(//button[contains(text(),'Edit')])[5]")
	public WebElement Manuals_Edit_orientation_btn;
	@FindBy(xpath="(//button[contains(text(),'Edit')])[6]")
	public WebElement Manuals_Edit_printPerpage_btn;
	
	@FindBy(xpath="(//div[@class='accordion-list__choicegroup-print-label'])[1]")
	public WebElement Manuals_printProperties_Paper_StdWhitePaperbtn;
	@FindBy(xpath="(//div[@class='accordion-list__choicegroup-print-label'])[2]")
	public WebElement Manuals_printProperties_Paper_proWhitePaperbtn;
		@FindBy(xpath="(//div[@class='choice__label-text'])[10]")
		public WebElement Manuals_printProperties_Paper_proWhitePaperbtn_leaser60lb;
		@FindBy(xpath="(//div[@class='choice__label-text'])[11]")
		public WebElement Manuals_printProperties_Paper_proWhitePaperbtn_leaser80lb;
		@FindBy(xpath="(//div[@class='choice__label-text'])[12]")
		public WebElement Manuals_printProperties_Paper_proWhitePaperbtn_leaser32lb;
		
	@FindBy(xpath="(//div[@class='accordion-list__choicegroup-print-label'])[3]")
	public WebElement Manuals_printProperties_Paper_cardStockSpeciality_btn;
		@FindBy(xpath="//div[contains(text(),'Water Resistant (7.7 Mil)')]")
		public WebElement Manuals_printProperties_Paper_cardStockSpeciality_btn_waterResistant_btn;
		@FindBy(xpath="//div[@class='choice__label-content']//div[contains(text(),'Ivory (65 lb.)')]")
		public WebElement Manuals_printProperties_Paper_cardStockSpeciality_btn_Ivory65LB_btn;
		@FindBy(xpath="(//button[@class='accordion-list__button ng-tns-c11-3 accordion-list__button--no-icon ng-star-inserted'])[2]")
		public WebElement Manuals_printProperties_Paper_Close_btn;
		
	@FindBy(xpath="(//div[@class='accordion-list__choicegroup-print-label'])[4]")
	public WebElement Manuals_printProperties_Paper_StdColorPaperbtn;
		@FindBy(xpath="(//div[@class='radio-button-container']//label[@class='radio-button-layout no-select'])[33]")
		public WebElement Manuals_printProperties_Paper_StdColorPaperbtn_Ivory24LB_btn;//input[@id='edl-radio-32']
		
	@FindBy(xpath="(//div[@class='accordion-list__choicegroup-print-label'])[5]")
	public WebElement Manuals_printProperties_Paper_proColorPaperbtn;
	
	
	
	
	@FindBy(xpath="(//label[@class='radio-button-layout no-select'])[4]")
	public WebElement Manuals_StdPaper_Laser_24lb_radiobtn;
	@FindBy(xpath="(//label[@class='radio-button-layout no-select'])[5]")
	public WebElement Manuals_StdPaper_Laser_32lb_radiobtn;
	@FindBy(xpath="(//label[@class='radio-button-layout no-select'])[6]")
	public WebElement Manuals_StdPaper_Recycled_20lb_radiobtn;
	
	
	
	
	//Manuals Product Print properties Color Black/White webelements
	@FindBy(xpath="(//button[contains(text(),'Edit')])[3]")
	public WebElement Manuals_Edit_colorBW_btn;
	@FindBy(xpath="(//div[contains(text(),'Black & White')])[1]")////input[@id='edl-radio-52'] (//div[contains(text(),'Black & White')])[2]
	public WebElement Manuals_Edit_colorBW_BW_radiobtn;
	@FindBy(xpath="(//div[contains(text(),'Black & White')])[2]")
	public WebElement Manuals_Edit_colorBW_BW_FirstPageColor_radiobtn;
	@FindBy(xpath="//button[contains(text(),' Close ')]")
	public WebElement Manuals_Edit_colorBW_BW_closebtn;
	
	//Manuals Product Print properties Sides webelements
	@FindBy(xpath="//edl-accordion[@id='Sides']//div[@class='accordion-list__text accordion-list__text--enabled']")
	public WebElement Manuals_Edit_Sides_btn;
	@FindBy(xpath="//div[contains(text(),('Double-Sided'))]")
	public WebElement Manuals_Edit_Sides_doubleSided_radiobtn; 
	@FindBy(xpath="//button[contains(text(),(' Close '))]")
	public WebElement Manuals_Edit_Sides_Close_btn;
	
	
	//Manuals Product Print properties Orientation webelements
	
	@FindBy(xpath="//edl-accordion[@id='Orientation']//div[@class='accordion-list__text accordion-list__text--enabled']")
	public WebElement Manuals_Edit_orientation_btn1;
	@FindBy(xpath="(//div[@class='radio-label'])[58]")
	public WebElement Manuals_Edit_orientation_btn1_Landscape_radiobtn;
	
	
	
	//Configurator Binding and Finishing webelements
	
 	@FindBy(xpath="//edl-accordion[@id='Binding & Finishing']/div[1]/h3") //"//*[@id='Binding & Finishing']/div[1]/h3"
 	public WebElement Binding_and_Finishing;
 	
 	//Binding & Stapling
	@FindBy(xpath="//edl-accordion[@id='Binding & Stapling']//button[contains(text(),' Add ')]")
  	public WebElement Binding_and_Finishing_binding_stapling_addbtn;
	@FindBy(xpath="(//edl-radio-button[@class='choice__radio-button']/label/div/div[@class='inner-circle'])[17]")
	public WebElement Binding_and_Finishing_binding_stapling_StapleRadiobtn;
	@FindBy(xpath="//input[@id='custom-dropdown-39']")
	public WebElement Binding_and_Finishing_binding_stapling_drpdown;
 	@FindBy(xpath="//button[contains(text(),' Close ')]")
 	public WebElement Binding_and_Finishing_binding_stapling_CLOSEbtn;
	
	//Binding & FInishing -> Cutting web elements
 	@FindBy(xpath="//edl-accordion[@id='Cutting']//button[contains(text(),' Add ')]")
 	public WebElement Binding_and_Finishing_binding_Cutting_addbtn;
 	@FindBy(xpath="(//label[@class='radio-button-layout no-select'])[66]")
 	public WebElement Binding_and_Finishing_binding_Cutting_HalfVerticle;
 	@FindBy(xpath="//button[contains(text(),' Close ')]")
 	public WebElement Binding_and_Finishing_binding_Cutting_CLOSEbtn;
 	
 	
 	//Binding & FInishing -> Cutting web elements
 	@FindBy(xpath="//edl-accordion[@id='Lamination']//button[contains(text(),' Add ')]")
 	public WebElement Binding_and_Finishing_binding_lamination_addbtn;
 	@FindBy(xpath="//div[contains(text(),'Glossy with No Border')]")
 	public WebElement Binding_and_Finishing_binding_lamination_noGLossyBorder;
 	@FindBy(xpath="//button[contains(text(),' Close ')]")
 	public WebElement Binding_and_Finishing_binding_lamination_CLOSEbtn;
 	
 	
 	//Advanced Options
 	//Tabs and BlankSheet
 	
 	@FindBy(xpath="//edl-accordion[@id='Tabs & Blank Sheets']//h3")
 	public WebElement advOptions_tabs_blankSheets;
 	@FindBy(xpath="//edl-accordion[@id='Blank Sheets']//button[contains(text(),' Add ')]")
 	public WebElement advOptions_tabs_blankSheets_addbtn;
 	@FindBy(xpath="(//div[@class='input-group'])[9]")
 	public WebElement advOptions_tabs_blankSheets_paperType_drpdown;
	@FindBy(xpath="//button[contains(text(),' Close ')]")
 	public WebElement advOptions_tabs_blankSheets_CLOSEbtn;
	
	
}
