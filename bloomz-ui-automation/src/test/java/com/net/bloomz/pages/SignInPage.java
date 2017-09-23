package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidSignInPage;
import com.net.bloomz.pages.interfaces.SignPageActions;
import com.net.bloomz.pages.web.WebSignInPage;

public class SignInPage extends BasePage implements SignPageActions {

	static By backArrowButtonLocator = null;
	static By emailEditTextLocator = null;
	static By passwordEditTextLocator = null;
	static By signInButtonLocator = null;
	static By forgotPasswordLinkLocator = null;
	static By needHelpLinkLocator = null;
	static By resetButtonLocator = null;
	static By forgotPasswordBackButtonLocator = null;
	static By pageTitleLocator = null;

	public SignInPage(Browser<?> browser) {
		super(browser);

	}

	@Override
	public SignInPage enterEmailIdOnTextBox(String emailId) {
		sendText(emailEditTextLocator, emailId);
		return this;
	}

	@Override
	public SignInPage enterPasswordOnTextBox(String password) {
		sendText(passwordEditTextLocator, password);
		return this;
	}

	@Override
	public HomePage clickOnSignInButton() {
		click(signInButtonLocator);
		return HomePage.getHomePage(browser);
	}

	@Override
	public SignInPage setEnviroment() {

		return null;
	}
	
	
	public static SignInPage getSignInPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			backArrowButtonLocator = By.id("net.bloomz:id/llback");
			emailEditTextLocator = By.id("net.bloomz:id/editEmail");
			passwordEditTextLocator = By.id("net.bloomz:id/editPassword");
			signInButtonLocator = By.id("net.bloomz:id/btnSignIn");
			forgotPasswordLinkLocator = By.id("net.bloomz:id/txtForgotPassword");
			needHelpLinkLocator = By.id("net.bloomz:id/txtNeedHelp");
			resetButtonLocator = By.id("net.bloomz:id/btnReset");
			forgotPasswordBackButtonLocator = By.id("net.bloomz:id/backarrow");
			pageTitleLocator = By.id("net.bloomz:id/txtHeadingTitle");
			return new AndroidSignInPage(browser);

		} else if (string.contains(".iOS")) {
			backArrowButtonLocator = By.id("net.bloomz:id/llback");
			emailEditTextLocator = By.id("net.bloomz:id/editEmail");
			passwordEditTextLocator = By.id("net.bloomz:id/editPassword");
			signInButtonLocator = By.id("net.bloomz:id/btnSignIn");
			forgotPasswordLinkLocator = By.id("net.bloomz:id/txtForgotPassword");
			needHelpLinkLocator = By.id("net.bloomz:id/txtNeedHelp");
			resetButtonLocator = By.id("net.bloomz:id/btnReset");
			forgotPasswordBackButtonLocator = By.id("net.bloomz:id/backarrow");
			pageTitleLocator = By.id("net.bloomz:id/txtHeadingTitle");
		} else {
			backArrowButtonLocator = By.id("net.bloomz:id/llback");
			emailEditTextLocator = By.xpath("//*[@id=\"loginForm_username\"]");
			passwordEditTextLocator = By.xpath("//*[@id=\"loginForm_password\"]");
			signInButtonLocator = By.xpath("//*[@id=\"login_signin\"]");
			forgotPasswordLinkLocator = By.id("net.bloomz:id/txtForgotPassword");
			needHelpLinkLocator = By.id("net.bloomz:id/txtNeedHelp");
			resetButtonLocator = By.id("net.bloomz:id/btnReset");
			forgotPasswordBackButtonLocator = By.id("net.bloomz:id/backarrow");
			pageTitleLocator = By.id("net.bloomz:id/txtHeadingTitle");
			return new WebSignInPage(browser);
		}

		return null;
	}

}
