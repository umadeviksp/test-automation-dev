package com.net.bloomz.pages;

import org.openqa.selenium.By;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidInvitationPersonalConnectionPage ;
import com.net.bloomz.pages.interfaces.InvitationPersonalConnectionPageActions;
import com.net.bloomz.pages.web.WebInvitationPersonalConnectionPage;

public class InvitationPersonalConnectionPage extends BasePage implements InvitationPersonalConnectionPageActions {

	static By inviteButtonLocator = null;
	static By goBackButtonLocator = null;
	static By nameTextboxLocator = null ;

	public InvitationPersonalConnectionPage(Browser<?> browser) {
		super(browser);

	}

	
	public HomePage clickOnInviteButton() {
		click(inviteButtonLocator);
		return HomePage.getHomePage(browser);
	}

	public InvitationGroupPage clickOnGoBackButton() {
		click(goBackButtonLocator);
		return  InvitationGroupPage.getInvitationGroupPage(browser);
	}

	public InvitationPersonalConnectionPage enterEmailInTextBox(String emailAddress) {
		sendText(nameTextboxLocator, emailAddress);
		return  this ;
	}

	public static InvitationPersonalConnectionPage getInvitationPersonalConnectionPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			inviteButtonLocator 	= By.id("net.bloomz:id/txtMyProfile");
			goBackButtonLocator 	= By.id("net.bloomz:id/txtCancel");
			return new AndroidInvitationPersonalConnectionPage(browser);
		} else if (string.contains(".iOS")) {

		} else {
			inviteButtonLocator 	= By.xpath("//div[@id='recipientPicker']//a[contains(@class,'nextButton')]");
			goBackButtonLocator 	= By.xpath("//div[@id='recipientPicker']//a[contains(@class,'backButtonOnly')]");
			nameTextboxLocator 		= By.xpath("//div[@id='recipientPicker']//div[@class='recipients']//div[contains(@class,'textInput')]") ;
			return new WebInvitationPersonalConnectionPage(browser);
		}
		return null;
	}
}