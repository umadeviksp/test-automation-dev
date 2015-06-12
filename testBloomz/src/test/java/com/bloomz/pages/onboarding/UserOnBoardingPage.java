package com.bloomz.pages.onboarding;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.bloomz.pages.BasePage;

public class UserOnBoardingPage extends BasePage {

	By pageTitleLocator = By.id("net.bloomz:id/txtHeading");
	By firstNameEditTextLocator = By.id("net.bloomz:id/editFirstNameValue");
	By lastNameEditTextLocator = By.id("net.bloomz:id/editLastNameValue");
	By emailEditTextLocator = By.id("net.bloomz:id/editEmailValue");
	By passwordEditTextLocator = By.id("net.bloomz:id/editPassword");
	By zipCodeEditTextLocator = By.id("net.bloomz:id/editZipValue");
	By signUpButtonLocator = By.id("net.bloomz:id/btnSignUp");
	By termsLinkLocator = By.id("net.bloomz:id/txtterms");
	By cancelButtonLocator = By.id("net.bloomz:id/CancelBtn");

	public UserOnBoardingPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * On board user.
	 *
	 * @param userType the user type
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param emailId the email id
	 * @param password the password
	 * @param zipCode the zip code
	 * @return the user on boarding flow
	 */
	public UserOnBoardingFlow onBoardUser(String userType, String firstName,
			String lastName, String emailId, String password, String zipCode) {
		Assert.assertTrue(getText(pageTitleLocator).equals(userType),
				"Current page is not " + userType + " onboarding page, Its "
						+ getText(pageTitleLocator) + " onboarding page");
		sendText(firstNameEditTextLocator, firstName);
		sendText(lastNameEditTextLocator, lastName);
		sendText(emailEditTextLocator, emailId);
		sendText(passwordEditTextLocator, password);
		sendText(zipCodeEditTextLocator, zipCode);
		clickBack();
		click(signUpButtonLocator);
		return new UserOnBoardingFlow(appiumDriver);

	}
}
