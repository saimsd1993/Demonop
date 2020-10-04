package com.commerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.commerce.qa.base.Baseclass;



public class Cartpage extends Baseclass{
	
	public Cartpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Cart page OR
	
	@FindBy(xpath="//input[@id='discountcouponcode']")
	WebElement Couponcode;
	
	@FindBy(xpath="//input[@id='applydiscountcouponcode']")
	WebElement applycoupon;
	
	@FindBy(xpath="//div[@class='cart-collaterals']/descendant::div[contains(@class,'message-success')]")
	WebElement couponsuccess1;
	
	@FindBy(xpath="//div[@class='cart-collaterals']/descendant::span[contains(@class,'applied-discount-code')]")
	WebElement couponsuccess2;
	
	public void Getcoupondetails(String coupon)
	{
		Couponcode.sendKeys(coupon);
		applycoupon.click();
		
		
	}
	
	public String verifycouponmessage()
	{
		
		String text=couponsuccess1.getText().trim();
		String text1=couponsuccess2.getText().trim();
		return text;
	}

}
