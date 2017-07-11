package com.net.bloomz.pages.android;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.LandingPage;
import com.net.bloomz.pages.YourRolePage;
import com.net.bloomz.pages.interfaces.LandingPageActions;

public class AndroidLandingPage extends LandingPage implements LandingPageActions {

	public AndroidLandingPage(Browser<?> browser) {
		super(browser);
	}

	@Override
	public YourRolePage clickOnCreateAccount() {
		super.clickOnSignInButton();
		AndroidSignInPage.getSignInPage(browser).setEnviroment();
		super.clickBack();
		return super.clickOnCreateAccount();
	}
}
