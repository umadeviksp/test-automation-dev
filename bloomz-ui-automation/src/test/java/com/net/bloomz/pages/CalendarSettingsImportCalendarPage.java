package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidCalendarSettingsImportCalendarPage;
import com.net.bloomz.pages.interfaces.CalendarSettingsImportCalendarPageActions;
import com.net.bloomz.pages.web.WebCalendarSettingsImportCalendarPage;

public class CalendarSettingsImportCalendarPage extends BasePage implements CalendarSettingsImportCalendarPageActions {
	
	// declare By variables here
	static By goBackButtonLocator = null;
	static By saveButtonLocator = null;
	static By calendarNameTextLocator = null;
	static By calendarURLTextLocator = null;
	static By shareWithSpouseButtonLocator = null;

	public CalendarSettingsImportCalendarPage(Browser<?> browser) {
		super(browser);
	}

	public CalendarSettingsPage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return CalendarSettingsPage.getCalendarSettingsPage(browser);
	}

	public CalendarSettingsImportCalendarPage clickOnSaveButton() {
		click(saveButtonLocator);
		return CalendarSettingsImportCalendarPage.getCalendarSettingsImportCalendarPage(browser);
	}

	public CalendarSettingsImportCalendarPage enterCalendarName(String calendarName) {
		sendText(calendarNameTextLocator, calendarName);
		return this;
	}

	public CalendarSettingsImportCalendarPage enterCalendarURL(String calendarURL) {
		sendText(calendarURLTextLocator, calendarURL);
		return this;
	}

	public CalendarSettingsImportCalendarPage clickShareWithSpouseButton() {
		click(shareWithSpouseButtonLocator);
		return this;
	}

	public static CalendarSettingsImportCalendarPage getCalendarSettingsImportCalendarPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			return new AndroidCalendarSettingsImportCalendarPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
			saveButtonLocator 	= By.xpath("//div[@id='importCalendar']//a[@class='nextButton']");
			goBackButtonLocator	= By.xpath("//div[@id='importCalendar']//a[@class='backButtonOnly']");
			calendarNameTextLocator	= By.xpath("//div[@id='importCalendar']//input[@name='CalendarName']");
			calendarURLTextLocator	= By.xpath("//div[@id='importCalendar']//input[@name='Url']");
			shareWithSpouseButtonLocator	= By.xpath("//div[@id='importCalendar']//div[contains(@class,'switchControl')]");
			return new WebCalendarSettingsImportCalendarPage(browser);
		}
		return null;
	}

}
