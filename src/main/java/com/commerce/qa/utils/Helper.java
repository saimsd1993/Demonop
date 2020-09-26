package com.commerce.qa.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	public  static String captureScreenshot(WebDriver driver,String tname)
	{
		
		File src=(File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String datename= new SimpleDateFormat("yyyymmddss").format(new Date());
		String path=System.getProperty("user.dir")+"/Screenshots/"+ tname + datename + ".png";
		File dest=new File(path);
		try {
			FileUtils.copyFile(src, dest);
			System.out.println("Screenshot taken");
			
		}catch(Exception e)
		{
			System.out.println("unable to capture screenshot"+e.getMessage());
		}
		return path;
		
		
	}

}
