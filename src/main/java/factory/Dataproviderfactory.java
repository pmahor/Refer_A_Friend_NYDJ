package factory;

import dataprovider.ReadConfig;
import dataprovider.ReadExcel;

public class Dataproviderfactory {
	
	static ReadConfig config;
	static ReadExcel excelr;
	
	public static ReadConfig getConfig()
	{
		config = new ReadConfig();
		
		return config;	
	}
	
	public static ReadExcel getExceldata()
	{
		excelr= new ReadExcel();
		
		return excelr;
		
	}


}
