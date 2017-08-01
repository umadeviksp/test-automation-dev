package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.CreateEventInClassPageActions;
import com.net.bloomz.pages.web.WebCreateEventInClassPage;

public class CreateEventInClassPage extends BasePage implements CreateEventInClassPageActions {
	
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

	public CreateEventInClassPage(Browser<?> browser) {
		super(browser);
	}
	
	public CreateEventInClassPage enterTitle(String title) {
		sendText(titleBoxLocator, title);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage enterLocation(String location) {
		sendText(locationBoxLocator, location);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage enterNotes(String notes) {
		sendText(notesBoxLocator, notes);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickStartDateBox() {
		click(startDateBoxLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickStartDate() {
		click(startDateButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickEndDateBox() {
		click(endDateBoxLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickEndDate() {
		click(endDateBoxLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickInviteButton() {
		click(inviteButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickInviteAllButton() {
		click(inviteAllButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickDoneButton() {
		click(doneButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickRSVPButton() {
		click(rsvpButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}
	
	public CreateEventInClassPage clickSaveButton() {
		click(saveButtonLocator);
		return CreateEventInClassPage.getCreateEventInClassPage(browser);
	}

	public static CreateEventInClassPage getCreateEventInClassPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
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
			return new WebCreateEventInClassPage(browser);
		}
		return null;
	}

}
