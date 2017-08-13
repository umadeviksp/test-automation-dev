package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidCalendarSettingsPage;
import com.net.bloomz.pages.interfaces.CalendarSettingsPageActions;
import com.net.bloomz.pages.web.WebCalendarSettingsPage;

public class CalendarSettingsPage extends BasePage implements CalendarSettingsPageActions {
	
	// declare By variables here
	static By goBackButtonLocator = null;
	static By saveButtonLocator = null;

	public CalendarSettingsPage(Browser<?> browser) {
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

	public static CalendarSettingsPage getCalendarSettingsPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			return new AndroidCalendarSettingsPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
			saveButtonLocator 	= By.className("nextButton");
			goBackButtonLocator	= By.className("backButtonOnly");
			return new WebCalendarSettingsPage(browser);
		}
		return null;
	}

}
