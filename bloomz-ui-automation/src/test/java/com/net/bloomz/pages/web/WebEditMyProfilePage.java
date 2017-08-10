package com.net.bloomz.pages.web;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.EditMyProfilePage;
import com.net.bloomz.pages.SignOutConfirmationPage;

public class WebEditMyProfilePage extends EditMyProfilePage {

	public WebEditMyProfilePage(Browser<?> browser) {
		super(browser);
	}

	@Override
	public SignOutConfirmationPage clickOnSignOutButton() {
		return super.clickOnSignOutButton();
	}

}
