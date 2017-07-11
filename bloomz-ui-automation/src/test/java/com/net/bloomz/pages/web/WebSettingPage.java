package com.net.bloomz.pages.web;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.SettingPage;
import com.net.bloomz.pages.SignInPage;

public class WebSettingPage extends SettingPage {

	public WebSettingPage(Browser<?> browser) {
		super(browser);
	}

	@Override
	public SignInPage clickOnSignOutButton() {
		return super.clickOnSignOutButton();
	}

}
