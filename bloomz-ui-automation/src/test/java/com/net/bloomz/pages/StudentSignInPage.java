package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidStudentSignInPage;
import com.net.bloomz.pages.interfaces.StudentSignInPageActions;
import com.net.bloomz.pages.web.WebStudentSignInPage;

public class StudentSignInPage extends BasePage implements StudentSignInPageActions {

	static By signInButtonLocator = null;
	static By goBackButtonLocator = null;
	static By studentCodeBoxLocator = null;

	public StudentSignInPage(Browser<?> browser) {
		super(browser);

	}

	public 	SignInPage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return SignInPage.getSignInPage(browser);
	}

	public SignInPage clickOnSignInButton() {
		click(signInButtonLocator);
		return SignInPage.getSignInPage(browser);
	}

	public StudentSignInPage enterStudentCode(String studentCode) {
		sendText(studentCodeBoxLocator, studentCode);
		return this;
	}

	public static StudentSignInPage getStudentSignInPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			signInButtonLocator 	= By.id("net.bloomz:id/txtSignIn");
			goBackButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			studentCodeBoxLocator 	= By.id("net.bloomz:id/txtCancel");
			return new AndroidStudentSignInPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			signInButtonLocator 	= By.xpath("//span[contains(text(), \"Sign In\")]");
			goBackButtonLocator 	= By.className("backButtonOnly");
			studentCodeBoxLocator 	= By.xpath("//*[@id=\"loginForm_username\"]");
			return new WebStudentSignInPage(browser);
		}
		return null;
	}
}