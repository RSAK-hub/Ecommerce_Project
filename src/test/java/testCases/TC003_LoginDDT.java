package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends Baseclass{


	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email, String password, String exp) throws InterruptedException
	{
		try {
	
		//Home page
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin(); //Login link under MyAccount
				
			//Login page
			LoginPage lp=new LoginPage(driver);
			lp.Setemailaddress(email);
			lp.Setpassword(password);
			lp.ClickLogin(); //Login button
				
			//My Account Page
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExists();
			System.out.println(targetPage); //myreference
			
			/*	Data is valid  - login success - test pass  - logout
			Data is valid -- login failed - test fail

			Data is invalid - login success - test fail  - logout
			Data is invalid -- login failed - test pass
		*/	
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					macc.clicklogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					macc.clicklogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");
	
	
}
}