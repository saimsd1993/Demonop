package com.commerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.commerce.qa.base.Baseclass;

public class Wishlistpage extends Baseclass{
	
	public Wishlistpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//locators
	
	@FindBy(xpath="//input[@id='add-to-wishlist-button-37']")
	WebElement Addwishlist;
	
	@FindBy(xpath="//div[@class='bar-notification success']/descendant::a[contains(@href,'/wishlist')]")
	public WebElement wishlistsuccess;
	
	@FindBy(xpath="(//div[@class='wishlist-content']/descendant::input[@type='checkbox'])[1]")
	WebElement removewishlistcheckbox;
	
	@FindBy(xpath="//div[@class='buttons']/descendant::input[contains(@class,'button-2 update-wishlist-button')]")
	WebElement updatewishlist;
	
	@FindBy(xpath="//div[@class='page-body']/descendant::div[contains(@class,'no-data')]")
	WebElement emptywishlistmsg;
	
	
	//methods
	
	public void clickwishlist()
	{
		Addwishlist.click();
		wait.until(ExpectedConditions.visibilityOf(wishlistsuccess));
		wishlistsuccess.click();
	}
	
	public void verifyupdatewishlist()
	{
		removewishlistcheckbox.click();
		updatewishlist.click();
	}
	public String verifyemptymsg()
	{
		String text=emptywishlistmsg.getText().trim();
		wait.until(ExpectedConditions.visibilityOf(emptywishlistmsg));
		if(text.equalsIgnoreCase(prop.getProperty("emptylist")))
		{
			System.out.println("Product deleted from wishlist");
		}
		else
		{
			System.out.println("Product not deleted from wishlist");
		}
		return text;
	}
	

}
