package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidSignUpPage;
import com.net.bloomz.pages.interfaces.SignUpPageActions;
import com.net.bloomz.pages.web.WebSignUpPage;

public class SignUpPage extends BasePage implements SignUpPageActions {

	static By pageTitleLocator;
	static By firstNameEditTextLocator;
	static By lastNameEditTextLocator;
	static By emailEditTextLocator;
	static By passwordEditTextLocator;
	static By signUpButtonLocator;
	static By signUpSheetLocator;
	static By termsLinkLocator;
	static By backButtonLocator;
	static By roomParentButtonLocator;

	public SignUpPage(Browser<?> browser) {
		super(browser);
	}

	public static SignUpPage getSignUpPage(Browser<?> browser) {
		String string = browser.toString();
//		System.out.println(string);
		if (string.contains("AndroidMobile")) {

			firstNameEditTextLocator 	= By.id("net.bloomz:id/editFirstNameValue");
			lastNameEditTextLocator 	= By.id("net.bloomz:id/editLastNameValue");
			emailEditTextLocator 		= By.id("net.bloomz:id/editEmailValue");
			passwordEditTextLocator 	= By.id("net.bloomz:id/editPassword");
			signUpButtonLocator 		= By.id("net.bloomz:id/btnSignUp");
			termsLinkLocator 			= By.id("net.bloomz:id/txtterms");
			backButtonLocator 			= By.id("net.bloomz:id/backarrow");

//			roomParentButtonLocator = By.xpath("//android.widget.RadioButton[@text='I\'m a Room Parent']");
			roomParentButtonLocator = By.xpath("//android.widget.RadioButton[contains(@text,'a Room Parent')]");

			signUpSheetLocator = By.id("net.bloomz:id/btnStart");
			
			return new AndroidSignUpPage(browser);
		} else if (string.contains(".iOS")) {
		} else {
			pageTitleLocator = By.xpath("//*[@class=\"forceTruncate ng-binding\"]");
			firstNameEditTextLocator = By.id("signup_firstName");
			lastNameEditTextLocator = By.id("signup_lastName");
			emailEditTextLocator = By.id("signup_email");
			passwordEditTextLocator = By.id("signup_password");
			signUpButtonLocator = By.xpath("//*[@ng-click=\"verifyAndSignUp(signup)\"]");
			//Nov-5-2017 events locator changed
			//signUpSheetLocator = By.xpath("//*[@id='volunteer_addEventQuickLink']");
			signUpSheetLocator = By.xpath("//*[@id='volunteer']//*[@ng-repeat='event in calendarFeed.collection']");
			termsLinkLocator = By.xpath("//*[@ng-click=\"$emit('showAddToStack-terms');\"]");
			backButtonLocator = By.xpath("//*[@ ng-click=\"leftButtonClickCallback()\"]");
			roomParentButtonLocator = By.xpath("//*[@id=\"signUpScreen\"]/div/div/form/div[2]/section/div/div[2]");
			return new WebSignUpPage(browser);
		}
		return null;
	}

	@Override
	public SignUpPage enterFirstName(String fName) {
		sendText(firstNameEditTextLocator, fName);
		return SignUpPage.getSignUpPage(browser);
	}

	@Override
	public SignUpPage enterLastName(String lName) {
		sendText(lastNameEditTextLocator, lName);
		return SignUpPage.getSignUpPage(browser);
	}

	@Override
	public SignUpPage enterEmailId(String emailId) {
		sendText(emailEditTextLocator, emailId);
		return SignUpPage.getSignUpPage(browser);
	}

	@Override
	public SignUpPage enterPassword(String password) {
		sendText(passwordEditTextLocator, password);
		return SignUpPage.getSignUpPage(browser);
	}
	
	public SignUpPage clickOnRoomParent() {
		click(roomParentButtonLocator);
		return SignUpPage.getSignUpPage(browser);
	}
	
	@Override
	public HomePage clickOnSignUpButton() {
		click(signUpButtonLocator);
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifySignupButton() {
		Assert.assertTrue(getElementSize(signUpSheetLocator) > 0, "Signup button is not displayed");
		return HomePage.getHomePage(browser);
	}
	
	

}


