package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Tab;
import Common.Random;
import Constant.Constant;

public class LoginTest extends TestBase{

	@Test
	public void TC01() {
		System.out.println("TC01 - User can log into Railway with valid username and password");

		System.out.println("Step 1. Navigate to QA Railway Website");
		homePage.open();

		System.out.println("Step 2. Click on \"Login\" tab");
		homePage.gotoPage(Tab.LOGIN);

		System.out.println("Step 3. Enter valid Email and Password.");
		System.out.println("Step 4. Click on \"Login\" button.");

		String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
		String expectedMsg = "Welcome " + Constant.USERNAME;
		
		System.out.println("EB: User is logged into Railway. Welcome user message is displayed.");
		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
	}
	
	@Test
	public void TC02() {
		System.out.println("TC02 - User cannot login with blank \"Username\" textbox");
		
		System.out.println("Step 1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("Step 2. Click on \"Login\" tab");
		homePage.gotoPage(Tab.LOGIN);
		
		System.out.println("Step 3: Leave 'Username' textbox blank and enter a valid password.");
		System.out.println("Step 4: Click on 'Login' button.");
		loginPage.login("",Constant.PASSWORD);
		
		String actualErrorMsg = loginPage.getLoginErrorMsg();
		
		String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
		
		System.out.println("User can't login and message \"There was a problem with your login and/or errors exist in your form. \" appears.");
		Assert.assertEquals(actualErrorMsg,expectedErrorMsg,"Error message for blank username is not displayed correctly!");
		
	}
	
	@Test
	public void TC03() {
		System.out.println("TC03 - User cannot log into Railway with invalid password");
		
		System.out.println("Step 1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("Step 2. Click on \"Login\" tab");
		homePage.gotoPage(Tab.LOGIN);
		
		System.out.println("Step 3. Enter valid Email and invalid Password");
		System.out.println("Step 4. Click on \"Login\" button");

		String invalidPassword = Random.getRandomPassword();
		
		loginPage.login(Constant.USERNAME, invalidPassword);
		
		String actualErrorMsg = loginPage.getLoginErrorMsg();	
		String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";

		System.out.println("Error message \"There was a problem with your login and/or errors exist in your form.\" is displayed");
		Assert.assertEquals(actualErrorMsg,expectedErrorMsg,"Error message for invalid password is not displayed correctly!");

	}
	
	@Test
	public void TC04() {
		System.out.println("TC04 - System shows message when user enters wrong password many times");

		System.out.println("Step 1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("Step 2. Click on \"Login\" tab");
		homePage.gotoPage(Tab.LOGIN);
		
		System.out.println("Step 3. Enter valid information into \"Username\" textbox except \"Password\" textbox.");
		System.out.println("Step 4. Click on \"Login\" button");
		
		String invalidPassword = Random.getRandomPassword();
		
		loginPage.login(Constant.USERNAME, invalidPassword);
		
		String actualErrorMsg1 = loginPage.getLoginErrorMsg();	
		String expectedErrorMsg1 = "Invalid username or password. Please try again.";
		
		System.out.println("\"Invalid username or password. Please try again\" is shown");
		Assert.assertEquals(actualErrorMsg1,expectedErrorMsg1,"Error message for invalid password is not displayed correctly!");

		System.out.println("Step 5. Repeat step 3 and 4 three more times.");
		
		for(int i=1;i<=3;i++) {
			
			loginPage.login(Constant.USERNAME, Random.getRandomPassword());
		}
		
		String actualErrorMsg4 = loginPage.getLoginErrorMsg();	
		String expectedErrorMsg4 = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		
		System.out.println("User can't login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.");
		Assert.assertEquals(actualErrorMsg4,expectedErrorMsg4,"Error message for invalid password is not displayed correctly!");

	}
	
	@Test
	public void TC05() {
		System.out.println("TC05 - User can't login with an account hasn't been activated");
		
		System.out.println("Step 1. Navigate to QA Railway Website");
		homePage.open();
		
		System.out.println("Pre-condition: a not-active account is existing");
		
		homePage.gotoPage(Tab.REGISTER);
		
		String email = Random.getRandomEmail();
		String password = Random.getRandomPassword();
		
		registerPage.register(email, password, password, "12345678");
		
		System.out.println("Step 2. Click on \"Login\" tab");
		homePage.gotoPage(Tab.LOGIN);
		
		loginPage.login(email, password);
		
		String actualErrorMsg = loginPage.getLoginErrorMsg();	
		String expectedErrorMsg = "Invalid username or password. Please try again.";

		System.out.println("User can't login and message \"Invalid username or password. Please try again.\" appears.");
		Assert.assertEquals(actualErrorMsg,expectedErrorMsg,"Error message for invalid password is not displayed correctly!");


	}
	
	
	
	
}
