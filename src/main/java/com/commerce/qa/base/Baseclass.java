package com.commerce.qa.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.commerce.qa.utils.Helper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class Baseclass {

	
	public static WebDriver driver;               

	public static Properties prop;

	public static WebDriverWait wait; 
	
	public  static ExtentReports extent;
	
	public static ExtentTest logger2;
		
	public static Logger logger;
	
	public Baseclass()
	{
		try
		{
			logger=Logger.getLogger("Baseclass");
			PropertyConfigurator.configure("log4j.properties");
			prop=new Properties();
			FileInputStream fis=new FileInputStream("G:\\Workspace\\Test_Ecommerce\\src\\main\\java\\com\\commerce\\qa\\config\\Config.Properties");
			//InputStream is = Baseclass.class.getResourceAsStream("/src/main/java/com/commerce/qa/config/Config.Properties");
			//if(is != null)
			prop.load(fis);
			
			
			
		}catch(FileNotFoundException e)
		{
			System.out.println("Exception is" +e.getMessage());
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	    
		public static void fsetup() 
		{
	    	String br=prop.getProperty("browser");
			//String br= prop.getProperty("browser");
			if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","G:\\Workspace\\Test_Ecommerce\\src\\main\\java\\com\\commerce\\qa\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			}
			else if(br.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","G:\\Workspace\\Test_Ecommerce\\src\\main\\java\\com\\commerce\\qa\\drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
				
			}
			else if(br.equals("ie"))
			{
				System.setProperty("webdriver.gecko.driver","G:\\Workspace\\Test_Ecommerce\\src\\main\\java\\com\\commerce\\qa\\drivers\\IEDriverServer.exe");
				driver=new FirefoxDriver();
				
			    
			}
			else if(br.equals("safari"))
			{
				driver = new SafariDriver();
			}
			
		    driver.manage().deleteAllCookies();
			long implicitWaitTime = Long.parseLong(prop.getProperty("implicitiwait"));
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS); 
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver,40);
		    driver.get(prop.getProperty("testbaseurl2"));
			
		    
			
		}
		
		@BeforeTest
		public void config ()
	    {
			
			extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/AutomationResultsNew.html",true);
			extent.addSystemInfo("Organization", "ABC");
			extent.addSystemInfo("Browser", "CHROME");
			extent.addSystemInfo("Environemnt","QA");
			extent.addSystemInfo("user","Sri Sairam");
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
			
				
	    }

		@AfterTest
		 public void onFinish() {
			 
		     extent.flush();
		     extent.close();
		 }
		@AfterMethod
		public void Tear(ITestResult result) throws IOException 
		{
			if(result.getStatus()==ITestResult.FAILURE)
			{
				logger2.log(LogStatus.FAIL, "Test Case Failed is"+result.getName());//to add name in extent report
				logger2.log(LogStatus.FAIL, "Test Case Failed is"+result.getThrowable());  //to add exception message in extent reports
				String path= Helper.captureScreenshot(driver, result.getName());
				logger2.log(LogStatus.FAIL,logger2.addScreenCapture(path)); //to add screenshot in extent reports
				
				
				
			}
			
			else if(result.getStatus()==ITestResult.SKIP)
			{
				logger2.log(LogStatus.SKIP, "Test Case Skipped"+result.getName());
			}
		
		
		   extent.endTest(logger2);
		   System.out.println("Quitting the browser");
			driver.quit();
			
		
		}

	}	
		    
		    
		    
		    
		
	    
	    
		

		
