package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidProfileTimezonePage;
import com.net.bloomz.pages.interfaces.ProfileTimezonePageActions;
import com.net.bloomz.pages.web.WebProfileTimezonePage;

public class ProfileTimezonePage extends BasePage implements ProfileTimezonePageActions {
	
	// declare By variables here
	static By goBackButtonLocator = null;
	static By saveButtonLocator = null;

	public ProfileTimezonePage(Browser<?> browser) {
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

	public static ProfileTimezonePage getProfileTimezonePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			return new AndroidProfileTimezonePage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
			saveButtonLocator 	= By.className("nextButton");
			goBackButtonLocator	= By.className("backButtonOnly");
			return new WebProfileTimezonePage(browser);
		}
		return null;
	}

}
