package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidMyCalendarTabPage;
import com.net.bloomz.pages.web.WebMyCalendarTabPage;

public class CalendarTabPage extends BasePage {

	static By calendarEventsLocator;
	static By calendarTodayLocator;
	static By calendarSomeDayLocator;
	static By calendarUpLocator;
	static By PTCeventLocator;

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
			//calendarEventsLocator = By.xpath("//*[@ng-show=\"day.calendarEntries.length>=0\"]");
			//Nov-5-2017 events locator changed
			//calendarEventsLocator = By.xpath("//*[@id='calendarList']//*[@ng-repeat='entry in day.calendarEntries']");
			//calendarEventsLocator = By.xpath("//*[@id=\"calendarList\"]/div[3]/section[25]/article[2]/div/h2/span");
			calendarEventsLocator = By.xpath("//*[@id=\"calendarList\"]/div[3]");
			calendarTodayLocator = By.xpath("//*[@id='communityContent']/div/section[1]/article/h2");
			//calendarUpLocator = By.xpath("//*[@id='calendarList']/section[2]/article/h2");
			calendarUpLocator = By.xpath("//*[@id='calendarList']//*[contains (text(),'Today')]");
			//calendarSomeDayLocator = By.xpath("//*[@id='calendarList']/section[12]/article/h2");
			calendarSomeDayLocator = By.xpath("//*[@id='calendarList']/div[3]/section[4]/article[1]/h2");
			PTCeventLocator = By.xpath("//*[@id='communityContent']//span[contains (text(),'test_PTCEvent')]");
			return new WebMyCalendarTabPage(browser);
		}
		return null;
	}

	public CalendarTabPage thenVerifyCalendarEventsShouldNotBeNull() {
		Assert.assertTrue(getElementSize(calendarEventsLocator) > 1, "Day events are not displayed");
		return CalendarTabPage.getCalendarTabPage(browser);
	}
	
	public MembersTabPage thenVerifyElementExists() {
		Assert.assertTrue(getElementSize(calendarTodayLocator) > 0, "Calendar Tab is not displayed");
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	public CalendarTabPage ScrollDownCalendarFeed() throws InterruptedException {
		scrollIntoView(calendarSomeDayLocator);
		return CalendarTabPage.getCalendarTabPage(browser);
	}
	
	public EditEventPage clickOnPTCvent() {
		click(PTCeventLocator);
		return EditEventPage.getEditEventPage(browser);
	}
	
	public CalendarTabPage thenVerifyScrollDown(String sText) {
		
		System.out.println(addYearsMonthsDays(0,0,53));
		System.out.println(getText(calendarSomeDayLocator));
		Assert.assertEquals(getText(calendarSomeDayLocator), sText);
		return CalendarTabPage.getCalendarTabPage(browser);
	}
	
	public CalendarTabPage ScrollUpCalendarFeed() throws InterruptedException {
		scrollIntoView(calendarUpLocator);
		return CalendarTabPage.getCalendarTabPage(browser);
	}
	
	public CalendarTabPage thenVerifyScrollUp(String sText) {
		System.out.println(getText(calendarUpLocator));
		Assert.assertEquals(getText(calendarUpLocator), sText);
		return CalendarTabPage.getCalendarTabPage(browser);
	}
	
}
