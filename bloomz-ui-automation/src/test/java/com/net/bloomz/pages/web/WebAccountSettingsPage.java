package com.net.bloomz.pages.web;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.AccountSettingsPage;
import com.net.bloomz.pages.SignOutConfirmationPage;

public class WebAccountSettingsPage extends AccountSettingsPage {

	public WebAccountSettingsPage(Browser<?> browser) {
		super(browser);
	}

	@Override
	public SignOutConfirmationPage clickOnSignOutButton() {
		return super.clickOnSignOutButton();
	}

}
