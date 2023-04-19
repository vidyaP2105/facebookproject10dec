package facebookproject10dec;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BrowserSetup.base;
import pages.FeaturePage;
import pages.HomePage;
import utility.utiles;

 
 public class testNg extends base {
	 WebDriver driver;
	 FeaturePage featurePage;
	 HomePage homePage;
	 private int testId;
	 static ExtentTest test;
	 static ExtentHtmlReporter reporter;
	 @Parameters ("browser")
	 @BeforeTest
	 public void launchBrowser(String browsername) {
		 reporter = new ExtentHtmlReporter("");
		 ExtentReports extend = new  ExtentReports();
		 extend.attachReporter(reporter);
		 
		 if(browsername.equals("Chrome"))
		 {
			 driver = openChromeBrowser();
		 }
		  if(browsername.equals("Firefox"))
		  {
			  driver = openFirefoxBrowser();
		  }
	 }
		@BeforeClass
		public void CreatePOMObjects()
		{
			featurePage = new FeaturePage(driver);
			homePage = new HomePage(driver);
		}	
		
		@BeforeMethod
		public void verifyHomePage()
		{
			driver.get("https://www.facebook.com/");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			homePage.OpenHomepage();
			
		}
		@Test
		public void verifyFeaturePage()
		{
			testId = 2205;
			featurePage.OpenFeaturePage();
			String Title = driver.getTitle();
			String URL = driver.getCurrentUrl();
			
			Assert.assertEquals(Title, "Messenger features");
			Assert.assertEquals(URL, "https://www.messenger.com/features");
			
		}
	
		@AfterMethod
		public void LogOut(ITestResult result) throws IOException 
		{
			if(ITestResult.FAILURE == result.getStatus())
			{
				utiles.CaptureScreenShot(driver, testId);
			}
			
			System.out.println("LogOut");
		}
 
		@AfterClass
		public void RemovePOMObjects()
		{
			featurePage = null;
			homePage = null;
		}
		
		@AfterTest
		public void CloseDriver()
		{
			
			driver.quit();
			driver = null;
			System.gc();
		}
 }
	 

















































