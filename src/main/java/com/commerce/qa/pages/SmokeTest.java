package com.commerce.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.commerce.qa.base.Baseclass;

public class SmokeTest extends Baseclass{
	public JavascriptExecutor executor;
	
	public SmokeTest()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//place order scenario: in cart page for guest user
	
	@FindBy(xpath="//label[contains(text(),'I agree with the terms of service and I adhere to them unconditionally')]")
	public WebElement terms;
	
	@FindBy(xpath="//div[@class='order-summary-content']/descendant::button[contains(@class,'button-1 checkout-button')]")
	public WebElement Checkoutbutton;
	
	@FindBy(name="termsofservice")
	public WebElement Ternmsofservice;
	
   //guest user selection
	@FindBy(xpath="//div[@class='customer-blocks']/descendant::input[contains(@value,'Checkout as Guest')]")
	public WebElement guest;
	
	
	public void selectterms()
	{
		executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", terms);
        terms.click();		
		
	}
	
	public void clickcheckoutbutton()
	{
		executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",Checkoutbutton);
		
	}
	
	public void clickguestcheckout()
	{
		guest.click();
	}
	
	
	//gues user address details
	
	@FindBy(xpath="//div[@class='enter-address']/descendant::input[@id='BillingNewAddress_FirstName']")
	public WebElement firstname;
	
	@FindBy(xpath="//div[@class='edit-address']/descendant::input[@id='BillingNewAddress_LastName']")
	WebElement lastname;
	
	@FindBy(xpath="//div[@class='edit-address']/descendant::input[@id='BillingNewAddress_Email']")
	WebElement email;
	
	@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")
	public WebElement country;
	
	@FindBy(xpath="//div[@class='page-title']/descendant::h1")
	public WebElement pagetitle;
	
	@FindBy(xpath="//select[@id='BillingNewAddress_StateProvinceId']")
	WebElement State;
	
	@FindBy(xpath="//div[@class='edit-address']/descendant::input[@id='BillingNewAddress_City']")
	WebElement city;
	
	@FindBy(xpath="//div[@class='edit-address']/descendant::input[@id='BillingNewAddress_Address1']")
	WebElement addres1;
	
	@FindBy(xpath="//div[@class='edit-address']/descendant::input[@id='BillingNewAddress_ZipPostalCode']")
	WebElement postcode;
	
	@FindBy(xpath="//div[@class='edit-address']/descendant::input[@id='BillingNewAddress_PhoneNumber']")
	WebElement phonenumber;
	
	@FindBy(xpath="//div[@id='billing-buttons-container']/descendant::input[contains(@class,'button-1 new-address-next-step-button')]")
	WebElement Continue;
	
	@FindBy(xpath="//div[@id='shipping-method-buttons-container']/input[contains(@class,'button-1 shipping-method-next-step-button')]")
	WebElement Continue2;
	
	@FindBy(xpath="//div[@class='section payment-method']/descendant::input[contains(@id,'paymentmethod_1')]")
	WebElement creditcard;
	
	@FindBy(xpath="//div[@id='payment-method-buttons-container']/descendant::input[contains(@class,'button-1 payment-method-next-step-button')]")
	WebElement continue3;
	
	@FindBy(xpath="//div[@class='page checkout-page']/descendant::div[contains(@class,'page-title')]")
	public WebElement paymenttitle;
	public String getpagetitle()
	{
		String text=pagetitle.getText();
		return text;
	}
	
	public void getfirstname(String a)
	{
		firstname.sendKeys(a);
	}
	
	public void getlastname(String b)
	{
		lastname.sendKeys(b);
	}
	
	public void getemail(String c)
	{
		email.sendKeys(c);
	}
	
	public void selectcountrydrop()
	{
		Select drop=new Select(country);
		drop.selectByIndex(1);
		
	}
	public void Selectstate()
	{
		Select drop2=new Select(State);
		drop2.selectByIndex(3);
	}
	
	public void shippingdetails(String c,String a,String p,String n )
	{
		city.sendKeys(c);
		addres1.sendKeys(a);
		postcode.sendKeys(p);
		phonenumber.sendKeys(n);
	}
	public void checkoutnavigation()
	{
		Continue.click();
		Continue2.click();
		creditcard.click();
		continue3.click();
		
	}
	public String getpaymenttitle()
	{
		String text=paymenttitle.getText();
		return text;
	}
	
	//payment details
	
	@FindBy(xpath="//div[@id='checkout-step-payment-info']/descendant::input[@id='CardholderName']")
	WebElement cardname;
	
	@FindBy(xpath="//div[@id='checkout-step-payment-info']/descendant::input[@id='CardNumber']")
	WebElement Cardnumber;
	
	@FindBy(xpath="//select[@id='ExpireMonth']")
	WebElement expmonth;
	
	@FindBy(xpath="//div[@id='checkout-step-payment-info']/descendant::input[@id='CardCode']")
	WebElement cardcvv;
	
	@FindBy(xpath="//div[@id='payment-info-buttons-container']/descendant::input[@class='button-1 payment-info-next-step-button']")
	WebElement continue4;
	
	@FindBy(xpath="//div[@id='confirm-order-buttons-container']/descendant::input[@class='button-1 confirm-order-next-step-button']")
	WebElement placeorder;
	
	@FindBy(xpath="//div[@class='section order-completed']/descendant::div[@class='title']")
	WebElement ordersuccess;
	
	@FindBy(xpath="//div[@class='details']/descendant::div[@class='order-number']")
	WebElement orderno;
	public void Paymentdetails(String name,String number,String code)
	{
		cardname.sendKeys(name);
		Cardnumber.sendKeys(number);
		Select s1=new Select(expmonth);
		s1.selectByIndex(9);
		cardcvv.sendKeys(code);
	}
	public void placeorder()
	{
		continue4.click();
		placeorder.click();
		
		
		
	}
	public String ordersuccess()
	{
		String success=ordersuccess.getText();
		String text=orderno.getText();
		System.out.println(text);
		return success;
	}
	
	
	
}
