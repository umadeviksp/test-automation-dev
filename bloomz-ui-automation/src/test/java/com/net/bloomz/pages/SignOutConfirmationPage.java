package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidSignOutConfirmationPage;
import com.net.bloomz.pages.interfaces.SignOutConfirmationPageActions;
import com.net.bloomz.pages.web.WebSignOutConfirmationPage;

public class SignOutConfirmationPage extends BasePage implements SignOutConfirmationPageActions {

	static By signOutButtonLocator = null;
	static By cancelButtonLocator = null;

	public SignOutConfirmationPage(Browser<?> browser) {
		super(browser);

	}

	
	public 	AccountSettingsPage clickOnCancelButton() {
		click(cancelButtonLocator);
		return AccountSettingsPage.getAccountSettingsPage(browser);
	}

	public SignInPage clickOnSignOutButton() {
		click(signOutButtonLocator);
		return SignInPage.getSignInPage(browser);
	}

	public static SignOutConfirmationPage getSignOutConfirmationPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			signOutButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
			cancelButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			return new AndroidSignOutConfirmationPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			signOutButtonLocator 	= By.xpath("//span[contains(text(), \"Sign Out\")]");
			cancelButtonLocator 	= By.xpath("//span[contains(text(), \"Cancel\")]");
			return new WebSignOutConfirmationPage(browser);
		}
		return null;
	}
}