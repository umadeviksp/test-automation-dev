package com.net.bloomz.pages.web;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.SignInPage;

public class WebSignInPage extends SignInPage {

	public WebSignInPage(Browser<?> browser) {
		super(browser);
	}

	@Override
	public SignInPage enterEmailIdOnTextBox(String emailId) {
		return super.enterEmailIdOnTextBox(emailId);
	}

	@Override
	public SignInPage enterPasswordOnTextBox(String password) {
		return super.enterPasswordOnTextBox(password);
	}

	@Override
	public HomePage clickOnSignInButton() {
		return super.clickOnSignInButton();
	}

	@Override
	public SignInPage setEnviroment() {

		return null;
	}
}
