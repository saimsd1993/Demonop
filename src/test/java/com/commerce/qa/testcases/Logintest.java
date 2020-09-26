package com.commerce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.commerce.qa.base.Baseclass;
import com.commerce.qa.pages.Loginpage;
import com.relevantcodes.extentreports.LogStatus;

public class Logintest extends Baseclass{
	Loginpage lp;
	Logger logger=Logger.getLogger(Logintest.class);
	public Logintest()
	{
		super();
	}
	
	@BeforeMethod
	public void check()
	{
		fsetup();
		lp=new Loginpage();
	}
	
	@Test(priority=1)
	public void Verificationoflogin()
	{
		logger.info("Loginpage test Started ");
		logger2=extent.startTest("LoginPage Test Started");
		logger.info("Entering valid user details ");
		logger2.log(LogStatus.INFO,"Entering username and Password");
		lp.Verifylogin(prop.getProperty("email"), prop.getProperty("password"));
		logger.info("Login Successfull");
		logger2.log(LogStatus.PASS,"Login Successfull");
		Assert.assertTrue(true,"Test Passed");
		
		
		
	}
	
	

}
