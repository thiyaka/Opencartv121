package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups={"regression","master"})
	public void verify_Login() {
		
		logger.info("*** Starting TC_002_LoginTest ***");
		try {
		HomePage hp= new HomePage(driver);
		logger.info("Inside HomePage");
		hp.clickMyaccount();
		hp.clickLogin();

		LoginPage lp= new LoginPage(driver);
		logger.info("Inside Login Page");
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickSubmit();
		
		
		MyAccountPage mac= new MyAccountPage(driver);
		logger.info("Login Successful");
		logger.info("Inside MyAccountPage");
		boolean targetPage= mac.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);     //Assert.assertEquals(targetPage,true, "Login failed");
		}catch(Exception e) {
			Assert.fail();
		}
	
		finally{
		logger.info("*** Finished TC_002_LoginTest ***");
		}
		
	}
	
}
