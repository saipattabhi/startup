package ExcelDataConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceldata {
	
	XSSFWorkbook wb;
	XSSFSheet Sheet1;
	public exceldata(String Excelpath) throws FileNotFoundException
	{
		File src=new File(Excelpath);
		
		FileInputStream fis=new FileInputStream(src);
		try {
			 wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public String getexcelData(int sheetno,int row,int column)
	{
		 Sheet1=wb.getSheetAt(sheetno);
		
	String data = Sheet1.getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}
	
  public int getRowCount(int sheetindex)
  {
	int row = wb.getSheetAt(sheetindex).getLastRowNum();
	row=   row+1;
	return row;
	
  }
}
