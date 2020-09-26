package com.commerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.commerce.qa.base.Baseclass;

public class Homepage extends Baseclass{

	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='top-menu notmobile']/descendant::a[contains(@href,'/books')]")
	WebElement Books;
	
	@FindBy(xpath="//div[@class='item-grid']/descendant::a[contains(text(),'Fahrenheit 451 by Ray Bradbury')]")
	public WebElement randompro;
	
	@FindBy(xpath="//form[@id='product-details-form']/descendant::h1[contains(text(),'Fahrenheit 451 by Ray Bradbury')]")
	WebElement Productname;
	
	@FindBy(xpath="//div[@class='overview']/descendant::div[@class='product-name']")
	public WebElement protitle;
	
	public void clickcategory()
	{
		Books.click();
	}
	
	public void clickproduct()
	{
		randompro.click();
	}
	
	public String Gettext()
	{
		String text=Productname.getText();
		return text;
	}
	
	
	@FindBy(how=How.XPATH,using="//div[@class='overview']/descendant::input[contains(@id,'add-to-cart-button-37')]")
	WebElement Addtocart;
	
	@FindBy(xpath="//div[@class='add-to-cart-panel']/descendant::input[@type='button']")
	public WebElement addtocarttext;
	
	public void clickaddtocart()
	{
		Addtocart.click();
	}
	
	@FindBy(xpath="//div[@id='bar-notification']/descendant::p[@class='content']")
	public WebElement cartsuccessmsg;
	
	public void Verifysucvcsmsg()
	{
		cartsuccessmsg.isDisplayed();
	}
	
	@FindBy(xpath="//div[@class='bar-notification success']/descendant::span[@class='close']")
	WebElement close;
	
	public void clickclose()
	{
		close.click();
	}
	
	@FindBy(xpath="//li[@id='topcartlink']/descendant::a[contains(@href,'/cart')]")
	WebElement cartlink;
	
	public void clickcart()
	{
		cartlink.click();
	}
	
	@FindBy(xpath="(//div[@class='order-summary-content']/descendant::input[@type='checkbox'])[1]")
	WebElement checkbox;
	
	@FindBy(xpath="//div[@class='common-buttons']/descendant::input[@name='updatecart']")
	WebElement updatecart;
	
	public void selectcheck()
	{
		checkbox.click();
	}
	public void clickupdate()
	{
		updatecart.click();
	}
	
	@FindBy(xpath="//div[@class='order-summary-content']/div")
	public WebElement emptycartmsg;
	
	public String getcartmsg()
	{
		String text=emptycartmsg.getText();
		return text;
	}
   
	
	@FindBy(xpath="//ul[@class='top-menu notmobile']/descendant::a[contains(@href,'/computers')]")
	WebElement computer;
	
	@FindBy(xpath="(//ul[@class='sublist first-level']/descendant::a)[1]")
	public WebElement sub1;
	
	@FindBy(xpath="(//ul[@class='sublist first-level']/descendant::a)[2]")
	public WebElement Sub2;
	
	@FindBy(xpath="(//ul[@class='sublist first-level']/descendant::a)[3]")
	public WebElement sub3;
	
	@FindBy(xpath="//div[@class='page-title']/descendant::h1")
	WebElement ptitle;
	
	public WebElement clickheadercategory1()
	{
		WebElement com=computer;
		return com;
	}
	
	public void clickcat1()
	{
		sub1.click();
		
	}
	public void clickcat2()
	{
		Sub2.click();
	}
	public void clickcat3()
	{
		sub3.click();
	}
	
	public String getpagetitle()
	{
		String text=ptitle.getText();
		return text;
	}
	
}
