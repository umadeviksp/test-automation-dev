package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.CreateVolunteerInClassPageActions;
import com.net.bloomz.pages.web.WebCreateVolunteerInClassPage;

public class CreateVolunteerInClassPage extends BasePage implements CreateVolunteerInClassPageActions {
	
	static By volunteerTabLocator;
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

	public ClassPage clickVolunteerTab() {
		click(volunteerTabLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickNeedItemsButton() {
		click(needItemsButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage typeItems() {
		sendText(itemNameBoxLocator, "Apples, grapes, and carrots");
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickNeedPeopleButton() {
		click(needPeopleButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage enterTask() {
		sendText(taskBoxLocator, "3 people to set up");
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
	
	public ClassPage clickRepeatButton() {
		click(repeatButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickRepeatWeeklyButton() {
		click(repeatWeeklyButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickExitRepeatScreenButton() {
		click(exitRepeatScreenButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickEndRepeatButton() {
		click(endRepeatButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickAfterNumberOfTimesButtonLocator() {
		click(afterNumberOfTimesButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage typeNumberOfTimesButtonLocator() {
		sendText(numberOfTimesBoxLocator, "4");
		return ClassPage.getClassPage(browser);
	}
	
	public ClassPage clickExitAfterNumberOfTimesButtonLocator() {
		click(exitNumberOfTimesScreenButtonLocator);
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
	
	public static CreateVolunteerInClassPage getCreateVolunteerInClassPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			volunteerTabLocator = By.xpath("//*[@id=\"calendar\"]/div[3]/div[1]/div[3]/div/ul/li[6]");
			needItemsButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/div/div/section/section/ul/li[1]/a");
			itemNameBoxLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/div/div/section/div/section/label/span/input[1]");
			needPeopleButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/div/div/section/section/ul/li[2]/a");
			taskBoxLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/div/div/section/div[2]/section/label/span/input[1]");
			titleBoxLocator = By.xpath("//*[@id=\"addEvent_eventTitle\"]");
			locationBoxLocator = By.xpath("//*[@id=\"addEvent_eventLocation\"]");
			notesBoxLocator = By.xpath("//*[@id=\"addEvent_eventNotes\"]");
			startDateBoxLocator = By.xpath("//*[@id=\"splitDateTime_date_1501528106645\"]");
			startDateButtonLocator = By.xpath("//*[@id=\"CalendarControl\"]/table/tbody/tr[6]/td[2]");
			endDateBoxLocator = By.xpath("//*[@id=\"splitDateTime_date_1501528106647\"]");
			endDateButtonLocator = By.xpath("//*[@id=\"CalendarControl\"]/table/tbody/tr[8]/td[2]/a");
			repeatButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/section[5]/section[1]/label/a");
			repeatWeeklyButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/div[1]/section/section/div/div[2]");
			exitRepeatScreenButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/nav[3]/a");
			endRepeatButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/section[5]/section[2]/label/span");
			afterNumberOfTimesButtonLocator = By.xpath("//*[@id=\"occurrenceInput\"]");
			numberOfTimesBoxLocator = By.xpath("//*[@id=\"occurrenceInput\"]");
			exitNumberOfTimesScreenButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/nav[4]/a");
			rsvpButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form/div/div/section[6]/section[2]/div/label");
			saveButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/nav[1]/a[2]");
			return new WebCreateVolunteerInClassPage(browser);
		}
		return null;
	}

}
