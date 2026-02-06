package Railway;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;
import DataObjects.User;
import Constant.RegisterField;


public class RegisterPage extends GeneralPage{

	// Locators
	
	private final By btnRegister = By.xpath("//input[@value='Register']");
	private final By lblRegisterErrorMsg = By.xpath("//p[@class=\"message error\"]");
	private final By lblPasswordErrorMsg = By.xpath("//label[@class='validation-error'and@for='password']");
	private final By lblPidErrorMsg = By.xpath("//label[@class='validation-error'and@for='pid']");

	private String registerXpath = "//input[@id='%s']";
	
	// Elements
	
	public String getPasswordErrorMsg() {
	    return Constant.WEBDRIVER.findElement(lblPasswordErrorMsg).getText();
	}

	public String getPidErrorMsg() {
	    return Constant.WEBDRIVER.findElement(lblPidErrorMsg).getText();
	}

	public String getRegisterErrorMsg() {
	    return Constant.WEBDRIVER.findElement(lblRegisterErrorMsg).getText();
	}
	
	protected By getFieldLocator(RegisterField register) {
		String xpath = String.format(registerXpath, register.getId());
		return By.xpath(xpath);
	}
	
	// Methods
	public void register(User user) {

		Utilities.safeSendKeys(getFieldLocator(RegisterField.EMAIL),user.getEmail());
		Utilities.safeSendKeys(getFieldLocator(RegisterField.PASSWORD),user.getPassword());
		Utilities.safeSendKeys(getFieldLocator(RegisterField.CONFIRM_PASSWORD),user.getConfirmPassword());
		Utilities.safeSendKeys(getFieldLocator(RegisterField.PID),user.getPid());
		Utilities.safeClick(btnRegister);	
		
	}
}
