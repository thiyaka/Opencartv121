package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddressBookPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TCC_007_EditUserAddress extends BaseClass {

	@Test
	public void verify_editAddress() {

		try {
		HomePage hp = new HomePage(driver);

		hp.clickMyaccount();
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);

		lp.setEmail("frank.wilson@example.com");
		lp.setPassword("{!](qQo]");
		lp.clickSubmit();

		MyAccountPage acctPage = new MyAccountPage(driver);

		acctPage.clkEditAddress();

		AddressBookPage addressBook = new AddressBookPage(driver);
		addressBook.clkEditAddress();
		addressBook.setCity("Muthupet");

		addressBook.clkContinue();

		String successMsg = addressBook.getSuccessmsg();
		System.out.println("*****************"+successMsg);

	/*	if (successMsg.equalsIgnoreCase("Your address has been successfully added")) {
			Assert.assertTrue(true);
		} else {
			logger.info("Test Failed");
			logger.debug("Debug logs......");
			Assert.assertTrue(false);
		}*/
		}catch(Exception e) {
			Assert.fail();
		}finally {
			
			logger.info("***** Finished TCC_007_EditUserAddress ***");
		}
	}
}
