package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement btnLogout;
	
	@FindBy(xpath = "//div[@id='content']//ul[@class='list-unstyled']/li[1]/*[normalize-space()='Edit your account information']")
	WebElement lnkEditAcct;
	
	@FindBy(xpath="//div[@class='list-group']/a[contains(text(),'Address Book')]")
	WebElement btnAddressBook;
	
	
	public boolean isMyAccountPageExists() {
		try {
		return (msgHeading.isDisplayed());
		}
		catch(Exception e){
			return false;
		}
		
	}
	
	public void clklogout() {
		btnLogout.click();
	}
	
	public void clkEditAcct() {
		lnkEditAcct.click();
	}
	
	public void clkAddressBook() {
		btnAddressBook.click();
	}
	
	

}
