package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
static WebDriver driver;
	
	public static WebDriver getBrowser(String browsername)
	{
		if(browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", Dataproviderfactory.getConfig().getChromePath());
			driver = new ChromeDriver();
		}
		if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", Dataproviderfactory.getConfig().getIEPath());
			driver= new InternetExplorerDriver();
		}
		
		return driver;
		
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}


}
