package com.commerce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.commerce.qa.base.Baseclass;
import com.commerce.qa.pages.Homepage;
import com.commerce.qa.pages.Wishlistpage;
import com.relevantcodes.extentreports.LogStatus;

public class Wishlistpagetest extends Baseclass{
	
	Wishlistpage wp;
	Homepage hm;
	
	public Wishlistpagetest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		fsetup();
		wp=new Wishlistpage();
		hm=new Homepage();
	}
	@Test
	public void VerifyWishlistpage()
	{
		logger.info("Homepage test Started ");
		logger2=extent.startTest("Homepage Test Started");
		logger.info("Clicking on books ctaegory");
		hm.clickcategory();
		logger2.log(LogStatus.INFO, "Books Category clicked");
		logger.info("Clicking on first product");
		hm.clickproduct();
		logger2.log(LogStatus.INFO, "Books Category product clicked");
		logger.info("Clicking on Add to wishlist button");
		wp.clickwishlist();
		logger2.log(LogStatus.INFO, "Wishlist button clicked and navigated to wishlist page");
		logger.info("Clicking Remove wishlist checkbox");
		wp.verifyupdatewishlist();
		wp.verifyemptymsg();
		Assert.assertTrue(true,"Test case Passed");
	}

}
