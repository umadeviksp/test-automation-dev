package com.bloomz.pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;

import com.bloomz.pages.onboarding.YourRolePage;

// TODO: Auto-generated Javadoc
/**
 * The Class LandingPage.
 */
public class LandingPage extends BasePage {

	By signInButtonLocator = By.id("net.bloomz:id/SignIn");
	By iAmNewButtonLocator = By.id("net.bloomz:id/IAmNew");

	/**
	 * Instantiates a new landing page.
	 *
	 * @param appiumDriver
	 *            the appium driver
	 */
	public LandingPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Go to sign in page.
	 *
	 * @return the sign in page
	 */
	public SignInPage goToSignInPage() {
		click(signInButtonLocator);
		return new SignInPage(appiumDriver);
	}

	/**
	 * Go to im new page.
	 *
	 * @return the your role page
	 */
	public YourRolePage goToImNewPage() {
		click(iAmNewButtonLocator);
		return new YourRolePage(appiumDriver);
	}

}
