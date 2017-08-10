package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidProfileRemoveChildPage;
import com.net.bloomz.pages.interfaces.ProfileRemoveChildPageActions;
import com.net.bloomz.pages.web.WebProfileRemoveChildPage;

public class ProfileRemoveChildPage extends BasePage implements ProfileRemoveChildPageActions {

	static By saveButtonLocator = null;
	static By childNameTextLocator = null;
	static By goBackButtonLocator = null;

	public ProfileRemoveChildPage(Browser<?> browser) {
		super(browser);

	}

	
	public MyProfilePage clickOnSaveButton() {
		click(saveButtonLocator);
		return MyProfilePage.getMyProfilePage(browser);
	}

	public ProfileRemoveChildPage enterTextForChildName(String childName) {
		sendText(childNameTextLocator, childName);
		return this;
	}

	public MyProfilePage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return  MyProfilePage.getMyProfilePage(browser);
	}
	public static ProfileRemoveChildPage getProfileRemoveChildPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			saveButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
			childNameTextLocator 	= By.id("net.bloomz:id/txtMyProfile");
			goBackButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			return new AndroidProfileRemoveChildPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			saveButtonLocator 	= By.className("nextButton");
			childNameTextLocator 	= By.id("addUpdateChild_childName");
			goBackButtonLocator 	= By.className("backButtonOnly");
			return new WebProfileRemoveChildPage(browser);
		}
		return null;
	}
}