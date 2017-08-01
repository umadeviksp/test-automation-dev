package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.interfaces.ContactsTabPageActions;
import com.net.bloomz.pages.web.WebContactsTabPage;

public class ContactsTabPage extends BasePage implements ContactsTabPageActions {
	
	static By contactsLocator;

	public ContactsTabPage(Browser<?> browser) {
		super(browser);
	}

	public static ContactsTabPage getContactsTabPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			
		} else if (string.equals(".iOS")) {
			
		} else {
			contactsLocator = By.xpath("//*[@ng-repeat=\"person in contactGroup.collection\"]");
			
			return new WebContactsTabPage(browser);
		}
		return null;
	}
	
	public ContactsTabPage thenVerifyContactsShouldNotBeNull() {
		Assert.assertTrue(getElementSize(contactsLocator) > 0, "No contacts are displayed");
		return ContactsTabPage.getContactsTabPage(browser);
	}
}