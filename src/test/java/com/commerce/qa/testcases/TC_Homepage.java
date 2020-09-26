package com.commerce.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.commerce.qa.base.Baseclass;
import com.commerce.qa.pages.Homepage;
import com.commerce.qa.pages.Loginpage;
import com.relevantcodes.extentreports.LogStatus;

public class TC_Homepage extends Baseclass{
	
	Homepage hm;
	Logger logger=Logger.getLogger(TC_Homepage.class);
	
	public TC_Homepage()
	{
		super();
	}
	
	
	@BeforeMethod
	public void check()
	{
		fsetup();
		hm=new Homepage();
	}
	
	@Test(priority=0)
	public void Homepagedetails() throws InterruptedException
	{
		logger.info("Homepage test Started ");
		logger2=extent.startTest("Homepage Test Started");
		logger.info("Clicking on books ctaegory");
		hm.clickcategory();
		logger2.log(LogStatus.INFO, "Books Category clicked");
		logger.info("Clicking on first product");
		Thread.sleep(2000);
		hm.clickproduct();
		logger2.log(LogStatus.INFO, "Books Category product clicked");
		logger.info("waiting for product url display");
		String expecturl=prop.getProperty("PDPurl");
		String currurl=driver.getCurrentUrl();
		Thread.sleep(2000);
		if(currurl.equalsIgnoreCase(expecturl))
		{
			logger2.log(LogStatus.PASS, "Books Category Product page url Verified"+currurl+"<-->"+expecturl);
			Thread.sleep(1000);
			Assert.assertTrue(true,"Test Case Passed");
			logger.info("Product name Verified");
			
		}
		else
		{
			logger2.log(LogStatus.FAIL, "Books Category Product page url not Verified"+currurl+"<-->"+expecturl);
			Assert.assertTrue(false,"Test Case failed");
			logger.info("Product name not Verified");	
		}
		
	}
	
	@Test(priority=1)
	public void Endtoendflow() throws InterruptedException
	{
		logger.info("End to End test Started ");
		logger2=extent.startTest("Cart page Test Started");
		logger.info("Clicking on books ctaegory");
		hm.clickcategory();
		logger2.log(LogStatus.INFO, "Books Category clicked");
		logger.info("Clicking on first product");
		Thread.sleep(2000);
		hm.clickproduct();
		logger2.log(LogStatus.INFO, "Books Category product clicked");
		logger.info("Waiting for elelemnt to visible");
		wait.until(ExpectedConditions.visibilityOf(hm.addtocarttext));
		logger.info("clicking on add to cart button");
		hm.clickaddtocart();
		logger2.log(LogStatus.INFO, "Add to cart button clicked");
		logger.info("Verifying add to cart success message");
		wait.until(ExpectedConditions.visibilityOf(hm.cartsuccessmsg));
		hm.Verifysucvcsmsg();
		hm.clickclose();
		logger.info("success message closed");
		Thread.sleep(1000);
		hm.clickcart();
		logger2.log(LogStatus.INFO, "Cart link clicked in header");
		Thread.sleep(2000);
		logger.info("clicking on remove checkbox");
		hm.selectcheck();
		logger2.log(LogStatus.INFO, "Checkbox clicked in cartpage");
		logger.info("Removing product from cart");
		hm.clickupdate();
		logger2.log(LogStatus.INFO, "Product removed from cartpage");
		
		logger.info("Verifying cart empty message");
		String Empty=prop.getProperty("emptycart");
		wait.until(ExpectedConditions.visibilityOf(hm.emptycartmsg));
		if(hm.getcartmsg().equalsIgnoreCase(Empty))
		{
			logger2.log(LogStatus.PASS, "Empty cart message displayed"+hm.getcartmsg()+"<-->"+Empty);
			Thread.sleep(1000);
			Assert.assertTrue(true,"Test Passed");
			
		}
		else
		{
			logger2.log(LogStatus.FAIL, "Empty cart message not displayed"+hm.getcartmsg()+"<-->"+Empty);
			Assert.assertTrue(false,"Test Failed");
		}
		
	}
	@Test(priority=2)
	public void Headerverify() throws InterruptedException
	{
		logger.info("Homepage header test Started ");
		logger2=extent.startTest("Homepage Test Started");
		logger.info("Mouse hover to Computers ctaegory");
		WebElement menu=hm.clickheadercategory1();
		Actions builder = new Actions((WebDriver) driver);
		builder.moveToElement(menu).clickAndHold().perform();
		wait.until(ExpectedConditions.visibilityOf(hm.sub1));
		hm.clickcat1();
		logger.info("Clicked Computers ctaegory 1");
		logger2.log(LogStatus.INFO,"Clicked Catgory 1");
		builder.moveToElement(menu).clickAndHold().perform();
		wait.until(ExpectedConditions.visibilityOf(hm.Sub2));
		hm.clickcat2();
		logger.info("Clicked Computers ctaegory 2");
		logger2.log(LogStatus.INFO,"Clicked Catgory 2");
		builder.moveToElement(menu).clickAndHold().perform();
		wait.until(ExpectedConditions.visibilityOf(hm.sub3));
		hm.clickcat3();
		logger.info("Clicked Computers ctaegory 3");
		logger2.log(LogStatus.INFO,"Clicked Catgory 3");
		
		String title=prop.getProperty("Titlep");
		String actual=hm.getpagetitle();
		if(title.equals(actual))
		{
			logger.info("Header title verified ");
			Assert.assertTrue(true,"Test case Passed");
			
		}
		else
		{
			logger.info("Header title not verified ");
			Assert.assertTrue(false,"Test case failed");
		}
		
		
		
		
		
		
		
		
	}

}
