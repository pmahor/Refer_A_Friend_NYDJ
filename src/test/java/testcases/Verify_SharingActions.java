package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.Dataproviderfactory;
import pages.Sharing_Actions;

public class Verify_SharingActions 
{
	WebDriver driver;
	Sharing_Actions sharingobj;
	
	@BeforeTest
	public void setup()
	{
		driver=BrowserFactory.getBrowser("Chrome");
		driver.manage().window().maximize();
		driver.get(Dataproviderfactory.getConfig().getUrl());
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		sharingobj=PageFactory.initElements(driver,Sharing_Actions.class);
	}
	
	@Test(priority=1)
	public void RAF_login()
	{
		sharingobj.RAF_Login();
	}

	@Test(priority=2)
	public void FacebookSharing()
	{
		sharingobj.FbSharing();
	}
	
	@Test(priority=3)
	public void TwitterSharing()
	{
		sharingobj.TwitterSharing();
	}

	@Test(priority=4)
	public void Emailsharing()
	{
		sharingobj.EmailSharing();
	}
	
	@Test(priority=5)
	public void Managerewardsection()
	{
		sharingobj.ManageRewards();
	}
	
	@Test(priority=6)
	public void Referralstatus()
	{
		sharingobj.ReferralStatus();
	}
	/*
	@Test(priority=2)
	public void Personalbitlysharing()
	{
		sharingobj.PersonalbitlyShare();
	}*/	
}
