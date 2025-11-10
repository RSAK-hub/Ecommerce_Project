package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends Baseclass{

	@Test(groups={"Master","Sanity"})
	public void verifylogintest()
	{
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.Setemailaddress(p.getProperty("webemail"));
		lp.Setpassword(p.getProperty("webpassword"));
		lp.ClickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean confmsg1=macc.isMyAccountPageExists();
		System.out.println(confmsg1); //myreference
		
		Assert.assertEquals(confmsg1, true,"Login failed");
		macc.clicklogout();
	//	macc.clickcontinue();
		} 

		catch(Exception e)
		{
		Assert.fail();
		}
		
	
	
	}}
