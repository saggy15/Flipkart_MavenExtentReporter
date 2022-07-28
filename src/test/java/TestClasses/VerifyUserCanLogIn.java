package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClasses.BaseClass1;
import PomClasses.HomePage;
import PomClasses.LoginPage;

@Listeners(listenerClasses.Listener1.class)

public class VerifyUserCanLogIn {
	
	static WebDriver driver;
	LoginPage lp;
	ExtentHtmlReporter ExtentReporter;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() throws IOException
	{
		ExtentReporter = BaseClass1.getHtmlReporter();
		report = BaseClass1.getReports();
		test = BaseClass1.getExtentTest("VerifyUserCanLogIn");
		
		
		driver = BaseClass1.getDriver("chrome");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		lp = new LoginPage(driver);
	}
	
	@Test
	public void verifyUserCanLogin() throws IOException, InterruptedException
	{
		lp.enterEmail();
		lp.enterPassword();
		lp.clickLoginBtn();
		
		HomePage hp = new HomePage(driver);
		
		Assert.assertTrue(hp.getProfileName());
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName() + " test passed");
		}
		else {
			
			String path = lp.getScreenshot(driver, result.getName());
			test.log(Status.FAIL, result.getName() + " test failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}
	
	
	@AfterClass
	public void afterClass()
	{
		report.flush();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
