package com.net.bloomz.pages.android;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.ClassPage;
import com.net.bloomz.pages.CreateVolunteerInClassPage;
import com.net.bloomz.pages.interfaces.CreateVolunteerInClassPageActions;

public class AndroidCreateVolunteerInClassPage extends CreateVolunteerInClassPage implements CreateVolunteerInClassPageActions {

	static By notifyAllMembersButtonLocator =By.id("net.bloomz:id/txtNotify") ;
	
	public AndroidCreateVolunteerInClassPage(Browser<?> browser) {
		super(browser);

	}
	
	public CreateVolunteerInClassPage clickNextButton() {
//		click(nextButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	public CreateVolunteerInClassPage clickNext2Button() {
//		click(next2ButtonLocator);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	public CreateVolunteerInClassPage enterMessage(String sMessage) {
//		sendText(messageFieldLocator, sMessage);
		return CreateVolunteerInClassPage.getCreateVolunteerInClassPage(browser);
	}
	public ClassPage clickSendButton() {
		super.clickSendButton() ;
		clickNotifyAllMembersButton() ;
		return ClassPage.getClassPage(browser);
	}
	public void clickNotifyAllMembersButton() {
		click(notifyAllMembersButtonLocator);
	}

}
