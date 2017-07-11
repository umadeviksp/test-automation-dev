package com.net.bloomz.pages.web;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.pages.SignInPage;
import com.net.bloomz.pages.YourRolePage;
import com.net.bloomz.pages.interfaces.LandingPageActions;

public class WebLandingPage extends LandingPage implements LandingPageActions {

	public WebLandingPage(Browser<?> browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	@Override
	public SignInPage clickOnSignInButton() {
		return super.clickOnSignInButton();
	}

	@Override
	public YourRolePage clickOnCreateAccount() {
		return super.clickOnCreateAccount();
	}
}
