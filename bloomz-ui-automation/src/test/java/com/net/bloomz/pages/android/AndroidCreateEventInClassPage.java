package com.net.bloomz.pages.android;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.CreateEventInClassPage;
import com.net.bloomz.pages.interfaces.CreateEventInClassPageActions;

public class AndroidCreateEventInClassPage extends CreateEventInClassPage implements CreateEventInClassPageActions {

	By inviteButtonLocator = By.id("net.bloomz:id/txtInvite") ;

	public AndroidCreateEventInClassPage(Browser<?> browser) {
		super(browser);

	}
	public CreateEventInClassPage clickInviteButton() {
		click(inviteButtonLocator);
		return super.clickInviteButton() ;
	}

}
