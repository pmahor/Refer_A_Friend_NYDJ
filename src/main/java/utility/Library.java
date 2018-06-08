package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Library
{
	public static void takescreensnap(WebDriver driver, String tc_name)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		File dest=new File("D:/Pankaj BACKUP/Selenium/Workspace/Refer-a-Friend_NYDJ/Screenshot/"+tc_name+".png");
		
		try
		{			
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e)
		{
			System.out.println("Screenshot was not saved");
			e.printStackTrace();
		}
		
	}


}
