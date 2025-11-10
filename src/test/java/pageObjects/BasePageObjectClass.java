package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageObjectClass {	
	//this class is only for initiating driver using constructor	
	WebDriver driver;
	
	BasePageObjectClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}	
}
