package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BrowserFactory;
import factory.Dataproviderfactory;
import utility.Library;

public class Sharing_Actions 
{
	WebDriver driver;
	@FindBy(xpath="//*[@id='sa_s2_first_name']") WebElement Firstnametxtbox;
	@FindBy(xpath="//*[@id='sa_s2_your_email']") WebElement Emailtxtbox;
	@FindBy(xpath="//*[@id='s2_signup_submit']") WebElement StartSharingbtn;
	
	
	public Sharing_Actions(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void RAF_Login()
	{
		try 
		{
			Thread.sleep(5000);
			driver.switchTo().frame("s2-main-iframe");
			Firstnametxtbox.sendKeys("john");
			Emailtxtbox.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,0));
			Thread.sleep(5000);
			Library.takescreensnap(driver, "RAF_Login_Page");
			StartSharingbtn.click();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	@FindBy(xpath="//*[@id='s2-fb-share-button']") WebElement FBsharebtn;
	@FindBy(xpath="//*[@id='fb_custom_msg']/div/div[2]/div[3]/a") WebElement FBshareclosebtn;
	
	@FindBy(xpath="//input[@id='email']") WebElement fbemailaddr;
	@FindBy(xpath="//input[@id='pass']") WebElement fbpasswd;
	@FindBy(xpath="//input[@id='u_0_0']") WebElement fbloginbtn;
	
	public void FbSharing()
	{
		try 
		{
		Thread.sleep(5000);
		FBsharebtn.click();
		Thread.sleep(5000);
		
		String parentwindow=driver.getWindowHandle();
		Set<String> winHandles=driver.getWindowHandles();
		for(String winHandl : winHandles)
		{	
			driver.switchTo().window(winHandl);
		}
		Thread.sleep(5000);
		fbemailaddr.sendKeys(Dataproviderfactory.getExceldata().getStringData(0, 0));
		fbpasswd.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,1));
		fbloginbtn.click();
		
		Thread.sleep(5000);
		driver.switchTo().window(parentwindow);
		Thread.sleep(5000);
		driver.switchTo().frame("s2-main-iframe");
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".FB_UI_Dialog")));	
		Thread.sleep(5000);
		Library.takescreensnap(driver, "Facebook_Sharing_Feedbox_Popup");
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",driver.findElement(By.name("__CONFIRM__")));
		Thread.sleep(5000);
		
		driver.switchTo().window(parentwindow);
		Thread.sleep(5000);
		driver.switchTo().frame("s2-main-iframe");
		Library.takescreensnap(driver, "Facebook_Sharing_ThankYou_Popup");
		FBshareclosebtn.click();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	@FindBy(xpath="//*[@id='s2-tw-share-button']") WebElement twsharingbtn;
	@FindBy(xpath="//input[@id='username_or_email']") WebElement tweetEmail;
	@FindBy(xpath="//input[@id='password']") WebElement tweetpass;
	@FindBy(xpath="//input[@id='allow']") WebElement tweetloginbtn;	
	
	public void TwitterSharing()
	{
		try 
		{
			Thread.sleep(5000);	
			twsharingbtn.click();
			
			String parentwindow=driver.getWindowHandle();
			Set<String> winHandles=driver.getWindowHandles();
			for(String winHandl : winHandles)
			{
				driver.switchTo().window(winHandl);
			}
			Thread.sleep(5000);
			tweetEmail.sendKeys(Dataproviderfactory.getExceldata().getStringData(0, 0));
			tweetpass.sendKeys(Dataproviderfactory.getExceldata().getStringData(0, 2));
			Thread.sleep(5000);
			Library.takescreensnap(driver, "Twitter_Sharing_Login_Window");
			tweetloginbtn.click();
					
			Thread.sleep(5000);
			driver.switchTo().window(parentwindow);
			Thread.sleep(5000);
			driver.switchTo().frame("s2-main-iframe");
			
			Thread.sleep(5000);
			Library.takescreensnap(driver, "Twitter_Sharing_ThankYou_Popup");
			FBshareclosebtn.click();	
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath="//*[@id='s2-email-share-buttons']") WebElement Emailsharingbtn;
	@FindBy(xpath="//*[@id='email_to_shareEm']") WebElement frndsemail;
	@FindBy(xpath="//*[@id='emailSocialShareButton']") WebElement Emailsharebtn;	
	
	public void EmailSharing()
	{
		try 
		{
			Thread.sleep(5000);	
			Emailsharingbtn.click();
			Thread.sleep(5000);	
			frndsemail.sendKeys("johnhenry.sa62@gmail.com");
			Thread.sleep(10000);	
			Library.takescreensnap(driver, "Email_Sharing_Popup");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(Emailsharebtn));

			Emailsharebtn.click();
			Thread.sleep(5000);	
			Library.takescreensnap(driver, "Email_Sharing_ThankYou_Popup");
			FBshareclosebtn.click();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	
		@FindBy(xpath="//*[@id='s2_referrelStatusDiv']/p/a") WebElement referralstatusbtn2;
		@FindBy(xpath="//*[@id='s2_rewardStatusForm']/div/div/div/div[1]/a") WebElement backtosharingbtntn;
		
		public void ReferralStatus()
		{		
			try 
			{			
				Thread.sleep(5000);
				referralstatusbtn2.click();
				Thread.sleep(5000);
				Library.takescreensnap(driver, "Referral_Status");
				backtosharingbtntn.click();
				Thread.sleep(5000);
		
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		
	
	
		
	@FindBy(xpath="//*[@id='s2_userInviteForm']/p/a") WebElement Viewrewardbtn;
//	@FindBy(xpath="//*[@id='tabs']/li[2]/a") WebElement referralstatusbtn;
//	@FindBy(xpath="//*[@id='tabs']/li[1]/a") WebElement managerewardbtn;
	@FindBy(xpath="//*[@id='s2_rewardCliamForm']/div[2]/div/div/div[1]/a") WebElement backtosharingbtn;
	
	public void ManageRewards()
	{		
		try 
		{	
			Thread.sleep(5000);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", Viewrewardbtn);
			//Viewrewardbtn.click();
			Thread.sleep(5000);
			Library.takescreensnap(driver,"Mangereward_popup");
			/*referralstatusbtn.click();
			Thread.sleep(5000);*/
			Library.takescreensnap(driver,"ReferralStatus_popup");
			
			Thread.sleep(5000);
			backtosharingbtn.click();
			
		}  
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	@FindBy(xpath="//*[@id='s2_personBitlyForm_submit']") WebElement copylinkbtn;
	@FindBy(xpath="//*[@id='s2_bitlyurlText']") WebElement personalbitly;
	
	@FindBy(xpath="//*[@id='ye_s2_divEmailSend']/input") WebElement unloEmailtxtbox;
	@FindBy(xpath="//*[@id='codSendEmailRS']") WebElement unlockbtn;
	
	public void PersonalbitlyShare()
	{		
		try 
		{			
			Thread.sleep(5000);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", copylinkbtn);
			//copylinkbtn.click();
			String bitlytext = personalbitly.getAttribute("value");
			System.out.println("Bitly text="+bitlytext);
			Library.takescreensnap(driver, "Personal_Bitly");
			
			driver= BrowserFactory.getBrowser("Chrome");	
			driver.manage().window().maximize();
			driver.get(bitlytext);
			
			Thread.sleep(10000);
			driver.switchTo().frame(driver.findElement(By.id("s2-main-iframe")));
			//driver.switchTo().frame("s2-main-iframe");
			Thread.sleep(5000);
			
			String parentwindow=driver.getWindowHandle();
			Set<String> winHandles=driver.getWindowHandles();
			
		    int numberOfWindows = winHandles.size();
			System.out.println("Number of windows="+ numberOfWindows);
			for(String winHandl : winHandles)
			{
				driver.switchTo().window(winHandl);
			}			
			
		    
			JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
			myExecutor.executeScript("arguments[0].value='testestestes1232@gmail.com';", unloEmailtxtbox);
			
			
			//unloEmailtxtbox.sendKeys("sa.testtesttt123@gmail.com");
			Library.takescreensnap(driver, "PersonalBitly_share_Unlockcodepoup");
			Thread.sleep(5000);
			unlockbtn.click();
			Thread.sleep(10000);
			Library.takescreensnap(driver, "PersonalBitly_share_Couponcodepopup");
			System.out.println("Personal Bitly Execution Completed......................");
		     
			driver.quit();
		}  
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
}
