package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidProfileAddSpousePage ;
import com.net.bloomz.pages.interfaces.ProfileAddSpousePageActions;
import com.net.bloomz.pages.web.WebProfileAddSpousePage;

public class ProfileAddSpousePage extends BasePage implements ProfileAddSpousePageActions {

	static By doneButtonLocator = null;
	static By spouseEMailTextLocator = null;
	static By goBackButtonLocator = null;
	static By addContactButtonLocator = null;

	public ProfileAddSpousePage(Browser<?> browser) {
		super(browser);

	}

	
	public ProfileAddSpousePage enterTextForSpouseEmail(String spouseEmail) {
		sendText(spouseEMailTextLocator, spouseEmail);
		return this;
	}

	public MyProfilePage clickOnaddContactButton() {
		addContactButtonLocator 	= By.className("addContact");
		click(addContactButtonLocator);
		return MyProfilePage.getMyProfilePage(browser);
	}

	public MyProfilePage clickOnDoneButton() {
		click(doneButtonLocator);
		return MyProfilePage.getMyProfilePage(browser);
	}

	public MyProfilePage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return  MyProfilePage.getMyProfilePage(browser);
	}
	public static ProfileAddSpousePage getProfileAddSpousePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			doneButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
			spouseEMailTextLocator 	= By.id("net.bloomz:id/txtMyProfile");
			goBackButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			return new AndroidProfileAddSpousePage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			doneButtonLocator 	= By.className("nextButton");
			spouseEMailTextLocator 	= By.id("inviteSpouse_searchEmail");
			goBackButtonLocator 	= By.className("backButtonOnly");
			return new WebProfileAddSpousePage(browser);
		}
		return null;
	}
}