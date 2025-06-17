package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountInfoPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TCC_005_UpdateAccount extends BaseClass {

	@Test(dataProvider = "LoginData" , dataProviderClass = DataProviders.class)
	public void verify_account_updation(String email, String psw) {
		logger.info("*** Starting TCC_005_UpdateAccount ****");

		try {
			HomePage hp = new HomePage(driver);

			hp.clickMyaccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(psw);

			lp.clickSubmit();

			MyAccountPage mypage = new MyAccountPage(driver);
			mypage.clkEditAcct();

			MyAccountInfoPage acctInfo = new MyAccountInfoPage(driver);
			// acctInfo.setFirstName(null);
			// acctInfo.setLastName(null);
			// acctInfo.setEmail(null);
			acctInfo.setPhoneNumber(randomNumber());

			acctInfo.clkSubmit();

			String SuccessMsg = acctInfo.getSuccessMsg();

			if (SuccessMsg.contains("Success: Your account has been successfully updated.")) {
				Assert.assertTrue(true);
				mypage.clklogout();
				
			} else {
				logger.info("Test Failed");
				logger.debug("Debug logs......");
				Assert.assertTrue(false);

			}
		} catch (Exception e) {
			Assert.fail();
		} finally {
			logger.info("***** Finished TCC_005_UpdateAccount ***");
		}
	}
}
