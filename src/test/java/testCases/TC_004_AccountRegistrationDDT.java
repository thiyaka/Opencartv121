package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders_Registration;

public class TC_004_AccountRegistrationDDT extends BaseClass {

	@Test(dataProvider = "RegisterData", dataProviderClass = DataProviders_Registration.class)
	public void verify_account_registration_DDT(String fname, String lname, String email, String phno, String psw,
			String cnfPsw) {

		logger.info("*** Starting TC_001_AccountRegistrationTest ****");
		// logger.debug("This is a debug log message");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			logger.info("Cliked on Myaccount");

			hp.clickRegister();
			logger.info("Cliked on Register");

			AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);

			logger.info("Providing customer details");

			registrationPage.setFirstName(fname);
			registrationPage.setLastName(lname);
			registrationPage.setEmail(email);
			registrationPage.setPhoneNumber(phno);

			// String password= randomAlphaNumeric();
			registrationPage.setPassword(psw);
			registrationPage.setConfirmPassword(cnfPsw);
			registrationPage.setPrivacyPolicy();
			registrationPage.clickcontinue();

			logger.info("Validation message");
			String confmsg = registrationPage.getConfirmationMsg();
			String warnmsg = registrationPage.getWarningMsg();

			MyAccountPage mypage = new MyAccountPage(driver);

			if (warnmsg.equalsIgnoreCase("E-Mail Address is already registered")) {
				logger.info("Test Failed E-mail already Exist");
				Assert.assertTrue(false);
				mypage.clklogout();
			} else if (confmsg.equals("Your Account Has Been Created!")) {
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
			logger.info("***** Finished TC_004_AccountRegistrationDDT *****");

		}
	}

}
