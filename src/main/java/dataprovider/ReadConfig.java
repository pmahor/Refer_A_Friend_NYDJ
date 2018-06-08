package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig()
	{
		
		File src= new File("./configuration/config.properties");
		
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			
		}
		catch (FileNotFoundException e)
		{	
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}	
	}
	
	public String getChromePath()
	{
		String chrome_location= pro.getProperty("Chrome_Path");
		
		return chrome_location;
		
	}
	
	public String getIEPath()
	{
		String IE_path= pro.getProperty("IE_Path");
		
		return IE_path;
	}
	
	public String getUrl()
	{
		
		String Login_Url=pro.getProperty("URL");
		
		return Login_Url;
	}
	
	public String getfbUrl()
	{
		String FB_Url=pro.getProperty("FB_URL");
		return FB_Url;
	}
	
	public String getTwitterUrl()
	{
		String Tw_Url=pro.getProperty("Twitter_URL");
		return Tw_Url;
	}
	
	public String getGmailUrl()
	{
		String Gm_Url=pro.getProperty("Gmail_URL");
		return Gm_Url;
	}

}
