package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePageObjectClass{

	   //constructor
		public MyAccountPage(WebDriver driver)
		{
			super(driver);		
		}	
		
		//Locators
		
		@FindBy(xpath=("//h2[text()='My Account']")) WebElement msgHeading;  // MyAccount Page heading
		
		@FindBy(xpath=("//a[@class][text()='Logout']")) WebElement lnkLogout;  //Logout
		
		
	//	@FindBy(xpath=("//a[text()='Continue']")) WebElement lnkContinue; //click continue button after logout
		
		//Actions
		
		public boolean isMyAccountPageExists()   // MyAccount Page heading display status
		{
			try
			{
				return(msgHeading.isDisplayed());
			}
			catch(Exception e)
			{
				return (false);
			}		
		}
		
		public void clicklogout()
		{
			lnkLogout.click();
		}
		
	/*	public void clickcontinue()
		{
			lnkContinue.click();
		} */
}
