package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidSettingPage;
import com.net.bloomz.pages.interfaces.SettingPageActions;
import com.net.bloomz.pages.web.WebSettingPage;

public class SettingPage extends BasePage implements SettingPageActions {

	static By signOutButtonLocator = null;

	public SettingPage(Browser<?> browser) {
		super(browser);

	}

	@Override
	public SignInPage clickOnSignOutButton() {
		click(signOutButtonLocator);
		return SignInPage.getSignInPage(browser);
	}

	public static SettingPage getSettingPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			signOutButtonLocator = By.id("net.bloomz:id/txtSignOut");
			return new AndroidSettingPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			signOutButtonLocator = By.xpath("//span[contains(text(), \"Sign Out\")]");
			return new WebSettingPage(browser);
		}
		return null;
	}
}
