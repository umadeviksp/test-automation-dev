package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.ChangeEmailAddressPageActions;
import com.net.bloomz.pages.web.WebChangeEmailAddressPage;
import com.net.bloomz.pages.android.AndroidChangeEmailAddressPage;

public class ChangeEmailAddressPage extends BasePage implements ChangeEmailAddressPageActions {
	
	// declare By variables here
	static By goBackButtonLocator = null;
	static By saveButtonLocator = null;
	static By newEmailTextLocator = null;
	static By passwordTextLocator = null;
	static By showPasswordButtonLocator = null;

	public ChangeEmailAddressPage(Browser<?> browser) {
		super(browser);
	}

	public AccountSettingsPage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return AccountSettingsPage.getAccountSettingsPage(browser);
	}

	public AccountSettingsPage clickOnSaveButton() {
		click(saveButtonLocator);
		return AccountSettingsPage.getAccountSettingsPage(browser);
	}

	public ChangeEmailAddressPage enterNewEmailAddress(String newEmailAddress) {
		sendText(newEmailTextLocator, newEmailAddress);
		return this;
	}

	public ChangeEmailAddressPage enterPassword(String password) {
		sendText(passwordTextLocator, password);
		return this;
	}

	public ChangeEmailAddressPage clickShowHidePassword() {
		click(showPasswordButtonLocator);
		return this;
	}

	public static ChangeEmailAddressPage getChangeEmailAddressPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			return new AndroidChangeEmailAddressPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
			saveButtonLocator 	= By.className("nextButton");
			goBackButtonLocator	= By.className("backButtonOnly");
			newEmailTextLocator	= By.id("changeEmailForm_newemail");
			passwordTextLocator	= By.id("changeEmailForm_password");
			showPasswordButtonLocator	= By.id("showPswd_changeEmailForm_password");
			return new WebChangeEmailAddressPage(browser);
		}
		return null;
	}

}
