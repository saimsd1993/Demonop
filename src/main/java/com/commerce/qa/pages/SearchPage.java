package com.commerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commerce.qa.base.Baseclass;

public class SearchPage extends Baseclass {
	
	public SearchPage()
	{
		PageFactory.initElements(driver, this);
	}
    
	
	//Search page OR
	@FindBy(xpath="//div[@class='search-box store-search-box']/descendant::input[@id='small-searchterms']")
	WebElement searcharea;
	
	@FindBy(xpath="//input[contains(@class,'button-1 search-box-button')]")
	WebElement Searchbutton;
	
	@FindBy(xpath="(//div[@class='search-results']/descendant::div[contains(@class,'item-box')])[1]")
	WebElement Searchresults;
	
	public void getsearchresults(String data)
	{
		searcharea.sendKeys(data);
		Searchbutton.click();
		if(Searchresults.isDisplayed())
		{
			System.out.println(Searchresults.getText());
		}
		else
		{
			System.out.println("search failed");
		}
	}
}
