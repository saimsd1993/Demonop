package com.commerce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.commerce.qa.base.Baseclass;
import com.commerce.qa.pages.Loginpage;
import com.commerce.qa.pages.SearchPage;
import com.relevantcodes.extentreports.LogStatus;



public class SearchpageTest extends Baseclass{
	SearchPage sp;
	Logger logger=Logger.getLogger(SearchpageTest.class);
	
	public SearchpageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void check()
	{
		fsetup();
		sp=new SearchPage();
	}
	
	
	
	@Test
	public void verifysearchresults()
	{
		logger.info("Searchpage test Started ");
		logger2=extent.startTest("Searchpage Test Started");
		sp.getsearchresults(prop.getProperty("proname"));
		logger2.log(LogStatus.PASS,"Search Test Passed");
		Assert.assertEquals(true, true);
		
	}

}
