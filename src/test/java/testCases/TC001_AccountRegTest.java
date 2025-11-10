package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base.Baseclass;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class TC001_AccountRegTest extends Baseclass
{	
	@Test(groups={"Master","Regression"})
	public void verify_account_reg() 
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		
		try
		{
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link.. ");
		
		RegistrationPage rp= new RegistrationPage(driver);
		
		logger.info("Providing customer details...");
		rp.SetFirstName(randomString().toUpperCase());
		rp.SetLastName(randomString().toUpperCase());
		rp.SetEmail(randomString()+"@gmail.com");
		rp.SetPhonenum(randomnumber());
		
		String password= randomAlphanumneric();
		rp.SetPassword(password);
		rp.SetConformpwd(password);
		
		rp.Setprivacypolicy();
		rp.Clickcontinuebtn();
		
		logger.info("Validating expected message..");
		String confmsg=rp.getconfirmationmsg();
		System.out.println(confmsg); //myreference
	
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed..");
			logger.debug("log errors...");
			Assert.assertTrue(false);
		} 
		logger.info("Test passed");
	}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");	
		
		catch(Exception e)
		{
		//	logger.error("Test failed: " +e.getMessage());
		//	Assert.fail("Test failed: " +e.getMessage());
			Assert.fail();
		}
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	}
		
	}
	
	
	
	
	
	
	
	
	

