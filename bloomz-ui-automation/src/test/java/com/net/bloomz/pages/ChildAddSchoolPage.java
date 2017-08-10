package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidChildAddSchoolPage;
import com.net.bloomz.pages.interfaces.ChildAddSchoolPageActions;
import com.net.bloomz.pages.web.WebChildAddSchoolPage;
import com.net.bloomz.pages.ProfileAddChildPage;

public class ChildAddSchoolPage extends BasePage implements ChildAddSchoolPageActions {

	static By signOutButtonLocator = null;
	static By schoolNameTextLocator = null;
	static By newButtonLocator = null;
	static By goBackButtonLocator = null;

	public ChildAddSchoolPage(Browser<?> browser) {
		super(browser);

	}

	

	public ProfileAddChildPage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return ProfileAddChildPage.getProfileAddChildPage(browser);
	}
	
	public ChildAddSchoolPage clickOnGoNextButton() {
		click(newButtonLocator);
		return this ;
	}
	
	public ChildAddSchoolPage enterTextForSchoolName(String SchoolName) {
		sendText(schoolNameTextLocator, SchoolName);
		return this;
	}

	
	public static ChildAddSchoolPage getChildAddSchoolPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			signOutButtonLocator 	= By.id("net.bloomz:id/txtSignOut");
			schoolNameTextLocator 	= By.id("net.bloomz:id/txtMyProfile");
			newButtonLocator = By.id("net.bloomz:id/txtAccountSettings");
			goBackButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			return new AndroidChildAddSchoolPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			signOutButtonLocator 	= By.xpath("//label[contains(text(), \"Sign Out\")]");
			schoolNameTextLocator 	= By.id("pickLocationId");
			newButtonLocator		= By.className("nextButton");
			goBackButtonLocator 	= By.className("backButtonOnly");
			return new WebChildAddSchoolPage(browser);
		}
		return null;
	}
}