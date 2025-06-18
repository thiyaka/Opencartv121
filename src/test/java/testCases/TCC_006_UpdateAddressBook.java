package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddressBookPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TCC_006_UpdateAddressBook extends BaseClass {

	@Test
	public void verify_Address_update() {

		logger.info("*** Starting TCC_005_UpdateAccount ****");

		try {
			HomePage hp = new HomePage(driver);

			hp.clickMyaccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail("frank.wilson@example.com"); // frank.wilson@example.com

			lp.setPassword("{!](qQo]");// {!](qQo]
			lp.clickSubmit();

			MyAccountPage acctPage = new MyAccountPage(driver);
			acctPage.clkAddressBook();

			AddressBookPage addressBook = new AddressBookPage(driver);
			addressBook.clkNewAddress();
			addressBook.setFirstName("Hari");
			addressBook.setLastName("Batman");
			addressBook.setCompanyName("Bruceveynce");
			addressBook.setAddress("Dark");
			addressBook.setCity("Gotham");

			// dropdown
			addressBook.selectCountry("India");
			addressBook.selectZone("Tamil Nadu");

			// radiobtn

			addressBook.selectDefaultAddress("Yes");

			addressBook.clkContinue();

			String successMsg = addressBook.getSuccessmsg();

			if (successMsg.equalsIgnoreCase("Your address has been successfully added")) {
				Assert.assertTrue(true);
			} else {
				logger.info("Test Failed");
				logger.debug("Debug logs......");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			
			Assert.fail();
		} finally {
			logger.info("***** Finished TCC_006_UpdateAddressBook ***");
		}

	}

}
