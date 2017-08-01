package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.CreatePTCEventInClassPageActions;
import com.net.bloomz.pages.web.WebCreatePTCEventInClassPage;

public class CreatePTCEventInClassPage extends BasePage implements CreatePTCEventInClassPageActions {
	
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
	
	public CreatePTCEventInClassPage(Browser<?> browser) {
		super(browser);
	}
	
	public CreatePTCEventInClassPage clickOnMediaTab() {
		click(mediaTabLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickOnCalendarTab() { 
		click(calendarTabLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickOnEventButton() {
		click(eventButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickOnEventTab() {
		click(eventTabLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage enterTitleText() {
		sendText(titleBoxLocator, "Random");
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage enterLocationText() {
		sendText(locationBoxLocator, "Random");
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage enterNotesText() {
		sendText(notesBoxLocator, "Random");
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickStartDateBox() {
		click(startDateBoxLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickStartDate() {
		click(startDateButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickEndDateBox() {
		click(endDateBoxLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickEndDate() {
		click(endDateBoxLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickInviteButton() {
		click(inviteButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickInviteAllButton() {
		click(inviteAllButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickDoneButton() {
		click(doneButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickRSVPButton() {
		click(rsvpButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickSaveButton() {
		click(saveButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public static CreatePTCEventInClassPage getCreatePTCEventInClassPage(Browser<?> browser) {
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
			return new WebCreatePTCEventInClassPage(browser);
		}
		return null;
	}
}
