package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidProfileAddChildPage;
import com.net.bloomz.pages.interfaces.ProfileAddChildPageActions;
import com.net.bloomz.pages.web.WebProfileAddChildPage;
import com.net.bloomz.pages.ChildAddActivitiesPage;
import com.net.bloomz.pages.ChildAddSchoolPage;

public class ProfileAddChildPage extends BasePage implements ProfileAddChildPageActions {

	static By saveButtonLocator = null;
	static By childNameTextLocator = null;
	static By goBackButtonLocator = null;
	static By pinkLabelColourLocator = null;
	static By orangeLabelColourLocator = null;
	static By yellowLabelColourLocator = null;
	static By greenLabelColourLocator = null;
	static By blueLabelColourLocator = null;
	static By purpleLabelColourLocator = null;
	static By addSchoolButtonLocator = null;
	static By deleteSchoolButtonLocator = null;
	static By addActivitiesButtonLocator = null;

	public ProfileAddChildPage(Browser<?> browser) {
		super(browser);

	}
	
	public MyProfilePage clickOnSaveButton() {
		click(saveButtonLocator);
		return MyProfilePage.getMyProfilePage(browser);
	}

	public ProfileAddChildPage enterTextForChildName(String childName) {
		sendText(childNameTextLocator, childName);
		return this;
	}

	public ProfileAddChildPage pickLabelColourPink() {
		click(pinkLabelColourLocator);
		return this;
	}

	public ProfileAddChildPage pickLabelColourOrange() {
		click(orangeLabelColourLocator);
		return this;
	}

	public ProfileAddChildPage pickLabelColourYellow() {
		click(yellowLabelColourLocator);
		return this;
	}

	public ProfileAddChildPage pickLabelColourGreen() {
		click(greenLabelColourLocator);
		return this;
	}

	public ProfileAddChildPage pickLabelColourBlue() {
		click(blueLabelColourLocator);
		return this;
	}

	public ProfileAddChildPage pickLabelColourPurple() {
		click(purpleLabelColourLocator);
		return this;
	}

	public ChildAddSchoolPage clickOnAddSchoolButton() {
		click(addSchoolButtonLocator);
		return ChildAddSchoolPage.getChildAddSchoolPage(browser);
	}

	public ChildAddActivitiesPage clickOnAddActivitiesButton() {
		click(addActivitiesButtonLocator);
		return ChildAddActivitiesPage.getChildAddActivitiesPage(browser);
	}

	public MyProfilePage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return  MyProfilePage.getMyProfilePage(browser);
	}

	public static ProfileAddChildPage getProfileAddChildPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			saveButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
			childNameTextLocator 	= By.id("net.bloomz:id/txtMyProfile");
			goBackButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			return new AndroidProfileAddChildPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			saveButtonLocator 	= By.className("nextButton");
			childNameTextLocator 	= By.id("addUpdateChild_childName");
			goBackButtonLocator 	= By.className("backButtonOnly");
			pinkLabelColourLocator 	= By.className("circleColor_pink");
			orangeLabelColourLocator 	= By.className("circleColor_orange");
			yellowLabelColourLocator 	= By.className("circleColor_yellow");
			greenLabelColourLocator 	= By.className("circleColor_green");
			blueLabelColourLocator 	= By.className("circleColor_blue");
			purpleLabelColourLocator 	= By.className("circleColor_purple");

			addSchoolButtonLocator 	= By.xpath("//span[contains(text(), \"Add School\")]");
			deleteSchoolButtonLocator 	= By.className("location");
			addActivitiesButtonLocator 	= By.xpath("//span[contains(text(), \"Add Activities\")]");
			
			
			return new WebProfileAddChildPage(browser);
		}
		return null;
	}
}