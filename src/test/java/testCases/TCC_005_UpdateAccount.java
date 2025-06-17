package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountInfoPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TCC_005_UpdateAccount extends BaseClass {

	@Test
	public void verify_account_updation() {
		logger.info("*** Starting TCC_005_UpdateAccount ****");

		try {
			HomePage hp = new HomePage(driver);

			hp.clickMyaccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail("frank.wilson@example.com");
			lp.setPassword("{!](qQo]");

			lp.clickSubmit();

			MyAccountPage mAcct = new MyAccountPage(driver);
			mAcct.clkEditAcct();

			MyAccountInfoPage acctInfo = new MyAccountInfoPage(driver);
			// acctInfo.setFirstName(null);
			// acctInfo.setLastName(null);
			// acctInfo.setEmail(null);
			acctInfo.setPhoneNumber("8959854085");

			acctInfo.clkSubmit();

			String SuccessMsg = acctInfo.getSuccessMsg();

			if (SuccessMsg.contains("Success: Your account has been successfully updated.")) {
				Assert.assertTrue(true);
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
