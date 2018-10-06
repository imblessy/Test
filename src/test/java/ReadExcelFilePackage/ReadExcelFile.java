package ReadExcelFilePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;*/

public class ReadExcelFile {
	public Sheet  readExcel(String FilePath,String FileName,String SheetName) throws IOException
	{
		File file = new File(FilePath +"\\"+ FileName);
		FileInputStream InputStream = new FileInputStream(file);
		Workbook XLWorkbook = null;
		String fileExtensionName = FileName.substring(FileName.indexOf("."));
			if(fileExtensionName.equals(".xlsx"))
			{
				XLWorkbook = new XSSFWorkbook(InputStream);
			}else if(fileExtensionName.equals(".xls"))
			{
				XLWorkbook = new HSSFWorkbook(InputStream);
			}
			Sheet XLSheet = XLWorkbook.getSheet(SheetName);
			
		return XLSheet;
	}
	
	public String DataInCell(String FilePath,String FileName,String SheetName,int row, int column) throws IOException
	{
		DataFormatter formatter = new DataFormatter();
		
		String DataInCell = formatter.formatCellValue(readExcel( FilePath, FileName, SheetName).getRow(row).getCell(column));
		return DataInCell;
	}
	
	public int getRowCount(String FilePath,String FileName,String SheetName) throws IOException
	{
		int row = readExcel(FilePath, FileName, SheetName).getLastRowNum();	
		row = row+1;
		return row;
	}

	public int getColumnCount(String FilePath,String FileName,String SheetName,int row) throws IOException
	{
		int Column = readExcel( FilePath, FileName, SheetName).getRow(row).getLastCellNum();	
		Column = Column+1;
		return Column;
	}

	}


