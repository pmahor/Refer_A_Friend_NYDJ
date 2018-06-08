package pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.Dataproviderfactory;
import utility.Library;

public class BitlyExecution 
{
	
		WebDriver driver;
		@FindBy(id="email") WebElement emailaddr;
		@FindBy(id="pass") WebElement emailpass;
		@FindBy(id="loginbutton") WebElement loginbtn;
		@FindBy(xpath="//a[@title='Profile']") WebElement fbprofile; 
		@FindBy(xpath="//div[@class='_6l- __c_']") WebElement fbbitly;
		
		@FindBy(xpath="//*[@id='sa_s2_your_emailSend']") WebElement Emailtxtbox;
		@FindBy(xpath="//*[@id='codSendEmailRS']") WebElement unlockbtn;
		
	
		
		public BitlyExecution(WebDriver driver)
		{
			this.driver=driver;
		}
		
		public void fbbitly()
		{
			try 
			{
				
			System.out.println("login to facebook");
			driver.get(Dataproviderfactory.getConfig().getfbUrl());
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			Thread.sleep(10000);		
			
			emailaddr.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,0));
			emailpass.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,1));
			loginbtn.click();
			
			//	Thread.sleep(10000);
			//	driver.switchTo().alert().accept();
			Thread.sleep(5000);
			fbprofile.click();
			Thread.sleep(10000);
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", fbbitly);
			
			Thread.sleep(10000);
			
			//To take screenshot after bitly execution
			String parentwindow=driver.getWindowHandle();
			Set<String> winHandles=driver.getWindowHandles();
			for(String winHandl : winHandles)
			{
				driver.switchTo().window(winHandl);
			}
			
			Thread.sleep(5000);
			driver.switchTo().frame("s2-main-iframe");
			Thread.sleep(5000);
			
			Emailtxtbox.sendKeys("sa.test87df654@gmail.com");
			Library.takescreensnap(driver, "FB_Unlockcodepoup");
			Thread.sleep(5000);
			unlockbtn.click();
			Thread.sleep(10000);
			Library.takescreensnap(driver, "FB_Coupon_codepoup");
			System.out.println("Facebook Bitly Execution Completed......................");
			driver.quit();
			
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		@FindBy(xpath="//input[@class='js-username-field email-input js-initial-focus']") WebElement TwEmail; 
		@FindBy(xpath="//input[@class='js-password-field']") WebElement Twpass;
		@FindBy(xpath="//button[@class='submit EdgeButton EdgeButton--primary EdgeButtom--medium']") WebElement Twloginbtn;
		
		@FindBy(xpath="//a[@class='ProfileCardStats-statLink u-textUserColor u-linkClean u-block js-nav js-tooltip']") WebElement Twprofilelink;
		@FindBy(xpath="//span[contains(.,'bit.ly/2Jl9tNZ')]") WebElement Twitbitlyclick ;
		
		
		public void Twitterbitly()
		{
			try
			{
				System.out.println("clicking on twitterbitly");
				driver.get(Dataproviderfactory.getConfig().getTwitterUrl());
				Thread.sleep(10000); 
				
				TwEmail.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,0));
				Twpass.sendKeys(Dataproviderfactory.getExceldata().getStringData(0,2));
				Twloginbtn.click();
				Thread.sleep(10000);
				
				Twprofilelink.click();
				Thread.sleep(10000);
				Twitbitlyclick.click();
				
				Thread.sleep(10000);
				
				//To take screenshot after bitly execution
				String parentwindow=driver.getWindowHandle();
				Set<String> winHandles=driver.getWindowHandles();
				for(String winHandl : winHandles)
				{
					driver.switchTo().window(winHandl);
				}
				Thread.sleep(5000);
				driver.switchTo().frame("s2-main-iframe");
				Thread.sleep(5000);
				
				Emailtxtbox.sendKeys("sa.test165d623@gmail.com");
				Library.takescreensnap(driver, "Twitter_Unlockcodepoup");
				Thread.sleep(5000);
				unlockbtn.click();
				Thread.sleep(10000);
				Library.takescreensnap(driver, "Twitter_Couponcodepoup");
				System.out.println("Twitter Bitly Execution Completed......................");
			
				driver.quit();
				
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		@FindBy(xpath=".//*[@id='identifierId']") WebElement gmEmail; 
		@FindBy(xpath=".//*[@id='identifierNext']/content/span") WebElement gmnextbtn;
		
		@FindBy(xpath=".//*[@id='password']/div[1]/div/div[1]/input") WebElement passwd;
		@FindBy(xpath=".//*[@id='passwordNext']/content/span") WebElement gmnectbtn2;
		
		@FindBy(name="q") WebElement searchbox;
		@FindBy(xpath="//*[@id='gbqfb']") WebElement searchbtn;
		
		@FindBy(xpath="//*[@id=':k3']") WebElement inboxemail;
		@FindBy(xpath="//*[@id=':z2']/table/tbody/tr[2]/td/table/tbody/tr/td/div[4]/a/img") WebElement emailbitlyclick;	
		
		public void Emailbitly()
		{
			try 
			{	
				System.out.println("clicking on emailbitly");
				driver.get(Dataproviderfactory.getConfig().getGmailUrl());
				
				Thread.sleep(5000);
				
				gmEmail.sendKeys(Dataproviderfactory.getExceldata().getStringData(1,0));
				gmnextbtn.click();
				Thread.sleep(5000);
			
				passwd.sendKeys(Dataproviderfactory.getExceldata().getStringData(1,1));
				gmnectbtn2.click();
				Thread.sleep(10000);
				
				searchbox.sendKeys("John");
				Thread.sleep(5000);
				searchbtn.click();
				
				Thread.sleep(5000);
				inboxemail.click();
				
				Thread.sleep(10000);
				emailbitlyclick.click();
				Thread.sleep(10000);
				
				Set<String> winHandles=driver.getWindowHandles();
				for(String winHandl : winHandles)
				{
					driver.switchTo().window(winHandl);
				}
					
				Thread.sleep(5000);
				driver.switchTo().frame("s2-main-iframe");
				Thread.sleep(5000);
				
				Emailtxtbox.sendKeys("sa.test23234@gmail.com");
				Library.takescreensnap(driver, "Email_Unlockcodepoup");
				Thread.sleep(5000);
				unlockbtn.click();
				Thread.sleep(10000);
				Library.takescreensnap(driver, "Email_Coupon_codepoup");
						
				System.out.println("Email Bitly Execution Completed......................");
								
				driver.quit();
								
			} 
			catch (InterruptedException e)
			{				
					e.printStackTrace();
			}
			
			}
}
