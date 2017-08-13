package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidPreferredLanguagePage;
import com.net.bloomz.pages.interfaces.PreferredLanguagePageActions;
import com.net.bloomz.pages.web.WebPreferredLanguagePage;

public class PreferredLanguagePage extends BasePage implements PreferredLanguagePageActions {
	
	// declare By variables here
	static By goBackButtonLocator = null;
	static By saveButtonLocator = null;

	public PreferredLanguagePage(Browser<?> browser) {
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

	public static PreferredLanguagePage getPreferredLanguagePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			return new AndroidPreferredLanguagePage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
			saveButtonLocator 	= By.className("nextButton");
			goBackButtonLocator	= By.className("backButtonOnly");
			return new WebPreferredLanguagePage(browser);
		}
		return null;
	}

}
