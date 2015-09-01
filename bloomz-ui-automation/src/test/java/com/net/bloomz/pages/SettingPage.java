package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidSettingPage;
import com.net.bloomz.pages.interfaces.SettingPageActions;
import com.net.bloomz.pages.web.WebSettingPage;

public class SettingPage extends BasePage implements SettingPageActions {

	static By signOutButtonLocator = null;
	static By popUpSignOutButtonLocator = null;

	public SettingPage(Browser<?> browser) {
		super(browser);

	}

	@Override
	public SettingPage clickOnSignOutButton() {
		click(signOutButtonLocator);
		return this;
	}

	@Override
	public SignInPage clickOnPopUpSignOutButton() {
		click(popUpSignOutButtonLocator);
		return SignInPage.getSignInPage(browser);
	}

	public static SettingPage getSettingPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			signOutButtonLocator = By.id("net.bloomz:id/txtSignOut");
			popUpSignOutButtonLocator = By.id("net.bloomz:id/SignOutBtn");
			return new AndroidSettingPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			signOutButtonLocator = By.xpath("//*[@ng-click=\"logout()\"]");
			popUpSignOutButtonLocator = By.xpath("//*[contains(text(), \"Sign Out\")]");
			return new WebSettingPage(browser);
		}
		return null;
	}
}
