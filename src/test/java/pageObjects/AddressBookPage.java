package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressBookPage extends BasePage {

	public AddressBookPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='pull-right']/a[contains(text(),'New Address')]")
	WebElement btnNewAddress;

	@FindBy(xpath = "//*[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//*[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//*[@id='input-company']")
	WebElement txtCompany;

	@FindBy(xpath = "//*[@id='input-address-1']")
	WebElement txtAddress1;

	@FindBy(xpath = "//*[@id='input-city']")
	WebElement txtCity;

	@FindBy(xpath = "//*[@id='input-postcode']")
	WebElement txtPostcode;

	@FindBy(xpath = "//*[@id='input-country']")
	WebElement dpCountry;

	@FindBy(xpath = "//*[@id='input-zone']")
	WebElement dpZone;

	@FindBy(xpath = "//div[@class='col-sm-10']/label[1]/input")
	WebElement yesRadio;

	@FindBy(xpath = "//div[@class='col-sm-10']/label[2]/input")
	WebElement noRadio;

	@FindBy(xpath = "//div[@class='pull-right']/input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//*[normalize-space()='Your address has been successfully added']")
	WebElement successMsg;
	
	@FindBy(xpath="//a[contains(text(),'Edit')]/ancestor::div[@id='content']/div/table/tbody/tr/td[contains(text(),'Hari')]/following-sibling::td/a[contains(text(),'Edit')]")
	WebElement btnEditAddress;
	
	
	public void clkNewAddress() {
		btnNewAddress.click();
	}

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setCompanyName(String company) {
		txtCompany.sendKeys(company);
	}

	public void setAddress(String address) {
		txtAddress1.sendKeys(address);
	}

	public void setCity(String city) {
		txtCity.clear();
		txtCity.sendKeys(city);
	}

	public void setPostcod(String pcode) {
		txtPostcode.sendKeys(pcode);
	}

	public void selectCountry(String country) {

		Select select = new Select(dpCountry);

		select.selectByVisibleText(country);
	}

	public void selectZone(String zone) {

		Select select = new Select(dpZone);

		select.selectByVisibleText(zone);
	}

	public void selectDefaultAddress(String option) {

		if (option.equalsIgnoreCase("yes") && !yesRadio.isSelected()) {
			yesRadio.click();
		} else if (option.equalsIgnoreCase("no") && !noRadio.isSelected()) {
			noRadio.click();
		}
	}

	public void clkContinue() {

		btnContinue.click();
	}

	public String getSuccessmsg() {

		try {
		//	return (successMsg.getText());
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) successMsg));
			
			return(successMsg.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}
	
	public void clkEditAddress() {
		
		btnEditAddress.click();
	}

}
