package com.commerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commerce.qa.base.Baseclass;

public class Addresspage extends Baseclass{
	public Addresspage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//guest user address details
	
	//guest user selection
		@FindBy(xpath="//div[@class='customer-blocks']/descendant::input[contains(@value,'Checkout as Guest')]")
		public WebElement guest;
	
	
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
		public WebElement city;
		
		@FindBy(xpath="//div[@class='edit-address']/descendant::input[@id='BillingNewAddress_Address1']")
		WebElement addres1;
		
		@FindBy(xpath="//div[@class='edit-address']/descendant::input[@id='BillingNewAddress_ZipPostalCode']")
		WebElement postcode;
		
		@FindBy(xpath="//div[@class='edit-address']/descendant::input[@id='BillingNewAddress_PhoneNumber']")
		WebElement phonenumber;
		
		@FindBy(xpath="//div[@id='billing-buttons-container']/descendant::input[contains(@class,'button-1 new-address-next-step-button')]")
		WebElement Continue;
		
		public void getAddressdetails(String fname,String lname,String Email,String City,String ad1,String pcode,String pno)
		{
			firstname.sendKeys(fname);
			lastname.sendKeys(lname);
			email.sendKeys(Email);
			city.sendKeys(City);
			addres1.sendKeys(ad1);
			postcode.sendKeys(pcode);
			phonenumber.sendKeys(pno);
			Continue.click();
			
		}

}
