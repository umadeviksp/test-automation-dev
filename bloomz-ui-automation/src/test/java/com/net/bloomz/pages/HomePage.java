package com.net.bloomz.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidHomePage;
import com.net.bloomz.pages.interfaces.HomePageActions;
import com.net.bloomz.pages.web.WebHomePage;

public class HomePage extends BasePage implements HomePageActions {

	static By settingButtonLocator;
	static By createButtonLocator;
	static By postUpdateCards;
	static By myCalendarTabLocator;
	static By myContactsTabLocator;
	static By messagesLocator;
	static By volunteerTabLocator;
	
	static By classNameLocator;

	// By textEventLocator = By.id("net.bloomz:id/txtEventCalender");
	// By homeListViewLocator = By.id("net.bloomz:id/HomeListView");
	// By postTextLocator = By.id("net.bloomz:id/txtAlbumPhotoComment");
	// By homeLauncherIconLocator = By.name("Apps");
	// By bloomzAppLocator = By.name("Bloomz");
	// By homeTab = By.name("home");
	// By menuButtonLocator = By.id("net.bloomz:id/menuBtn");
	// By calendarTab = By.name("calender");
	// By messageTab = By.name("message");
	// By volunteerTab = By.name("volunteer");
	// By contactsTab = By.name("contacts");
	// By postCommentLocator = By.id("net.bloomz:id/txtAlbumPhotoPostBy");
	// By postMessageLocator = By.id("net.bloomz:id/txtPostMessage");
	// By eventNameLocator = By.id("net.bloomz:id/txtCalName");
	// By profileNameLocator = By.id("net.bloomz:id/txtProfileName");
	// By postTitleLocator = By.id("net.bloomz:id/txtPostTitle");

	public HomePage(Browser<?> browser) {
		super(browser);
	}

	@Override
	public SettingPage clickOnSettingButton() {
		waitForElement(settingButtonLocator);
		click(settingButtonLocator);
		return SettingPage.getSettingPage(browser);
	}

	@Override
	public HomePage clickOnBloomzIconForMobileApp() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CalendarTabPage clickOnMyCalendarTab() {
		click(myCalendarTabLocator);
		return CalendarTabPage.getCalendarTabPage(browser);
	}
	
	@Override
	public ContactsTabPage clickOnMyContactsTab() {
		click(myContactsTabLocator);
		return ContactsTabPage.getContactsTabPage(browser);
	}

	public HomePage thenVerifyMainFeedPostShouldNotBeNull() {
		Assert.assertTrue(getElementSize(postUpdateCards) > 3, "This account doesn't contain posts");
		return HomePage.getHomePage(browser);
	}

	public HomePage thenVerifyCreateButtonShouldBeDisplayed() {
		waitForElement(createButtonLocator);
		Assert.assertTrue(browser.getActions().isClickable(createButtonLocator), "Create is not displayed");
		return HomePage.getHomePage(browser);
	}
	
	public HomePage thenVerifyMessagesShouldNotBeNull() {
		Assert.assertTrue(getElementSize(messagesLocator) > 0, "No messages are displayed");
		return HomePage.getHomePage(browser);
	}
	
	public ClassPage clickOnAClassName() {
		click(classNameLocator);
		return ClassPage.getClassPage(browser);
	}

	public static HomePage getHomePage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			settingButtonLocator = By.id("net.bloomz:id/txtSetting");
			createButtonLocator = By.id("net.bloomz:id/btnStart");
			postUpdateCards = By.id("");
			myCalendarTabLocator = By.name("calendar");
			volunteerTabLocator = By.name("volunteer");
			return new AndroidHomePage(browser);
		} else if (string.contains(".iOS")) {
			settingButtonLocator = By.id("");
		} else {
			settingButtonLocator = By.xpath("//*[@id=\"bloomzMainNav_navLeftProfile\"]");
			createButtonLocator = By.xpath("//*[@data-post=\"+ Create\"]");
			postUpdateCards = By.xpath("//*[@post-message=\"postMessage\"]");
			myCalendarTabLocator = By.xpath("//*[@id=\"bloomzMainNav_navLeftMy Calendar\"]");
			myContactsTabLocator = By.xpath("//*[@id=\"bloomzMainNav_navLeftMy Contacts\"]");
			volunteerTabLocator = By.id("bloomzMainNav_navLeftVolunteers");
			
			messagesLocator = By.xpath("//*[@ng-click=\"showMessage(message)\"]");
			classNameLocator = By.xpath("//*[@id=\"posts\"]/nav[1]/div[2]/ul[4]/li/ul/li[1]/span/a");
			
			return new WebHomePage(browser);
		} 
		return null;
	}

}