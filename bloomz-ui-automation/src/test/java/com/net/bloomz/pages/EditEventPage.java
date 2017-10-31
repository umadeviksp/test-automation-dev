package com.net.bloomz.pages;



import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidEditEventPage ;
import com.net.bloomz.pages.interfaces.EditEventPageActions;
import com.net.bloomz.pages.web.WebEditEventPage;


public class EditEventPage extends BasePage implements EditEventPageActions {
	
	static By optionsEditEventLocator = null;
	static By inviteMorePeopleLocator = null;
	static By allMembersLocator = null;
	static By doneLocator = null;
	static By sendButtonLocator = null;
	static By successUpdateTextLocator = null;
	static By emailNotifTextLocator = null;
		
	public EditEventPage(Browser<?> browser) {
		super(browser);

	}

	public EditEventPage clickOnOptionsEditEvent() {
		click(optionsEditEventLocator);
		return EditEventPage.getEditEventPage(browser);
	}
	
	public EditEventPage clickOnInviteMorePeople() {
		click(inviteMorePeopleLocator);
		return EditEventPage.getEditEventPage(browser);
	}
	
	public EditEventPage clickOnAllMembers() {
		click(allMembersLocator);
		return EditEventPage.getEditEventPage(browser);
	}
	
	public EditEventPage clickOnDoneButton() {
		click(doneLocator);
		return EditEventPage.getEditEventPage(browser);
	}
	
	public EditEventPage clickOnSendButton() {
		click(sendButtonLocator);
		return EditEventPage.getEditEventPage(browser);
	}
	
	public EditEventPage thenVerifyEmailUpdate() {
		System.out.println(getText(successUpdateTextLocator));
		System.out.println(getText(emailNotifTextLocator));
		Assert.assertEquals(getText(successUpdateTextLocator), "Successfully Updated!");
		Assert.assertEquals(getText(emailNotifTextLocator), "Email Notification has been sent to all the invitees.");
		return EditEventPage.getEditEventPage(browser);
	}

	public static EditEventPage getEditEventPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {

			return new AndroidEditEventPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			optionsEditEventLocator = By.xpath("//*[@id='calendarViewControl']//a[contains (text(),'Options')]");
			inviteMorePeopleLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//span[contains (text(),'Invite More People')]");
			allMembersLocator = By.xpath("//*[@id='recipientPicker']//button[contains (text(),'All')]");
			doneLocator = By.xpath("//*[@id='recipientPicker']//a[contains (text(),'Done')]");
			sendButtonLocator = By.xpath("//*[@id='addPost']//a[contains (text(),'Send')]");
			successUpdateTextLocator = By.xpath("//*[@id='calendarViewControl']/div[1]/section/section[1]/h1[1]/span[1]");
			emailNotifTextLocator = By.xpath("//*[@id='calendarViewControl']/div[1]/section/section[1]/h1[1]/span[2]");
			return new WebEditEventPage(browser);
		}
		return null;
	}


}