package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageObjectClass  
{	
    //constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);		
	}	
	
	//Locators
	
	@FindBy(xpath=("//input[@id='input-email']"))
	WebElement txtEmailAddress;
	
	@FindBy(xpath=("//input[@id='input-password']"))
	WebElement txtPassword;;
	
	@FindBy(xpath=("//input[@type='submit']"))
	WebElement btnlogin;
	
	//Actions
	
	public void Setemailaddress(String email) 
	{
		txtEmailAddress.sendKeys(email);
	}
	
	public void Setpassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void ClickLogin() 
	{
		btnlogin.click();
	}
	
}
