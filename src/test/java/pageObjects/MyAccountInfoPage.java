package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountInfoPage extends BasePage {

	public MyAccountInfoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//*[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//*[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//*[@id='input-telephone']")
	WebElement txtPhoneNumber;

	@FindBy(xpath = "//*[@class='btn btn-primary']")
	WebElement btnSubmit;

	@FindBy(xpath = "//*[normalize-space()='Success: Your account has been successfully updated.']")
	WebElement successMsg;
	

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPhoneNumber(String phno) {
		txtPhoneNumber.clear();
		txtPhoneNumber.sendKeys(phno);

	}
	
	public void clkSubmit() {
		btnSubmit.click();
	}
	
	public String getSuccessMsg() {
		try {
			return (successMsg.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}
}
