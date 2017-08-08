package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.CreateVolunteerInClassPageActions;
import com.net.bloomz.pages.web.WebCreateVolunteerInClassPage;

public class CreateVolunteerInClassPage extends BasePage implements CreateVolunteerInClassPageActions {
	
	static By needItemsButtonLocator;
	static By itemNameBoxLocator;
	static By needPeopleButtonLocator;
	static By taskBoxLocator;
	static By titleBoxLocator;
	static By locationBoxLocator;
	static By notesBoxLocator;
	static By startDateBoxLocator;
	static By startDateButtonLocator;
	static By endDateBoxLocator;
	static By endDateButtonLocator;
	static By repeatButtonLocator;
	static By repeatWeeklyButtonLocator;
	static By exitRepeatScreenButtonLocator;
	static By endRepeatButtonLocator;
	static By afterNumberOfTimesButtonLocator;
	static By numberOfTimesBoxLocator;
	static By exitNumberOfTimesScreenButtonLocator;
	static By rsvpButtonLocator;
	static By saveButtonLocator;
	
	public CreateVolunteerInClassPage(Browser<?> browser) {
		super(browser);
	}
	
	public CreateVolunteerInClassPage clickNeedItemsButton() {
		click(needItemsButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage typeItems() {
		sendText(itemNameBoxLocator, "Apples, grapes, and carrots");
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage clickNeedPeopleButton() {
		click(needPeopleButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage enterTask() {
		sendText(taskBoxLocator, "3 people to set up");
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage enterTitleText(String title) {
		sendText(titleBoxLocator, title);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage enterLocationText(String location) {
		sendText(locationBoxLocator, location);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage enterNotesText(String notes) {
		sendText(notesBoxLocator, notes);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage clickStartDateBox() {
		click(startDateBoxLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage clickStartDate() {
		click(startDateButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage clickEndDateBox() {
		click(endDateBoxLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage clickEndDate() {
		click(endDateBoxLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage clickRepeatButton() {
		click(repeatButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage clickRepeatWeeklyButton() {
		click(repeatWeeklyButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage clickExitRepeatScreenButton() {
		click(exitRepeatScreenButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage clickEndRepeatButton() {
		click(endRepeatButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage clickAfterNumberOfTimesButtonLocator() {
		click(afterNumberOfTimesButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage typeNumberOfTimesButtonLocator() {
		sendText(numberOfTimesBoxLocator, "4");
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage clickExitAfterNumberOfTimesButtonLocator() {
		click(exitNumberOfTimesScreenButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}

	public CreateVolunteerInClassPage clickRSVPButton() {
		click(rsvpButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage clickSaveButton() {
		click(saveButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public static CreateVolunteerInClassPage getCreateVolunteerInClassPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			needItemsButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/div/div/section/section/ul/li[1]/a");
			itemNameBoxLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/div/div/section/div/section/label/span/input[1]");
			needPeopleButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/div/div/section/section/ul/li[2]/a");
			taskBoxLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/div/div/section/div[2]/section/label/span/input[1]");
			titleBoxLocator = By.id("addEvent_eventTitle");
			locationBoxLocator = By.id("addEvent_eventLocation");
			notesBoxLocator = By.id("addEvent_eventNotes");
			startDateBoxLocator = By.xpath("//*[@id=\"splitDateTime_date_1501528106645\"]");
			startDateButtonLocator = By.xpath("//*[@id=\"CalendarControl\"]/table/tbody/tr[6]/td[2]");
			endDateBoxLocator = By.xpath("//*[@id=\"splitDateTime_date_1501528106647\"]");
			endDateButtonLocator = By.xpath("//*[@id=\"CalendarControl\"]/table/tbody/tr[8]/td[2]/a");
			repeatButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/section[5]/section[1]/label/a");
			repeatWeeklyButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/div[1]/section/section/div/div[2]");
			exitRepeatScreenButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/nav[3]/a");
			endRepeatButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/section[5]/section[2]/label/span");
			afterNumberOfTimesButtonLocator = By.id("occurrenceInput");
			numberOfTimesBoxLocator = By.id("occurrenceInput");
			exitNumberOfTimesScreenButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/nav[4]/a");
			rsvpButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/section[6]/section[2]/div/label");
			saveButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/nav[1]/a[2]");
			return new WebCreateVolunteerInClassPage(browser);
		}
		return null;
	}

}
