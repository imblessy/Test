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
	
	@FindBy(id ="userName")
	WebElement Username;
	
	@FindBy(id ="password")
	WebElement Password;
	
	@FindBy(css = ".btn.btn-login")
	WebElement LoginButton;
	
	@FindBy(id = "logoff")
	WebElement LogOffButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	public void ClickLogOffButton()
	{
		LogOffButton.click();
	}
	
	public void LogintoApplication(String strUsername,String strPassword)
	{
		
		Username.sendKeys(strUsername);
		Password.sendKeys(strPassword);
		LoginButton.click();
	}
}
