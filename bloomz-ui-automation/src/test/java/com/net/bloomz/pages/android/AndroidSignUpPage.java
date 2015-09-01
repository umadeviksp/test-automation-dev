package com.net.bloomz.pages.android;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.HomePage;
import com.net.bloomz.pages.SignUpPage;
import com.net.bloomz.pages.interfaces.SignUpPageActions;

@SuppressWarnings("rawtypes")
public class AndroidSignUpPage extends SignUpPage implements SignUpPageActions {

	By pageTitleLocator = By.id("net.bloomz:id/textView2");
	By videoLocator = By.id("net.bloomz:id/welcomeVideoPhoto");
	By createClassButtonLocator = By.id("net.bloomz:id/createClassBtn");
	By titleBarLocator = By.id("android:id/action_bar_title");
	By classNameEditTextLocator = By.id("net.bloomz:id/txtTitleNameValue");
	By schoolLocator = By.id("net.bloomz:id/relativeLayout1");
	By schoolTitleLocator = By.id("net.bloomz:id/Title");
	By createButtonLocator = By.name("Create");
	By addPhotoTitleLocator = By.id("net.bloomz:id/txtTitle"); // Add a Photo
	By skipAddImageLocator = By.id("net.bloomz:id/txtSkip");
	By feedLocator = By.name("Feed");
	By classTitleLocator = By.id("net.bloomz:id/txtHeading");
	By childNameEditTextLocator = By.id("net.bloomz:id/childName");
	By signUpPageTitleLocator = By.id("net.bloomz:id/txtHeading");
	By backButtonLocator = By.id("net.bloomz:id/backarrow");

	public AndroidSignUpPage(Browser<?> browser) {
		super(browser);
	}

	@Override
	public HomePage clickOnSignUpButton() {
		String signUpType = getText(signUpPageTitleLocator);
		super.clickOnSignUpButton();
		click(createClassButtonLocator);
		sendText(classNameEditTextLocator, signUpType);
		if (signUpType.equals("Room Parent")) {
			if (((AndroidDriver) browser.getWebDriver()).findElements(childNameEditTextLocator).size() < 1) {
				swipeUp("android:id/content", 3, 3, 1000);
			}
			sendText(childNameEditTextLocator, signUpType.substring(0, 4));
		}
		click(schoolLocator);
		click(schoolTitleLocator);
		click(createButtonLocator);
		click(skipAddImageLocator);
		click(backButtonLocator);
		return HomePage.getHomePage(browser);
	}
}
