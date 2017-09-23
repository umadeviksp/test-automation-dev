package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.CreatePTCEventInClassPageActions;
import com.net.bloomz.pages.web.WebCreatePTCEventInClassPage;

public class CreatePTCEventInClassPage extends BasePage implements CreatePTCEventInClassPageActions {
	
	static By titleBoxLocator;
	static By locationBoxLocator;
	static By notesBoxLocator;
	static By addDateButtonLocator;
	static By someDateButtonLocator;
	static By nextButtonLocator;
	static By next2ButtonLocator;
	static By selectFirstClassButtonLocator;
	static By doneButtonLocator;
	static By sendButtonLocator;
	static By successMsgLocator;
	static By datepickerLocator;
	
	public CreatePTCEventInClassPage(Browser<?> browser) {
		super(browser);
	}
	
	public CreatePTCEventInClassPage enterTitle(String title) {
		sendText(titleBoxLocator, title);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage enterLocation(String location) {
		sendText(locationBoxLocator, location);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage enterNotes(String notes) {
		sendText(notesBoxLocator, notes);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage enterDate() {
		//click(addDateButtonLocator);
		selectDateFromDatePicker(addDateButtonLocator, datepickerLocator);
		//click(someDateButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clearDate() {
		clearTextBox(addDateButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage enterStartDate(Integer iYrs, Integer iMons, Integer iDay) {
		sendText(addDateButtonLocator,addYearsMonthsDays(iYrs,iMons,iDay));
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickNextButton() {
		click(nextButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickNext2Button() {
		click(next2ButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage selectFirstClassButton() {
		click(selectFirstClassButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickDoneButton() {
		click(doneButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage clickSendButton() {
		click(sendButtonLocator);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	
	public CreatePTCEventInClassPage thenVerifyThatPTCEventWasSuccessful(String stext) {
		Assert.assertEquals(getText(successMsgLocator) , stext);
		return CreatePTCEventInClassPage.getCreatePTCEventInClassPage(browser);
	}
	public static CreatePTCEventInClassPage getCreatePTCEventInClassPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			titleBoxLocator = By.id("addEvent_eventTitle");
			locationBoxLocator = By.id("addEvent_eventLocation");
			notesBoxLocator = By.id("addEvent_eventDetails");
			addDateButtonLocator = By.xpath("//*[@id=\"addUpdatePtEvent\"]/div/form/div/div[2]/section[3]/section[1]/ul/li/label/a");
			someDateButtonLocator = By.xpath("//*[@id=\"CalendarControl\"]/table/tbody/tr[4]/td[2]/a");
			nextButtonLocator = By.xpath("//*[@ng-click=\"clickNext()\"]");
			next2ButtonLocator = By.xpath("//*[@ng-click=\"actionBtnClicked()\"]");
			selectFirstClassButtonLocator = By.xpath("//*[@id=\"recipientPicker\"]/div/div/div/section/div[1]/section/div/h2/button/span[2]");
			doneButtonLocator = By.xpath("//*[@ng-click=\"applyCommit()\"]");
			sendButtonLocator = By.xpath("//*[@ng-click=\"addPTEvent()\"]");
			successMsgLocator = By.xpath("//*[@id=\"calendarViewControl\"]/div[1]/section/section[1]/h1[1]/span[1]");
			datepickerLocator = By.xpath("//*[@id=\"CalendarControl\"]/table/tbody");
					//*[@id="calendarViewControl"]/div[1]/section/section[1]/h1[1]/span[1]
			return new WebCreatePTCEventInClassPage(browser);
		}
		return null;
	}
}
