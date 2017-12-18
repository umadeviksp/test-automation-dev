package com.net.bloomz.pages.android;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.CreateMessageToMyContactsPage;

public class AndroidCreateMessageToMyContactsPage extends CreateMessageToMyContactsPage {

	public AndroidCreateMessageToMyContactsPage(Browser<?> browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}
	public CreateMessageToMyContactsPage clickOnMyContacts() {
		// This button is not present in android
		return CreateMessageToMyContactsPage.getCreateMessageToMyContactsPage(browser);
	}
	

}
