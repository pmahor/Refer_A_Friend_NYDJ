package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import pages.BitlyExecution;

public class Verify_BitlyExecution 
{

		WebDriver driver;
		BitlyExecution bitlyexecobj;

		//@BeforeMethod
		public void setup()
		{
			driver=BrowserFactory.getBrowser("Chrome");
			driver.manage().window().maximize();	
			bitlyexecobj=PageFactory.initElements(driver, BitlyExecution.class);
		}
				
		@Test(priority=7)
		public void FacebookBitlyExecution()
		{
			setup();
			bitlyexecobj.fbbitly();
		}
	
		@Test(priority=8)
		public void TwitterBitlyexecution()
		{
			setup();
	        bitlyexecobj.Twitterbitly();
		}
		
		@Test(priority=9)
		public void emailBitlyexecution()
		{
			setup();
			bitlyexecobj.Emailbitly();
		}
		
}
