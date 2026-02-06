package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;


import Common.Tab;

public class CreatAccountTest extends TestBase{

	@Test
	public void TC07() {
		
		System.out.println("TC07 - User can't create account with an already in-use email");
		
		System.out.println("Pre-condition: an actived account is existing");
		
		System.out.println("Step 1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("Step 2. Click on \"Register\" tab");
		homePage.gotoPage(Tab.REGISTER);
		
		registerPage.register(Constant.USERNAME, Constant.PASSWORD, Constant.PASSWORD, "12345678");
		
		String actualErrorMsg = registerPage.getRegisterErrorMsg();
		String expectedErrorMsg = "This email address is already in use.";
		
		System.out.println("Error message \"This email address is already in use.\" displays above the form.");
		Assert.assertEquals(actualErrorMsg,expectedErrorMsg,"Error message for 'Email address already in use' is not displayed correctly!");
	
		
	}
	
	@Test
	public void TC08() {
		System.out.println("TC08 - User can't create account while password and PID fields are empty");
				
		System.out.println("Step 1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("Step 2. Click on Register tab");
		homePage.gotoPage(Tab.REGISTER);
		
		System.out.println("Step 3. Enter valid email address and leave other fields empty");
		registerPage.register(Constant.USERNAME,"", "", "");
		
		String actualErrorMsg1 = registerPage.getRegisterErrorMsg();
		String expectedErrorMsg1 = "There're errors in the form. Please correct the errors and try again.";
		
		String actualErrorMsg2 = registerPage.getPasswordErrorMsg();
		String expectedErrorMsg2 = "Invalid password length";
		
		String actualErrorMsg3 = registerPage.getPidErrorMsg();
		String expectedErrorMsg3 = "Invalid ID length";
		
		System.out.println("Message \"There're errors in the form. Please correct the errors and try again.\" appears above the form.");
		Assert.assertEquals(actualErrorMsg1, expectedErrorMsg1, "General registration error message is not displayed correctly!");
		
		System.out.println("Next to password fields, error message \"Invalid password length.\" displays");
		Assert.assertEquals(actualErrorMsg2, expectedErrorMsg2, "Password validation error message is not displayed correctly!");
		
		System.out.println("Next to PID field, error message \"Invalid ID length.\" displays");
		Assert.assertEquals(actualErrorMsg3, expectedErrorMsg3, "PID validation error message is not displayed correctly!");
		
	}
	
}
