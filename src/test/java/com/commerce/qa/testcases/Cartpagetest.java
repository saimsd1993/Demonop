package com.commerce.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.commerce.qa.base.Baseclass;
import com.commerce.qa.pages.Cartpage;
import com.commerce.qa.pages.Homepage;
import com.relevantcodes.extentreports.LogStatus;

public class Cartpagetest extends Baseclass{
	Homepage hm;
	Cartpage cp;
	
	public Cartpagetest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		fsetup();
		hm=new Homepage();
		cp=new Cartpage();
		
	}

	@Test
	public void verifycoupon() throws InterruptedException
	{
		logger.info("Cartpage test Started ");
		logger2=extent.startTest("Cartpage Test Started");
		logger.info("Clicking on books ctaegory");
		hm.clickcategory();
		logger2.log(LogStatus.INFO, "Books Category clicked");
		logger.info("Clicking on first product");
		Thread.sleep(1000);
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
		Thread.sleep(1000);
		logger.info("Applying coupon code");
		cp.Getcoupondetails(prop.getProperty("code"));
		if(cp.verifycouponmessage().equals(prop.getProperty("success1")))
				{
			        logger.info("Text Verified :"+cp.verifycouponmessage());
			        Assert.assertTrue(true,"Test Case Passed");  
				}
		else
		{
			logger.info("Text not Verified");
			Assert.assertTrue(false,"Test Case failed");  
		}
	}
}
