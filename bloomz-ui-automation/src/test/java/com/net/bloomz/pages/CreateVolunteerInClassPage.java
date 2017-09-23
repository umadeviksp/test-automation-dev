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
	static By nextButtonLocator;
	static By next2ButtonLocator;
	static By messageFieldLocator;
	static By sendButtonLocator;
	static By successEventMessageLocator;
	
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
	
	public CreateVolunteerInClassPage clickNextButton() {
		click(nextButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	
	public CreateVolunteerInClassPage clickNext2Button() {
		click(next2ButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	public CreateVolunteerInClassPage enterMessage(String sMessage) {
		sendText(messageFieldLocator, sMessage);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	
	
	public ClassPage clickSendButton() {
		click(sendButtonLocator);
		return ClassPage.getClassPage(browser);
	}
	
	public HomePage thenVerifyVolunteerEventWasSuccessful(String sText) {
		System.out.println(getText(successEventMessageLocator));
		Assert.assertEquals(getText(successEventMessageLocator), sText);
		return HomePage.getHomePage(browser);
	}
	
	public static CreateVolunteerInClassPage getCreateVolunteerInClassPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			needItemsButtonLocator = By.xpath("//*[@id='addUpdateEvent']/div/form/div/div/div/div/section/section/ul/li[1]/a");
			needItemsButtonLocator = By.xpath("//section[@class='taskFooter']//div[@class='addAnotherItem']") ;
			itemNameBoxLocator = By.xpath("//*[@id='addUpdateEvent']/div/form/div/div/div/div/section/div/section/label/span/input[1]");
			needPeopleButtonLocator = By.xpath("//*[@id='addUpdateEvent']/div/form/div/div/div/div/section/section/ul/li[2]/a");
			taskBoxLocator = By.xpath("//*[@id='addUpdateEvent']/div/form/div/div/div/div/section/div[2]/section/label/span/input[1]");
			titleBoxLocator = By.xpath("//form[@name='editEventForm']//div//div/div[3]//section[@class='formLayout']//section[@class='autoSuggest']//label//div//input[@id='addEvent_eventTitle']");
			locationBoxLocator = By.xpath("//form[@name='editEventForm']//div//div/div[3]//section[@class='formLayout']//section[2]//label//input[@id='addEvent_eventLocation']");
			notesBoxLocator = By.id("addEvent_eventNotes");
			startDateBoxLocator = By.xpath("//*[@id='splitDateTime_date_1501528106645']");
			startDateButtonLocator = By.xpath("//*[@id='CalendarControl']/table/tbody/tr[6]/td[2]");
			endDateBoxLocator = By.xpath("//*[@id='splitDateTime_date_1501528106647']");
			endDateButtonLocator = By.xpath("//*[@id='CalendarControl']/table/tbody/tr[8]/td[2]/a");
			//repeatButtonLocator = By.xpath("//*[@id='addUpdateEvent']/div/form/div/div/section[5]/section[1]/label/a");
			repeatButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/form[2]/div/div/div[3]/section[3]/section[3]/label/a");
			repeatWeeklyButtonLocator = By.xpath("//*[@id='addUpdateEvent']/div/div[1]/section/section/div/div[2]");
			exitRepeatScreenButtonLocator = By.xpath("//*[@id='addUpdateEvent']/div/nav[3]/a");
			//endRepeatButtonLocator = By.xpath("//*[@id='addUpdateEvent']/div/form/div/div/section[5]/section[2]/label/span");
			endRepeatButtonLocator = By.xpath("//*[@id='addUpdateEvent']/div/form[2]/div/div/div[3]/section[3]/section[4]/label/a");
			afterNumberOfTimesButtonLocator = By.id("occurrenceInput");
			numberOfTimesBoxLocator = By.id("occurrenceInput");
			exitNumberOfTimesScreenButtonLocator = By.xpath("//*[@id='addUpdateEvent']/div/nav[4]/a");
			rsvpButtonLocator = By.xpath("//*[@id='addUpdateEvent']/div/form/div/div/section[6]/section[2]/div/label");
			saveButtonLocator = By.xpath("//*[@id='addUpdateEvent']/div/nav[1]/a[2]");
			nextButtonLocator = By.xpath("//*[@id=\"addUpdateEvent\"]/div/nav[1]/a[2]");
			next2ButtonLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/nav[1]/a[2]");
			messageFieldLocator = By.xpath("//*[@id='ptInvite_message']");
			//*[@id="//*[@id="ptInvite_message"]"]
			sendButtonLocator = By.xpath("//div[@id='addPost']//a[@class='nextButton']");
			successEventMessageLocator = By.id("toast");
			
			//*[@id="addPost"]/div/nav/a[2]
			return new WebCreateVolunteerInClassPage(browser);
		}
		return null;
	}

}
