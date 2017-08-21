package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidChangePasswordPage;
import com.net.bloomz.pages.interfaces.ChangePasswordPageActions;
import com.net.bloomz.pages.web.WebChangePasswordPage;

public class ChangePasswordPage extends BasePage implements ChangePasswordPageActions {
	
	// declare By variables here
	static By goBackButtonLocator = null;
	static By saveButtonLocator = null;
	static By oldPasswordTextLocator = null;
	static By newPasswordTextLocator = null;
	static By showPasswordButtonLocator = null;

	public ChangePasswordPage(Browser<?> browser) {
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

	public ChangePasswordPage enterOldPassword(String oldPassword) {
		sendText(oldPasswordTextLocator, oldPassword);
		return this;
	}

	public ChangePasswordPage enterNewPassword(String newPassword) {
		sendText(newPasswordTextLocator, newPassword);
		return this;
	}

	public ChangePasswordPage clickShowHidePassword() {
		click(showPasswordButtonLocator);
		return this;
	}

	public static ChangePasswordPage getChangePasswordPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			return new AndroidChangePasswordPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
			saveButtonLocator 	= By.xpath("//div[@id='changePassword']//a[contains(@class,'nextButton')]");
			goBackButtonLocator	= By.xpath("//div[@id='changePassword']//a[contains(@class,'backButtonOnly')]");
			oldPasswordTextLocator 	= By.id("changePasswordForm_oldpassword2");
			newPasswordTextLocator	= By.id("changePasswordForm_newpassword2");
			showPasswordButtonLocator	= By.xpath("//div[@id='changePassword']//div[@class='switchControl']");
			return new WebChangePasswordPage(browser);
		}
		return null;
	}

}
