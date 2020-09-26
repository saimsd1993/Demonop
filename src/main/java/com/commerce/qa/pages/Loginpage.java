package com.commerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.commerce.qa.base.Baseclass;

public class Loginpage extends Baseclass{
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
    
	//Login page OR
	
		@FindBy(xpath="//div[@class='header-links-wrapper']/descendant::a[contains(@class,'ico-login')]")
		WebElement Loginbutton;
		
		@FindBy(xpath="//div[@class='returning-wrapper fieldset']/descendant::input[@id='Email']")
		WebElement Username;
		
		@FindBy(xpath="//div[@class='returning-wrapper fieldset']/descendant::input[@id='Password']")
		WebElement Password;
		
		@FindBy(xpath="//div[@class='returning-wrapper fieldset']/descendant::input[contains(@class,'button-1 login-button')]")
		WebElement Signin;
		
		@FindBy(xpath="//div[@class='returning-wrapper fieldset']/descendant::div[contains(@class,'message-error validation-summary-errors')]")
		public WebElement errormessage;
		
		
		public void Verifylogin(String uname,String pwd)
		{
			Loginbutton.click();
			Username.sendKeys(uname);
			Password.sendKeys(pwd);
			Signin.click();
		}
		
		public String Verifylogin()
		{
			Loginbutton.click();
			Username.sendKeys("sai20@gmail.com");
			Password.sendKeys("Test12345");
			Signin.click();
			wait.until(ExpectedConditions.visibilityOf(errormessage));
			String text=errormessage.getText().trim();
			return text;
		}
	
}
