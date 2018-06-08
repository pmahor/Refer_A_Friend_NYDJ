package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	

	XSSFWorkbook wb;
	XSSFSheet wbs1;
	
	
	public ReadExcel()
	{
		File src = new File("./Application Testdata/test_data.xlsx");
		
		try {
			
				FileInputStream fis= new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
				
				wbs1= wb.getSheetAt(0);
			} 
		catch (FileNotFoundException e)
		{
		    System.out.println("Excel File Not Found...Check the location");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Exception while loading Sheet");
			e.printStackTrace();
		}
				
	}
	
	public String getStringData(int row,int column)
	{
		String data=wbs1.getRow(row).getCell(column).getStringCellValue();
		return data;
  
	}

}
