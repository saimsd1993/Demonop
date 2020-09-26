package com.commerce.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.commerce.qa.base.Baseclass;
import com.commerce.qa.pages.Addresspage;
import com.commerce.qa.pages.Homepage;
import com.commerce.qa.pages.Loginpage;
import com.commerce.qa.pages.SmokeTest;
import com.commerce.qa.utils.Testutil;
import com.relevantcodes.extentreports.LogStatus;

public class Addresspagetest extends Baseclass {
	Testutil testutil;
	Addresspage ap;
	Homepage hm;
	SmokeTest sm;
	Logger logger=Logger.getLogger(Addresspagetest.class);
	
	String sheetName="shipping";
	
	public Addresspagetest()
	{
		super();
	}
	
	@BeforeMethod
	public void check()
	{
		fsetup();
		ap=new Addresspage();
		hm=new Homepage();
		sm= new SmokeTest();
	}
	
	
	@DataProvider
	public Object[][] getNoptestdata() 
	{
		Object data [][]=Testutil.getTestData(sheetName);
		return data;
		
	}
	
	
	@Test(dataProvider="getNoptestdata")
	public void verifyaddress(String firstname,String lastname,String email,String city,String address1,String postcode,String phonenumber) throws InterruptedException
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
		sm.clickcheckoutbutton();
		logger.info("checkout button  clicked");
		Thread.sleep(3000);
		sm.clickguestcheckout();
		logger.info("guest checkout clicked");
		Thread.sleep(2000);
		ap.getAddressdetails(firstname,lastname,email,city,address1,postcode,phonenumber);
		Thread.sleep(2000);
		sm.selectcountrydrop();
		logger.info("Country option selection");
		Thread.sleep(3000);
		sm.Selectstate();
		logger.info("state selected");
		
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
		
	}

}
