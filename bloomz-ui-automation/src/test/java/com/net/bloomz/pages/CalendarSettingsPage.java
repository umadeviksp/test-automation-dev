package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidCalendarSettingsPage;
import com.net.bloomz.pages.interfaces.CalendarSettingsPageActions;
import com.net.bloomz.pages.web.WebCalendarSettingsPage;

public class CalendarSettingsPage extends BasePage implements CalendarSettingsPageActions {
	
	// declare By variables here
	static By goBackButtonLocator = null;
	static By saveButtonLocator = null;
	static By addCalendarButtonLocator = null;
	static By importCalendarButtonLocator = null;
	static By calendarListLocator = null;

	public CalendarSettingsPage(Browser<?> browser) {
		super(browser);
	}

	public AccountSettingsPage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return AccountSettingsPage.getAccountSettingsPage(browser);
	}

	public AccountSettingsPage clickOnSaveButton() {
		click(saveButtonLocator);
		return AccountSettingsPage.getAccountSettingsPage(browser);
	}

	public CalendarSettingsImportCalendarPage clickOnAddCalendarButton() {
		click(addCalendarButtonLocator);
		return CalendarSettingsImportCalendarPage.getCalendarSettingsImportCalendarPage(browser);
	}

	public CalendarSettingsImportCalendarPage clickOnImportCalendarButton() {
		click(importCalendarButtonLocator);
		return CalendarSettingsImportCalendarPage.getCalendarSettingsImportCalendarPage(browser);
	}

	public CalendarSettingsImportCalendarPage clickOnExistingCalendarButton() {
		if(browser.getWebDriver().findElements(calendarListLocator).size() >0)
		{
			browser.getWebDriver().findElement(calendarListLocator).click();
		}
		return CalendarSettingsImportCalendarPage.getCalendarSettingsImportCalendarPage(browser);
	}

	public static CalendarSettingsPage getCalendarSettingsPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
			return new AndroidCalendarSettingsPage(browser);
		} else if (string.equals(".iOS")) {
			
		} else {
			// define By variables here
			saveButtonLocator 	= By.xpath("nextButton");
			goBackButtonLocator	= By.xpath("//div[@id='calendarSettings']//a[@class='backButtonOnly']");
			addCalendarButtonLocator 	= By.xpath("//div[@id='calendarSettings']//*[@class='inlineAddBtn']");
			importCalendarButtonLocator	= By.xpath("//div[@id='calendarSettings']//*[contains(@class,'linkControl')]");
			calendarListLocator	= By.xpath("//div[@id='calendarSettings']//section[contains(@class,'calendarToggle')]//label");
			return new WebCalendarSettingsPage(browser);
		}
		return null;
	}

}
