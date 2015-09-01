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

	public LandingPage(Browser<?> browser) {
		super(browser);
	}

	@Override
	public SignInPage clickOnSignInButton() {
		click(signInButtonLocator);
		return SignInPage.getSignInPage(browser);
	}

	@Override
	public YourRolePage clickOnCreateAccountOrIAmNewButton() {
		click(createAccountButtonLocator);
		return YourRolePage.getYourRolePage(browser);
	}

	public static LandingPage getLandingPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			signInButtonLocator = By.id("net.bloomz:id/SignIn");
			createAccountButtonLocator = By.id("net.bloomz:id/IAmNew");
			return new AndroidLandingPage(browser);
		} else if (string.equals(".iOS")) {
			signInButtonLocator = By.id("net.bloomz:id/SignIn");
			createAccountButtonLocator = By.id("net.bloomz:id/IAmNew");
		} else {
			signInButtonLocator = By.xpath("//*[@ng-click=\"navigateTo('login');\"]");
			createAccountButtonLocator = By.xpath("//*[@ng-click=\"navigateTo('roleChooser')\"]");
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
