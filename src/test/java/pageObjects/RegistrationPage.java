package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePageObjectClass
{	
    //constructor
	public RegistrationPage(WebDriver driver)
	{
		super(driver);		
	}	

	//Locators

	@FindBy(xpath=("//input[@id='input-firstname']")) WebElement txt_firstname;
	@FindBy(xpath=("//input[@id='input-lastname']")) WebElement txt_lasttname;
	@FindBy(xpath=("//input[@id='input-email']")) WebElement txt_email;
	@FindBy(xpath=("//input[@id='input-telephone']")) WebElement txt_phonenum;
	@FindBy(xpath=("//input[@id='input-password']")) WebElement txt_password;
	@FindBy(xpath=("//input[@id='input-confirm']")) WebElement txt_confirmpassword;
	@FindBy(xpath=("//input[@type='checkbox']")) WebElement chkbox_confirm;
	@FindBy(xpath=("//input[@type='submit']")) WebElement btn_continue;
	@FindBy(xpath=("//h1[text()='Your Account Has Been Created!']")) WebElement Status_msg;
	
	//Action Methods
	
	public void SetFirstName(String fname)
	{
		txt_firstname.sendKeys(fname);
	}

	public void SetLastName(String lname)
	{
		txt_lasttname.sendKeys(lname);
	}
	
	public void SetEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void SetPhonenum(String phnum)
	{
		txt_phonenum.sendKeys(phnum);
	}
	
	public void SetPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void SetConformpwd(String pwd)
	{
		txt_confirmpassword.sendKeys(pwd);
	}
	
	public void Setprivacypolicy()
	{
		chkbox_confirm.click();
	}
	
	public void Clickcontinuebtn()
	{
		btn_continue.click();
	}
	
	public String getconfirmationmsg()
	{
		try
		{
			return (Status_msg.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
}
