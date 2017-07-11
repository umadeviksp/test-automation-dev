package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidMyCalendarTabPage;
import com.net.bloomz.pages.web.WebMyCalendarTabPage;

public class CalendarTabPage extends BasePage {

	static By calendarEventsLocator;

	public CalendarTabPage(Browser<?> browser) {
		super(browser);
	}

	public static CalendarTabPage getCalendarTabPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			calendarEventsLocator = By.id("net.bloomz:id/llMainView");
			return new AndroidMyCalendarTabPage(browser);
		} else if (string.contains(".iOS")) {
		} else {
			calendarEventsLocator = By.xpath("//*[@ng-show=\"day.calendarEntries.length>=0\"]");
			return new WebMyCalendarTabPage(browser);
		}
		return null;
	}

	public CalendarTabPage thenVerifyCalendarEventsShouldNotBeNull() {
		Assert.assertTrue(getElementSize(calendarEventsLocator) > 1, "Day events are not displayed");
		return CalendarTabPage.getCalendarTabPage(browser);
	}

}
