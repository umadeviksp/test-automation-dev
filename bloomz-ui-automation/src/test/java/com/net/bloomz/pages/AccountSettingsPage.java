package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidAccountSettingsPage;
import com.net.bloomz.pages.interfaces.AccountSettingsPageActions;
import com.net.bloomz.pages.web.WebAccountSettingsPage;
import com.net.bloomz.pages.SignOutConfirmationPage;

public class AccountSettingsPage extends BasePage implements AccountSettingsPageActions {

	static By signOutButtonLocator = null;
	static By myProfileButtonLocator = null;
	static By accountSettingsButtonLocator = null;
	static By goBackButtonLocator = null;

	public AccountSettingsPage(Browser<?> browser) {
		super(browser);

	}

	
	public SignOutConfirmationPage clickOnSignOutButton() {
		click(signOutButtonLocator);
		return SignOutConfirmationPage.getSignOutConfirmationPage(browser);
	}

	public SignInPage clickOnMyProfileButton() {
		click(myProfileButtonLocator);
		return SignInPage.getSignInPage(browser);
	}
	public SignInPage clickOnAccountSettingsButton() {
		click(accountSettingsButtonLocator);
		return SignInPage.getSignInPage(browser);
	}
	public SignInPage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return SignInPage.getSignInPage(browser);
	}
	public static AccountSettingsPage getAccountSettingsPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			signOutButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
			myProfileButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			accountSettingsButtonLocator = By.id("net.bloomz:id/txtAccountSettings");
			goBackButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			return new AndroidAccountSettingsPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			signOutButtonLocator 	= By.xpath("//label[contains(text(), \"Sign Out\")]");
			myProfileButtonLocator 	= By.xpath("//span[contains(text(), \"My Profile\")]");
			accountSettingsButtonLocator = By.xpath("//span[contains(text(), \"Account Settings\")]");
			goBackButtonLocator 	= By.xpath("//span[contains(text(), \"Cancel\")]");
			return new WebAccountSettingsPage(browser);
		}
		return null;
	}
}