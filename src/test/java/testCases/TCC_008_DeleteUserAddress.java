package testCases;

import java.lang.foreign.AddressLayout;

import org.testng.annotations.Test;

import pageObjects.AddressBookPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountInfoPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TCC_008_DeleteUserAddress extends BaseClass {

	@Test
	public void verify_delete_UserAddress() {
		
		HomePage hp= new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail("frank.wilson@example.com");
		lp.setPassword("{!](qQo]");
		lp.clickSubmit();
		
		MyAccountPage acctpage = new MyAccountPage(driver);
		acctpage.clkEditAddress();
		
		AddressBookPage addressBk= new AddressBookPage(driver);
		
		addressBk.clkDeleteAddress();
		
		
	}
}
