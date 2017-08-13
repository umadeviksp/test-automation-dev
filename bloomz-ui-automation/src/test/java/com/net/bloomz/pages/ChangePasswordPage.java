package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidChangePasswordPage;
import com.net.bloomz.pages.interfaces.ChangePasswordPageActions;
import com.net.bloomz.pages.web.WebChangePasswordPage;

public class ChangePasswordPage extends BasePage implements ChangePasswordPageActions {
	
	// declare By variables here
	static By goBackButtonLocator = null;
	static By saveButtonLocator = null;

	public ChangePasswordPage(Browser<?> browser) {
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

	public static ChangePasswordPage getChangePasswordPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			return new AndroidChangePasswordPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
			saveButtonLocator 	= By.className("nextButton");
			goBackButtonLocator	= By.className("backButtonOnly");
			return new WebChangePasswordPage(browser);
		}
		return null;
	}

}
