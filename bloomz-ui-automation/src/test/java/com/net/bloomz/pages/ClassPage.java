package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.ClassPageActions;
import com.net.bloomz.pages.web.WebClassPage;

public class ClassPage extends BasePage implements ClassPageActions 
{
	
	static By createButtonLocator;
	static By volunteerTabLocator;
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
	
	public ClassPage(Browser<?> browser) {
		super(browser);
	}
	
	public ClassPage clickCreateButton() {
		click(createButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public CreateVolunteerInClassPage createVolunteerAsk() {
		click(volunteerTabLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public ClassPage clickOnMediaTab() {
		click(mediaTabLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickOnCalendarTab() { 
		click(calendarTabLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickOnEventButton() {
		click(eventButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickOnEventTab() {
		click(eventTabLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage enterTitleText() {
		sendText(titleBoxLocator, "Random");
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage enterLocationText() {
		sendText(locationBoxLocator, "Random");
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage enterNotesText() {
		sendText(notesBoxLocator, "Random");
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickStartDateBox() {
		click(startDateBoxLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickStartDate() {
		click(startDateButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickEndDateBox() {
		click(endDateBoxLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickEndDate() {
		click(endDateBoxLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickInviteButton() {
		click(inviteButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickInviteAllButton() {
		click(inviteAllButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickDoneButton() {
		click(doneButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickRSVPButton() {
		click(rsvpButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickSaveButton() {
		click(saveButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public static ClassPage getClassPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			createButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[1]");
			volunteerTabLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[10]");
			mediaTabLocator = By.xpath("//*[@ng-click=\"setSelected(menu); \"][@data-coachmark=\"Media\"]");
			calendarTabLocator = By.xpath("//*[@id=\"communityMenu_calendar\"]/a");
			eventButtonLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[1]");
			eventTabLocator = By.xpath("//*[@id=\"orgHome\"]/div/div[1]/div[1]/div[2]/div/ul/li[9]");
			
			titleBoxLocator = By.xpath("//*[@id=\"addEvent_eventTitle\"]");
			locationBoxLocator = By.xpath("//*[@id=\"addEvent_eventLocation\"]");
			notesBoxLocator = By.xpath("//*[@id=\"addEvent_eventNotes\"]");
			startDateBoxLocator = By.xpath("//*[@id=\"splitDateTime_date_1501528106645\"]");
			startDateButtonLocator = By.xpath("//*[@id=\"CalendarControl\"]/table/tbody/tr[6]/td[2]");
			endDateBoxLocator = By.xpath("//*[@id=\"splitDateTime_date_1501619009735\"]");
			endDateButtonLocator = By.xpath("//*[@id=\"CalendarControl\"]/table/tbody/tr[8]/td[2]/a");
			inviteButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/section[6]/section[1]/label/a");
			inviteAllButtonLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div[1]/section/div/button");
			doneButtonLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/a");
			rsvpButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/section[6]/section[2]/div/label");
			saveButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/nav[1]/a[2]");
			return new WebClassPage(browser);
		}
		return null;
	}
}
