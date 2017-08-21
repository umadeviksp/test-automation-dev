package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidNotificationsQuietHoursPage;
import com.net.bloomz.pages.interfaces.NotificationsQuietHoursPageActions;
import com.net.bloomz.pages.web.WebNotificationsQuietHoursPage;

public class NotificationsQuietHoursPage extends BasePage implements NotificationsQuietHoursPageActions {
	
	// declare By variables here
	static By goBackButtonLocator = null;
	static By saveButtonLocator = null;
	static By quietHoursButtonLocator = null;
	static By addAnotherScheduleButtonLocator = null;

	public NotificationsQuietHoursPage(Browser<?> browser) {
		super(browser);
	}

	public NotificationsPage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return NotificationsPage.getNotificationsPage(browser);
	}

	public NotificationsPage clickOnSaveButton() {
		click(saveButtonLocator);
		return NotificationsPage.getNotificationsPage(browser);
	}

	public NotificationsQuietHoursPage clickQuietHoursButton() {
		click(quietHoursButtonLocator);
		return this;
	}

	public NotificationsQuietHoursPage clickAddAnotherScheduleButton() {
		click(addAnotherScheduleButtonLocator);
		return this;
	}

	public static NotificationsQuietHoursPage getNotificationsQuietHoursPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			return new AndroidNotificationsQuietHoursPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
			saveButtonLocator 	= By.xpath("//div[@id='calendarSettings']//a[contains(@class,'nextButton')]");
			goBackButtonLocator	= By.xpath("//div[@id='calendarSettings']//a[contains(@class,'backButtonOnly')]");

			quietHoursButtonLocator	= By.xpath("//div[@id='calendarSettings']//input[@id='quietHoursSwitch']");
			addAnotherScheduleButtonLocator	= By.xpath("//div[@id='calendarSettings']//section[@class='scheduledPostsLink']//a");
			return new WebNotificationsQuietHoursPage(browser);
		}
		return null;
	}

}
