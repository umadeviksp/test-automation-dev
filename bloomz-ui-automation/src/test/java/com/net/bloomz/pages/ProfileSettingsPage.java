package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidProfileSettingsPage;
import com.net.bloomz.pages.interfaces.ProfileSettingsPageActions;
import com.net.bloomz.pages.web.WebProfileSettingsPage;

public class ProfileSettingsPage extends MyProfilePage implements ProfileSettingsPageActions {
	
	// declare By variables here
	static By goBackButtonLocator = null;

	public ProfileSettingsPage(Browser<?> browser) {
		super(browser);
	}
@Override
	public AccountSettingsPage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return AccountSettingsPage.getAccountSettingsPage(browser);
	}

	public static ProfileSettingsPage getProfileSettingsPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
		
			return new AndroidProfileSettingsPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
			goBackButtonLocator	= By.className("backButtonOnly");
			return new WebProfileSettingsPage(browser);
		}
		return null;
	}

}
