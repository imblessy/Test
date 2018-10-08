package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Operation.LoginPage;
import ReadExcelFilePackage.ReadExcelFile;


public class DriverWorkflow {
	WebDriver driver;
	LoginPage objLogin; 


  @BeforeTest	
  public void setUp() {

	  System.setProperty("webdriver.chrome.driver", "D:/Softwares1/Softwares/ChromeDriver2/chromedriver.exe");
	  
	  driver = new ChromeDriver();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("http://192.168.1.211:4568");
      driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
  }

  @Test(priority = 0,dataProvider = "safetyfirstdata")
  
  public void Login(String LoginUsername, String LoginPassword)throws InterruptedException, FileNotFoundException, IOException
  {
	  objLogin =  new LoginPage(driver);

	  objLogin.LogintoApplication( LoginUsername, LoginPassword);
	  
  }
  @AfterTest
  public void afterTest() {
  }

 @DataProvider(name = "safetyfirstdata")
 public Object[][] passData() throws IOException
 {
	 ReadExcelFile ReadExcelFile = new ReadExcelFile();
	 int rows =ReadExcelFile.getRowCount("D:\\SafetyFirst", "SafetyFirstData_eclipse.xlsx", "Safety_First_Data");
	
	 Object[][]Data =null;
	 for(int i=1; i<rows;i++)
	 {
	 int columns =ReadExcelFile.getColumnCount("D:\\SafetyFirst", "SafetyFirstData_eclipse.xlsx", "Safety_First_Data",i);
	
		 Data = new Object[rows-1][columns-1];
		 
		 for(int j=0;j<columns-1;j++)
		 {
			 
		 Data[i-1][j]=ReadExcelFile.DataInCell("D:\\SafetyFirst","SafetyFirstData_eclipse.xlsx", "Safety_First_Data", i, j);
		 
		 }
		
	 }
	return Data;
	
	 
 }
}
