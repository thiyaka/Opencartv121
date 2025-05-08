package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	/*Data is valid  - login success - test pass  - logout
	Data is valid -- login failed - test fail

	Data is invalid - login success - test fail  - logout
	Data is invalid -- login failed - test pass
	*/
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String password, String res) {
		
		logger.info("*** Starting verify_loginDDT ***");
		
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickSubmit();
		
		MyAccountPage myAccPage= new MyAccountPage(driver);
		boolean targetpage= myAccPage.isMyAccountPageExists();
		
		if(res.equalsIgnoreCase("valid")) {
			
			if(targetpage=true) {
				myAccPage.clklogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		if(res.equalsIgnoreCase("invalid")) {
			if(targetpage= true) {
				myAccPage.clklogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		finally {
			logger.info("**** Finished TC_003_LoginDDT *****");
		}
	}

}
