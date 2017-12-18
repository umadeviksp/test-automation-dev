package com.net.bloomz.pages.android;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.SignInPage;
import com.net.bloomz.pages.interfaces.SignPageActions;

public class AndroidSignInPage extends SignInPage implements SignPageActions {

	public AndroidSignInPage(Browser<?> browser) {
		super(browser);
	}
/*
	@Override
	public SignInPage enterEmailIdOnTextBox(String emailId) {
		this.setEnviroment();
		return super.enterEmailIdOnTextBox(emailId);
	}

	@Override
	public SignInPage setEnviroment() {
		if (browser.getActions().getElements(settingButtonLocator).size() != 0) {
			click(settingButtonLocator);
			sendText(editNewUrlEditTextLocator, "http://app-test01.bloomz.net:8000");
			click(saveButtonLocator);
		}
		return new SignInPage(browser);
	}
*/
}
