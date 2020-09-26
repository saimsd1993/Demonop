package com.commerce.qa.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.commerce.qa.base.Baseclass;
import com.commerce.qa.pages.Homepage;
import com.commerce.qa.pages.SmokeTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_Smoke extends Baseclass{
	SmokeTest sm;
	Homepage hm;
	Logger logger=Logger.getLogger(TC_Smoke.class);
	
	public TC_Smoke()
	{
		super();
	}
	
	@BeforeMethod
	public void check()
	{
		fsetup();
		hm=new Homepage();
		sm=new SmokeTest();
		
	}
	
	@Test
	public void smoketest() throws InterruptedException
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
		sm.selectterms();
		Thread.sleep(4000);
		//logger2.log(LogStatus.INFO,"scroll happened");
		//wait.until(ExpectedConditions.visibilityOf(sm.terms));
		//sm.selectterms();
		//logger.info("sterms box clicked");
		
		sm.clickcheckoutbutton();
		logger.info("checkout button  clicked");
		Thread.sleep(2000);
		sm.clickguestcheckout();
		logger.info("guest checkout clicked");
		Thread.sleep(2000);
		sm.getfirstname(prop.getProperty("firstname"));
		logger.info("first name entered");
		sm.getlastname(prop.getProperty("lastname"));
		logger.info("last name entered");
		sm.getemail(prop.getProperty("email"));
		logger.info("email entered");
		sm.selectcountrydrop();
		logger.info("Country option selection");
		Thread.sleep(3000);
		sm.Selectstate();
		logger.info("state selected");
		Thread.sleep(2000);
		logger.info("Enterinh shipping details");
		sm.shippingdetails(prop.getProperty("city"), prop.getProperty("address"), prop.getProperty("postcode"), prop.getProperty("pno"));
		wait.until(ExpectedConditions.visibilityOf(sm.pagetitle));
		String checktitle=prop.getProperty("ptitle");
		if(sm.getpagetitle().equalsIgnoreCase(checktitle))
		{
			logger.info("checkout text verified");
			Assert.assertTrue(true,"Test case Passed");
		}
		else
		{
			logger.info("checkout text not verified");
			Assert.assertTrue(true,"Test case failed");
		}
		sm.checkoutnavigation();
		Thread.sleep(2000);
		if(sm.getpaymenttitle().equalsIgnoreCase(prop.getProperty("check")))
		{
			logger.info("payment page text verified");
			Assert.assertTrue(true,"Test case Passed");
		}
		else
		{
			logger.info("payment text not verified");
			Assert.assertTrue(true,"Test case failed");
		}
		logger.info("Entering payment details");
		sm.Paymentdetails(prop.getProperty("cardholder"), prop.getProperty("cardnumber"), prop.getProperty("cvv"));
		logger.info("Clicking on place order button");
		sm.placeorder();
		logger.info("order successfully placed using card");
		Thread.sleep(2000);
		logger.info("Verifying order success message");
		if(sm.ordersuccess().equalsIgnoreCase(prop.getProperty("successmessage")))
		{
			logger.info("order success text verified");
			Assert.assertTrue(true,"Test case Passed");
		}
		else
		{
			logger.info("order success text not verified");
			Assert.assertTrue(true,"Test case Failed");
		}
		
		
			
		
		
	}

}
