package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidLandingPage;
import com.net.bloomz.pages.interfaces.LandingPageActions;
import com.net.bloomz.pages.web.WebLandingPage;

public class LandingPage extends BasePage implements LandingPageActions {
	static By signInButtonLocator;
	static By createAccountButtonLocator;
	static By studentButtonLocator;

	public LandingPage(Browser<?> browser) {
		super(browser);
	}

	@Override
	public SignInPage clickOnSignInButton() {
		click(signInButtonLocator);
		return SignInPage.getSignInPage(browser);
	}

	@Override
	public CreateAccountPage clickOnCreateAccount() {
		click(createAccountButtonLocator);
		return CreateAccountPage.getCreateAccountPage(browser);
	}

	public StudentSignInPage clickOnStudentButton() {
		click(studentButtonLocator);
		return StudentSignInPage.getStudentSignInPage(browser);
	}
	
	public static LandingPage getLandingPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			signInButtonLocator = By.id("net.bloomz:id/SignIn");
			createAccountButtonLocator = By.id("net.bloomz:id/IAmNew");
			studentButtonLocator = By.id("net.bloomz:id/Student");
			return new AndroidLandingPage(browser);
		} else if (string.equals(".iOS")) {
			signInButtonLocator = By.id("net.bloomz:id/SignIn");
			createAccountButtonLocator = By.id("net.bloomz:id/IAmNew");
			studentButtonLocator = By.id("net.bloomz:id/Student");
		} else {
			signInButtonLocator = By.xpath("//*[@ng-click=\"navigateTo('login');\"]");
			createAccountButtonLocator = By.xpath("//*[@ng-click=\"navigateTo('createJoinGroup')\"]");
			studentButtonLocator = By.xpath("//a[contains(text(), \"Student\")]");
			return new WebLandingPage(browser);
		}
		return null;
	}

	public LandingPage thenVerifySignInAndCreateButtonsShouldBeDisplayed() {
		Assert.assertTrue(getElementSize(signInButtonLocator) != 0 && getElementSize(createAccountButtonLocator) != 0,
				"Current page is not Landing Page");
		return LandingPage.getLandingPage(browser);
	}

}
