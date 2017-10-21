package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidSettingPage;
import com.net.bloomz.pages.interfaces.SettingPageActions;
import com.net.bloomz.pages.web.WebSettingPage;

public class SettingPage extends BasePage implements SettingPageActions {

	static By signOutButtonLocator = null;
	static By myProfileButtonLocator = null;
	static By accountSettingsButtonLocator = null;
	static By cancelButtonLocator = null;

	public SettingPage(Browser<?> browser) {
		super(browser);

	}

	@Override
	public SignInPage clickOnSignOutButton() {
		click(signOutButtonLocator);
		return SignInPage.getSignInPage(browser);
	}

	public MyProfilePage clickOnMyProfileButton() {
		click(myProfileButtonLocator);
		return MyProfilePage.getMyProfilePage(browser);
	}
	public AccountSettingsPage clickOnAccountSettingsButton() {
		click(accountSettingsButtonLocator);
		return AccountSettingsPage.getAccountSettingsPage(browser);
	}
	public HomePage clickOnCancelButton() {
		click(cancelButtonLocator);
		return HomePage.getHomePage(browser);
	}
	


	public static SettingPage getSettingPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			signOutButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
			myProfileButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			accountSettingsButtonLocator = By.id("net.bloomz:id/txtAccountSettings");
			cancelButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			return new AndroidSettingPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			signOutButtonLocator 	= By.xpath("//span[contains(text(), \"Sign Out\")]");
			myProfileButtonLocator 	= By.xpath("//span[contains(text(), \"My Profile\")]");
			accountSettingsButtonLocator = By.xpath("//span[contains(text(), \"Account Settings\")]");
			cancelButtonLocator 	= By.xpath("//span[contains(text(), \"Cancel\")]");
			return new WebSettingPage(browser);
		}
		return null;
	}
}