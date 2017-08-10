package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidChildAddActivitiesPage;
import com.net.bloomz.pages.interfaces.ChildAddActivitiesPageActions;
import com.net.bloomz.pages.web.WebChildAddActivitiesPage;

public class ChildAddActivitiesPage extends BasePage implements ChildAddActivitiesPageActions {

	static By activityNameTextLocator = null;
	static By doneButtonLocator = null;
	static By enableActivityNameLocator = null ;
	
	public ChildAddActivitiesPage(Browser<?> browser) {
		super(browser);

	}

	public ChildAddActivitiesPage enterTextForActivityName(String activityName) {
		click(enableActivityNameLocator);
		sendText(activityNameTextLocator, activityName);
		return this;
	}

	
	public ProfileAddChildPage clickOnDoneButton() {
		click(doneButtonLocator);
		return  ProfileAddChildPage.getProfileAddChildPage(browser);
	}

	public static ChildAddActivitiesPage getChildAddActivitiesPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			activityNameTextLocator 	= By.id("net.bloomz:id/txtMyProfile");
			doneButtonLocator = By.id("net.bloomz:id/txtAccountSettings");
			return new AndroidChildAddActivitiesPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			enableActivityNameLocator = By.className("placeHolderText");
			activityNameTextLocator = By.className("newEntry");
			doneButtonLocator		= By.className("nextButton");
			return new WebChildAddActivitiesPage(browser);
		}
		return null;
	}
}