package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidMyCalenderTabPage;
import com.net.bloomz.pages.web.WebMyCalenderTabPage;

public class CalendarTabPage extends BasePage {

	static By calenderEventsLocator;

	public CalendarTabPage(Browser<?> browser) {
		super(browser);
	}

	public static CalendarTabPage getCalenderTabPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			calenderEventsLocator = By.id("net.bloomz:id/llMainView");
			return new AndroidMyCalenderTabPage(browser);
		} else if (string.contains(".iOS")) {
		} else {
			calenderEventsLocator = By.xpath("//*[@ng-show=\"day.calendarEntries.length>=0\"]");
			return new WebMyCalenderTabPage(browser);
		}
		return null;
	}

	public CalendarTabPage thenVerifyCalenderEventsShouldNotBeNull() {
		Assert.assertTrue(getElementSize(calenderEventsLocator) > 1, "Day events are not displayed");
		return CalendarTabPage.getCalenderTabPage(browser);
	}

}
