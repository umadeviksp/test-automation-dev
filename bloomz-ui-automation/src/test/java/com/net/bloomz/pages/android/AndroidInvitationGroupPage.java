package com.net.bloomz.pages.android;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.InvitationGroupPage;
import com.net.bloomz.pages.interfaces.InvitationGroupPageActions;

public class AndroidInvitationGroupPage extends InvitationGroupPage implements InvitationGroupPageActions {

	public AndroidInvitationGroupPage(Browser<?> browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}
	public InvitationGroupPage enterEmailId(String emailId) {
		super.enterEmailId(emailId+",");	//android needs extra comma to enable the send button.
		return InvitationGroupPage.getInvitationGroupPage(browser) ;
	}

}
