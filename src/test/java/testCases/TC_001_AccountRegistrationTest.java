package testCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "sanity", "master" })
	public void verify_account_registration() {

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

			registrationPage.setFirstName(randomString().toUpperCase());
			registrationPage.setLastName(randomString().toUpperCase());
			registrationPage.setEmail(randomString() + "@gmail.com");
			registrationPage.setPhoneNumber(randomNumber());

			String password = randomAlphaNumeric();
			registrationPage.setPassword(password);
			registrationPage.setConfirmPassword(password);
			registrationPage.setPrivacyPolicy();
			registrationPage.clickcontinue();

			logger.info("Validation message");
			String confmsg = registrationPage.getConfirmationMsg();

			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.info("Test Failed");
				logger.debug("Debug logs......");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.fail();
		} finally {
			logger.info("***** Finished TC001_AccountRegistrationTest *****");

		}
	}

}
