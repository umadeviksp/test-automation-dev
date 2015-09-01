package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidVolunteersTabPage;
import com.net.bloomz.pages.web.WebVolunteersTabPage;

public class VolunteersTabPage extends BasePage {

	static By volunteerAddButtonLocator;

	public VolunteersTabPage(Browser<?> browser) {
		super(browser);
	}

	public static VolunteersTabPage getVolunteersTabPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			volunteerAddButtonLocator = By.name("  Volunteer Asks");
			return new AndroidVolunteersTabPage(browser);
		} else if (string.contains(".iOS")) {
		} else {
			volunteerAddButtonLocator = By.id("volunteer_addEventQuickLink");
			return new WebVolunteersTabPage(browser);
		}
		return null;
	}

	public VolunteersTabPage thenVerifyAddVolunteerButtonShouldBeDisplayed() {
		Assert.assertTrue(getElementSize(volunteerAddButtonLocator) != 0, "Current page is not Volunteers Tab Page");
		return VolunteersTabPage.getVolunteersTabPage(browser);

	}

}
