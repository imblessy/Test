package Operation;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  Properties p;
	WebDriver driver;
	
	@FindBy(name = "Username")
	WebElement Username;
	
	@FindBy(id ="txtPassword")
	WebElement Password;
	
	@FindBy(id = "btnLogin")
	WebElement LoginButton;
	
	@FindBy(id = "logoff")
	WebElement LogOffButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	
	public void LogintoApplication(String strUsername,String strPassword)
	{
		
		Username.sendKeys(strUsername);
		Password.sendKeys(strPassword);
		LoginButton.click();
	}
}
