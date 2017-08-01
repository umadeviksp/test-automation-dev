package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.ClassPageActions;
import com.net.bloomz.pages.interfaces.PTCEventPageActions;
import com.net.bloomz.pages.web.WebClassPage;

public class PTCEvent extends BasePage implements PTCEventPageActions {
	
	static By mediaTabLocator;
	static By calendarTabLocator;
	static By eventButtonLocator;
	static By eventTabLocator;
	static By titleBoxLocator;
	static By locationBoxLocator;
	static By notesBoxLocator;
	static By startDateBoxLocator;
	static By startDateButtonLocator;
	static By endDateBoxLocator;
	static By endDateButtonLocator;
	static By inviteButtonLocator;
	static By inviteAllButtonLocator;
	static By doneButtonLocator;
	static By rsvpButtonLocator;
	static By saveButtonLocator;
	
	public PTCEvent(Browser<?> browser) {
		super(browser);
	}
	
	public PTCEvent clickOnMediaTab() {
		click(mediaTabLocator);
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent clickOnCalendarTab() { 
		click(calendarTabLocator);
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent clickOnEventButton() {
		click(eventButtonLocator);
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent clickOnEventTab() {
		click(eventTabLocator);
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent enterTitleText() {
		sendText(titleBoxLocator, "Random");
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent enterLocationText() {
		sendText(locationBoxLocator, "Random");
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent enterNotesText() {
		sendText(notesBoxLocator, "Random");
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent clickStartDateBox() {
		click(startDateBoxLocator);
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent clickStartDate() {
		click(startDateButtonLocator);
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent clickEndDateBox() {
		click(endDateBoxLocator);
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent clickEndDate() {
		click(endDateBoxLocator);
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent clickInviteButton() {
		click(inviteButtonLocator);
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent clickInviteAllButton() {
		click(inviteAllButtonLocator);
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent clickDoneButton() {
		click(doneButtonLocator);
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent clickRSVPButton() {
		click(rsvpButtonLocator);
		return PTCEvent.getClassPage(browser);
	}
	
	public PTCEvent clickSaveButton() {
		click(saveButtonLocator);
		return PTCEvent.getClassPage(browser);
	}
	
	public static PTCEvent getClassPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			mediaTabLocator = By.xpath("//*[@ng-click=\"setSelected(menu); \"][@data-coachmark=\"Media\"]");
			calendarTabLocator = By.xpath("//*[@id=\"communityMenu_calendar\"]/a");
			eventButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[1]");
			eventTabLocator = By.xpath("//*[@id=\"calendar\"]/div[3]/div[1]/div[3]/div/ul/li[5]");
			
			titleBoxLocator = By.xpath("//*[@id=\"addEvent_eventTitle\"]");
			locationBoxLocator = By.xpath("//*[@id=\"addEvent_eventLocation\"]");
			notesBoxLocator = By.xpath("//*[@id=\"addEvent_eventNotes\"]");
			startDateBoxLocator = By.xpath("//*[@id=\"splitDateTime_date_1501528106645\"]");
			startDateButtonLocator = By.xpath("//*[@id=\"CalendarControl\"]/table/tbody/tr[6]/td[2]");
			endDateBoxLocator = By.xpath("//*[@id=\"splitDateTime_date_1501528106647\"]");
			endDateButtonLocator = By.xpath("//*[@id=\"CalendarControl\"]/table/tbody/tr[8]/td[2]/a");
			inviteButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/section[6]/section[1]/label/a");
			inviteAllButtonLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div[1]/section/div/button");
			doneButtonLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/a");
			rsvpButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/section[6]/section[2]/div/label");
			saveButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/nav[1]/a[2]");
			return new WebPTCEventPage(browser);
		}
		return null;
	}
}
