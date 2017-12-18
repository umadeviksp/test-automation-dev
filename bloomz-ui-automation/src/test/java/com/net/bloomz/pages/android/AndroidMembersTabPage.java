package com.net.bloomz.pages.android;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.InvitationGroupPage;
import com.net.bloomz.pages.MembersTabPage;

public class AndroidMembersTabPage extends MembersTabPage {

	
	By searchMembersEmailGrayedLocator = By.id("net.bloomz:id/rlSearchText") ;
	public AndroidMembersTabPage(Browser<?> browser) {
		super(browser);
		// TODO Auto-generated constructor stub
	}

	public MembersTabPage enterEmailSearchMembers(String sEmail) {
		click(searchMembersEmailGrayedLocator);
		return super.enterEmailSearchMembers(sEmail);
	}
	public MembersTabPage thenVerifyTheToastMessage(String sText) {
		//Unable to capture toast from android
		return MembersTabPage.getMembersTabPage(browser);
	}
	
	

}
