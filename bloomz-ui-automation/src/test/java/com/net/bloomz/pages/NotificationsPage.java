package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidNotificationsPage;
import com.net.bloomz.pages.interfaces.NotificationsPageActions;
import com.net.bloomz.pages.web.WebNotificationsPage;

public class NotificationsPage extends BasePage implements NotificationsPageActions {
	
	// declare By variables here
	static By goBackButtonLocator = null;
	static By saveButtonLocator = null;

	public NotificationsPage(Browser<?> browser) {
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

	public static NotificationsPage getNotificationsPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			return new AndroidNotificationsPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
			saveButtonLocator 	= By.className("nextButton");
			goBackButtonLocator	= By.className("backButtonOnly");
			return new WebNotificationsPage(browser);
		}
		return null;
	}

}
